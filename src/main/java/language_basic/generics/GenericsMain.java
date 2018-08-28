package language_basic.generics;

import java.io.Serializable;
import java.util.ArrayList;

public class GenericsMain {
    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Box<Integer> box = new Box<Integer>(); 在java7 之后可以省略尖括号之中的内容
        Box<Integer> box = new Box<>();
        box.setData(5);
        System.out.println(box.getData());

        Pair<String, String> pair = new OrderedPair<>("hello", "world");
        System.out.println(pair.getKey() + pair.getValue());

        Pair<Integer, Box<Integer>> boxPair = new OrderedPair<>(5, box);
        System.out.println(boxPair.getValue().getData());

        //Raw type  泛型中的原始类型，原始类型主要是为了键入 jdk 1.5之前没有引入泛型时存在的遗留代码
        Box box1 = new Box();
        Box<Integer> intBox = new Box<>();
        //box1 = intBox; //ok
        //intBox = box1; //warming : uncheck assignment
        //warming : unchecked invocation to set(T) 可以通过@SuppressWarmings 注解消除 unchecked 警告
        //box1.setData(8);

        Pair<Integer, String> pair1 = new OrderedPair<>(1, "pair1");
        Pair<Integer, String> pair2 = new OrderedPair<>(2, "pair2");
        boolean b = GenericsMethodDemo.comparePari(pair1, pair2);
        System.out.println(b);

        Box<String> box2 = new Box<>();
        box2.setData("class box");
        //box.inspect("chass"); //error String 并不是Number 的子类
        box2.inspect(5);
        //多重限定，
        // Class A { /* ... */ }
        //interface B { /* ... */ }
        //interface C { /* ... */ }
        //
        //class D <T extends A & B & C> { /* ... */ }
        // 使用 & 将 父类或者父接口拼接
        // 其中父类必须放在第一位（否则编译错误）并且只能有一个父类，父接口可以有很多个

        Box<Number> numberBox = new Box<>();
        //numberBox.setData(new Integer(5));//ok
        numberBox.setData(new Double(15));//ok

        testBox(numberBox); //ok
        System.out.println(numberBox.getClass().getName());
        //testBox(new Box<Integer>()); //error  Box<Integer> 并不是Box<Number> 的子类，他们都是Box泛型类

        //类型推断
        Serializable s = pick("d", new ArrayList<String>());

        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                new java.util.ArrayList<>();
        GenericsMain.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes); //type witness 类型见证
        addBox(Integer.valueOf(20), listOfIntegerBoxes);  //因为 类型推断 可以省略类型见证
        addBox(Integer.valueOf(30), listOfIntegerBoxes);
        outputBoxes(listOfIntegerBoxes);
    }

    //这个方法不能接收 Box<Integer> 类型的参数
    private static void testBox(Box<Number> numberBox) {

    }

    private static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static <U> void addBox(U u,
                                  java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.setData(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.getData();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

}
