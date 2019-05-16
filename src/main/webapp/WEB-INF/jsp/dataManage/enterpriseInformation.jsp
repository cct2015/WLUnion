<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>企业商户资料</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel" >
            <div class="x_title">
                <h2>企业商户资料</h2>
                <div class="clearfix"></div>
            </div>
            <div>
                <form class="form-horizontal" role="form" id="myform">
                    <div class="row">
                        <div class="form-group col-md-10">
                            <label for="id" class="col-sm-3 control-label" >商户ID</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="id" name="id" placeholder="id"
                                       readonly="true" >
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="companyName" class="col-sm-6 control-label">商户名称：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="companyName" name="companyName"
                                           placeholder="商户名称">
                                </div>
                            </div>
                            <div class="form-group col-md-5 ">
                                <label for="companyShort" class="col-sm-6 control-label">商户简称：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="companyShort" name="companyShort"
                                           placeholder="商户简称">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="marketingNo" class="col-sm-6 control-label">商户号：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="marketingNo" name="marketingNo"
                                           placeholder="商户号">

                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="industryId" class="col-sm-6 control-label">行业类别：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="industryId" name="industryId" placeholder="行业类别">
                                        <%--<option selected="selected" style='display: none'></option>--%>
                                    </select>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="contacter" class="col-sm-6 control-label">联系人：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="contacter" name="contacter"
                                           placeholder="联系人">
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="tel" class="col-sm-6 control-label">联系电话：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="tel" name="tel" placeholder="联系电话">
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="country" class="col-sm-6 control-label">国家：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="country" name="country">
                                        <option value="中国">中国</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="province" class="col-sm-6 control-label">省(直辖市)：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="province" name="province">
                                    </select>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="city" class="col-sm-6 control-label">城市：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="city" name="city">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="district" class="col-sm-6 control-label">县（区）：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="district" name="district">
                                    </select>
                                </div>
                            </div>

                        </div>

                        <div class="row">
                            <div class="form-group col-md-10">
                                <label for="address" class="col-sm-3 control-label">企业地址：</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" id="address" name="address" 企业地址="主营品牌" rows="3"
                                              cols="40"
                                              ></textarea>
                                </div>
                            </div>
                            <div class="form-group col-md-5" hidden>
                                <label for="step" class="col-sm-6 control-label">商户级别：</label>
                                <div class="col-sm-6">
                                    <input type="number" class="form-control" id="step" name="step" placeholder="商户级别"
                                           min="0"/>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="mainProducts" class="col-sm-6 control-label">主营产品：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="mainProducts" name="mainProducts"
                                           placeholder="主营产品">
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="merchantType" class="col-sm-6 control-label">商户类别：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="merchantType" name="merchantType"
                                            placeholder="商户类别" disabled>
                                        <option value='1'>企业商户</option>
                                    </select>
                                </div>
                            </div>


                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="parentId" class="col-sm-6 control-label">上级商户：</label>
                                <div class="col-sm-6">
                                    <select readonly="readonly" class="form-control" id="parentId" name="parentId"
                                            placeholder="上级商户">
                                        <option selected="selected" style='display: none'></option>
                                        <%--<option value="0">总部</option>--%>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="bankUser" class="col-sm-6 control-label">开户名：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="bankUser" name="bankUser"
                                           placeholder="开户名">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="bankAddress" class="col-sm-6 control-label">开户行：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="bankAddress" name="bankAddress"
                                           placeholder="开户行">
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="bankNo" class="col-sm-6 control-label">银行账号：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="bankNo" name="bankNo"
                                           placeholder="银行账号">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="creditCode" class="col-sm-6 control-label">营业执照账号：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="creditCode" name="creditCode"
                                           placeholder="营业执照账号">
                                </div>
                            </div>
                            <div class="form-group col-md-5">
                                <label for="faxNo" class="col-sm-6 control-label">纳税号：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="faxNo" name="faxNo" placeholder="纳税号">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-5">
                                <label for="acquirer" class="col-sm-6 control-label">收单机构：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="acquirer" name="acquirer" placeholder="收单机构">
                                        <option value='0'>银联</option>
                                        <option value='1'>杉德</option>
                                        <option value='2'>银联/杉德</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group col-md-5">
                                <label for="faxNo" class="col-sm-6 control-label">粉丝数：</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="fans" name="fans" placeholder="粉丝数">
                                </div>
                            </div>
                            <div class="form-group col-md-5" hidden="hidden">
                                <label for="status" class="col-sm-6 control-label">状态：</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="status" name="status" placeholder="状态">
                                        <option value='0'>正常使用</option>
                                        <option value='1'>停用</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-10">
                                <label for="mainBrand" class="col-sm-3 control-label">主营品牌：</label>
                                <div class="col-sm-9">
                    <textarea class="form-control" id="mainBrand" name="mainBrand" placeholder="主营品牌" rows="3" cols="40"
                              ></textarea>

                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-10">
                                <label for="remark" class="col-sm-3 control-label">备注：</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" id="remark" name="remark" placeholder="备注"
                                              ></textarea>
                                </div>
                            </div>
                        </div>
                        <%-- <div class="row"  id="userInformation">
                             <div class="form-group col-md-5">
                                 <label for="name" class="col-sm-6 control-label">用户名：</label>
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="name" name="name" placeholder="用户名"/>
                                 </div>
                             </div>
                             <div class="form-group col-md-5">
                                 <label for="password" class="col-sm-6 control-label">密码：</label>
                                 <div class="col-sm-6">
                                     <input type="text" class="form-control" id="password" name="password" placeholder="密码"/>
                                 </div>
                             </div>
                         </div>--%>
                        <div class="row">
                            <div class="form-group col-md-12" style="text-align: center;">
                                <input type="button" id="success11" class="btn btn-primary btn-sm"
                                       style="width: 300px;height: 30px;" value="确认修改"/>
                            </div>
                        </div>
                    </div>

                </form>

            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    var flag = 0;
    $(document).ready(function () {
        $.ajax({
            url: "${ctx}/marketingMerchant/selectById",
            type: "post",
            data: {"id": ""},
            dataType: "json",
            success: function (data) {
                console.log(data);
                console.log(data.rows[0]);
                var values = data.rows[0];
                $('#id').val(values.id),
                    $('#companyName').val(values.companyName),
                    $('#companyShort').val(values.companyShort),
                    $('#contacter').val(values.contacter),
                    $('#tel').val(values.tel),
                    $('#address').val(values.address),
                    $('#mainProducts').val(values.mainProducts),
                    $('#mainBrand').val(values.mainBrand),
                    $('#step').val(values.step),
                    $('#bankNo').val(values.bankNo),
                    $('#bankAddress').val(values.bankAddress),
                    $('#status').val(values.status),
                    $('#creditCode').val(values.creditCode),
                    $('#remark').val(values.remark),
                    $('#bankUser').val(values.bankUser),
                    $('#marketingNo').val(values.marketingNo),
                    $('#acquirer').val(values.acquirer),
                    $('#fans').val(values.fans),
                    $('#faxNo').val(values.faxNo)
//行业
                $.ajax({
                    type: "POST",
                    url: "${ctx}/baseIndustry/selectAll",
                    success: function (data) {
                        for (var i = 0; i < data.rows.length; i++) {
                            if (data.rows[i].id == values.industryId) {
                                $("#industryId").append("<option selected=\"selected\"  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
                                continue;
                            }
                            $("#industryId").append("<option  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
                        }
                    }
                });
                $("#merchantType").children("option[value='" + values.merchantType + "']").attr("selected", "selected");

                $.ajax({
                    type: "POST",
                    url: "${ctx}/marketingMerchant/selectAll",
                    success: function (data) {
                        for (var i = 0; i < data.rows.length; i++) {
                            if (data.rows[i].id == values.parentId) {
                                $("#parentId").append("<option selected=\"selected\" value='" + data.rows[i].id + "'>" + data.rows[i].companyName + "</option>");
                                $("#parentId").attr("disabled", "disabled");
                                continue;
                            }
                            if (data.rows[i].id != values.id) {
                                $("#parentId").append("<option  value='" + data.rows[i].id + "'>" + data.rows[i].companyName + "</option>");
                            }
                        }
                    }
                });

                $.get("${ctx}" + "/static/json/location.min.json", function (data) {
                    for (var key in data) {
                        if (data[key].code == values.province) {
                            $("#province").append("<option selected='selected' value='" + data[key].code + "'>" + data[key].name + "</option>");
                        }
                        $("#province").append("<option value='" + data[key].code + "'>" + data[key].name + "</option>");
                        for (var keys in data[key].cities) {
                            if (data[key].code == $("#province").val()) {
                                if (data[key].cities[keys].code == values.city) {
                                    $("#city").append("<option selected='selected' value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                                }
                                $("#city").append("<option value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                                for (var keyss in data[key].cities[keys].districts) {
                                    if (data[key].cities[keys].code == $("#city").val()) {
                                        if (keyss == values.district) {
                                            $("#district").append("<option selected='selected' value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                        }
                                        $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                    }
                                }
                            }
                        }
                    }
                })


            }
        })


    });

    //提交
    $("#success11").click(function () {
        //find("option:selected").text().trim()


        var json = {
            'id': $.trim($("#myform").find("#id").val()),
            'companyName': $.trim($("#myform").find("#companyName").val()),
            'companyShort': $.trim($("#myform").find("#companyShort").val()),
            'industryId': $.trim($("#myform").find("#industryId").val()),
            'contacter': $.trim($("#myform").find("#contacter").val()),
            'tel': $.trim($("#myform").find("#tel").val()),
            'district': $.trim($("#myform").find("#district").val()),
            'city': $.trim($("#myform").find("#city").val()),
            'province': $.trim($("#myform").find("#province").val()),
            'country': $.trim($("#myform").find("#country").val()),
            'address': $.trim($("#myform").find("#address").val()),
            'mainProducts': $.trim($("#myform").find("#mainProducts").val()),
            'mainBrand': $.trim($("#myform").find("#mainBrand").val()),
            'merchantType': $.trim($("#myform").find("#merchantType").val()),
            'step': $.trim($("#myform").find("#step").val()),
            'parentId': $.trim($("#myform").find("#parentId").val()),
            'bankNo': $.trim($("#myform").find("#bankNo").val()),
            'bankAddress': $.trim($("#myform").find("#bankAddress").val()),
            'remark': $.trim($("#myform").find("#remark").val()),
            'status': $.trim($("#myform").find("#status").val()),
            'faxNo': $.trim($("#myform").find("#faxNo").val()),
            'bankUser': $.trim($("#myform").find("#bankUser").val()),
            'marketingNo': $.trim($("#myform").find("#marketingNo").val()),
            'acquirer': $.trim($("#myform").find("#acquirer").val()),
            'fans': $.trim($("#myform").find("#fans").val()),
            'creditCode': $.trim($("#myform").find("#creditCode").val())
        }

        $("#myform").bootstrapValidator({
            live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
            submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
            message: '通用的验证失败消息',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                industryId: {
                    validators: {
                        notEmpty: {
                            message: '行业类型不能为空！'
                        },
                    }
                },
                companyName: {
                    validators: {
                        notEmpty: {
                            message: '商户名称不能为空！'
                        },
                    }
                },
                companyShort: {
                    validators: {
                        notEmpty: {
                            message: '企业简称不能为空！'
                        },
                    }
                },
                contacter: {
                    validators: {
                        notEmpty: {
                            message: '联系人不能为空！'
                        },
                    }
                },
                tel: {
                    validators: {
                        notEmpty: {
                            message: '联系电话不能为空！'
                        },
                    }
                },
                mainProducts: {
                    validators: {
                        notEmpty: {
                            message: '主营产品不能为空！'
                        },
                    }
                },
                mainBrand: {
                    validators: {
                        notEmpty: {
                            message: '主营品牌不能为空！'
                        },
                    }
                },
                creditCode: {
                    validators: {
                        notEmpty: {
                            message: '营业执照号不能为空！'
                        },
                    }
                },
                step: {
                    validators: {
                        notEmpty: {
                            message: '商户级别不能为空！'
                        },
                    }
                }

            }
        });
        var bootstrapValidator = $("#myform").data('bootstrapValidator');
        bootstrapValidator.validate();
        if (bootstrapValidator.isValid()) {
            $.ajax({
                url: "${ctx}/marketingMerchant/updateById",
                data: json,
                dataType: "json",
                cache: false,
                success: function (response) {
                    if (response != null) {


                        getCode('update', "修改成功!");
                        window.location.reload();
                    } else {
                        getCode('update', "修改失败!");

                    }
                },

                error: function (textStatus, e) {
                    getCode('update', "系统ajax交互错误!");

                }
            });
        }


    })

    $(function () {
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
    })
</script>
</body>
</html>
