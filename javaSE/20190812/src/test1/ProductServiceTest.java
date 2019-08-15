package test1;

public class ProductServiceTest {
    public static void main(String[] args) {
        //可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
        //ProductService service = (a) -> {System.out.println("name:" + a);};

        //可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
        ProductService service = a -> System.out.println("name:" + a);
        service.service("月月");
    }
}
