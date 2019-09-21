package com.hxzy.biz.impl;

import com.hxzy.dao.UserDao;
import com.hxzy.dao.impl.UserDaoImpl;
import com.hxzy.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserBizImplTest {

    @Test
    public void queryAll() {
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.queryAll();

        users.stream().forEach(System.out::println);
    }
}