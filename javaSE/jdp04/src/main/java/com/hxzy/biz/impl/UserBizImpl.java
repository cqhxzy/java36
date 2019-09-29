package com.hxzy.biz.impl;

import com.hxzy.biz.UserBiz;
import com.hxzy.dao.UserDao;
import com.hxzy.dao.impl.UserDaoImpl;
import com.hxzy.entity.User;
import com.hxzy.util.PageUtil;
import com.hxzy.vo.UserVo;

import java.util.List;

public class UserBizImpl implements UserBiz {
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

    @Override
    public UserVo login(String account, String loginPwd) {
        User login = userDao.login(account, loginPwd);
        if (login != null) {
            UserVo vo = new UserVo(login.getId(), login.getAccount(), login.getNickName(), login.getEmail());
            return vo;
        }
        return null;
    }

    @Override
    public PageUtil paging(PageUtil util, String condition) {
        return userDao.paging(util,condition);
    }

    @Override
    public int total(String condition) {
        return userDao.total(condition);
    }

    /**
     * 如果用户名已经存在，则返回false
     * 如果用户名不存在，则返回true
     * @param account
     * @return
     */
    @Override
    public boolean validateAccount(String account) {
        User user = userDao.validateAccount(account);
        return user == null;
    }
}
