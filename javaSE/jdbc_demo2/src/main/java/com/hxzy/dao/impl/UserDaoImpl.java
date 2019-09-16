package com.hxzy.dao.impl;

import com.hxzy.dao.UserDao;
import com.hxzy.entity.User;
import com.hxzy.utils.DbUtils;

import java.util.List;

public class UserDaoImpl extends DbUtils implements UserDao {
    @Override
    public User login(String userName, String password) {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }
}
