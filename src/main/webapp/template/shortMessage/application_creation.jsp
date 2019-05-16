<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>应用创建</title>
    <style>
        .modal .modal-dialog {
            width: 1000px;
        }
    </style>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="container">
        <div class="row">
            <div class="form-group col-md-10">
                <label for="name" class="col-md-3 control-label">*应用名称：</label>
                <div class="col-md-7">
                    <input type="text" class="form-control" id="name" name="name" placeholder="">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="desc" class="col-md-3 control-label">*应用描述：</label>
                <div class="col-md-7">
                    <textarea class="form-control" id="desc" name="desc"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-10 col-lg-offset-1">
                <label for="staffId" class="col-md-3 control-label">*企业员工id：</label>
                <div class="col-md-7">
                    <input type="number" class="form-control" id="staffId" name="staffId"/>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
