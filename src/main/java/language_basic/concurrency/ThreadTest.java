package language_basic.concurrency;

import java.util.Date;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("可用核心数 ： " + Runtime.getRuntime().availableProcessors());
        System.out.println("主线层名称 ：" + Thread.currentThread().getName());
        Runnable runnable = new HelloRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new WorldThread();

        thread1.start();
        thread1.join();    //等待thread1 完成后其他线程才能执行
        thread2.start();

        //sleep()
//        for (int i = 0; i < 10; i++) {
//
//            try {
//                Thread.sleep(4000);  // 不保证间隔时间的准确性
//                System.out.println("第" + i + "次打印的时间 ：" + new Date().getTime());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //**********
        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        //long patience = 1000 * 60 * 60;
        long patience = 1000 * 10;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        MessageLoop.threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        MessageLoop.threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            MessageLoop.threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                    && t.isAlive()) {
                MessageLoop.threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        MessageLoop.threadMessage("Finally!");
    }

    private static class MessageLoop implements Runnable {

        @Override
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }

        // Display a message, preceded by
        // the name of the current thread
        static void threadMessage(String message) {
            String threadName =
                    Thread.currentThread().getName();
            System.out.format("%s: %s%n",
                    threadName,
                    message);
        }

    }

}
