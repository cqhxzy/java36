package productorAndCustomer;

public class Productor implements Runnable {

    private Repo repo;

    public Productor(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        //生产者负责生产
        while (true) {
            repo.product();
        }
    }
}
