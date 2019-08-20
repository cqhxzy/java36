package dom4j;

import java.math.BigDecimal;
import java.util.Date;

public class Food {
    private String name;
    private BigDecimal price;
    private Integer count;
    private Date date;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", date=" + date +
                '}';
    }

    public Food() {
    }

    public Food(String name, BigDecimal price, Integer count, Date date) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        System.out.println("setPrice:" + price);
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        System.out.println("setCount:" + count);
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        System.out.println("setDate:" + date);
        this.date = date;
    }
}
