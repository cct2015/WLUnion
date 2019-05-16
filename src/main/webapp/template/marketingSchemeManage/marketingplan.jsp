<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="motherid" value="${pageContext.request.getParameter('tenantId')}" />
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
                <label for="title" class="col-sm-4 control-label">标题：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="title" name="title" placeholder="标题">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="content" class="col-md-4 control-label">内容：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="content" name="content" placeholder="内容">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="remark" class="col-sm-4 control-label">备注：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="remark" name="remark" placeholder="备注">
                </div>

            </div>

        </div>

    </div>

</form>
<script>
    console.log(${motherid});
</script>
</body>
</html>
