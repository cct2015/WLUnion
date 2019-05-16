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
    <style>
        .modal .login-dialog {
            width: 900px;
            margin-left: 40%;
            margin-top: 10px;
        }
    </style>


    <title>营销方案申请</title>
</head>
<body class="nav-md">
<script>

    function openWin(id) {
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPE_DEFAULT,
            title: "<span style=\"color:#73879C\">营销方案标签查看</span>",
            closable: false,
            draggable: true,
            cssClass: 'api-blacklist-form-add',
            message: $('<div></div>').load('/marketingPlan/marketingPlanLabelSettingPage?id=' + id),//加载弹出页面
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
</script>
<div class="container body">

    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>营销方案申请</h2>
                <div class="clearfix"></div>
            </div>
            <div container>
                <div class="row">
                    <form id="formSearch" class="form-horizontal">
                        <div class="form-group">
                            <label for="status" class="control-label col-sm-1">审核状态：</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="status" name="status" class="selectpicker">
                                    <option value="0" selected="selected">未审核</option>
                                    <option value="1">审核通过</option>
                                    <option value="2">审核没通过</option>
                                </select>
                            </div>
                            <div>
                                <input type="button" value="查 询" onclick="Query();"
                                       class="btn btn-primary"/>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            <div class="x_content" style="margin-top: 10px">
                <div>
                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>
                </div>

                <script type="text/javascript">
                    function Query() {
                        var status = $('#status').val();
                        $("#jqGrid").jqGrid('setGridParam', {
                            url: '${ctx}/marketingPlan/getMarketingPlanInEnterprise',
                            postData: {status: status},
                            datatype: 'json',
                            page: 1
                        }).trigger("reloadGrid");
                    }

                    function Init() {
                        var status = $('#status').val();
                        jQuery("#jqGrid").jqGrid({
                            url: '${ctx}/marketingPlan/getMarketingPlanInEnterprise',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            mtype: "POST",
                            postData: {status: status},
                            rownumbers: true,
                            colNames: ['ID', '方案名称', '方案内容', '所属商户', '开始时间', '结束时间', '使用规则', 'status', '审核状态', '省', '市', '县', '联系账号', '联系手机', '佣金1', '佣金2', '佣金3', '优惠券', '抵用方式', '券值1', '券值2', '券值3', '活动描述',
                                '支持门店', '优惠卷数量', '创建人', '审核人', '创建时间', '是否异业', '优惠劵其他说明', '备注', '操作'],
                            colModel: [
                                {name: 'id', index: 'id', width: '30px', hidden: true},
                                {name: 'title', index: 'title', width: '50px'},
                                {name: 'content', index: 'content', width: '80px'},
                                {name: 'merchantId', index: 'merchantId', width: '80px', hidden: true},
                                {name: 'beginTime', index: 'beginTime', width: '80px'},
                                {name: 'endTime', index: 'endTime', width: '80px'},
                                {name: 'usageRule', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'status', index: 'status', width: '80px', hidden: true},
                                {
                                    name: 'ischeck', index: 'ischeck', width: '80px',
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

                                {name: 'supportStore', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'couponsNumber', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'checker', index: 'checker', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '80px', sortable: true,},
                                {name: 'isDifferent', index: 'isDifferent', width: '80px', hidden: true},
                                {name: 'otherDescripe', index: 'otherDescripe', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true},
                                {
                                    name: 'detail', index: 'detail', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Str = "<input type='button' onclick=\"Detail('" + options.rowId + "');\"  value='详情' />";
                                        //修改和删除
                                        if (rowObject.status == 0) {
                                            Str += "<input type='button' onclick=\"Update('" + options.rowId + "');\"  value='修改' />";
                                            Str += "<input type='button' onclick=\"Delete('" + rowObject.id + "');\"  value='删除' />";
                                        }
                                        return Str;
                                    }
                                }
                            ],
                            rowNum: 15,
                            rowList: [20, 15, 30],
                            height: $(window).height,
                            autowidth: true,
                            pager: "#jqGridPager",
                            altRows: true,
                            hidegrid: false,
                            viewrecords: true,
                            recordpos: 'left',
                            loadonce: true,
                            sortable: true,
                            sortname: 'addTime',
                            sortorder: "asc",

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
                            refresh: true,
                            edit: false,
                            add: false,
                            del: false,
                            search: false,
                            position: "right"
                        }).navButtonAdd('#jqGridPager', {
                            caption: "添加",
                            buttonicon: "glyphicon-plus",
                            onClickButton: openDialog4Adding,
                            position: "last"
                        });
                    }

                    $(document).ready(function () {
                        Init();
                    });
                    var openDialog4Adding = function () {
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增营销方案</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div style=\'z-index:800\'></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApply.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var couponType = $("input[name='couponType']:checked").val();
                                    var blockId = $("input[name='couponType']:checked").val();
                                    var preferentialWay = $("#" + blockId).find("input[name='aaa']:checked").attr("myvalue");
                                    var rio = $("input[type='radio'][name='Fruit']:checked").val();
                                    var commissionTypeOne = "";
                                    var commissionTypeTwo = "";
                                    var commissionTypeThree = "";
                                    if (rio == '1') {
                                        commissionTypeOne = $.trim($("#myform").find("#commissionTypeOne").val())
                                    }
                                    if (rio == '2') {
                                        commissionTypeTwo = $.trim($("#myform").find("#commissionTypeTwo").val())
                                    }
                                    if (rio == '3') {
                                        commissionTypeThree = $.trim($("#myform").find("#commissionTypeThree").val())
                                    }
                                    var valueOne = 0;
                                    var valueTwo = 0;
                                    var valueTree = 0;
                                    var bool = false;
                                    var msg = "";
                                    if (couponType == "折扣券") {
                                        valueOne = $("#myform").find("#valueOne").val();

                                        if (valueOne == "") {
                                            bool = true;
                                            msg = "请完整填写折扣券！";
                                        }
                                    } else if (couponType == "满减券") {
                                        valueOne = $("#" + blockId).find("#valueFour").val();
                                        valueTwo = $("#" + blockId).find("#valueFive").val();
                                        valueTree = $("#" + blockId).find("#valueSix").val();
                                        if (valueOne == "" | valueTwo == "" | valueTree == "") {
                                            bool = true;
                                            msg = "请完整填写满减券！";
                                        }
                                    } else if (couponType == "代金券") {
                                        valueOne = $("#" + blockId).find("#valueSeven").val();
                                        valueTwo = $("#" + blockId).find("#valueEight").val();
                                        if (valueOne == "" | valueTwo == "") {
                                            bool = true;
                                            msg = "请完整填写代金券！";
                                        }
                                    } else if (couponType == "兑换券") {
                                        valueOne = $("#" + blockId).find("#valueNine").val();
                                        if (valueOne == "") {
                                            bool = true;
                                            msg = "请完整填写兑换券！";
                                        }
                                    }
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'addUser': $.trim($("#myform").find("#addUser").val()),
                                        'title': $.trim($("#myform").find("#title").val()),
                                        'content': $.trim($("#myform").find("#content").val()),
                                        'beginTime': $.trim($("#myform").find("#beginTime").val()),
                                        'endTime': $.trim($("#myform").find("#endTime").val()),
                                        'province': $.trim($("#myform").find("#province").val()),
                                        'city': $.trim($("#myform").find("#city").val()),
                                        'district': $.trim($("#myform").find("#district").val()),
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'tell': $.trim($("#myform").find("#tell").val()),
                                        'commissionTypeOne': commissionTypeOne,
                                        'commissionTypeTwo': commissionTypeTwo,
                                        'commissionTypeThree': commissionTypeThree,
                                        'describe': $.trim($("#myform").find("#describe").val()),
                                        'otherDescripe': $.trim($("#myform").find("#otherDescripe").val()),
                                        'isDifferent': $.trim($("#myform").find("#isDifferent").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
                                        'usageRule': $.trim($("#myform").find("#usageRule").val()),
                                        'supportStore': $.trim($("#myform").find("#supportStore").val()),
                                        'couponsNumber': $.trim($("#myform").find("#couponsNumber").val()),
                                        'couponType': couponType,
                                        'preferentialWay': preferentialWay,
                                        'valueOne': valueOne,
                                        'valueTwo': valueTwo,
                                        'valueTree': valueTree,
                                        'selLabelKeys': $.trim($("#myform").find("#hdnSelLabelKeys").val())
                                    };

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

                                        fields:
                                            {
                                                title: {
                                                    validators: {
                                                        notEmpty: {
                                                            message: '标题不能为空！'
                                                        }
                                                    }
                                                },
                                                content: {
                                                    validators: {
                                                        notEmpty: {
                                                            message: '内容不能为空！'
                                                        }
                                                    }
                                                },
                                                name: {
                                                    validators: {
                                                        notEmpty: {
                                                            message: '用户名不能为空！'
                                                        }
                                                    }
                                                },
                                                tell: {
                                                    validators: {
                                                        notEmpty: {
                                                            message: '联系方式不能为空！'
                                                        }
                                                    }
                                                }

                                            }
                                    });


                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {

                                        var beginTime = $.trim($("#myform").find("#beginTime").val());
                                        var endTime = $.trim($("#myform").find("#endTime").val());
                                        if (($.trim(beginTime).length == 0) || ($.trim(endTime).length == 0)) {
                                            getCode("check", "请填写方案的使用时间！");
                                            return;
                                        }
                                        if (endTime < beginTime) {
                                            getCode("check", "方案的开始时间必须小于结束时间！");
                                            return;
                                        }

                                        if (($.trim(commissionTypeOne).length == 0) && ($.trim(commissionTypeTwo).length == 0) && ($.trim(commissionTypeThree).length == 0)) {

                                            getCode("check", "请填写营销佣金！");

                                            return;
                                        }
                                        if (bool) {
                                            getCode("check", msg);
                                            return;
                                        }
                                        console.log(json);
                                        $.ajax({
                                            url: "${ctx}/marketingPlan/addMarketingPlanInEnterprise",
                                            data: json,
                                            type: "post",
                                            dataType: "json",
                                            cache: false,
                                            success: function (data) {
                                                if (data != null) {
                                                    dialogItself.close();
                                                    getCode('add', "添加成功!");
                                                   $('#jqGrid').setGridParam({datatype:'json'}).trigger('reloadGrid');
                                                } else {
                                                    getCode('add', "添加失败!");
                                                }
                                            },
                                            error: function (e) {
                                                getCode('add', "系统ajax交互错误!");
                                            }
                                        });
                                    }
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

                    function Update(selectedRowId) {

                        // var selectedRowId = $("#jqGrid").jqGrid("getGridParam", "selrow");
                        // if (selectedRowId == null | selectedRowId == "") {
                        //     getCode('check', '请选择行');
                        //     return;
                        // }
                        //获得当前行各项属性
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        // if (values.status == '通过审核' | values.status == '未通过审核') {
                        //     getCode('check', '已审核方案不可修改');
                        //     return;
                        // }

                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">修改一条数据</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApply.jsp'),//加载弹出页面
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
                                    $('#describe').val(values.describe),
                                    $('#remark').val(values.remark),
                                    $('#usageRule').val(values.usageRule),
                                    $('#supportStore').val(values.supportStore),
                                    $('#couponsNumber').val(values.couponsNumber),
                                    $('#isDifferent').val(values.isDifferent),
                                    $('#otherDescripe').val(values.otherDescripe),
                                    getSelLabels(values.id)

                            },
                            buttons: [{
                                id: 'btnformsubmit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var couponType = $("input[name='couponType']:checked").val();
                                    var blockId = $("input[name='couponType']:checked").val();
                                    var preferentialWay = $("#" + blockId).find("input[name='aaa']:checked").attr("myvalue");
                                    var rio = $("input[type='radio'][name='Fruit']:checked").val();
                                    var commissionTypeOne = "";
                                    var commissionTypeTwo = "";
                                    var commissionTypeThree = "";
                                    if (rio == '1') {
                                        commissionTypeOne = $.trim($("#myform").find("#commissionTypeOne").val())
                                    }
                                    if (rio == '2') {
                                        commissionTypeTwo = $.trim($("#myform").find("#commissionTypeTwo").val())
                                    }
                                    if (rio == '3') {
                                        commissionTypeThree = $.trim($("#myform").find("#commissionTypeThree").val())
                                    }
                                    var valueOne = 0;
                                    var valueTwo = 0;
                                    var valueTree = 0;
                                    var bool = false;
                                    var msg = "";
                                    if (couponType == "折扣券") {
                                        valueOne = $("#myform").find("#valueOne").val();

                                        if (valueOne == "") {
                                            bool = true;
                                            msg = "请完整填写折扣券！";
                                        }
                                    } else if (couponType == "满减券") {
                                        valueOne = $("#" + blockId).find("#valueFour").val();
                                        valueTwo = $("#" + blockId).find("#valueFive").val();
                                        valueTree = $("#" + blockId).find("#valueSix").val();
                                        if (valueOne == "" | valueTwo == "" | valueTree == "") {
                                            bool = true;
                                            msg = "请完整填写满减券！";
                                        }
                                    } else if (couponType == "代金券") {
                                        valueOne = $("#" + blockId).find("#valueSeven").val();
                                        valueTwo = $("#" + blockId).find("#valueEight").val();
                                        if (valueOne == "" | valueTwo == "") {
                                            bool = true;
                                            msg = "请完整填写代金券！";
                                        }
                                    } else if (couponType == "兑换券") {
                                        valueOne = $("#" + blockId).find("#valueNine").val();
                                        if (valueOne == "") {
                                            bool = true;
                                            msg = "请完整填写兑换券！";
                                        }
                                    }
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'lastUpdater': $.trim($("#myform").find("#addUser").val()),
                                        'title': $.trim($("#myform").find("#title").val()),
                                        'content': $.trim($("#myform").find("#content").val()),
                                        'beginTime': $.trim($("#myform").find("#beginTime").val()),
                                        'endTime': $.trim($("#myform").find("#endTime").val()),
                                        'province': $.trim($("#myform").find("#province").val()),
                                        'city': $.trim($("#myform").find("#city").val()),
                                        'district': $.trim($("#myform").find("#district").val()),
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'tell': $.trim($("#myform").find("#tell").val()),
                                        'commissionTypeOne': commissionTypeOne,
                                        'commissionTypeTwo': commissionTypeTwo,
                                        'commissionTypeThree': commissionTypeThree,
                                        'couponType': couponType,
                                        'preferentialWay': preferentialWay,
                                        'valueOne': valueOne,
                                        'valueTwo': valueTwo,
                                        'valueTree': valueTree,
                                        'remark': $.trim($("#myform").find("#remark").val()),
                                        'usageRule': $.trim($("#myform").find("#usageRule").val()),
                                        'supportStore': $.trim($("#myform").find("#supportStore").val()),
                                        'couponsNumber': $.trim($("#myform").find("#couponsNumber").val()),
                                        'describe': $.trim($("#myform").find("#describe").val()),
                                        'isDifferent': $.trim($("#myform").find("#isDifferent").val()),
                                        'otherDescripe': $.trim($("#myform").find("#otherDescripe").val()),
                                        'selLabelKeys': $.trim($("#myform").find("#hdnSelLabelKeys").val())
                                    }
                                    console.log(json);

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
                                            title: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标题不能为空！'
                                                    },
                                                }
                                            },
                                            content: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '内容不能为空！'
                                                    },
                                                }
                                            },
                                            name: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '用户名不能为空！'
                                                    },
                                                }
                                            },
                                            tell: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '联系方式不能为空！'
                                                    },
                                                }
                                            }

                                        }
                                    });

                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {

                                        var beginTime = $.trim($("#myform").find("#beginTime").val());
                                        var endTime = $.trim($("#myform").find("#endTime").val());
                                        if (($.trim(beginTime).length == 0) || ($.trim(endTime).length == 0)) {
                                            getCode("check", "请填写方案的使用时间！");
                                            return;
                                        }
                                        if (endTime < beginTime) {
                                            getCode("check", "方案的开始时间必须小于结束时间！");
                                            return;
                                        }
                                        if (($.trim(commissionTypeOne).length == 0) && ($.trim(commissionTypeTwo).length == 0) && ($.trim(commissionTypeThree).length == 0)) {

                                            getCode("check", "请填写营销佣金！");

                                            return;
                                        }
                                        if (bool) {
                                            getCode("check", msg);
                                            return;
                                        }

                                        $.ajax({
                                            url: "${ctx}/marketingPlan/updateMarketingPlanInEnterprise",
                                            data: json,
                                            dataType: "json",
                                            type: 'POST',
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {
                                                    dialogItself.close();
                                                    getCode('update', "修改成功!");
                                                    $('#jqGrid').setGridParam({datatype:'json'}).trigger('reloadGrid');
                                                    /*$('#refresh_jqGrid').trigger('click');*/
                                                } else {
                                                    getCode('update', "修改失败!");
                                                }
                                            },

                                            error: function (textStatus, e) {
                                                getCode('update', "系统ajax交互错误!");
                                            }
                                        });
                                    }
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

                    function Delete(id) {

                        myConfirm('${ctx}/marketingPlan/deleteMarketingPlanDotInEnterprise', id);

                    };

                    function Detail(selectedRowId) {
                        debugger;
                        //获得当前行各项属性
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">数据详细</span><input type='hidden' id='detail' value='\"+values.id+\"' />",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplyDetail.jsp'),
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
                                    $('#describe').val(values.describe),
                                    $('#remark').val(values.remark),
                                    $('#usageRule').val(values.usageRule),
                                    $('#supportStore').val(values.supportStore),
                                    $('#couponsNumber').val(values.couponsNumber),
                                    $('#isDifferent').val(values.isDifferent),
                                    $('#otherDescripe').val(values.otherDescripe),
                                    getSelLabels(values.id),
                                    $('#myform').find('select,input,textarea,span').attr("disabled", "disabled");
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
            </div>
        </div>
    </div>
</div>
</body>
</html>
