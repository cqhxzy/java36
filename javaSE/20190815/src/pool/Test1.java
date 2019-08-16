package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "A线程");
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "B线程");
        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "C线程");
        Thread thread4 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, "D线程");


        //创建只有一个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //将线程托管到线程池
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);

        executorService.shutdown();//关闭线程池

    }
}
