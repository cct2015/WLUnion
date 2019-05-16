<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>欢迎登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${ctx}/static/css/loginPage.css" rel='stylesheet' type='text/css' media="all"/>
    <script src="${ctx}/static/jqGrid/js/jquery.min.js"></script>
    <script src="${ctx}/static/js/jquery.form.js"></script>
    <script src="${ctx}/static/js/jquery.cookie.js"></script>
    <!-- /css files -->
    <style>
        html { overflow-x: hidden; }
    </style>
</head>
<body>
<h1><span id="dataNameView"></span>数据营销联盟</h1>
<div class="log">
    <div class="content1">
        <h2>用户登录</h2>
        <form id="myform" action="${ctx}/login" method="post">
            <div>
                <input type="text" maxlength="50" id="username" name="username" placeholder="用户名" required=""/>
                <div id="divusername"
                     style="display: block; height: 18px; margin-top:0px;color:red; padding-top: 0px;"></div>
            </div>
            <div>
                <input type="password" maxlength="60" id="password" name="password" placeholder="密码" required=""/>
                <div id="divpassword" class="divpassword"></div>
            </div>
            <div class="rememberPassword">
                <input type="checkbox" onchange="myfunction()" id="check" name="check" style="margin-top: 0px;vertical-align: middle">记住密码
                <a href="sendEmail" style="padding-left: 40%">忘记密码?</a>
            </div>
            <div class="button-row">
                <a class="sign-in" onclick="login()">登录</a>
                <div class="clear"></div>
            </div>
        </form>
    </div>
    <div class="clear"></div>
</div>
<div class="footer">
    <%
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String now = df.format(d);
    %>
    <p><%=now %> &copy;上海陆尔信息科技有限公司</p>
</div>

<script>

    var test = window.location.href;
     $.ajax({
     url: "${ctx}/merchantInformation/getMerchantDefineInformation?url="+test,
     dataType: "json",
     type: 'POST',
     cache: false,
     success: function (data) {
         var v=data.merchantName;
         if(v!=""){
             $("#dataNameView").html(v);
         }else {

         }
     },
     error: function (status, e) {

     }
     });

    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            login();
        }
    });
    function login() {
        if (!checkInput()) return;
        $("#myform").ajaxSubmit({
            dataType: "json",
            type: "post",
            success: function (data) {
                if (data.code == 200) {
                    window.location.href = "${ctx}/common/index";
                } else {
                    $("#divpassword").html('用户名或密码输入错误！');

                }
            }
        });
    }
    function checkInput() {
        var Flag = true;
        var user = $("#username").val().trim();
        var Strname = "";
        var Strpass = "";
        if (user.length == 0) {
            Flag = false;
            Strname = "账号不能为空！";
        }
        else if (!checkTextValid(user)) {
            Flag = false;
            if (Strname != "")
                Strname += "<br />";
            Strname += "用户名不得含有怪异字符！";
        }
        var pwd = $("#password").val().trim();
        if (pwd.length == 0) {
            Flag = false;
            if (Strpass != "")
                Strpass += "<br />";
            Strpass += "密码不能为空！";
        }
        else if (!checkTextValid(pwd)) {
            Flag = false;
            if (Strpass != "")
                Strpass += "<br />";
            Strpass += "密码不得含有怪异字符！";
        }
        if (!Flag) {
            $("#divusername").html(Strname);
            $("#divpassword").html(Strpass)
        }
        else {
            $("#divusername").html('');
            $("#divpassword").html('')
        }
        return Flag;
    }

    function checkTextValid(value) {
        var Str = /^[^\|"'<>;]*$/;
        if (Str.test(value))
            return true;
        else
            return false;
    }

    /*记住密码*/
    $(function () {
        if ($.cookie("COOKIE_CHECK") == "true") {
            $("#username").val($.cookie("COOKIE_USERNAME"));
            $("#password").val($.cookie("COOKIE_PASSWORD"));
            $("#check").attr("checked", true);
        }
    });

    function myfunction() {
        if (($('input[name="check"]:checked').length) == "1") {

            $.cookie("COOKIE_USERNAME", $("#username").val(), {path: '/', expires: 10});
            $.cookie("COOKIE_PASSWORD", $("#password").val(), {path: '/', expires: 10});
            $.cookie("COOKIE_CHECK", "true", {path: '/', expires: 10});
            //var date = new Date();
            //date.setTime(date.getTime() + (3 * 24 * 60 * 60 * 1000)); //三天后的这个时候过期
            //$.cookie(COOKIE_NAME, $("#username").val(), { path: '/', expires: date });
        } else {

            $.cookie("COOKIE_USERNAME", null, {path: '/'});  //删除cookie
            $.cookie("COOKIE_PASSWORD", null, {path: '/'});  //删除cookie
            $.cookie("COOKIE_CHECK", "false", {path: '/'});  //删除cookie
        }
    }

</script>
</body>
</html>
