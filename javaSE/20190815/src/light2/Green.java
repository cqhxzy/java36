package light2;

public class Green implements Runnable {
    private Light light;

    public Green(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (true) {
            light.green();
        }
    }
}
