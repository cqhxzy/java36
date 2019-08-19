package dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        //加载Document

        SAXReader reader = new SAXReader();
        try {
            //一个Document代表了一个xml文档
            Document document = reader.read(new File("F:\\java36\\java\\xml操作\\students.xml"));

            //获取根节点，根节点有且仅有一个
            //一个Element的对象，代表了一个xml节点
            Element root = document.getRootElement();

            //获取root节点下，所有的子级节点
            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element element = it.next();
                // 获取标签名
                /*QName qName = element.getQName();//一个标签的节点
                String name = qName.getName();
                System.out.println(name);*/

                //获取属性
                /*List<Attribute> attributes = element.attributes();//获取节点所有的属性
                attributes.stream().forEach(t->{
                    String value = t.getValue();//获取属性的值
                    System.out.println(value);
                });*/

                //获取具体某个子节点
                /*Element stuNo = element.element("stuNo");//获取element对应的student节点中的stuNo子节点
                String text = stuNo.getText();
                System.out.println(text);*/

                //获取element节点中所有的子节点
                List<Element> elements = element.elements();

                /*for (Element t : elements) { //foreach遍历

                }*/

                /*elements.stream().forEach(t->{  //符合函数式编程思想。应为forEach方法需要的是一个Consumer接口的实现。
                    //Consumer接口中只有一个方法叫accept方法
                    //在本例中的匿名代码块实际上就是accept方法的匿名实现
                    String text = t.getText(); //获取子节点的文本
                    String name = t.getName();//获取标签名
                    System.out.println("name:" + name + ",text:" + text);
                });*/


            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
