import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calc {

    private static Logger logger = LoggerFactory.getLogger(Calc.class);

    public double div(double num1,double num2){
        logger.debug("准备执行div，num1:" + num1 + ",num2:" + num2);
        if (num2 == 0) {
            logger.error("除数为0，不符合数学规则！  " + num2);
            throw new RuntimeException("除数不能为0！");
        }
        logger.debug("执行num1 / num2");
        return num1 / num2;
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        double div = calc.div(10,0);
        System.out.println(div);
    }
}
