package test1;

public class CustomerImpl implements Customer {
    @Override
    public void service() {
        System.out.println("service -------------------");
    }

    public static void main(String[] args) {
        Customer customer = new CustomerImpl();
        //customer.service();

        //通过匿名实现的方式实例化对象
        Customer c2 = new Customer() {
            @Override
            public void service() {
                System.out.println("匿名实现的service");
            }
        };

        Customer c3 = () -> { // （）为Customer接口中的唯一方法，service
            System.out.println("通过Lambda表达式实现的service方法");
        };

        /*test(customer); //常规的，通过实现类的方式实现接口
        test(c2);       //匿名实现
        test(()->{      //匿名实现，是JDK8中引入的Lambda表达式
            System.out.println("service方法被执行了");
        });*/
        c3.service();
    }

    public static void test(Customer customer){
        customer.service();
        customer.print();
    }
}
