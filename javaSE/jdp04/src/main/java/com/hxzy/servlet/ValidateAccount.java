package com.hxzy.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UserBiz;
import com.hxzy.biz.impl.UserBizImpl;
import com.hxzy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/validateAccount")
public class ValidateAccount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String account = request.getParameter("account");
        boolean b = StringUtils.strNotEmpty(account);
        response.setContentType("application/json;charset=utf-8");
        HashMap<Object, Object> map = new HashMap<>();
        if (b) {
            UserBiz userBiz = new UserBizImpl();
            boolean b1 = userBiz.validateAccount(account);
            map.put("validate",b1);//true,可以注册  false,已经被注册
        } else {
            map.put("error", "系统繁忙");
        }
        String json = JSONObject.toJSONString(map);
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();

    }
}
