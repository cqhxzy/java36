package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
    public static void main(String[] args) {

        //可缓存的线程池
        //池的大小并不固定，
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });
        Thread thread2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });
        Thread thread3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });
        Thread thread4 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });
        Thread thread5 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });
        Thread thread6 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "正在执行");
        });

        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);
        executorService.execute(thread6);

        executorService.shutdown();

    }
}
