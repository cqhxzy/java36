package com.ajax.demo.service.impl;

import com.ajax.demo.entity.User;
import com.ajax.demo.mapper.UserMapper;
import com.ajax.demo.service.UserService;
import com.ajax.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserVo login(String account, String password) {
        User login = mapper.login(account, password);
        if (login == null) {
            return null;
        }
        UserVo vo = UserVo.builder()
                .id(login.getId())
                .account(login.getAccount())
                .name(login.getName())
                .phone(login.getPhone())
                .age(login.getAge())
                .gender(login.getGender())
                .address(login.getAddress())
                .email(login.getEmail())
                .idCard(login.getIdCard())
                .build();
        return vo;
    }

    @Override
    public int add(User user) {
        return mapper.insert(user);
    }

    @Override
    public int validateUserAccount(String account) {
        return mapper.validateUserAccount(account);
    }
}
