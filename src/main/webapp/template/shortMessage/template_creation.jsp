<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="container">
        <div class="row">
            <div class="form-group col-md-10">
                <label for="type" class="col-md-3 control-label">*模板类型：</label>
                <div class="col-md-7">
                    <select class="form-control" id="type" name="type">
                        <option value="3">营销类</option>
                        <option value="2">通知类</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10">
                <label for="name" class="col-md-3 control-label">*模板名称：</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" id="name" name="name" placeholder="">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="content" class="col-md-3 control-label">*模板内容：</label>
                <div class="col-md-7">
                    <textarea class="form-control" id="content" name="content" placeholder="例如：亲爱的%s,我公司最近特大优惠，最低优惠到%s折。欢迎光临！退订回复T!(模板内容必须包含退订！)"></textarea>
                </div>
            </div>
        </div>
        <%--<div class="row">
            <div class="form-group col-md-10>
                 <label for="staffId" class="col-md-3 control-label">*企业员工Id：</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" id="staffId" name="staffId" placeholder="">
                </div>
            </div>
        </div>--%>
    </div>
</form>
</body>
</html>
