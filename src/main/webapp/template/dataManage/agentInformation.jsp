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
            <input type="text" class="form-control" id="newIndustryId" name="newIndustryId" placeholder="newIndustryId">
            <input type="text" class="form-control" id="newProvince" name="newProvince" placeholder="newProvince">
            <input type="text" class="form-control" id="newCity" name="newCity" placeholder="newCity">
            <input type="text" class="form-control" id="newDistrict" name="newDistrict" placeholder="newDistrict">
            <input type="text" class="form-control" id="newMerchantType" name="newMerchantType" placeholder="newMerchantType">
            <input type="text" class="form-control" id="newParentId" name="newParentId" placeholder="newParentId">
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="form-group col-md-5">
                <label for="companyName" class="col-sm-7 control-label">渠道商名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="companyName" name="companyName" placeholder="商户名称">
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="companyShort" class="col-md-7 control-label">渠道商简称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="companyShort" name="companyShort" placeholder="商户简称">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-5">
                <label for="contacter" class="col-sm-7 control-label">联系人：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="contacter" name="contacter" placeholder="联系人">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="tel" class="col-sm-7 control-label">联系电话：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="tel" name="tel" placeholder="联系电话">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="bankUser" class="col-sm-7 control-label">开户名：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="bankUser" name="bankUser" placeholder="开户名">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="bankAddress" class="col-sm-7 control-label">开户行：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="bankAddress" name="bankAddress" placeholder="开户行">
                </div>
            </div>

        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="bankNo" class="col-sm-7 control-label">银行账号：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="bankNo" name="bankNo" placeholder="银行账号">
                </div>
            </div>

            <div class="form-group col-md-5" hidden="hidden">
                <label for="status" class="col-sm-7 control-label">状态：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="status" name="status" placeholder="状态">
                        <option value='0'>正常使用</option>
                        <option value='1'>停用</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-5" hidden="hidden">
                <label for="remark" class="col-sm-7 control-label">备注：</label>
                <div class="col-sm-5">
                    <textarea class="form-control" id="remark" name="remark" placeholder="备注" ></textarea>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>
