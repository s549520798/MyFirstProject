package language_basic.concurrency;

/**
 * 方法二方式创建线程，这种方法适用于简单的线程任务，因为必须是Thread类的子类所以局限性比较大
 */
public class WorldThread extends Thread {

    @Override
    public void run() {
        System.out.println(" subclass thread name ：" + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            System.out.println("world " + i);
        }
    }
}
