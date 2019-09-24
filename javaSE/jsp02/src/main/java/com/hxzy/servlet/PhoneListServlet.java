package com.hxzy.servlet;

import com.hxzy.biz.PhoneBiz;
import com.hxzy.biz.impl.PhoneBizImpl;
import com.hxzy.vo.PhoneVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phoneList")
public class PhoneListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PhoneBiz phoneBiz = new PhoneBizImpl();
        List<PhoneVo> phones = phoneBiz.queryAllPhone();

        //将查询出的数据添加到request作用域
        request.setAttribute("list",phones);

        request.getRequestDispatcher("/phone/phonelist.jsp").forward(request,response);
    }
}
