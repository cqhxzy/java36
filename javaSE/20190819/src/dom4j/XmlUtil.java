package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Method;
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
}
