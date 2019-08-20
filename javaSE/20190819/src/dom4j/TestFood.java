package dom4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestFood {
    private static List<Food> list = new ArrayList<>();

    private static void init(){
        list.add(new Food("牛肉干", new BigDecimal(25), 10, new Date()));
        list.add(new Food("豆腐干", new BigDecimal(2), 5, new Date()));
        list.add(new Food("葡萄干", new BigDecimal(8), 6, new Date()));
        list.add(new Food("芒果干", new BigDecimal(9), 7, new Date()));
        list.add(new Food("猪肉干", new BigDecimal(15), 3, new Date()));
    }

    /**
     * 将集合中的数据保存到xml
     */
    private static void save(){

    }
}
