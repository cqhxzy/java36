package com.ajax.demo.controller;

import com.ajax.demo.entity.User;
import com.ajax.demo.service.UserService;
import com.ajax.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/")
public class IndexController {

    @Autowired
    private UserService service;

    @PostMapping(value="/login")
    public Object index(String account,String password){
        UserVo vo = service.login(account, password);
        Map map = new HashMap();
        map.put("isSuccess", vo != null);
        map.put("data",vo);
        return map;
    }

    @PostMapping("/register")
    public Object register(User user){
        Map result = new HashMap();
        if (user.getAccount() == null || user.getAccount() == "") {
            result.put("isSuccess",false);
            result.put("msg", "请完善注册信息");
            return result;
        }
        int i = service.validateUserAccount(user.getAccount());

        if (i != 0) {
            result.put("isSuccess",false);
            result.put("msg", "用户名已存在");
            return result;
        }

        int add = service.add(user);

        result.put("isSuccess",add != 0);
        result.put("msg", "注册成功");
        return result;
    }

    @PostMapping("/validAccount")
    public Object validateAccount(String account){
        int i = service.validateUserAccount(account);
        Map map = new HashMap();
        map.put("valid", i == 0);
        return map;
    }

    @GetMapping("/hotbooks")
    public Object hotBooks(){
        List list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("author","陈儒");
        map1.put("fav_nums",0);
        map1.put("image","https://img3.doubanio.com/lpic/s3435132.jpg");
        map1.put("title","Python源码剖析");

        Map map2 = new HashMap();
        map2.put("author","MarkPilgrim");
        map2.put("fav_nums",0);
        map2.put("image","https://img3.doubanio.com/lpic/s29631790.jpg");
        map2.put("title","Dive Into Python");

        Map map3 = new HashMap();
        map3.put("author","MarkPilgrim");
        map3.put("fav_nums",0);
        map3.put("image","https://img3.doubanio.com/lpic/s4059293.jpg");
        map3.put("title","Dive Into Python 3");

        list.add(map1);
        list.add(map2);
        list.add(map3);

        return list;
    }
}
