<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>重置密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${ctx}/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/notifIt.min.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/static/css/bootstrapValidator.css"/>
    <link href="${ctx}/static/css/loginPage.css" rel='stylesheet' type='text/css' media="all"/>
    <script src="${ctx}/static/jqGrid/js/jquery.min.js"></script>
    <script src="${ctx}/static/js/notifIt.min.js"></script>
    <script src="${ctx}/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/static/js/bootstrapValidator.js"></script>
    <script src="${ctx}/static/js/jquery.form.js"></script>
    <script src="${ctx}/static/js/jquery.cookie.js"></script>
    <!-- /css files -->
    <style>
        .sendEmail {
            border: 5px;
            border-radius: 20px;
            height: 500px;
            width: 800px;
            opacity: 0.8;
            background-color: rgba(0, 0, 0, 0.11);
            margin-left: 15%;
            margin-top: 10%
        }
        html { overflow-x: hidden; overflow-y: auto; }
    </style>
</head>

<body>
<div class="log">
    <div class="sendEmail">
        <div style="padding-top: 100px;padding-left: 100px">
            <div class="container">
                <form class="form-horizontal" role="form" id="myform">
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="username" class="col-md-3 control-label">密码丢失的账号：</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" id="username" name="username"
                                       placeholder="请输入要找回密码的账号">
                                <span id="errorNotice"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8 col-lg-offset-1">
                            <label for="send" class="col-md-3 control-label"></label>
                            <div class="col-md-5">
                                <input type="button" value="发送验证码" onclick="settime(this)" name="send" id="send">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8 col-lg-offset-1">
                            <label for="password" class="col-md-3 control-label">验证码：</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" id="code" name="code" placeholder="请输入邮箱收到的验证码">
                            </div>
                        </div>
                    </div>
                </form>
                <form class="form-horizontal" role="form" id="myFormSubmit">
                    <div class="row">
                        <div class="form-group col-md-8 col-lg-offset-1">
                            <label for="password" class="col-md-3 control-label">请输入新密码：</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" id="password" name="password"
                                       placeholder="请输入新密码">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8 col-lg-offset-1">
                            <label for="repassword" class="col-md-3 control-label">确认新密码：</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" id="repassword" name="repassword"
                                       placeholder="确认新密码">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8 col-lg-offset-1">
                            <label for="repassword" class="col-md-3 control-label"></label>
                            <div class="col-md-5">
                                <input type="submit" value="提交新密码" name="updatePassword" id="updatePassword">
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>


    </div>
</div>
<script>
    var code = "";
    var userName = "";
    var countdown = 30;
    function settime(val) {
        if (countdown == 30) {
            userName = $("#username").val();
            $("#myform").bootstrapValidator({
                live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                message: '通用的验证失败消息',//好像从来没出现过
                feedbackIcons: {//根据验证结果显示的各种图标
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    username: {
                        validators: {
                            notEmpty: {
                                message: '*账号不能为空'
                            },
                            threshold: 2,//有2字符以上才发送ajax请求
                            remote: {//ajax验证。server result:{"valid",true or false}
                                url: "${ctx}/checkUserNameAndEmail",
                                message: '您的账户错误或者账户未绑定邮箱',
                                delay: 1000,//ajax刷新的时间是1秒一次
                                type: 'POST',
                                //自定义提交数据，默认值提交当前input value
                                cache: false,
                                data: function (validator) {
                                    return {
                                        name: $("#username").val()
                                    };
                                }
                            }
                        }
                    },
                }
            });
            var bootstrapValidator = $("#myform").data('bootstrapValidator');
            bootstrapValidator.validate();
            setTimeout(function () {
                if (bootstrapValidator.isValid() === true) {
                    $.ajax({
                        url: "${ctx}/sendEmailMsg?userName=" + userName,
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            code=data.data;
                            getCode("delete", "验证码已发送！")
                        }
                    })
                }
            }, 300);

        }

        if (countdown == 0) {
            val.removeAttribute("disabled");
            val.value = "发送验证码";
            countdown = 30;
        } else {
            val.setAttribute("disabled", true);
            val.value = "重新发送(" + countdown + ")";
            countdown--;
            setTimeout(function () {
                settime(val)
            }, 1000)
        }


    }

    $("#updatePassword").click(function () {
        var checkname = $.trim($("#myform").find("#username").val());
        var newcode = $("#code").val();
        if (checkname == userName && code == newcode && code != "" && newcode != "" && userName != "") {
            var json = {
                'name': userName,
                'password': $.trim($("#myFormSubmit").find("#password").val())
            };
            $("#myFormSubmit").bootstrapValidator({
                live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                message: '通用的验证失败消息',//好像从来没出现过
                feedbackIcons: {//根据验证结果显示的各种图标
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    password: {
                        validators: {
                            notEmpty: {
                                message: '*新密码不能为空'
                            }
                        }
                    },
                    repassword: {
                        validators: {
                            notEmpty: {
                                message: '*确认密码不能为空'
                            },
                            identical: {
                                field: 'password',
                                message: '*两次输入密码不一致'
                            }
                        }
                    }
                }
            });
            var bootstrapValidator = $("#myform").data('bootstrapValidator');
            bootstrapValidator.validate();
            if (bootstrapValidator.isValid()) {
                $.ajax({
                    url: "/updateSysUserPassword",
                    data: json,
                    dataType: "json",
                    cache: false,
                    success: function (response) {
                        getCode("update", "修改成功,即将返回登录页！");
                        setTimeout(function () {
                            window.location.href = "${ctx}/login";
                        }, 3000);
                    },

                    error: function (textStatus, e) {
                    }
                });
            } else {
                getCode("delete", "修改失败")
            }
        } else {
            getCode("check", "验证码不正确")
        }

    });
    function getCode(type, message) {

        if (type == 'add') {
            notif({
                msg: message,
                timeout: 2000,
                position: "right",
                type: "success"
            });
        }
        if (type == 'update') {
            notif({
                msg: message,
                position: "right",
                bgcolor: "#2fff5f",
                timeout: 2000,
                color: "#f19c65"

            });
        }
        if (type == 'delete') {
            notif({
                'type': 'success',
                'msg': message,
                timeout: 2000,
                'position': 'center'
            })
        }
        if (type == 'check') {
            notif({
                type: "warning",
                msg: message,
                position: "center",
                timeout: 2000,
                opacity: 0.8
            });
        }


    }
</script>
</body>
</html>
