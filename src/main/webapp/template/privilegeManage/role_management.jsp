<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label">ID</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="id" name="id" placeholder="id">
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="form-group col-md-5">
                <label for="rolename" class="col-sm-4 control-label">角色名：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="rolename" name="rolename" placeholder="角色名">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="createUser" class="col-md-4 control-label">创建人：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="createUser" name="createUser" placeholder="创建人">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="remark" class="col-md-4 control-label">备注：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="remark" name="remark" placeholder="备注">
                </div>
            </div>
        </div>
    </div>
</form>
<script>


</script>
</body>
</html>
