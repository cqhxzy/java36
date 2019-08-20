package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("F:\\java36\\java\\xml操作\\students.xml"));
            //通过Xpath得到具体的节点。根节点通过//表示
            List<Node> nodes = document.selectNodes("//root/student/stuNo");
            for (Node node : nodes) {
                System.out.println(node.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
