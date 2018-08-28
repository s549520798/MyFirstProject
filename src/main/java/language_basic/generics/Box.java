package language_basic.generics;

/**
 * 简单的泛型类
 * 构建泛型类的语法：class name<T1, T2, ..., Tn>
 * The type parameter section, delimited by angle brackets (<>), follows the class name.
 * It specifies the type parameters (also called type variables) T1, T2, ..., and Tn.
 * @param <T>
 */
public class Box<T> {

    private T t;

    public T getData() {
        return t;
    }

    public void setData(T t) {
        this.t = t;
    }
    //限定参数类型，U 必须继承自 Number 类型
    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
}
