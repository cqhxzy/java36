package test2;

public class TrainThread extends Thread {
    private static int ticket = 20;
    private static Object lock = new Object(); //充当锁的对象，



    @Override
    public void run() {
        while (ticket > 0) {
            String name = Thread.currentThread().getName();

            /*安全舱门已关闭*/
            synchronized (lock){  //同步代码块，在锁代码块期间，一定不能够修改lock对象应用
                System.out.println(name + "线程卖出票号：" + ticket);  //ticket共享资源
                ticket--;
            }
            /*安全舱门已打开*/

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
