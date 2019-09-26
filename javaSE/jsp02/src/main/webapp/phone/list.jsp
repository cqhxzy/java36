<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/26 0026
  Time: 下午 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机</title>

    <style>

        table{
            width: 500px;
            text-align: center;
            margin: 0 auto;
        }
        table,td,th{
            border: 1px solid black;
            border-collapse: collapse;
        }

        caption h2{
            position: relative;
        }
        caption h2 a{
            position: absolute;
            right: 0;
            bottom: 0;
            font: normal normal 16px "微软雅黑";
        }
        .foot{
            padding: 5px;
        }
        .pageIndex{
            display: inline-block;
            width: 20px;
            line-height: 20px;
            border: 1px solid lightskyblue;
            text-align: center;
            margin: 0 20px;
        }
        ul{
            margin: 0;
            padding: 0;
        }
        li{
            list-style: none;
            float: left;
        }
        .clear::after{
            content: '';
            display: block;
            clear: both;
        }
        li a{
            display: inline-block;
            width: 25px;
            line-height: 25px;
            border: 1px solid lightgray;
            text-align: center;
            margin: 0 5px;
            color: blue;
            cursor: pointer;
        }
        li a.pre,li a.next{
            min-width: 50px;
            border: none;
        }
        .foot ul{
            max-width: 450px;
        }
        .currentPage{
            color: #666;
            border: none;
        }
        li a:hover{
            border-color: blue;
            background-color: rgba(71,160,219,0.1);
        }
        .currentPage:hover{
            background-color: #fff;
            cursor: default;
        }
        li a.pre,li a.next:hover{
            background-color: #fff;
        }
    </style>
    <script src="<%=request.getContextPath()%>/static/vendor/jquery/jquery-1.10.2.min.js"></script>
</head>
<body>
<table>
    <caption>
        <h2>
            手机信息
            <!--
                在前端页面中，路径中的/代表着tomcat webapps根目录

                在后端java代码开发中，/代表着webapp目录。
            -->
            <%
                String contextPath = request.getContextPath();
            %>
            <a href="<%=contextPath%>/phone/addPhone.jsp">新增手机</a>
        </h2>
    </caption>
    <thead>
    <tr>
        <th>品牌</th>
        <th>系列</th>
        <th>系统</th>
        <th>网络类型</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <script>
            $(function(){

                paging();

                $("tfoot").on("click","a",function(e){
                    e.preventDefault();//阻止a标签跳转

                    let page = $(this).attr("page");
                    //alert("页码：" + page);
                    paging(page);
                })
            });
            function paging(pageIndex){
                pageIndex = pageIndex || 1;
                //浏览器加载完毕后，通过ajax异步请求数据
                $.getJSON("<%=request.getContextPath()%>/ajax_phoneList",{"page":pageIndex},function(json){
                    //console.log(json);
                    let data = json.data;
                    $("tbody").empty(); //清空tbody
                    //通过循环遍历，为表格添加数据
                    $(data).each(function(index,item){
                        let template = `
                                        <tr>
                                            <td>${item["brand"]}</td>
                                            <td>${item["series"]}</td>
                                            <td>${item["os"]}</td>
                                            <td>${item["networkModel"]}</td>
                                            <td>${item["price"]}</td>
                                            <td>
                                                <a href="<%=contextPath%>/updatePhone?id=${item["id"]}">修改</a>
                                                <a href="<%=contextPath%>/deletePhone?id=${item["id"]}">删除</a>
                                            </td>
                                        </tr>
                                    `;
                        $("tbody").append($(template));
                    });

                    //添加页码及页面跳转
                    let pre = json.pre;//是否有上一页
                    let next = json.next; //是否有下一页

                    let foot = $(".foot ul").empty();
                    if (pre){
                        foot.append($('<li><a class="pre" page="'+(json.pageIndex - 1)+'">上一页</a></li>'))
                    }
                    let nav = json.nav;
                    $(nav).each(function(index,item){
                        let $a = $('<li><a>'+item+'</a></li>').find("a");
                        if(item == json.pageIndex){ //在当前页上加载currentPage类
                            $a.addClass("currentPage");
                        } else{
                            $a.attr("page",item)
                        }
                        foot.append($a.parent());

                    });
                    if (next){
                        foot.append($('<li><a class="next" page="'+(json.pageIndex + 1)+'">下一页</a></li>'))
                    }

                })
            }
        </script>
    </tbody>
    <tfoot>
        <tr>
            <td colspan="6" class="foot">
                <ul class="clear"></ul>
            </td>
        </tr>
    </tfoot>
</table>
</body>
</html>
