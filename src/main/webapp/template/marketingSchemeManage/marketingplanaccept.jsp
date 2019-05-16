<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <script src="${ctx}/static/js/e_data_support.js"></script>
    <style>
        .input-group[class*=col-] {
            float: none;
            padding-left: 12.5px;
            padding-right: 7.5px;
            width: 176.66px;
        }

        .myOtherDescripe {
            width: 600px;
            height: 80px;
        }
    </style>
</head>
<body>
<form class="form-horizontal" role="form" id="myform">
    <div class="form-group required" hidden="hidden">
        <label for="id" class="col-sm-2 control-label">ID</label>
        <div class="col-sm-9">
            <input type="text" value="" class="form-control" id="id" name="id" placeholder="id">
        </div>
    </div>
    <div class="container" id="container">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="title" class="col-sm-4 control-label">方案名称：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="title" name="title">
                </div>
            </div>
            <div class="form-group col-md-6 col-lg-offset-1">
                <label for="content" class="col-md-4 control-label">方案内容：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="content" name="content">
                </div>
            </div>
            <input type="hidden" id="merchantId" name="merchantId" value=""/>

        </div>
        <div class="row">

            <div class="form-group col-md-6">
                <label for="describe" class="col-sm-4 control-label">活动描述：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="describe" name="describe">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="isDifferent" class="col-sm-4 control-label">推送方式 ：</label>
                <div class="col-sm-5">
                    <select class="form-control" id="isDifferent" name="isDifferent">
                        <option value="0">垂直营销</option>
                        <option value="1">异业营销</option>
                    </select>

                </div>
            </div>
        </div>
        <div class="row">

            <div class="form-group col-md-6">
                <label for="usageRule" class="col-sm-4 control-label">使用规则：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="usageRule" name="usageRule">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="supportStore" class="col-sm-4 control-label">支持门店 ：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="supportStore" name="supportStore">

                </div>
            </div>
        </div>
        <div class="row">

            <div class="form-group col-md-6 <%--col-lg-offset-1--%>">
                <label for="beginTime" class="col-md-4 control-label">开始时间:</label>
                <div class=" input-group col-md-6 date form_datetime  "
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="beginTime"
                           id="beginTime" placeholder="开始时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>
            <div class="form-group col-md-6 <%--col-lg-offset-1--%>">
                <label for="endTime" class="col-md-4 control-label">结束时间:</label>
                <div class=" input-group  date form_datetime col-md-6"
                     data-date="" data-date-format="yyyy-mm-dd hh:ii">
                    <input class="form-control col-sm-4" readonly="readonly" type="text" value="" name="endTime"
                           id="endTime"
                           placeholder="结束时间">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
            </div>

        </div>
        <div class="row">


            <div class="form-group col-md-6">
                <label for="name" class="col-sm-4 control-label">活动联系人：</label>
                <div class="col-sm-5">
                    <input type="text" maxlength="50" class="form-control" id="name" name="name">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="tell" class="col-sm-4 control-label">联系电话：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="tell" name="tell">
                </div>
            </div>
        </div>
        <div class="row">

            <div class="form-group col-md-6">
                <label for="couponsNumber" class="col-sm-4 control-label">优惠卷数量：</label>
                <div class="col-sm-5">
                    <input type="number" min="0" maxlength="10" class="form-control" id="couponsNumber"
                           name="couponsNumber">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="remark" class="col-sm-4 control-label">备注：</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="remark" name="remark">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="selLabelNames" class="col-sm-4 control-label">目标人群属性：</label>
                <div class="col-sm-3">
                    <textarea id="selLabelNames" class="myOtherDescripe" name="selLabelNames" readonly
                              onclick="showMenu();" cols="40" rows="30"
                              placeholder="目标人群属性"></textarea>
                    <input type="hidden" id="hdnSelLabelKeys" value=""/>

                </div>
            </div>
        </div>
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
        <div class="row">
            <div class="form-group col-md-6">
                <label for="tell" class="col-md-8 control-label">接受状态：</label>
                <div class="col-md-4">
                    <select class="form-control" id="status" name="status">
                        <option value="1">接受</option>
                        <option value="2">拒绝接受</option>
                    </select>

                </div>
            </div>
        </div>
    </div>
