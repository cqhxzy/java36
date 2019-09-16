package com.hxzy.biz.impl;

import com.hxzy.biz.CourseBiz;
import com.hxzy.vo.CourseVo;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CourseBizImplTest {

    private CourseBiz biz = new CourseBizImpl();

    @Test
    public void insert() {
        CourseVo vo = new CourseVo(0,"物理","2019-1-1");
        int insert = biz.insert(vo);
        assertThat(insert, greaterThan(0));//断言insert的值比0大
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
        CourseVo byId = biz.findById(8);
        Date date = new Date();
        System.out.println(date);
        System.out.println(byId);
    }

    @Test
    public void queryAll() {
    }
}