package language_basic.generics;

/**
 * 泛型方法demo , 泛型方法是 方法自己引入泛型类型，和泛型类 类似，引入的泛型类型放在尖括号中间
 *  泛型类型 放在方法的修饰符之后 ，返回类型之前。
 *  在泛型类中的方法调用的泛型类型是类名中引入的type 所以泛型类中的方法并不是泛型方法
 */
public class GenericsMethodDemo {


    public static <K, V> boolean comparePari(Pair<K, V> pair, Pair<K, V> kvPair) {
        return pair.getKey().equals(kvPair.getKey());
    }
    //由于 > 只能作用于 基础数据类型 所以 当 T 为object 调用错误
    //public static <T> int countGreaterThan(T[] anArray, T elem) {
    //    int count = 0;
    //    for (T e : anArray)
    //        if (e > elem)  // compiler error
    //            ++count;
    //    return count;
    //}
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }
}
