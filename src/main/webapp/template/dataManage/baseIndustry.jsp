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
                <label for="industryName" class="col-sm-4 control-label">行业名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control"  maxlength="60" id="industryName" name="industryName" placeholder="行业名称">
                </div>
            </div>

        </div>

    </div>

</form>
</body>
</html>
