package language_basic.inheritance;

class ChildClassB implements InterfaceA,InterfaceB {

    //因为 interfaceA 和interfaceB 拥有相同的default方法，子类无法判断使用哪个， 必须重写此方法
    @Override
    public void sameMethod() {
        InterfaceA.super.sameMethod();
        InterfaceB.super.sameMethod();
    }
}