</form>

</body>
<script>
    function showData(values) {


        if ($.trim(values.commissionTypeOne) != "") {
            $('#radio1').attr("checked", "checked")
        } else if ($.trim(values.commissionTypeTwo) != "") {
            $('#radio2').attr("checked", "checked")
        } else if ($.trim(values.commissionTypeThree) != "") {
            $('#radio3').attr("checked", "checked")
        }
        if (values.couponType == "折扣券") {
            $('#couponType0').attr("checked", "checked");
            if (values.preferentialWay == "固定") {
                $('#aaa0').attr("checked", "checked")
            } else {
                $('#aaa1').attr("checked", "checked")
            }
            $('#valueOne').val(values.valueOne),
                $('#valueTwo').val(values.valueTwo),
                $('#valueTree').val(values.valueTree)

        } else if (values.couponType == "满减券") {
            if (values.preferentialWay == "固定") {
                $('#aaa2').attr("checked", "checked")
            } else {
                $('#aaa3').attr("checked", "checked")
            }
            $('#couponType1').attr("checked", "checked"),
                $('#valueFour').val(values.valueOne),
                $('#valueFive').val(values.valueTwo),
                $('#valueSix').val(values.valueTree)
        } else if (values.couponType == "代金券") {
            $('#couponType2').attr("checked", "checked"),
                $('#valueSeven').val(values.valueOne),
                $('#valueEight').val(values.valueTwo)
        } else if (values.couponType == "兑换券") {
            $('#couponType3').attr("checked", "checked"),
                $('#valueNine').val(values.valueOne)
        }
        $('#id').val(values.id),
            $('#title').val(values.title),
            $('#content').val(values.content),
            $('#beginTime').val(values.beginTime),
            $('#endTime').val(values.endTime),
            $('#province').val(values.province),
            $('#city').val(values.city),
            $('#district').val(values.district),
            $('#name').val(values.name),
            $('#tell').val(values.tell),
            $('#commissionTypeOne').val(values.commissionTypeOne),
            $('#commissionTypeTwo').val(values.commissionTypeTwo),
            $('#commissionTypeThree').val(values.commissionTypeThree),
            $('#couponType').val(values.couponType),
            $('#preferentialWay').val(values.preferentialWay),
            $('#describe').val(values.describe),
            $('#remark').val(values.remark),
            $('#usageRule').val(values.usageRule),
            $('#supportStore').val(values.supportStore),
            $('#couponsNumber').val(values.couponsNumber),
            $('#isDifferent').val(values.isDifferent),
            $('#otherDescripe').val(values.otherDescripe),
            $('#status').val(values.status),
            getSelLabels(values.id)
        $('#myform').find('input,textarea').attr("disabled", "disabled");
        $('#isDifferent').attr("disabled", "disabled");
        /*
        var jsonArr = ['title','content','merchantId','beginTime','endTime','province','city','district',
            'name','tell','status','commissionTypeOne','commissionTypeTwo','commissionTypeThree',
            'preferentialWay','describe','isDifferent','otherDescripe',"merchant"];
        $('#myform').find('select,input,textarea').attr("disabled", "disabled");
        $('#status').removeAttr('disabled');
        bindData(jsonArr,values);
        setCommissionTypeRadio(values);
        setCouponTypeaAndValue(values);*/
    }

    function init() {
        var id = $('#id').val();
        $.post("${ctx}/marketingPlan/getMarketingPlanInEnterpriseById", {id: id}).done(function (data) {

            showData(data);
        });
    }

    window.onload = init();

    function getSelLabels(id) {
        $.ajax({
            url: "/MarketingPlanLabel/getSelLabels",
            dataType: "json",
            type: 'POST',
            data: {planId: id},
            cache: false,
            success: function (response) {
                var v = "";
                var keys = "";
                $.each(response, function (index, item) {
                    if (v != "") {
                        v += "," + item.labelName;
                        keys += "," + item.keyss;
                    }
                    else {
                        v = item.labelName;
                        keys = item.keyss;
                    }
                });

                $("#selLabelNames").html(v);
                $("#hdnSelLabelKeys").val(keys);
            },
            error: function (status, e) {
                alert("系统错误:" + e);
            }
        });
    }
</script>
</html>
