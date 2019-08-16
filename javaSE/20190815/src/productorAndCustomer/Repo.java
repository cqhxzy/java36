package productorAndCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 仓库类
 * 共享资源
 */
public class Repo {

    private final int capability = 10; //容量为10
    private int count = 0;

    /**
     * 生产
     */
    public synchronized void product(){
        while (count >= capability) {
            try {
                System.out.println("当前仓库达到上限，生产开始等待消费");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String name = Thread.currentThread().getName();
        int ran = (int)(Math.random() * (capability / 2)) + 1;
        count += ran;
        System.out.println(name + "生产了一个产品,当前库存为：" + count);

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //唤醒所有的线程
        notifyAll();
    }

    /**
     * 负责消费的方法
     */
    public synchronized void consume(){
        int ran = (int)(Math.random() * (capability / 2)) + 1;
        while (count <= 0 || this.count < ran) {
            System.out.println("当前库存不足消费，消费者开始等待生产");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String name = Thread.currentThread().getName();
        count -= ran;
        System.out.println(name + "消费了一个产品,当前库存为：" + count);
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //唤醒所有的线程
        notifyAll();
    }
}
