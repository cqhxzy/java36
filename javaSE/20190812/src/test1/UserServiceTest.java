package test1;

public class UserServiceTest {
    public static void main(String[] args) {
        //可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
        UserService userService = (a,b) ->{
            System.out.println("name:" + a);
            System.out.println("age:" + b);
        };

        userService.save("阿宝", 18);
    }
}
