<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<body>
<form class="form-horizontal"  id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label" style="margin: 0 0;padding: 0 0">ID</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="id" name="id" placeholder="id">

        </div>
    </div>
    <div >
        <div class="row">
            <div class="form-group col-md-9">
                <label for="internetAddress" class="col-md-3 control-label">代理商登录地址：</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="internetAddress" name="internetAddress" placeholder="代理商登录地址">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-9">
                <label for="merchantName" class="col-md-3 control-label">代理商登录页名称：</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="merchantName" name="merchantName" placeholder="代理商登录页名称">
                </div>
            </div>
        </div>
    </div>

</form>

</body>
</html>
