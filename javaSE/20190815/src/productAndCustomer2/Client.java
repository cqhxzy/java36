package productAndCustomer2;

public class Client {
    public static void main(String[] args) {
        Repo repo = new Repo(); //创建共享资源

        new Thread(new Producter(repo),"李师傅").start();
        new Thread(new Producter(repo),"王师傅").start();
        new Thread(new Producter(repo),"张师傅").start();
        new Thread(new Producter(repo),"赵师傅").start();

        new Thread(new Customer(repo), "小张").start();
        new Thread(new Customer(repo), "小王").start();
        new Thread(new Customer(repo), "小李").start();
        new Thread(new Customer(repo), "小冯").start();
    }
}
