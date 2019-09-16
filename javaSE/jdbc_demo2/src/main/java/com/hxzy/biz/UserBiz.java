package com.hxzy.biz;

import com.hxzy.entity.User;
import com.hxzy.vo.UserVo;

public interface UserBiz extends CommonBiz<User> {

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    UserVo login(String userName,String password);
}
