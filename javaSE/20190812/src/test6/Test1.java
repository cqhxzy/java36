package test6;

public class Test1 {
    public static void main(String[] args) {
        try {
            div(10,0);
        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public static void div(double num1, double num2) throws Exception {
        if (num2 == 0) {
            /*throw new RuntimeException("除数不能为0");*/
            throw new Exception("除数不能为0");
        }
        double result = num1 / num2;

        System.out.println(result);
    }
}
