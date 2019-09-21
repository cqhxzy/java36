package com.hxzy.vo;

public class UserVo {
    /**
     * 自增长序号
     */
    private Integer id;

    /**
     * 登录帐号
     */
    private String account;

    /**
     * 0代表用户，1代表管理员
     */
    private Boolean admin;

    /**
     * 用户姓名
     */
    private String username;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", admin=" + admin +
                ", username='" + username + '\'' +
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
