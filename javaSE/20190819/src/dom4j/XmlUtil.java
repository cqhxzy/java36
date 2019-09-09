package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class XmlUtil {
    private XmlUtil(){}

    //饿汉式
    /*private static XmlUtil instance = new XmlUtil();

    public static XmlUtil getInstance() {
        return instance;
    }*/


    //懒汉式
   /* private static XmlUtil instance = null;

    public static XmlUtil getInstance() {
        if (instance == null) {
            instance = new XmlUtil();
        }
        return instance;
    }*/


    /**
     * 静态内部类的单例模式
     * 优势？劣势？
     * 　　优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。
     *
     * 　　劣势：需要多加载一个类；相比于懒汉模式，Holder 创建的单例，只能通过 JVM 去控制器生命周期，不能手动 destroy。
     * @return
     */
    public static XmlUtil getInstance(String path) {
        if (path != null) {
            PATH = path;
        }
        return Holder.instance;
    }

    /**
     * 私有的静态内部类，这个类只能够在XmlUtils类中使用。在外部无法使用
     */
    private static class Holder{
        private static XmlUtil instance = new XmlUtil();
    }


    private static String PATH; //被解析的xml的路径

    /**
     * 通过反射解析xml
     * 注意：xml的节点名称必须和Class<T> 的属性名完全一致
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> List<T> readXml(Class<T> tClass) throws Exception{
        List<T> list = new ArrayList<>();
        Document document = getDocument();

        Element rootElement = document.getRootElement(); //得到根节点

        List<Element> elements = rootElement.elements(); //得到所有的food节点
        for (Element t : elements) {
            T t1 = tClass.newInstance(); //通过反射，通过无参构造方法实例化T的对象
            List<Element> elements1 = t.elements();//得到每个food节点的子节点

            for (Element element : elements1) {
                String name = element.getName(); //得到节点名，name，price，count，date

                //通过内省机制为属性赋值
                BeanInfo info = Introspector.getBeanInfo(tClass);
                //得到所有属性的描述，通过PropertyDescriptor对象的getName() 得到每个属性的名称
                PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();

                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    //setName ,setPrice,setCount,setDate
                    Method writeMethod = propertyDescriptor.getWriteMethod();//调用属性的封装方法 setXXX方法
                    if (propertyDescriptor.getName().equals(name)) {
                        String fieldName = propertyDescriptor.getName();//得到属性名
                        Class<?> type = tClass.getDeclaredField(fieldName).getType();//获取属性的类型
                        Object convert = StringUtil.convert(type, element.getText());//将字符串格式的xml的节点文本转换为对应的java类型的值
                        writeMethod.invoke(t1,convert);
                    }
                }
            }
            list.add(t1);
        }
        return  list;
    }

    /**
     * 加载document
     * @return
     */
    public Document getDocument(){
        SAXReader reader = new SAXReader();
        try {
            return reader.read(new File(PATH));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将集合写回xml
     * @param list
     * @param <T>
     */
    public <T> void write2Xml(List<T> list){
        //验证文件是否存在
        File file = new File(PATH);
        if (!file.exists()){
            try {
                file.createNewFile(); //如果文件不存在就创建一个xml文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            document = createDocument();
            document.addElement("root"); //添加根节点
        }

        Element rootElement = document.getRootElement();
        for (T t : list) {
            String name = t.getClass().getName();//得到类的完整名称，dom4j.Food
            String element_name = name.substring(name.lastIndexOf(".") + 1).toLowerCase();//将Food转换为food
            Element element = rootElement.addElement(element_name); //得到food节点

            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());

                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors(); //得到属性
                for (PropertyDescriptor descriptor : propertyDescriptors) {
                    String name1 = descriptor.getName(); //得到属性名。name,price,count,date
                    if (name1.equalsIgnoreCase("class")) { //getClass方法，内省机制会将getClass方法理解称为有个属性就是class
                        continue;
                    }
                    Element element1 = element.addElement(name1);

                    //通过getXXX方法获取属性值
                    Method readMethod = descriptor.getReadMethod();
                    Object invoke = readMethod.invoke(t); //得到方法的返回值

                    String s = StringUtil.convertObj2String(invoke);
                    element1.setText(s);
                }

            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        writeDocument(document);



    }

    public Document createDocument(){
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("utf-8");
        return document;
    }

    /**
     * 将document写到文件
     * @param document
     */
    public void writeDocument(Document document) {
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fileWriter, format);

            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
