package language_basic.exceptions;

/**
 *  An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions
 *
 *
 */
public class ExceptionText {

    public static void main(String[] args) {

        System.out.println("计算除法开始！");
        try {
            System.out.println("除法就按 20/0 的结果是 = " + 20 / 0);
//            System.out.println("计算除法结束！");
        } catch (Exception e) {
            System.out.println("除法运算发生异常 ！");
            System.out.println("异常信息 ： " + e.getMessage());
            e.printStackTrace();           //可以打印完整异常信息
        }finally {
            System.out.println("计算除法结束！");  //不管是否出现异常 都执行finally 中的内容
        }

        try {
            MyMath.div(10,2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyMath{

    public static int div(int x,int y)throws Exception{
        return y/x;
    }
}
