package test3;

public class Test {
    public static void main(String[] args) {

        Ticket ticket = new Ticket(); //共享资源

        TrainThread t1 = new TrainThread(ticket);
        TrainThread t2 = new TrainThread(ticket);
        TrainThread t3 = new TrainThread(ticket);
        TrainThread t4 = new TrainThread(ticket);
        TrainThread t5 = new TrainThread(ticket);
        TrainThread t6 = new TrainThread(ticket);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        new Thread(t5).start();
        new Thread(t6).start();
    }
}
