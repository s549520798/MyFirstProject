package language_basic.concurrency;

/**
 * 创建新的线程的方式：1、 实现Runnable接口，将实现类作为参数传入Thread类的 构造器中。
 * 2、子类继承自Thread 类，复写Thread 的 run()方法， 注：Thread类本身就实现了Runnable接口,不过其实现的run()为空实现
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable thread name ：" + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            System.out.println("hello " + i);
        }
    }
}
