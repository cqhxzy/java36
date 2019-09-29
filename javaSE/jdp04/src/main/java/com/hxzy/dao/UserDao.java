package com.hxzy.dao;

import com.hxzy.entity.User;
import com.hxzy.util.PageUtil;

public interface UserDao extends CommonDao<User> {
    User login(String account,String loginPwd);
    /**
     * 分页查询
     * @param util
     * @return
     */
    PageUtil paging(PageUtil util,String condition);

    /**
     * 分页查询条数
     * @param condition
     * @return
     */
    int total(String condition);

    /**
     * 查询用户名是否已经存在
     * @param account
     * @return
     */
    User validateAccount(String account);
}
