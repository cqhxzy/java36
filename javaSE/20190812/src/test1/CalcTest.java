package test1;

public class CalcTest {
    public static void main(String[] args) {
        //如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
        Calc calc = (a,b) -> {return a + b;};

        Calc calc2 = (a,b) -> a + b;

        int add = calc2.add(10, 5);
        System.out.println(add);

    }
}
