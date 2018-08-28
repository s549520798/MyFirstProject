package language_basic.inheritance;

interface InterfaceB {
    default void sameMethod(){
        System.out.println("interface b default method");
    }
}
