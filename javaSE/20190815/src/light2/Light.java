package light2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Light {
    private int state = 1;// 1:红灯   2：黄灯   3：绿灯
    private final Lock lock = new ReentrantLock();
    private Condition redCondition = lock.newCondition();  //红灯锁
    private Condition yellowCondition = lock.newCondition(); //黄灯锁
    private Condition greenCondition = lock.newCondition(); //绿灯锁


    public void red(){
            try {
                lock.lock();
                //假设当前状态不为红灯，则红灯的线程就要一直等待。
                while (state != 1) {
                    redCondition.await();
                }

                //红灯亮5下
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":红灯亮" + (i + 1 ) + "下");
                    Thread.sleep(500);
                }

                //黄灯亮
                state = 2;

                yellowCondition.signal(); //仅唤醒黄灯
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

    }

    //黄灯
    public void yellow(){
        try {
            lock.lock();
            while (state != 2) {
                yellowCondition.await();
            }

            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":黄灯亮" + (i + 1) + "下") ;
                Thread.sleep(500);
            }

            //绿灯亮
            state = 3;

            greenCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void green(){
        try {
            lock.lock();
            while (state != 3) {
                greenCondition.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":绿灯亮" + (i + 1) + "下") ;
                Thread.sleep(500);
            }

            //红灯亮
            state = 1;

            redCondition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
