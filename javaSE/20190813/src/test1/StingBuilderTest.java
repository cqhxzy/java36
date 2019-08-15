package test1;

public class StingBuilderTest {
    /**
     * 在java操作
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("我喜欢软妹子")
                .append(",身轻体柔易推倒");

        String str = builder.toString();
        System.out.println(str);

        StringBuffer buffer = new StringBuffer();
        buffer.append("你喜欢御姐")
                .append(",不知道");
        System.out.println(buffer.toString());
    }
}
