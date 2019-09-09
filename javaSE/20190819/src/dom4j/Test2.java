package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        //加载Document

        SAXReader reader = new SAXReader();
        //一个Document代表了一个xml文档
        Document document = null;
        try {
            document = reader.read(new File("F:\\java36\\java\\xml操作\\students.xml"));

            //获取根节点，根节点有且仅有一个
            //一个Element的对象，代表了一个xml节点
            Element root = document.getRootElement();



            List<Element> elements = root.elements();//获取root下所有的直接子节点
            //System.out.println(elements.size());

            //iter(elements);
            stream(elements);

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

    /**
     * 通过迭代器实现解析xml并得到java集合
     * @param elements
     */
    private static void iter( List<Element> elements) {
        List<Student> list = new ArrayList<>();
        for (Element t : elements) {
            //每个t就是一个student节点
            int stuNo = Integer.parseInt(t.element("stuNo").getText());//获取学号节点的文本
            String stuName = t.element("stuName").getText();
            int age = Integer.parseInt(t.element("age").getText());
            char sex = t.element("sex").getText().charAt(0);
            String  phone = t.element("phone").getText();
            BigInteger phone_str = new BigInteger(phone);

            String address = t.element("address").getText();

            //根据读取的节点组件java对象
            Student student = new Student();
            student.setStuNo(stuNo);
            student.setStuName(stuName);
            student.setAge(age);
            student.setSex(sex);
            student.setPhone(phone_str);
            student.setAddress(address);

            list.add(student);
        }

        for (Student student : list) {
            System.out.println(student);
        }
    }

    private static void stream( List<Element> elements){
        List<Student> list = elements.stream().map(t -> { //将Element转换为Student
            //每个t就是一个student节点
            int stuNo = Integer.parseInt(t.element("stuNo").getText());//获取学号节点的文本
            String stuName = t.element("stuName").getText();
            int age = Integer.parseInt(t.element("age").getText());
            char sex = t.element("sex").getText().charAt(0);
            String phone = t.element("phone").getText();
            BigInteger phone_str = new BigInteger(phone);
            String address = t.element("address").getText();
            //根据节点组建学生对象
            Student student = new Student();
            student.setStuNo(stuNo);
            student.setStuName(stuName);
            student.setAge(age);
            student.setSex(sex);
            student.setPhone(phone_str);
            student.setAddress(address);
            return student;
        })
                .filter(t-> t.getSex() == '女')  //过滤：只要性别为女的信息
                .collect(Collectors.toList()); //终止操作

        for (Student student : list) {
            System.out.println(student);
        }
    }
}
