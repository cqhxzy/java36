package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) {
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

        //获取当前java虚拟机能够取得的CPU的数目
        int processors = Runtime.getRuntime().availableProcessors(); //4

        //创建固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(processors);
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);
        executorService.execute(thread6);

        executorService.shutdown();
    }
}
