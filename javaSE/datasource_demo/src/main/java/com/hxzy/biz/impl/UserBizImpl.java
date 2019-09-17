package com.hxzy.biz.impl;

import com.hxzy.biz.UserBiz;
import com.hxzy.dao.UserDao;
import com.hxzy.dao.impl.UserDaoImpl;
import com.hxzy.entity.User;

import java.util.List;

public class UserBizImpl implements UserBiz {

    //业务逻辑层访问数据访问层
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
