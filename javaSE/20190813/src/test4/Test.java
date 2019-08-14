package test4;

public class Test {
    public static void main(String[] args) {
        /*Integer integer = new Integer(127);

        int i = integer.intValue(); //获取这个类对应的int的值
        byte b = integer.byteValue();//获取其对应的byte值
        short i1 = integer.shortValue(); //获取short值
        long l = integer.longValue(); //获取long值
        integer.floatValue();
        integer.doubleValue();

        Integer integer1 = Integer.valueOf("128");//将字符串的数字转换为Integer类型
        int i2 = Integer.parseInt("1128"); //将字符串的数组转换为int类型*/
        //test();
        System.out.println(10 / 0);
    }

    private  static  void test(){
        Integer i1 = new Integer(97);
        Integer i2 = new Integer(97);
        System.out.println(i1 == i2);  //内存地址不同
        System.out.println(i1.equals(i2));
        System.out.println("-----------");

        Integer i3 = new Integer(197);
        Integer i4 = new Integer(197);
        System.out.println(i3 == i4); //比内存地址
        System.out.println(i3.equals(i4));
        System.out.println("-----------");

        Integer i5 = 97;  //自动装箱，在缓存池中获取-128~127的Integer的对象
        Integer i6 = 97;
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));
        System.out.println("-----------");

        Integer i7 = 197;   //自动装箱，但是197 > 127 ,因此重新new一个Integer
        Integer i8 = 197;   //两个Integer对象的内存地址不同
        System.out.println(i7 == i8);
        System.out.println(i7.equals(i8));
    }

    public void test2(){
        int i = 10;
    }
}
