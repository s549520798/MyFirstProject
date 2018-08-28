package language_basic.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 可通配符使用的地方 ： as the type of a parameter, field, or local variable; sometimes as a return type
 * 通配符不能使用的地方 ： The wildcard is never used as a type argument for a generic method invocation, a generic class instance creation, or a supertype
 * 不能在 泛型类 和 泛型方法 中作为泛型参数，泛型类 和 泛型方法的 泛型参数由 大写字母 代表的泛型表示。
 * 又在方法参数中，或者变量的声明中，来放宽对泛型的限定
 *
 * @param <T>
 */
public class WildcardsDemo<T extends Number> {


    public static int countList(List<Number> list) {
        int sum = 0;
        for (Number n : list) {
            sum += n.intValue();
        }
        return sum;
    }

    public static int countList1(List<? extends Number> list) {
        int sum = 0;
        for (Number n : list) {
            sum += n.intValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        //没有使用通配符的情况
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(Double.valueOf(10));
        List<Integer> integerList = Arrays.asList(2, 3, 4);
        countList(numberList);  //ok
        //countList(integerList); //error

        countList1(numberList); //ok
        countList1(integerList); //ok

//        List<? extends Number> list = new ArrayList<>();
//        list.addAll(numberList);  //error
//        list.addAll(integerList); //error
//        List<?> list1 = new ArrayList<>();
//        list1.addAll(numberList); //error
//        list1.addAll(integerList); //error
    }

}
