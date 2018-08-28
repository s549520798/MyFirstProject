package language_basic.inheritance;

import java.util.Properties;

class TestInheritance {

    public static void main(String[] args) {

        // result: child class print : static method ; 子类中重新定义与父类中相同方法签名的static方法
        // 会将父类中的方法 hide 隐藏
        ChildClassA.staticMethod();

        Object ob = new ChildClassA();
        ChildClassA childClassA;
        if (ob instanceof ChildClassA) {
            childClassA = (ChildClassA) ob;
            childClassA.instanceMethod();
        }

        ChildClassB childClassB = new ChildClassB();
        childClassB.sameMethod();
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

}
