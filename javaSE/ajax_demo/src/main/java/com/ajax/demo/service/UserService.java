package com.ajax.demo.service;

import com.ajax.demo.entity.User;
import com.ajax.demo.vo.UserVo;

public interface UserService {
    UserVo login(String account,String password);

    int add(User user);

    int validateUserAccount(String account);
}
