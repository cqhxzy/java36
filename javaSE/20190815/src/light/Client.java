package light;

public class Client {
    public static void main(String[] args) {
        Light light = new Light();

        Thread t1 = new Thread(new Red(light),"red1");
        Thread t2 = new Thread(new Yellow(light),"yellow1");
        Thread t3 = new Thread(new Green(light),"green1");

        Thread t4 = new Thread(new Red(light),"red2");
        Thread t5 = new Thread(new Yellow(light),"yellow2");
        Thread t6 = new Thread(new Green(light),"green2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
