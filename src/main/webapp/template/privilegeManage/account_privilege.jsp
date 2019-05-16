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
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="form-group col-md-5">
                <label for="name" class="col-sm-4 control-label">用户名：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="name" name="name" placeholder="用户名">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="password" class="col-md-4 control-label">密码：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="password" name="password" placeholder="密码">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="repassword" class="col-md-4 control-label">确认密码：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="repassword" name="repassword" placeholder="确认密码">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="roleName" class="col-md-4 control-label">角色名：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="roleName" name="roleName" placeholder="角色名">
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
