package productAndCustomer2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源
 * lock和condition实现线程的通信
 */
public class Repo {
    private final int capability = 10; //容量为10
    private int count = 0;

    private final Lock lock = new ReentrantLock();

    //生产者条件
    private Condition producterCondition = lock.newCondition();//根据锁来获取condition

    //消费者条件
    private Condition customerCondition = lock.newCondition();

    /**
     * 生产者生产的方法，也是一个同步方法
     */
    public void product(){
        try {
            lock.lock(); //开启锁
            String name = Thread.currentThread().getName();

            //一定要先假设线程会出现虚假唤醒的情况
            while (count >= capability){
                //生产者阻塞
                System.out.println(name + "准备生产，但是当前仓库达到上限，开始等待消费");
                producterCondition.await();
            }


            int ran = (int)(Math.random() * (capability / 2)) + 1;
            count += ran;
            System.out.println(name + "生产了一个产品,当前库存为：" + count);

            //具有针对性的，只唤醒消费者
            customerCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //解锁，一定要放到finally中，不然有可能出现死锁的情况
        }
    }

    public void consume(){
        try {
            lock.lock();//加锁
            String name = Thread.currentThread().getName();
            int ran = (int)(Math.random() * (capability / 2)) + 1;
            //一定要先假设线程会出现虚假唤醒的情况
            while (count <= 0 || this.count < ran){
                System.out.println(name + "准备消费" + ran + "个产品，但是库存" + count + "不足消费，开始等待生产");
                customerCondition.await();//阻塞消费者
            }


            count -= ran;
            System.out.println(name + "消费了一个产品,当前库存为：" + count);

            producterCondition.signal();//唤醒生产者

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //解锁
        }
    }
}
