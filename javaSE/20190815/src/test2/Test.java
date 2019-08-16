package test2;

public class Test {
    public static void main(String[] args) {
        TrainThread t1 = new TrainThread();
        TrainThread t2 = new TrainThread();
        TrainThread t3 = new TrainThread();
        TrainThread t4 = new TrainThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
