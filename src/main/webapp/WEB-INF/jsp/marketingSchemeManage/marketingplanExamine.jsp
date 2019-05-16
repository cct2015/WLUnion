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
    <meta name="referrer" content="no-referrer">
    <link rel="shortcut icon" type="image/png" href="${ctx}/static/images/bool.png">
    <title>营销方案审核</title>
    <style>
        .login-dialog .modal-dialog {
            width: 500px;
            height: 500px;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>营销方案审核</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div>
                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>
                </div>
                <script type="text/javascript">
                    $(document).ready(function () {
                        $("#jqGrid").jqGrid({
                            url: '${ctx}/marketingPlan/getMarketingPlanExamine',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['ID', '方案名称', '方案内容', '所属商户', '开始时间', '结束时间', 'status', '审核状态', '省', '市', '县', '联系账号', '联系手机', '佣金1', '佣金2', '佣金3', '优惠券', '抵用方式', '券值1', '券值2', '券值3', '活动描述', '使用规则', '支持门店', '优惠卷数量', '创建人', '审核人', '推送方式', '优惠劵其他说明', '备注', 'couponUrl', 'couponsSource', '创建时间', '方案详细', '效果预测', '方案审核', '营销素材设置'],
                            colModel: [
                                {name: 'id', index: 'id', width: '30px', hidden: true},
                                {name: 'title', index: 'title', width: '300px'},
                                {name: 'content', index: 'content', width: '80px',hidden: true},
                                {name: 'merchantId', index: 'merchantId', width: '80px', hidden: true},
                                {name: 'beginTime', index: 'beginTime', width: '100px'},
                                {name: 'endTime', index: 'endTime', width: '100px'},
                                {name: 'status', index: 'status', width: '80px', hidden: true},
                                {
                                    name: 'ischeck', index: 'ischeck', width: '90px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch (rowObject.status) {
                                            case 0:
                                                return '未审核';
                                            case 1:
                                                return '通过审核';
                                            case 2:
                                                return '未通过审核';
                                            case 3:
                                                return '执行中';
                                            case 4:
                                                return '执行完毕';
                                            case 5:
                                                return '触达中';
                                            case 6:
                                                return '触达完毕';
                                            default:
                                                return "";
                                        }
                                    }
                                },
                                {name: 'province', index: 'province', width: '80px', hidden: true},
                                {name: 'city', index: 'city', width: '80px', hidden: true},
                                {name: 'district', index: 'district', width: '80px', hidden: true},
                                {name: 'name', index: 'name', width: '80px', hidden: true},
                                {name: 'tell', index: 'tell', width: '80px', hidden: true},
                                {name: 'commissionTypeOne', index: 'commissionTypeOne', width: '80px', hidden: true},
                                {name: 'commissionTypeTwo', index: 'commissionTypeTwo', width: '80px', hidden: true},
                                {
                                    name: 'commissionTypeThree',
                                    index: 'commissionTypeThree',
                                    width: '80px',
                                    hidden: true
                                },
                                {name: 'couponType', index: 'couponType', width: '80px', hidden: true},
                                {name: 'preferentialWay', index: 'preferentialWay', width: '80px', hidden: true},
                                {name: 'valueOne', index: 'valueOne', width: '80px', hidden: true},
                                {name: 'valueTwo', index: 'valueTwo', width: '80px', hidden: true},
                                {name: 'valueTree', index: 'valueTree', width: '80px', hidden: true},
                                {name: 'describe', index: 'describe', width: '80px', hidden: true},
                                {name: 'usageRule', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'supportStore', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'couponsNumber', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'checker', index: 'checker', width: '80px', hidden: true},
                                {name: 'isDifferent', index: 'isDifferent', width: '80px', hidden: true},
                                {name: 'otherDescripe', index: 'otherDescripe', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true},
                                {name: 'couponUrl', index: 'couponUrl', width: '80px', hidden: true},
                                {name: 'couponsSource', index: 'couponsSource', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '100px', sortable: true},

                                {
                                    name: 'detail', index: 'detail',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Btn = "<input type='button'  onclick=\"findDetail('" + options.rowId + "')\" value='查看详情'  />";
                                        return Btn;
                                    }
                                },   //详细
                                {
                                    name: 'forecast', index: 'forecast',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Btn = "<input type='button' value=\"效果预测\" onclick=\"forecast('" + rowObject.id + "')\" />";
                                        return Btn;
                                    }


                                },//效果预测
                                {
                                    name: 'examine', index: 'examine',
                                    formatter: function (grid_id, options, rowObject) {
                                        var htmlStr = "";
                                        switch (rowObject.status) {
                                            case 0:
                                                htmlStr = "<input type='button'  value='审 核' onclick=\"Check('" + rowObject.id + "')\" />";
                                                break;
                                            case 1:
                                                htmlStr = '已审核';
                                                break;

                                            case 2:
                                                htmlStr = '已审核';
                                                break;
                                        }
                                        return htmlStr;
                                    }

                                }, //审核
                                {
                                    name: 'coupon', index: 'coupon',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Btn = "";
                                        if (rowObject.status == 1) {
                                            Btn = "<input type='button' value=\"设置营销素材\" onclick=\"couponUpdate('" + options.rowId + "')\" />";
                                        }
                                        return Btn;
                                    }
                                },    //设置营销素材

                            ],

                            sortable: true,
                            /*sortname:'创建时间',*/
                            sortname: 'addTime',
                            sortorder: 'desc',
                            rowNum: 15,
                            rowList: [20, 15, 30],
                            height: $(window).height,
                            autowidth: true,
                            pager: "#jqGridPager",
                            altRows: true,
                            hidegrid: false,
                            viewrecords: true,
                            recordpos: 'left',
                            loadonce: false,
                            multiselect: false,
                            loadComplete: function () {
                            },
                            jsonReader: {
                                root: "rows",
                                page: "page",
                                total: "total",
                                records: "records",
                                repeatitems: false,
                                cell: "cell",
                                id: "id"
                            }
                        });

                        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                            refresh: false,
                            edit: false,
                            add: false,
                            del: false,
                            search: false,
                            position: "right"
                        })
                        // window.find = find;


                    });

                    //审核
                    function Check(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);

                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">审核方案</span>" +
                            "<input type='hidden' id='id' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplyExamine.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            //数据回显
                            onshown: function () {

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
                                    $('#status').val(values.status),
                                    $('#merchantId').val(values.merchantId),
                                    $('#remark').val(values.remark),
                                    $('#usageRule').val(values.usageRule),
                                    $('#supportStore').val(values.supportStore),
                                    $('#couponsNumber').val(values.couponsNumber),
                                    $('#describe').val(values.describe),
                                    $('#isDifferent').val(values.isDifferent),
                                    $('#otherDescripe').val(values.otherDescripe)
                                getSelLabels(values.id),
                                    $('#myform').find('select,input,textarea').attr("disabled", "disabled");
                                $('#status').removeAttr('disabled');

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var status = $.trim($("#myform").find("#status").val());
                                    var isDifferent = $.trim($("#myform").find("#isDifferent").val());
                                    var merchantId = $.trim($("#myform").find('#merchantId').val());
                                    if (status == null || status == '' || status == undefined) {
                                        getCode('add', "请选择审核状态!");
                                        return;
                                    }
                                    var json = {
                                        'id': id,
                                        'status': status,
                                        'isDifferent': isDifferent,
                                        'merchantId': merchantId
                                    };
                                    $.ajax({
                                        url: "${ctx}/marketingPlan/examineMarketingPlan",
                                        data: json,
                                        dataType: "json",
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {
                                                dialogItself.close();
                                                getCode('add', "审核成功!");
                                                $('#jqGrid').trigger('reloadGrid');
                                            } else {
                                                getCode('add', "审核失败!");
                                            }
                                        },

                                        error: function (textStatus, e) {
                                            getCode('add', "系统ajax交互错误!");
                                        }
                                    });
                                }
                            }, {
                                label: '关闭',
                                icon: 'fa fa-close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                        });
                    }

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

                    function forecast(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">适配人群数量</span>" +
                            "<input type='hidden' id='id' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingResultGuest.jsp?planId=' + values.id),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            //数据回显
                            buttons: [{
                                label: '关闭',
                                icon: 'fa fa-close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                        });
                    }

                    function findDetail(selectedRowId) {
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">查看详情</span>" +
                            "<input type='hidden' id='id' value='" + values.id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplyDetail.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {

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
                                    $('#status').val(values.status),
                                    $('#describe').val(values.describe1),
                                    $('#remark').val(values.remark),
                                    $('#usageRule').val(values.usageRule),
                                    $('#supportStore').val(values.supportStore),
                                    $('#couponsNumber').val(values.couponsNumber),
                                    $('#isDifferent').val(values.isDifferent),
                                    $('#otherDescripe').val(values.otherDescripe),

                                    getSelLabels(values.id),
                                    $('#myform').find('select,input,textarea').attr("disabled", "disabled");
                            },
                            buttons: [{
                                label: '关闭',
                                icon: 'fa fa-close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                        });

                    }

                    function couponUpdate(selectedRowId) {

                        //获得当前行各项属性
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">设置优惠券链接地址</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div style=\'z-index:800\'></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplycoupon.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                debugger;
                                //获取所有封面图片
                                var id = values.id;
                                console.log(id);
                                var coverType = "cover";
                                var sourceMaterialType = "sourceMaterial";
                                //获取所有封面图片
                                fileCoverShow(id, coverType);
                                //获取所有素材图片
                                sourceMaterialShow(id, sourceMaterialType);

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
                                    $('#merchantId').val(values.merchantId),
                                    $('#couponUrl').val(values.couponUrl),

                                    $('#couponsSource').val(values.couponsSource),
                                    getSelLabels(values.id)
                                // $('#myform').find('select,input,textarea').attr("disabled", "disabled");
                                $('#title').attr("disabled", "disabled");
                                $('#isDifferent').attr("disabled", "disabled");
                                $('#couponsNumber').attr("disabled", "disabled");

                                if (values.isDifferent == 1) {
                                    /*回显*/
                                    $.ajax({
                                        type: "POST",
                                        url: "${ctx}/marketingPlanRecommend/selectByPlanId?planId=" + id,
                                        success: function (data) {
                                            console.log( data);
                                            for (var i = 0; i < data.length; i++) {
                                                console.log( data[i]);
                                                if (i > 0) {
                                                    addRow();
                                                }

                                                $("#merchantId" + i).append("<option selected value='" + data[i].id + "'>" + data[i].companyName + "</option>");
                                                $("#couponUrlId" + i).val(data[i].couponUrl);
                                            }

                                        }
                                    });
                                }
                                if (values.isDifferent == 0) {
                                    document.getElementById("tableDiv").style.display = "none";
                                }

                                $('#myform').find('#couponUrl').removeAttr("disabled");
                                $('#myform').find('#couponsSource').removeAttr("disabled");

                            },
                            buttons: [{
                                id: 'btnformsubmit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var couponUrl = $.trim($("#myform").find("#couponUrl").val());
                                    if (($.trim(couponUrl).length == 0)) {
                                        getCode("check", "请填写优惠券链接地址！");
                                        return;
                                    }
                                    if (($.trim($.trim($("#myform").find("#couponsSource").val())).length == 0)) {
                                        getCode("check", "请填写优惠券来源！");
                                        return;
                                    }
                                    var list = [];
                                    if (values.isDifferent ==1) {
                                        var marketingPlanRecommendList;
                                        var currentRows = document.getElementById("urlTable").rows.length - 1;
                                        for (var i = 0; i < currentRows; i++) {
                                            var nowCouponUrl = $.trim($("#myform").find("#couponUrlId" + i).val());
                                            if ((nowCouponUrl == null) || (nowCouponUrl == "")) {
                                                getCode("check", "请填写优惠券链接地址！");
                                                return;
                                            }
                                            marketingPlanRecommendList = new Object();
                                            marketingPlanRecommendList.merchantId = $.trim($("#myform").find("#merchantId" + i).val());
                                            marketingPlanRecommendList.couponUrl = nowCouponUrl;
                                            list.push(marketingPlanRecommendList);

                                        }
                                    }

                                   /* debugger;
                                    var summernote = $.trim($("#myform").find("#summernote").val());
                                    console.log(summernote);

                                    var noticeContent=$.trim($("#myform").find("#noticeContent").val());
                                    console.log(noticeContent);*/
                                    var json = {
                                        id: $.trim($("#myform").find("#id").val()),
                                        list: JSON.stringify(list),
                                        couponUrl: $.trim($("#myform").find("#couponUrl").val()),
                                        couponsSource: $.trim($("#myform").find("#couponsSource").val()),
                                        isDifferent: $.trim($("#myform").find("#isDifferent").val())
                                    }
                                   $.ajax({
                                        url: "${ctx}/marketingPlan/couponMarketingPlanInEnterprise",
                                        data: json,
                                        //contentType:'application/json',
                                        dataType: "json",
                                        type: 'POST',
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {
                                                if (response.code == 200) {
                                                    getCode('update', "设置成功");
                                                    dialogItself.close();
                                                    $('#jqGrid').trigger('reloadGrid');
                                                }
                                                else {
                                                    getCode('update', "设置失败!");
                                                }
                                            } else {
                                                getCode('update', "设置失败!");
                                            }
                                        },
                                        error: function (textStatus, e) {
                                            getCode('update', "系统ajax交互错误!");
                                        }
                                    });
                                }

                            },
                                {
                                    label: '关闭',
                                    icon: 'fa fa-close',
                                    action: function (dialogItself) {
                                        dialogItself.close();
                                    }
                                }]
                        });

                    };

                    function fileCoverShow(id, type) {
                        var coverData = {
                            id: id,
                            type: type
                        }
                        //获取所有封面图片
                        $.ajax({
                            type: "POST",
                            url: "${ctx}/common/getAllPathFile",
                            data: coverData,
                            success: function (img) {

                                document.getElementById("galleryfileCover").innerHTML = "";
                                var div = document.createElement("div");
                                for (var i = 0; i < img.length; i++) {

                                    var url = img[i];
                                    // 创建 一个FileReader对象
                                    var reader = new FileReader();
                                    var box = document.createElement("img");
                                    box.setAttribute("src", url);
                                    box.className = 'img';
                                    var imgBox = document.createElement("div");
                                    imgBox.style.display = 'inline-block';
                                    imgBox.className = 'img-item';
                                    var deleteIcon = document.createElement("span");
                                    deleteIcon.className = 'delete';
                                    deleteIcon.innerText = 'x';
                                    deleteIcon.dataset.filename = img[i];
                                    imgBox.appendChild(deleteIcon);
                                    imgBox.appendChild(box);
                                    var body = document.getElementsByClassName("galleryfileCover")[0];
                                    body.appendChild(imgBox);
                                    $(deleteIcon).click(function () {
                                        var filename = $(this).data("filename");
                                        var path = {
                                            path: filename
                                        };
                                        $.ajax({
                                            type: "POST",
                                            url: "${ctx}/common/deleteFileByPath",
                                            data: path,
                                            success: function (data) {
                                                if (data.code = 200) {
                                                    getCode("check", "封面图片删除成功");
                                                    fileCoverShow(id, type);
                                                } else {
                                                    getCode("check", "封面图片删除失败");
                                                }
                                            }
                                        });
                                    })
                                }
                            },
                            error: function (textStatus, e) {
                                getCode('add', "系统ajax交互错误!");
                            }
                        });

                    }

                    function sourceMaterialShow(id, type) {
                        var sourceMaterialData = {
                            id: id,
                            type: type
                        }
                        $.ajax({
                            type: "POST",
                            url: "${ctx}/common/getAllPathFile",
                            data: sourceMaterialData,
                            success: function (img) {
                                document.getElementById("galleryfileImg").innerHTML = "";
                                var div = document.createElement("div");
                                for (var i = 0; i < img.length; i++) {
                                    var url = img[i];
                                    // 创建 一个FileReader对象
                                    var reader = new FileReader();
                                    var box = document.createElement("img");
                                    box.setAttribute("src", url);
                                    box.className = 'imgTwo';
                                    var imgBox = document.createElement("div");
                                    imgBox.style.display = 'inline-block';
                                    imgBox.className = 'img-itemTwo';
                                    var deleteIcon = document.createElement("span");
                                    deleteIcon.className = 'deleteTwo';
                                    deleteIcon.innerText = 'x';
                                    deleteIcon.dataset.filename = img[i];
                                    imgBox.appendChild(deleteIcon);
                                    imgBox.appendChild(box);
                                    var body = document.getElementsByClassName("galleryfileImg")[0];
                                    body.appendChild(imgBox);
                                    $(deleteIcon).click(function () {
                                        var filename = $(this).data("filename");
                                        var path = {
                                            path: filename
                                        };
                                        $.ajax({
                                            type: "POST",
                                            url: "${ctx}/common/deleteFileByPath",
                                            data: path,
                                            success: function (data) {
                                                if (data.code = 200) {
                                                    getCode("check", "素材图片删除成功");
                                                    sourceMaterialShow(id, type);
                                                } else {
                                                    getCode("check", "素材图片删除失败");
                                                }
                                            }
                                        });
                                    })
                                }
                            },
                            error: function (textStatus, e) {
                                getCode('add', "系统ajax交互错误!");
                            }
                        });
                    };


                </script>
            </div>
        </div>
    </div>
</div>

</body>
</html>
