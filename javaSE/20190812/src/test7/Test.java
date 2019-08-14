package test7;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        double[] arr = new double[100000000];

        for (int i = 0; i < arr.length; i++) {
            double ran = Math.random();
            arr[i] = ran;
        }

        double sum = 0;
        System.out.println("初始化数据完毕，开始运算......");
        long begin = System.currentTimeMillis(); //获取自1970-1-1 0:0:0 至今的毫秒数

        for (int i = 0; i < arr.length; i++) {
            double v = arr[i];
            sum += v;
        }

        long end = System.currentTimeMillis();
        System.out.println("总和：" + sum);
        System.out.println("执行时间：" + (end - begin));

        System.out.println("-----------------------");
        begin = System.currentTimeMillis();
        double sum1 = DoubleStream.of(arr).parallel().sum();
        end = System.currentTimeMillis();
        System.out.println("总和：" + sum);
        System.out.println("执行时间：" + (end - begin));


    }
}
