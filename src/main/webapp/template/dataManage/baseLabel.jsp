<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label" style="margin: 0 0;padding: 0 0">ID</label>
        <div class="col-sm-9">
            <input type="text" class="form-control" id="id" name="id" placeholder="id">
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="form-group col-md-5">
                <label for="text" class="col-sm-4 control-label">标签名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" maxlength="60" id="text" name="text" placeholder="标签名称">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="orderNo" class="col-sm-4 control-label">标签序号：</label>
                <div class="col-sm-5">
                    <input type="number" class="form-control" min="0" id="orderNo" name="orderNo"
                           placeholder="标签序号">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="isMust" class="col-sm-4 control-label">是否必选：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="isMust" name="isMust" >
                        <option value="0">非必选</option>
                        <option value="1">必选</option>
                    </select>

                </div>
            </div>
        </div>
    </div>

</form>
</form>
</body>
</html>
