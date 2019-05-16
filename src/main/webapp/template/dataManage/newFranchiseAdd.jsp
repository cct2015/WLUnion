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
                <label for="companyName" class="col-sm-7 control-label">商户名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="companyName" name="companyName" placeholder="企业名">
                    <div style="display: none">
                        <input type="text" class="form-control" id="flag" name="flag" value="0"/>
                    </div>
                </div>
            </div>
            <div class="form-group col-md-5 col-lg-offset-1">
                <label for="companyShort" class="col-md-7 control-label">商户简称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="companyShort" name="companyShort" placeholder="企业简称">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="merchantType" class="col-sm-7 control-label">商户类别：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="merchantType" name="merchantType" placeholder="商户类别">
                        <option value='1'>企业商户</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="industryId" class="col-sm-7 control-label">行业分类：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="industryId" name="industryId" placeholder="行业名称">

                    </select>
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
                <label for="parentId" class="col-sm-7 control-label">上级商户：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="parentId" name="parentId" placeholder="上级商户">

                    </select>
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
                <label for="country" class="col-sm-7 control-label">国家：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="country" name="country">
                        <option value="中国">中国</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="province" class="col-sm-7 control-label">省(直辖市)：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="province" name="province">
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="city" class="col-sm-7 control-label">城市：</label>
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
                <label for="address" class="col-sm-7 control-label">企业地址：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="address" name="address" placeholder="企业地址" disabled>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="step" class="col-sm-7 control-label">商户级别：</label>
                <div class="col-sm-5">
                    <input type="number" class="form-control" id="step" name="step" placeholder="商户级别" min="0"/>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="mainBrand" class="col-sm-7 control-label">主营品牌：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="mainBrand" name="mainBrand" placeholder="主营品牌">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="mainProducts" class="col-sm-7 control-label">主营产品：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="mainProducts" name="mainProducts" placeholder="主营产品">
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
                <label for="bankNo" class="col-sm-7 control-label">银行对公账号：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="bankNo" name="bankNo" placeholder="银行对公账号">
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="faxNo" class="col-sm-7 control-label">纳税号：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="faxNo" name="faxNo" placeholder="纳税号">
                </div>
            </div>

        </div>
        <div class="row">
            <div class="form-group col-md-5">
            <label for="creditCode" class="col-sm-7 control-label">企业信用码/营业执照号：</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="creditCode" name="creditCode" placeholder="企业信用码/营业执照号">
            </div>
        </div>
            <div class="form-group col-md-5">
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
            <div class="form-group col-md-5">
                <label for="remark" class="col-sm-7 control-label">备注：</label>
                <div class="col-sm-5">
                    <textarea class="form-control" id="remark" name="remark" placeholder="备注" rows="3" cols="40"
                              style="width: 520px;height: 50px;resize:none;"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-5">
                <label for="name" class="col-sm-7 control-label">用户名：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="name" name="name" placeholder="用户名"/>
                    <span id="doubleName" hidden="hidden" style="color: red">*用户名存在或为空</span>
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
</form>
<script type="text/javascript">
    $(function () {
        //上级商户赋值
        $.get("${ctx}/marketingMerchant/selectAll", function (data) {
            $("#parentId").append("<option value='0'>总部</option>");
            for (var i = 0; i < data.rows.length; i++) {
                $("#parentId").append("<option value='" + data.rows[i].id + "'>" + data.rows[i].companyName + "</option>");
            }
        })

        //初始化给行业赋值
        $.get("${ctx}/baseIndustry/selectAll", function (data) {
            for (var i = 0; i < data.rows.length; i++) {
                $("#industryId").append("<option value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
            }
        })
        //初始化给省市区赋值和企业地址的值
        $.get("${ctx}" + "/static/json/location.min.json", function (data) {
            for (var key in data) {
                $("#province").append("<option value='" + data[key].code + "'>" + data[key].name + "</option>");
                for (var keys in data[key].cities) {
                    if (data[key].code == $("#province").val()) {
                        $("#city").append("<option value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                        for (var keyss in data[key].cities[keys].districts) {
                            if (data[key].cities[keys].code == $("#city").val()) {
                                $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                $("#address").val(data[key].name + " " + data[key].cities[keys].name + " " + data[key].cities[keys].districts[$("#district").val()]);
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
            $.get("${ctx}" + "/static/json/location.min.json", function (data) {
                for (var key in data) {
                    for (var keys in data[key].cities) {
                        if (data[key].code == $("#province").val()) {
                            $("#city").append("<option value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                            for (var keyss in data[key].cities[keys].districts) {
                                if (data[key].cities[keys].code == $("#city").val()) {
                                    $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                    $("#address").val(data[key].name + " " + data[key].cities[keys].name + " " + data[key].cities[keys].districts[$("#district").val()]);
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
            $.get("${ctx}" + "/static/json/location.min.json", function (data) {
                for (var key in data) {
                    for (var keys in data[key].cities) {
                        for (var keyss in data[key].cities[keys].districts) {
                            if (data[key].cities[keys].code == $("#city").val()) {
                                $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                $("#address").val(data[key].name + " " + data[key].cities[keys].name + " " + data[key].cities[keys].districts[$("#district").val()]);
                            }
                        }
                    }
                }
            })
        })
        //选择区时替换企业地址的值
        $("#district").change(function () {
            $.get("${ctx}" + "/static/json/location.min.json", function (data) {
                for (var key in data) {
                    for (var keys in data[key].cities) {
                        for (var keyss in data[key].cities[keys].districts) {
                            if (data[key].cities[keys].code == $("#city").val()) {
                                $("#address").val(data[key].name + " " + data[key].cities[keys].name + " " + data[key].cities[keys].districts[$("#district").val()]);
                            }
                        }
                    }
                }
            })
        })

        //判断用户名是否重复
        $("#name").blur(function () {

            console.log($("#name").val());
            if($("#name").val()==null|$.trim($("#name").val())==""){
                document.getElementById("doubleName").innerText="用户名不能为空！";
                $("#doubleName").removeAttr("hidden");
                $("#flag").val("1");
            }else{
                $.ajax({
                    url: "${ctx}/verificateUser",
                    type: "post",
                    data: {"name": $("#name").val()},
                    dataType: "json",
                    success: function (data) {
                        if (data.length != 0) {
                            document.getElementById("doubleName").innerText="用户名已存在！";
                            $("#doubleName").removeAttr("hidden");
                            $("#flag").val("1");
                        } else {
                            $("#doubleName").attr("hidden", "true");
                            $("#flag").val("2");
                        }
                    }
                })
            }

        })
    })
</script>
</body>
</html>
