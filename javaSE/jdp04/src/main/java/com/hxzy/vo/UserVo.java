package com.hxzy.vo;

public class UserVo {
    private Integer id;
    private String account;
    private String nickName;
    private String email;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserVo() {
    }

    public UserVo(Integer id, String account, String nickName, String email) {
        this.id = id;
        this.account = account;
        this.nickName = nickName;
        this.email = email;
    }
}
