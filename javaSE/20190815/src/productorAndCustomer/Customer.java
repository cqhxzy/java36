package productorAndCustomer;

public class Customer implements Runnable {
    private Repo repo;

    public Customer(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        //消费者负责消费
        while (true) {
            repo.consume();
        }
    }
}
