package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calc {
    private static Logger logger = LoggerFactory.getLogger("demo.Calc");

    public int add(int num1,int num2){
        logger.debug("执行求和的方法：{} + {}",num1,num2);
        return num1 + num2;
    }

    public int minus(int num1,int num2){
        logger.debug("执行求差的方法：" + num1 + "-" + num2);
        return num1 - num2;
    }

    public int mult(int num1,int num2){
        logger.debug("执行求积的方法：{}*{}",num1,num2);
        return num1 * num2;
    }

    public double div(double num1,double num2){
        logger.debug("执行求商的方法：{}/{}",num1,num2);
        if (num2 == 0) {
            logger.error("除数为0！num2={}", num2);
            throw new RuntimeException("除数不能为0！");
        }
        return num1 / num2;
    }
}
