package daemon;

public class ThreadDaemon {

    public static void main(String[] args) {

        /*
        * 守护线程：在主线程中开启的子线程可以设置为守护线程
        *           守护线程会随着主线程的终止而终止。
        * 守护线程通常用于收集程序执行过程中的数据，日志等操作。
        * */
        Thread thread = new Thread(() -> {
            Thread daemon = new Thread(()->{  //thread子线程
                String name = Thread.currentThread().getName();
                while (true) {  //循环永不结束
                    System.err.println(name);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            daemon.setDaemon(true); //将线程设置为守护线程
            daemon.start();

            for (int i = 0; i < 100; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
