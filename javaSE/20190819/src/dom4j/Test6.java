package dom4j;

import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        XmlUtil instance = XmlUtil.getInstance("F://food.xml");
        try {
            List<Food> foods = instance.readXml(Food.class);
            System.out.println(foods.size());
            for (Food food : foods) {
                System.out.println(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
