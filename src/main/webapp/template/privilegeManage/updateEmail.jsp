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
            <div class="form-group col-md-8">
                <label for="name" class="col-md-3 control-label">用户名：</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" disabled="disabled" id="name" name="name" placeholder="用户名">
                </div>
            </div>
            </div>
        <div class="row">
            <div class="form-group col-md-8 col-lg-offset-1">
                <label for="email" class="col-md-3 control-label">原邮箱：</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="oldEmail" name="oldEmail" placeholder="" disabled="disabled">
                </div>
            </div>

        </div>
        <div class="row">
            <div class="form-group col-md-8 col-lg-offset-1">
                <label for="email" class="col-md-3 control-label">请输入新邮箱：</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="email" name="email" placeholder="请输入新邮箱">
                </div>
            </div>

        </div>
    </div>
</form>
</body>
</html>
