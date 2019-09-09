package productorAndCustomer;

public class Producter implements Runnable {

    private Repo repo;

    public Producter(Repo repo) {
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
