package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 {
    static int i = 0;
    //static Object lock = new Object();
    public static void main(String[] args) {


        for (int j = 0; j < 100; j++) {

            CountDownLatch countDownLatch = new CountDownLatch(10);

            ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);
            for (int i = 0; i < 10;i++) {
               pool.execute(new Worker(countDownLatch));
            }
            pool.shutdown();

            try {
                countDownLatch.await();  //阻塞代码，直到线程完成操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有线程执行完毕");
            System.out.println("总和为：" + i);
        }
        System.out.println("所有数的总和：" + i);
    }

    private static class Worker implements Runnable {
        private CountDownLatch countDownLatch;

        private final ReentrantLock lock = new ReentrantLock();

        public Worker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try{
                lock.lock();//加锁
                Test5.i++;
                countDownLatch.countDown();
            } finally {
                lock.unlock();
            }
        }
    }

}
