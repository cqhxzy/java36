<%@ page import="com.hxzy.biz.BrandBiz" %>
<%@ page import="com.hxzy.biz.impl.BrandBizImpl" %>
<%@ page import="com.hxzy.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //调用品牌的业务逻辑层
    BrandBiz brandBiz = new BrandBizImpl();
    //查询所有品牌信息
    List<Brand> brands = brandBiz.queryAll();

    //从request作用域中获取要被修改的手机信息
    Map<String, Object> phone = (Map<String, Object>) request.getAttribute("phone");

    Integer brandId = ((Long)phone.get("brandId")).intValue(); //品牌
    Integer seriesId = ((Long)phone.get("seriesId")).intValue();//系列
    Integer os = ((Long)phone.get("os")).intValue();//系统

    Integer networkModel = phone.get("networkModel")!=null ? ((Long)phone.get("networkModel")).intValue() : 0;
%>

<html>
<head>
    <title>修改手机</title>
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
        tr{
            line-height: 50px;
        }
        td:last-child{
            text-align: left;
            padding-left: 10px;
        }

        tr:last-child td{
            text-align: center;
        }

        input:disabled{ /*为所有的禁用的input标签设置鼠标悬浮时，鼠标的图标显示为禁止*/
            cursor: not-allowed;
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
    </style>
    <%
        String contextPath = request.getContextPath();
    %>
    <script src="<%=contextPath%>/static/vendor/jquery/jquery-1.10.2.min.js"></script>
    <script>

        $(function(){

            querySeriesImmediately();

            $("[name='os']").change(function(){
                let phoneType = $(this).val();

                let netType = $("[name='networkModel']"); //获取所有的网络类型的复选框

                if(phoneType == 3){
                    netType.attr("disabled","disabled");
                } else {
                    netType.removeAttr("disabled");
                }
            });

            $("[name='networkModel']").change(function(){

                let val = $(this).val();
                let checked = $(this).prop("checked"); //是否被选中
                let $index = $(this).parent($(this)).index();//获取当前被选择的复选框的索引
                //console.log($(this).parent($(this)).index());
                if(!checked){
                    $(this).prop("checked",false);
                    $("[name='networkModel']").each(function(index,item){
                        let that = $(item).val();
                        //console.log(that);
                        if(that == val){
                            $(item).prop("checked",false);
                            val++;
                        }
                    })
                }else{
                    $("[name='networkModel']").each(function(index,item){
                        //console.log("index:"  + index + ",$(this).index():" + $index)
                        if(index <= $index){
                            $(item).prop("checked",true);
                        }
                    });
                }
            });

            $("[name='brand']").change(function(){
                $("[name='series']").empty(); //清空系列原本的option
                querySeriesImmediately();
            });

            /*表单提交事件*/
            $("form").submit(function(e){
                e.preventDefault();

                //表单验证

                //通过异步，将用户输入的手机信息插入到数据
                let data = $("form").serialize();
                console.log(data);

                //向服务器发起一次post请求，将表单中的数据提交到addPhone的servlet中
                $.post(
                    "<%=contextPath%>/updatePhone",
                    data,
                    function(json){
                        console.log(json);
                        if(json && json.result == true){
                            alert("修改成功");
                        } else {
                            alert("修改失败");
                        }
                    }
                    ,"json"
                );
            });

            /*立即根据品牌查询系列*/
            function querySeriesImmediately(){
                let brandId = $("[name='brand']").val(); //获取当前被选择的option的value值,获取被选择的品牌编号

                let seriesId = $("[name='seriesId']").val();
                //利用ajax异步请求json
                $.getJSON("<%=contextPath%>/phone/getSeries",{"brandId":brandId},function(json){
                    //console.log(json);
                    $(json).each(function(index,item){ //通过循环，将json转换为option，并追加到系列下拉列表中

                        //console.log(item);
                        let id = item["id"];
                        let name = item["name"];
                        let template;
                        if(seriesId == id){
                            template = $("<option selected  value='"+ id +"'>"+name+"</option>");
                        } else {
                            template = $("<option  value='"+ id +"'>"+name+"</option>");
                        }
                        $("[name='series']").append($(template));

                    });
                });
            }
        });

    </script>
</head>
<body>
<form method="post" >
    <table>
        <caption>
            <h2>
                修改手机
                <input type="hidden" name="seriesId" value="<%=seriesId%>" />
                <input type="hidden" name="id" value="<%=phone.get("id")%>" />
                <a href="<%=contextPath%>/phoneList">返回首页</a>
            </h2>
        </caption>
        <tr>
            <td>品牌</td>
            <td>

                <select name="brand" disabled>
                    <%
                        for (Brand brand : brands) {
                    %>
                        <option <%=brand.getId().equals(brandId)?"selected":""%> value="<%=brand.getId()%>"><%=brand.getName()%></option>
                    <%
                        }
                    %>

                </select>
            </td>
        </tr>
        <tr>
            <td>系列</td>
            <td>
                <select name="series"></select>
            </td>
        </tr>
        <tr>
            <td>操作系统</td>
            <td>
                <label>
                    <input type="radio" name="os" value="1" <%=os.equals(1)?"checked":""%> /> Android
                </label>
                <label>
                    <input type="radio" name="os" value="2" <%=os.equals(2)?"checked":""%>/> IOS
                </label>
                <label>
                    <input type="radio" name="os" value="3" <%=os.equals(3)?"checked":""%>/> 老人机
                </label>
            </td>
        </tr>
        <tr class="disabled">
            <td>网络类型</td>
            <td>
                <label>
                    <input type="checkbox" name="networkModel" value="2" <%=networkModel != null &&networkModel.equals(2)?"checked":""%> /> 2G
                </label>
                <label>
                    <input type="checkbox" name="networkModel" value="3" <%=networkModel != null &&networkModel.equals(3)?"checked":""%> /> 3G
                </label>
                <label>
                    <input type="checkbox" name="networkModel" value="4" <%=networkModel != null &&networkModel.equals(4)?"checked":""%> /> 4G
                </label>
                <label>
                    <input type="checkbox" name="networkModel" value="5" <%=networkModel != null &&networkModel.equals(5)?"checked":""%> /> 5G
                </label>
            </td>
        </tr>
        <tr>
            <td>价格</td>
            <td>
                <input type="text" name="price" value="<%=phone.get("price")%>" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">提交</button>
            </td>
        </tr>
    </table>
    seriesId:<%=phone.get("seriesId")%> <br />
    brandId:<%=phone.get("brandId")%> <br>
    os:<%=phone.get("os")%> <br>
    networkModel:<%=phone.get("networkModel")%> <br>
    price:<%=phone.get("price")%> <br>
</form>
</body>
</html>
