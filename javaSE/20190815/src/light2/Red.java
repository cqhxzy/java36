package light2;

public class Red implements Runnable {
    private Light light;

    public Red(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (true) {
            light.red();
        }
    }
}
