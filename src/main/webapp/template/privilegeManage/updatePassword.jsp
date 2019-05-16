<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label" style="margin: 0 0;padding: 0 0">ID</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="id" name="id" placeholder="id" >
           <%-- <input type="text" class="form-control" id="flag" name="flag" value="0"/>--%>

        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="form-group col-md-5">
                <label for="name" class="col-sm-4 control-label">用户名：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" disabled="disabled" id="name" name="name" placeholder="用户名">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="oldPassword" class="col-md-4 control-label">旧密码：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="oldPassword" name="oldPassword" placeholder="旧密码">
                   <%-- <span id="doubleName" hidden="hidden" style="color: red"></span>--%>
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="password" class="col-md-4 control-label">新密码：</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="password" name="password" placeholder="新密码">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="repassword" class="col-md-4 control-label">确认新密码：</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="repassword" name="repassword" placeholder="确认新密码">
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    /*$("#oldPassword").focus(function () {
        $("#flag").val("1");
    });*/
    //判断用户名是否重复
   /* $("#oldPassword").blur(function () {

        console.log($("#name").val());
        if ($("#oldPassword").val() == null | $.trim($("#oldPassword").val()) == "") {
            document.getElementById("doubleName").innerText = "请输入旧密码！";
            $("#doubleName").removeAttr("hidden");
            $("#flag").val("1");
        } else {
            $.ajax({
                url: "/checkOldPassword",
                type: "post",
                data: {"name": $("#name").val(),
                      "password": $("#oldPassword").val()
                },
                dataType: "json",
                success: function (data) {
                    if (data.length == 0) {
                        console.log("-----------"+data.length);
                        document.getElementById("doubleName").innerText = "旧密码输入错误！";
                        $("#doubleName").removeAttr("hidden");
                        $("#flag").val("1");
                    } else {
                        console.log(data);
                        $("#doubleName").attr("hidden", "true");
                        $("#flag").val("2");
                    }
                }
            })
        }

    })*/
</script>
</body>
</html>
