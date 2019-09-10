package demo;

import org.junit.*;

/*
* 静态导包
* org.junit.Assert.* 意味着Assert中的所有的静态方法能够直接使用
* .* 代表着Assert类中的任意的静态属性和方法都被静态导入到了本类中
* 而不必要再通过Assert.xxx()调用
* */
import static org.junit.Assert.*;

public class CalcTest {

    @Before     //在每个测试方法之前都会被执行的方法
    public void before(){
        System.out.println("before");
    }

    @After    //在每个测试方法执行完毕后执行的方法
    public void after(){
        System.out.println("after");
    }

    @BeforeClass  //在单元测试执行方法之前，就执行的注解，只会执行一次
    public static void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }

    /*
    * 被测试的方法前通过加上@Test注解标注为需要测试的方法
    *
    * 被测试的方法访问修饰符必须是public
    * 返回值类型必须是void
    * 方法名通常已testXXX()
    * */
    @Test
    @Ignore
    public void add() {
        Calc calc = new Calc();
        int add = calc.add(5, 6); //调用要被测试的方法
        //fail();//测试失败
        //fail("手动的测试失败");
        //assertTrue("测试未通过",false);
        //assertFalse("测试结果为真，失败",false);  //断言为失败
        //assertEquals("期望值为1",1,add);   //断言两个值相同
        //assertNotEquals(11,add); //断言不相同
        //assertNull(null);     //断言为null
        //assertNotNull(null); //断言不为null


        assertEquals(11,add);


    }

    @Test
    public void minus() {
        Calc calc = new Calc();
        int minus = calc.minus(10, 0);
        assertEquals(10,minus);
    }

    @Test
    public void mult() {
        Calc calc = new Calc();
        int mult = calc.mult(2, 2);
        assertEquals(4,mult);
    }

    @Test
    public void div() {
        Calc calc = new Calc();
        double div = calc.div(10, 2);
        assertEquals(5,div,0);
    }
}