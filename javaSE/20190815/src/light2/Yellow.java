package light2;

public class Yellow implements Runnable {
    public Yellow(Light light) {
        this.light = light;
    }

    private Light light;
    @Override
    public void run() {
        while (true) {
            light.yellow();
        }
    }
}
