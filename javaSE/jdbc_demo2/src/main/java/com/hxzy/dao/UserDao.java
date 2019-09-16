package com.hxzy.dao;

import com.hxzy.entity.User;

/**
 * UserDao接口中仅编写UserDao本身的接口
 */
public interface UserDao extends CommonDao<User>{

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);
}
