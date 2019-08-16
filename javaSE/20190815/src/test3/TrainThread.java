package test3;

public class TrainThread implements Runnable{

    private Ticket ticket; //共享资源
    public TrainThread(Ticket ticket){ //实例化线程对象时，必须指定多个线程之间的共享资源
        this.ticket = ticket;
    }

    @Override
    public void run() {
        while (ticket.ticket > 0) {

            this.ticket.sell();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
