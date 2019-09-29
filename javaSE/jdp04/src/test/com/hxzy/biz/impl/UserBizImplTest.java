package com.hxzy.biz.impl;

import com.hxzy.biz.UserBiz;
import com.hxzy.entity.User;
import com.hxzy.util.PageUtil;
import com.hxzy.vo.UserVo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UserBizImplTest {

    private UserBiz userBiz;

    @Before
    public void init(){
        userBiz = new UserBizImpl();
    }

    @Test
    public void insert() {
        User user = new User(0, "admin", "admin", "123456", "admin@qq.com");
        int insert = userBiz.insert(user);
        assertThat(insert, greaterThan(0));
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void queryAll() {
    }

    @Test
    public void login() {
        UserVo admin = userBiz.login("admin", "123456");
        System.out.println(admin);
        assertThat(admin, notNullValue());
    }

    @Test
    public void paging() {
        PageUtil<User> pageUtil = new PageUtil<>();
        PageUtil paging = userBiz.paging(pageUtil, "admin");
        System.out.println(paging.getData());
        System.out.println("total:" + paging.getTotal());
        assertThat(paging.getData().size(), greaterThan(0));
    }

    @Test
    public void total() {
    }
}