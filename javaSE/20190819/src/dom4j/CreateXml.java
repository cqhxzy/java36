package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CreateXml {
    public static void main(String[] args) {
        //在内存中创建一个空的document对象
        Document document = DocumentHelper.createDocument();

        //在document中创建有且仅有一个的根节点
        Element root = document.addElement("root");

        /*
        * <root>
        *     <food>
        *         <name>牛肉干</name>
        *         <price>25</price>
        *         <count>10</count>
        *         <date>2019-08-20</date>
        *     </food>
        *
        * </root>
        *
        * */
        Element food = root.addElement("food");
        food.addElement("name").setText("牛肉干");
        food.addElement("price").setText("25");
        food.addElement("count").setText("10");
        food.addElement("date").setText("2019-08-20");

        //将document保存到文件
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();//创建具有格式化的xml
            //OutputFormat format = OutputFormat.createCompactFormat(); //创建紧凑的xml
            XMLWriter writer = new XMLWriter(new FileWriter("F://food.xml"),format);
            writer.write(document); //将document输出到文件
            writer.close(); //关闭字符输出流
            System.out.println("保存文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
