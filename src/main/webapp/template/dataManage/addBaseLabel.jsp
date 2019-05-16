<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label" >ID</label>
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
                <label for="parentKey" class="col-sm-4 control-label">上级标签：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="parentKey" name="parentKey">上级标签</select>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-5">
            <label for="description" class="col-sm-4 control-label">标签描述：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" maxlength="60" id="description" name="description"
                       placeholder="标签描述">
            </div>
        </div>

        <div class="form-group col-md-5">
            <label for="leaf" class="col-sm-4 control-label">标签级别：</label>
            <div class="col-sm-5">
                <input type="number" class="form-control" min="0" id="leaf" name="leaf"
                       placeholder="标签级别">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-5">
            <label for="orderNo" class="col-sm-4 control-label">标签序号：</label>
            <div class="col-sm-5">
                <input type="number" class="form-control" min="0" id="orderNo" name="orderNo"
                       placeholder="标签序号">
            </div>
        </div>

        <div class="form-group col-md-5">
            <label for="isMust" class="col-sm-4 control-label">是否必选：</label>
            <div class="col-sm-5">
                <select class="form-control" id="isMust" name="isMust">
                    <option value="0">非必选</option>
                    <option value="1">必选</option>
                </select>

            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-5">
            <label for="remark" class="col-sm-4 control-label">备注：</label>
            <div class="col-sm-5">
                     <textarea id="remark" name="remark" style="width:457px;height:80px;" cols="40" rows="5"
                               placeholder="备注"></textarea>

            </div>
        </div>
    </div>

</form>

</body>
</html>
