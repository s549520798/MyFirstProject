package language_basic.concurrency;

public class SynchronizedTest implements Runnable {

    private int i = 0;

    private int getI(){
        return this.i;
    }

    private synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest instance = new SynchronizedTest();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //如果increase()没有加 synchronized 关键字，则打印的i值可能少于200000
        System.out.println("完后后i的值" + instance.getI());
    }
}
