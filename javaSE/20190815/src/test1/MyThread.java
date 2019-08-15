package test1;

public class MyThread extends Thread {
    @Override
    public void run() {
        //run方法中就是我们的线程运行时的逻辑
        for (int i = 0; i < 10; i++) {
            Thread thread = Thread.currentThread(); //获取当前正则运行的线程
            String name = thread.getName(); //获取当前线程的名称
            System.out.println(name + "线程:" + i);

            try {
                Thread.sleep(100); //每次循环睡眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
