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
            <div class="form-group col-md-6">
                <label class="col-sm-4 control-label">营销佣金：</label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <br>
                <label class="col-sm-1 control-label"></label>
                <input name="Fruit" class="col-md-1" type="radio" id="radio1" checked value="1"/>按营销交易原单交易金额的<input
                    type="text" id="commissionTypeOne" name="commissionTypeOne"> % 收取
                </br>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-sm-1 control-label"></label>
                <input name="Fruit" class="col-md-1" type="radio" id="radio2" value="2"/>按营销交易固定金额收取,即
                <input type="text" id="commissionTypeTwo" name="commissionTypeTwo">元/笔
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label class="col-sm-4 control-label">券码营销：</label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <br>
                <label class="col-sm-1 control-label"></label>
                <input id="couponType0" class="col-sm-4" name="couponType" hidden type="radio" checked value="折扣券"/>折扣券:
                <input id="aaa0" name="aaa" class="col-md-1" type="radio" hidden myvalue="固定" value="testguding"
                       checked/>
                <input id="aaa1" name="aaa" type="radio" hidden myvalue="随机" value="testsuiji"/>
                &nbsp;折减
                <input type="text" size="5" id="valueOne" name="valueOne">%
                <br/>
            </div>
        </div>

    </div>

</form>
</body>
</html>
