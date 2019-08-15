package test7;

public class Test2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        /*int c = a;
        a = b;
        b = c;
        System.out.println("a:" + a);
        System.out.println("b:" + b);*/
        a = a ^ b;  //15
        b = b ^ a;  //10
        a = a ^ b;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
    }
}
