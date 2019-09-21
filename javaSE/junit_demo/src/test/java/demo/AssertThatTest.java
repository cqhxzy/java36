package demo;

import org.hamcrest.Matchers;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class AssertThatTest {

    @org.junit.Test
    public void test(){
        String str = "hello world";
        //assertThat(str,allOf(startsWithIgnoringCase("H"),endsWithIgnoringCase("D")));
        //assertThat(str,anyOf(notNullValue(),equalToIgnoringCase("HELLO WORLD")));
        //assertThat(str.length(),lessThan(0));
        //assertThat(str.length(),greaterThan(0));
        //assertThat(str.length(),is(11));
//        assertThat(
//                Arrays.asList("a","b","c","d"),
//                hasItem("a")     //断言集合中是否包含E
//        );

        double actual = 3.5;
        //closeTo(操作数，浮动范围)
        //assertThat(actual,closeTo(3.5,0.3));
        //assertThat(actual,allOf(greaterThanOrEqualTo(3.2),lessThanOrEqualTo(3.8)));

        assertThat(new Double(5),not(notANumber()));
    }
}
