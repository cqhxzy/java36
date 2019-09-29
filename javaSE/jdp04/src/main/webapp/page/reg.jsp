<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
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

    <form class="form-signin" role="form" novalidate>
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="account" placeholder="请输入登录账号" regex="[a-z0-9_-]{3,16}" autofocus required>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="nickName" placeholder="请输入昵称" regex="[a-z0-9A-Z\u2E80-\u9FFF]+" autofocus required>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginPwd" placeholder="请输入登录密码" regex="[a-z0-9_-]{6,18}" style="margin-top:10px;" required>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="email" placeholder="请输入邮箱地址" regex="^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$" style="margin-top:10px;" required>
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="checkbox">
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="login.html">我有账号</a>
            </label>
        </div>
        <button class="btn btn-lg btn-success btn-block" > 注册</button>
    </form>
</div>
<script src="${basePath}/static/jquery/jquery-2.1.1.min.js"></script>
<script src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/static/layer/layer.js"></script>

<script>
    $(function(){
        $("#account").blur(function(){
            let account = $(this).val();
            let result = validateAccount();
            if(result){
                //向服务器提交异步请求，验证用户名是否已经存在
                $.post("${basePath}/validateAccount",{"account":account},function(json){
                    if (json && json.validate == false) {
                        console.log("用户名已经存在");
                        layer.msg("用户名已存在",{icon:5,anim:6,time:2000},function(){
                            //当msg关闭时触发的回调函数
                            console.log("layer回调被执行了")
                        })
                        $("#account").parents(".form-group").removeClass("has-success").addClass("has-error")
                    } else {
                        layer.msg("用户名可以注册",{
                            icon:6,
                            anim:2,
                            offset:'rb',
                            time:1000
                        })
                        $("#account").parents(".form-group").removeClass("has-error").addClass("has-success")
                    }
                });
            }
        });
        $("form").submit(function(e){
            e.preventDefault();

            let validate = new ValidateUser("form").validate();
            if(validate){
                //提交表单
            }
        });
    });

    /*
    * 通过ES6的语法，创建一个js的类
    * */
    class ValidateUser{
        constructor(x){
            this.selector = x; //定义类需要的属性
        }

        //验证非空的方法
       notNull(){
           $(this.selector).find("input").each(function(index,item){
               if( $(item).is("[required]")){
                   let notNull = $(item).val() != "" && $(item).val().length > 0;
                   if(!notNull){
                       $(item).parents(".form-group").removeClass("has-success").addClass("has-error");
                       layer.msg("非空选项必须填写",{icon:5,anim:6,time:2000});
                       return false;
                   } else {
                       $(item).parents(".form-group").removeClass("has-error").addClass("has-success");
                   }
               }
           })
           return $(this.selector).find(".has-error").length == 0
       }

       //验证正则表达式的方法
       test(){
           $(this.selector).find("input").each(function(index,item){
               if( $(item).is("[regex]")){
                  let str = $(item).attr("regex");
                   let val = $(item).val();
                   let regex = new RegExp(str); //将字符串转换为正则表达式
                  if (!regex.test(val)){
                      layer.msg("请输入符合规则的内容",{icon:5,anim:6,time:2000})
                      $(item).parents(".form-group").removeClass("has-success").addClass("has-error");
                      return false;
                  }
               }
           });
           return $(this.selector).find(".has-error").length == 0 //true通过验证，false验证失败
       }

       //统一暴露出的方法
       validate(){
           let n = this.notNull();
           if(n){
              let t =  this.test();
              return t;
           }
           return false;
       }
    }

    function validateAccount(){
        let account = $("#account").val();
        let regex = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
        if(!isNotNull(account) || !regex.test(account)){
            //账号不符合正则表达式规则
            //console.log("账号必须由英文字母开头的4-12位组成");
            layer.msg("账号必须由英文字母开头的4-12位组成",{
                icon:5,
                anim:6,
                time:2000
            });
            $("#account").parents(".form-group").removeClass("has-success").addClass("has-error")
            return false;
        }
        return true;
    }
    /*
    * 验证val不为空
    * val为空，返回false
    * val不为空，返回true
    * */
    function isNotNull(val){
        return ! val == '';
    }
</script>
</body>
</html>