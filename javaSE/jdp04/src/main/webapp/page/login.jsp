<%@page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="${basePath}/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${basePath}/static/css/font-awesome.min.css">
	<link rel="stylesheet" href="${basePath}/static/css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">创意产品众筹平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="account" name="account" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="loginPwd" name="loginPwd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <%--<div class="form-group has-success has-feedback">
			<select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
		  </div>--%>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="remember"> 记住我
          </label>
          <br>
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="${basePath}/page/reg.jsp">我要注册</a>
          </label>
        </div>
        <button class="btn btn-lg btn-success btn-block" > 登录</button>
      </form>
    </div>
    <script src="${basePath}/static/jquery/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${basePath}/static/layer/layer.js"></script>
    <script>
        $(function(){
            $("form").submit(function(e){
                e.preventDefault();//阻止表单的默认行为
                //非空验证
                let result = validate();
                //console.log(result)
                //通过验证
                if(result){
                    //提交表单
                    let param = $("form").serialize(); //将表单序列化为字符串
                    $.post("${basePath}/login",param,function(json){
                        console.log(json)
                        if (json && json.code == 200){
                            //跳转页面
                            window.location.href="${basePath}/page/sys/main.jsp";
                        }  else if(json && json.code == 400){
                            //提示登录失败
                            layer.msg(json.msg,{icon:5,anim:6,time:2000});
                        }
                    });
                }
            });
        });

        function validate(){
            let result = true; //标记，假设表单通过了验证
            $(":text,:password").each(function(index,item){
                //console.log(item)
                let $item = $(item); //将dom对象转换为jquery对象
                let val = $item.val(); //获取文本框或密码框的value值
                if (val == "") {
                    layer.msg("请输入必填项",{icon:5,anim:6,time:2000});
                    $item.focus(); //获取焦点
                    result = false;
                    return false; //jquery的each循环中，通过return false跳出循环
                }
            });
            return result;
        }
    </script>
  </body>
</html>