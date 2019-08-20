package dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("F:\\java36\\java\\xml操作\\students.xml"));
            //通过Xpath得到具体节点的属性
            List<Node> nodes = document.selectNodes("//root/student/@value");
            //System.out.println(nodes.size());
            for (Node node : nodes) {
                //Node是Element和Attribute接口的父级接口
                Attribute attr = (Attribute) node;
                System.out.println(attr.getValue());

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
