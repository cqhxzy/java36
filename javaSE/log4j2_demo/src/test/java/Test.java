import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        //String property = properties.getProperty("user.home");
        //System.out.println(property);

        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

    }
}
