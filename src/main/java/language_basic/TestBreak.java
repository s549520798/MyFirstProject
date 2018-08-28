package language_basic;

import java.util.Arrays;

public class TestBreak {

    int[][] arrayOfIndex = new int[][]{
            {23, 43, 54, 23, 43},
            {34, 45, 76, 9, 1},
            {95, 37, 28, 29, 15}
    };

    int searchFor = 54;
    boolean fondInt;

    public static void main(String[] args) {
        //传入参数时，如果参数是基本数据类型，方法执行过后 参数的值不会被方法中的操作改变
        int x = 3;
        passInt(x);
        System.out.println("将x传入方法后 x = " + x);
        //传入的参数是 引用类型时， 对象还会指向原来的对象 但是对象的参数变量会被方法中执行的操作改变
        Body body = new Body(0,0);
        System.out.println("原对象的内存地址 = " + body);
        changeBody(body, 5, 6);
        System.out.println("现在对象的内存地址 + " + body);
        System.out.println("body 对象的值 X = " + body.getX() + " Y = " + body.getY());

        //关于String 类型和 数据类型的测试
        String s = "yuan string";
        int[] ints = new int[]{1,2,3,4,5};
        System.out.println(s);
        testStringAndInt(s,ints);
        System.out.println(s);
        System.out.println(Arrays.toString(ints));

    }

    private static void testStringAndInt(String s, int[] ints) {
        s= "xian zai string";
        ints[3] = 8;
        ints[1] = 9;
    }

    private static void changeBody(Body body,int xChangeTo,int yChangeTo){
        body.setX(xChangeTo);
        body.setY(yChangeTo);
    }
    private static void passInt(int x) {
        x = 10;
    }




    private void findIndex() {
        search:
        for (int[] anArrayOfIndex : arrayOfIndex) {
            for (int anAnArrayOfIndex : anArrayOfIndex) {
                if (anAnArrayOfIndex == searchFor) {
                    fondInt = true;
                    break search;
                }
            }
        }
    }

}

class Body{
    int x;
    int y;

    public Body(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
