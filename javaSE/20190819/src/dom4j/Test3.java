package dom4j;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Test3 {
    public static void main(String[] args) {
        BigInteger i1 = new BigInteger("188888888888888888888888888888888888888888888");
        BigInteger i2 = new BigInteger("1");

        BigInteger sum = i1.add(i2);  //求和

        BigInteger subtract = i1.subtract(i2);//求差
        BigInteger multiply = i1.multiply(i2);//求积
        BigInteger divide = i1.divide(i2);
        System.out.println(sum.toString());
        System.out.println(subtract.toString());
        System.out.println(multiply.toString());
        System.out.println(divide.toString());


        BigDecimal d1 = new BigDecimal("3.00000000000000000000000000000000000000000000001");
        BigDecimal d2 = new BigDecimal("0.00000000000000000000000000000000000000000000001");

        BigDecimal d3 = d1.add(d2);
        System.out.println(d3.toString());
    }
}
