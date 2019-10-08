package com.hxzy.vo;

/**
 * 为前端封装的一个json对象，用于描述响应
 */
public class JsonMsg {
    public static final Integer SUCCCESS = 200;
    public static final Integer FAIL = 400;
    private Integer code;// 200:成功   400：用户名或密码错误   500: 账号被禁用
    private String msg;
    private Object data;

    public JsonMsg() {
    }

    public JsonMsg(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
