package com.hxzy.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.PhoneBiz;
import com.hxzy.biz.impl.PhoneBizImpl;
import com.hxzy.util.PageUtil;
import com.hxzy.vo.PhoneVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax_phoneList")
public class AjaxPhoneList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");

        String page = request.getParameter("page");//页码
        String size = request.getParameter("size"); //pageSize

        Integer pageIndex = PageUtil.DEFAULT_PAGE_INDEX;
        Integer pageSize = PageUtil.DEFAULT_PAGE_SIZE;
        if (page != null && page.matches("\\d{1,}")) {
            pageIndex = new Integer(page); //将参数转换为Integer类型
        }
        if (size != null && size.matches("\\d{1,}")){
            pageSize = new Integer(size);
        }

        PhoneBiz phoneBiz = new PhoneBizImpl();
        PageUtil<PhoneVo> paging = phoneBiz.paging(pageIndex, pageSize);

        /*
        * {
        *   data:[phonevo1,phonevo2,phoneovn]
        *   pageIndex:1
        *   pageSize:5
        *   next:true
        *   pre:false
        *   total:19
        *   totalPages:5
        * }
        *
        * 上一页   1    下一页
        * */
        String json = JSONObject.toJSONString(paging);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
