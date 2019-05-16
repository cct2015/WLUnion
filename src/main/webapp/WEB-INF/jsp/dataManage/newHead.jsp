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
    <title>新建加盟</title>

</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <form class="form-horizontal" role="form" id="myform">
            <div class="container">
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="companyName" class="col-sm-7 control-label">商户名称：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="companyName" name="companyName" placeholder="企业名"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5 col-lg-offset-1">
                        <label for="companyShort" class="col-md-7 control-label">商户简称：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="companyShort" name="companyShort" placeholder="企业简称"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="marketingNo" class="col-sm-7 control-label">商户号：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="marketingNo" name="marketingNo" placeholder="商户号">

                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="industryId" class="col-sm-7 control-label">行业类别：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="industryId" name="industryId">
                            </select>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="contacter" class="col-sm-7 control-label">联系人：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="contacter" name="contacter" placeholder="联系人"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="tel" class="col-sm-7 control-label">联系电话：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="tel" name="tel" placeholder="联系电话"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="mainBrand" class="col-sm-7 control-label">主营品牌：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="mainBrand" name="mainBrand" placeholder="主营品牌"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="mainProduct" class="col-sm-7 control-label">主营产品：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="mainProduct" name="mainProducts" placeholder="主营产品"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="country" class="col-sm-7 control-label">国家：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="country" name="country">
                                <option value="中国">中国</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="province" class="col-sm-7 control-label">省：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="province" name="province">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="city" class="col-sm-7 control-label">市：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="city" name="city">
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="district" class="col-sm-7 control-label">县（区）：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="district" name="district">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="form-group col-md-5">
                        <label for="merchantType" class="col-sm-7 control-label">商户类别：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="merchantType" name="merchantType">
                                <option value="0">代理商</option>
                                <option value="1">企业商户</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="address" class="col-sm-7 control-label">企业地址：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="address" name="address" placeholder="企业地址" disabled/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="step" class="col-sm-7 control-label">商户级别：</label>
                        <div class="col-sm-5">
                            <input type="number" class="form-control" id="step" name="step" placeholder="商户级别" min="0"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="parentId" class="col-sm-7 control-label">上级商户：</label>
                        <div class="col-sm-5">
                            <select class="form-control" id="parentId" name="parentId">
                                <option value="0">总部</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="bankUser" class="col-sm-7 control-label">开户名：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="bankUser" name="bankUser" placeholder="户名">
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="bankNo" class="col-sm-7 control-label">银行对公账号：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="bankNo" name="bankNo" placeholder="银行对公账号"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="bankAddress" class="col-sm-7 control-label">开户行：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="bankAddress" name="bankAddress" placeholder="开户行"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="faxNo" class="col-sm-7 control-label">纳税号：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="faxNo" name="faxNo" placeholder="纳税号"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="creditCode" class="col-sm-7 control-label">企业信用码/营业执照号：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="creditCode" name="creditCode" placeholder="企业信用码或营业执照号"/>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="addUser" class="col-sm-7 control-label">添加人：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="addUser" name="addUser" placeholder="添加人"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="remark" class="col-sm-7 control-label">备注：</label>
                        <div class="col-sm-5">
                            <textarea class="form-control" id="remark" name="remark" placeholder="备注" style="width: 720px;height: 200px;resize:none;"></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="name" class="col-sm-7 control-label">用户名：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="name" name="name" placeholder="用户名"/>
                            <span id="doubleName" hidden="hidden" style="color: red">*用户名重复</span>
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="password" class="col-sm-7 control-label">密码：</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="password" name="password" placeholder="密码"/>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-top: 20px;">
                <div class="form-group col-md-12" style="text-align: center;">
                    <input type="button" id="success11" class="btn btn-primary btn-sm" style="width: 300px;height: 60px;" value="提交"/>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function () {

        var flag=0;

        //初始化给行业赋值
        $.get("${ctx}/baseIndustry/selectAll", function (data) {
            for(var i=0;i<data.rows.length;i++){
                $("#industryId").append("<option value='"+data.rows[i].id+"'>"+data.rows[i].industryName+"</option>");
            }
        })
        //初始化给省市区赋值和企业地址的值
        $.get("${ctx}" +"/static/json/location.min.json", function (data) {
            for(var key in data){
                $("#province").append("<option value='"+data[key].code+"'>"+data[key].name+"</option>");
                for(var keys in data[key].cities){
                    if(data[key].code == $("#province").val()){
                        $("#city").append("<option value='"+data[key].cities[keys].code+"'>"+data[key].cities[keys].name+"</option>");
                        for(var keyss in data[key].cities[keys].districts){
                            if(data[key].cities[keys].code == $("#city").val()){
                                $("#district").append("<option value='"+keyss+"'>"+data[key].cities[keys].districts[keyss]+"</option>");
                                $("#address").val(data[key].name+" "+data[key].cities[keys].name+" "+data[key].cities[keys].districts[$("#district").val()]);
                            }
                        }
                    }
                }
            }
        })
        //选择省时替换市区的值和企业地址的值
        $("#province").change(function () {
            $("#city").children().remove();
            $("#district").children().remove();
            $.get("${ctx}" +"/static/json/location.min.json", function (data) {
                for(var key in data) {
                    for (var keys in data[key].cities) {
                        if (data[key].code == $("#province").val()) {
                            $("#city").append("<option value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                            for (var keyss in data[key].cities[keys].districts) {
                                if (data[key].cities[keys].code == $("#city").val()) {
                                    $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                    $("#address").val(data[key].name+" "+data[key].cities[keys].name+" "+data[key].cities[keys].districts[$("#district").val()]);
                                }
                            }
                        }
                    }
                }
            })
        })
        //选择市时替换区的值和企业地址的值
        $("#city").change(function () {
            $("#district").children().remove();
            $.get("${ctx}" +"/static/json/location.min.json", function (data) {
                for(var key in data) {
                    for (var keys in data[key].cities) {
                        for (var keyss in data[key].cities[keys].districts) {
                            if (data[key].cities[keys].code == $("#city").val()) {
                                $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                $("#address").val(data[key].name+" "+data[key].cities[keys].name+" "+data[key].cities[keys].districts[$("#district").val()]);
                            }
                        }
                    }
                }
            })
        })
        //选择区时替换企业地址的值
        $("#district").change(function () {
            $.get("${ctx}" +"/static/json/location.min.json", function (data) {
                for(var key in data) {
                    for (var keys in data[key].cities) {
                        for (var keyss in data[key].cities[keys].districts) {
                            if (data[key].cities[keys].code == $("#city").val()) {
                                $("#address").val(data[key].name+" "+data[key].cities[keys].name+" "+data[key].cities[keys].districts[$("#district").val()]);
                            }
                        }
                    }
                }
            })
        })
        //根据商户类别替换上级商户的值
        $("#merchantType").change(function () {
            $("#parentId").children().remove();
            if($(this).val()==1){
                //初始化给上级商户赋值
                $.get("${ctx}/marketingMerchant/getParentMerchant", function (data) {
                    $("#parentId").append("<option value='0'>总部</option>");
                    for(var i=0;i<data.length;i++){
                        console.log(data);
                        $("#parentId").append("<option value='"+data[i].id+"'>"+data[i].companyName+"</option>");
                    }
                })
            }else{
                $("#parentId").append("<option value='0'>总部</option>");
            }
        })
        //提交
        $("#success11").click(function () {
            //find("option:selected").text().trim()
            if(flag==2){
                var json = {
                    companyName:$("#companyName").val(),
                    companyShort:$("#companyShort").val(),
                    industryId:$("#industryId").val(),
                    contacter:$("#contacter").val(),
                    tel:$("#tel").val(),
                    mainProducts:$("#mainProduct").val(),
                    country:$("#country").val(),
                    province:$("#province").val(),
                    city:$("#city").val(),
                    district:$("#district").val(),
                    mainBrand:$("#mainBrand").val(),
                    merchantType:$("#merchantType").val(),
                    step:$("#step").val(),
                    address:$("#address").val(),
                    parentId:$("#parentId").val(),
                    bankNo:$("#bankNo").val(),
                    bankAddress:$("#bankAddress").val(),
                    faxNo:$("#faxNo").val(),
                    creditCode:$("#creditCode").val(),
                    addUser:$("#addUser").val(),
                    bankUser:$("#bankUser").val(),
                    marketingNo:$("#marketingNo").val(),
                    remark:$("#remark").val()
                }
                $.ajax({
                    url:"/marketingMerchant/merchantAndUserInsert",
                    type:"post",
                    data:{"jsonStr":JSON.stringify(json),"name":$("#name").val(),"password":$("#password").val()},
                    dataType:"json",
                    success:function (data) {
                        location.href='/dataManage/marketingMerchant';
                    }
                })
            }else {
                getCode("check","请确认用户名是否正确输入！");
                return false;
            }


        })
        $("#name").blur(function() {
            $.ajax({
                url:"${ctx}/verificateUser",
                type:"post",
                data:{"name":$("#name").val()},
                dataType:"json",
                success:function (data) {
                    if(data.length!=0){

                        $("#doubleName").removeAttr("hidden");
                        flag=1;
                    }else {
                        $("#doubleName").attr("hidden","true");
                        flag=2;
                    }
                }
            })
        })

    })
</script>
</body>
</html>
