package test3;

public class Ticket {
    int ticket = 20;

    /**
     * 同步方法,synchronized同步方法锁的是这个方法所在的对象
     *          synchronized(this){
     *              sell()
     *          }
     */
    public synchronized void sell(){
        if (ticket > 0) {
            String name = Thread.currentThread().getName();

            /*安全舱门已关闭*/
            System.out.println(name + "线程卖出票号：" + ticket);  //ticket共享资源
            ticket--;
            /*安全舱门已打开*/


        }
    }
}
