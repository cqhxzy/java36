package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        final String PATH = "F://food.xml";
        XmlUtil instance = XmlUtil.getInstance(PATH);
        try {
            List<Food> foods = instance.readXml(Food.class);
            //foods.stream().forEach(System.out::println);  //方法引用
            foods.stream().forEach(t-> System.out.println(t));

            /*foods.add(new Food("test1", new BigDecimal(30), 1, new Date()));
            foods.add(new Food("test2", new BigDecimal(30), 1, new Date()));
            foods.add(new Food("test3", new BigDecimal(30), 1, new Date()));
            foods.add(new Food("test4", new BigDecimal(30), 1, new Date()));

            instance.write2Xml(foods);
            System.out.println("输出文件完毕");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
