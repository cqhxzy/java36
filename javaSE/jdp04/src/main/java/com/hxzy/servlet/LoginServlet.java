package com.hxzy.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UserBiz;
import com.hxzy.biz.impl.UserBizImpl;
import com.hxzy.vo.JsonMsg;
import com.hxzy.vo.UserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单提交的数据
        String account = request.getParameter("account");
        String loginPwd = request.getParameter("loginPwd");
        String[] remembers = request.getParameterValues("remember");//获取复选框的value值

        //调用业务逻辑层实现登录
        UserBiz userBiz = new UserBizImpl();
        UserVo login = userBiz.login(account, loginPwd);

        JsonMsg jsonMsg = new JsonMsg();
        if (login != null) {
            //如果需要保存用户名和密码
            if (remembers != null) {
                Cookie c_account = new Cookie("account", account);
                Cookie c_pwd = new Cookie("loginPwd", loginPwd);
                Cookie c_remeber = new Cookie("remember", Boolean.toString(true));

                c_account.setMaxAge(60 * 60 * 24 * 7);
                c_pwd.setMaxAge(60 * 60 * 24 * 7);
                c_remeber.setMaxAge(60 * 60 * 24 * 7);

                //cookie保存在客户端
                response.addCookie(c_account);
                response.addCookie(c_pwd);
                response.addCookie(c_remeber);
            }

            //将用户信息缓存到session
            HttpSession session = request.getSession();
            session.setAttribute("user",login);

            jsonMsg.setCode(JsonMsg.SUCCCESS);
            jsonMsg.setData(login);
        } else {
            jsonMsg.setCode(JsonMsg.FAIL);
            jsonMsg.setMsg("用户名或密码错误");
        }

        //将java 对象转换为json
        String json = JSONObject.toJSONString(jsonMsg);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
