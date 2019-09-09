package pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test4 {
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

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);

        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.schedule(thread4, 1000, TimeUnit.MILLISECONDS);//延迟1000毫秒执行
        pool.schedule(thread5, 2000, TimeUnit.MILLISECONDS);//延迟1000毫秒执行
        pool.schedule(thread6, 3000, TimeUnit.MILLISECONDS);//延迟1000毫秒执行

        pool.shutdown();

        //下一步操作需要根据多线程执行完毕后才能够进行。
    }
}
