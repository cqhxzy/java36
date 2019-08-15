package test1;

public class Test1 {
    public static void main(String[] args) {

        //test1();
        //test2();
        //test3();
        test4();
    }

    /**
     * 通过继承Thread的方式实现多线程
     */
    private static void test1(){
        MyThread t1 = new MyThread(); //创建了一个线程,主线程的子线程
        MyThread t2 = new MyThread(); //创建了一个线程,主线程的子线程

        //开启线程
        t1.start(); //一个线程的对象只能开启一次
        t2.start(); //开启第二个线程
    }

    /**
     * 通过实现Runnable接口的方式实现多线程
     */
    private static void test2(){
        Thread t1 = new Thread(new MyRunnable(),"A");//Thread(Runnable target,String name)
        Thread t2 = new Thread(new MyRunnable(),"B");

        t1.start();
        t2.start();
    }

    private static void test3(){
        Thread t1 = new Thread(new Runnable() {  //匿名实现
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
        },"tom");
        Thread t2 = new Thread(new Runnable() {  //匿名实现
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
        },"jack");

        t1.start();
        t2.start();
    }

    /**
     * 通过Lambda表达式实现多线程
     */
    private static void test4(){
        Thread t1 = new Thread(()->{
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
        },"target1");

        Thread t2 = new Thread(()->{
            //run方法中就是我们的线程运行时的逻辑
            for (int i = 10; i >= 0; i--) {
                Thread thread = Thread.currentThread(); //获取当前正则运行的线程
                String name = thread.getName(); //获取当前线程的名称
                System.out.println(name + "线程:" + i);

                try {
                    Thread.sleep(100); //每次循环睡眠100毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"target2");
        t1.start();
        t2.start();
    }
    private static class MyRunnable implements Runnable{
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

}
