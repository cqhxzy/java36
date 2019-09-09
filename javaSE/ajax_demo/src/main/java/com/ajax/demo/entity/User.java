package com.ajax.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;/*ID*/
    private String account; /*账号*/
    private String name; /*姓名*/
    private String password;/*登录密码*/
    private String phone; /*电话*/
    private Integer age; /*年龄*/
    private String gender; /*性别*/
    private String address;/*地址*/
    private String email;/*邮箱*/
    private String idCard;/*身份证号码*/
}
