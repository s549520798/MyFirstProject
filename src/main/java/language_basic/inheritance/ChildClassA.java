package language_basic.inheritance;

class ChildClassA extends ParentClassA {

    @Override
    public void instanceMethod() {
        System.out.println("child class print : instance method");

    }

    public static void staticMethod(){
        System.out.println("child class print : static method");
    }
}
