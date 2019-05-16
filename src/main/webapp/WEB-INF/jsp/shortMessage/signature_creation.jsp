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
    <title>签名创建</title>

</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">

        <input hidden="hidden" id="ctx" value="${ctx}">

        <div class="x_panel">
            <div class="x_title">
                <h2>签名创建</h2>
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
                            url: '${ctx}/shortMessage/signatureQuery',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['Id', '签名', 'type', '分类', 'use', '用途', 'auditStatus', '签名状态', '创建时间', '修改时间', '备注信息','staffId'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'signature', index: 'signature', width: '80px'},
                                {name: 'type', index: 'type', width: '80px', hidden: true},
                                {
                                    name: 'typeInfo', index: 'typeInfo', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.type == 2) {
                                            return '通知';
                                        } else {
                                            return '营销';
                                        }
                                    }
                                },
                                {name: 'use', index: 'use', width: '80px', hidden: true},
                                {
                                    name: 'useInfo', index: 'useInfo', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.use == 0) {
                                            return '自有产品';
                                        } else {
                                            return '非自有产品';
                                        }
                                    }
                                },
                                {name: 'auditStatus', index: 'auditStatus', width: '80px', hidden: true},
                                {
                                    name: 'auditStatusInfo', index: 'auditStatusInfo', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.auditStatus == 2) {
                                            return '审核通过';
                                        } else if (rowObject.auditStatus == 1) {
                                            return '审核中';
                                        } else {
                                            return '审核不通过';
                                        }
                                    }
                                },
                                {name: 'createTime', index: 'createTime', width: '150px'},
                                {name: 'updateTime', index: 'updateTime', width: '150px'},
                                {name: 'remark', index: 'remark', width: '80px'},
                                {name: 'staffId', index: 'staffId', width: '150px', hidden: true},
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
                                cell: "cell"
                            }
                        });
                        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                            refresh: false,
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

                        }).navButtonAdd('#jqGridPager', {

                            caption: "更新",

                            buttonicon: "glyphicon-edit",

                            onClickButton: openDialog4Updating,

                            position: "last"

                        });

                    });

                    var openDialog4Adding = function () {

                        var consoleDlg = $("#consoleDlg");
                        consoleDlg.find("input").removeAttr("disabled");
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">签名创建</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/shortMessage/signature_creation.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var use = $.trim($("#myform").find("#use").val());
                                    var json;
                                    if (use == "0") {
                                        json = {
                                            'licenseurl': $.trim($("#myform").find("#licenseurl").val()),
                                            'licensesize': $.trim($("#myform").find("#licensesize").val()),
                                            'licensefileName': $.trim($("#myform").find("#licensefileName").val()),
                                            'licenseStart': $.trim($("#myform").find("#licenseStart").val()),
                                            'licenseEnd': $.trim($("#myform").find("#licenseEnd").val()),
                                            'signature': $.trim($("#myform").find("#signature").val()),
                                            'type': $.trim($("#myform").find("#type").val()),
                                            'use': $.trim($("#myform").find("#use").val()),
                                            'staffId': $.trim($("#myform").find("#staffId").val()),
                                            'remark': $.trim($("#myform").find("#remark").val())
                                        };

                                    } else {
                                        json = {
                                            'authurl': $.trim($("#myform").find("#authurl").val()),
                                            'authsize': $.trim($("#myform").find("#authsize").val()),
                                            'authfileName': $.trim($("#myform").find("#authfileName").val()),
                                            'licenseurl': $.trim($("#myform").find("#licenseurl").val()),
                                            'licensesize': $.trim($("#myform").find("#licensesize").val()),
                                            'licensefileName': $.trim($("#myform").find("#licensefileName").val()),
                                            'licenseStart': $.trim($("#myform").find("#licenseStart").val()),
                                            'licenseEnd': $.trim($("#myform").find("#licenseEnd").val()),
                                            'authLicenseurl': $.trim($("#myform").find("#authLicenseurl").val()),
                                            'authLicensesize': $.trim($("#myform").find("#authLicensesize").val()),
                                            'authLicensefileName': $.trim($("#myform").find("#authLicensefileName").val()),
                                            'authLicenseStart': $.trim($("#myform").find("#authLicenseStart").val()),
                                            'authLicenseEnd': $.trim($("#myform").find("#authLicenseEnd").val()),
                                            'provesurl': $.trim($("#myform").find("#provesurl").val()),
                                            'provessize': $.trim($("#myform").find("#provessize").val()),
                                            'provesfileName': $.trim($("#myform").find("#provesfileName").val()),
                                            'signature': $.trim($("#myform").find("#signature").val()),
                                            'type': $.trim($("#myform").find("#type").val()),
                                            'use': $.trim($("#myform").find("#use").val()),
                                            'staffId': $.trim($("#myform").find("#staffId").val()),
                                            'remark': $.trim($("#myform").find("#remark").val())
                                        };
                                    }
                                    /* var json = {


                                         'authurl': $.trim($("#myform").find("#authurl").val()),
                                         'authsize': $.trim($("#myform").find("#authsize").val()),
                                         'authfileName': $.trim($("#myform").find("#authfileName").val()),

                                         'licenseurl': $.trim($("#myform").find("#licenseurl").val()),
                                         'licensesize': $.trim($("#myform").find("#licensesize").val()),
                                         'licensefileName': $.trim($("#myform").find("#licensefileName").val()),
                                         'licenseStart': $.trim($("#myform").find("#licenseStart").val()),
                                         'licenseEnd': $.trim($("#myform").find("#licenseEnd").val()),

                                         'authLicenseurl': $.trim($("#myform").find("#authLicenseurl").val()),
                                         'authLicensesize': $.trim($("#myform").find("#authLicensesize").val()),
                                         'authLicensefileName': $.trim($("#myform").find("#authLicensefileName").val()),
                                         'authLicenseStart': $.trim($("#myform").find("#authLicenseStart").val()),
                                         'authLicenseEnd': $.trim($("#myform").find("#authLicenseEnd").val()),

                                         'provesurl': $.trim($("#myform").find("#provesurl").val()),
                                         'provessize': $.trim($("#myform").find("#provessize").val()),
                                         'provesfileName': $.trim($("#myform").find("#provesfileName").val()),

                                         'signature': $.trim($("#myform").find("#signature").val()),
                                         'type': $.trim($("#myform").find("#type").val()),
                                         'use': $.trim($("#myform").find("#use").val()),
                                         'staffId': $.trim($("#myform").find("#staffId").val()),
                                         'remark': $.trim($("#myform").find("#remark").val())
                                     };*/
                                    $("#myform").bootstrapValidator({
                                        live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                                        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                                        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                                        message: '通用的验证失败消息',//好像从来没出现过
                                        feedbackIcons: {//根据验证结果显示的各种图标
                                            valid: 'glyphicon glyphicon-ok',
                                            invalid: 'glyphicon glyphicon-remove',
                                            validating: 'glyphicon glyphicon-refresh'
                                        },
                                        fields: {

                                            licenseurl: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*营业执照不能为空'
                                                    }
                                                }
                                            }

                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/shortMessage/signatureSave",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (result) {
                                                if (result != null) {
                                                    dialogItself.close();
                                                    getCode('add',result.msg)
                                                    /*$('#jqGrid').trigger('reloadGrid');*/
                                                } else {
                                                    getCode('add', '添加失败！');
                                                }
                                            },

                                            error: function (textStatus, e) {
                                                getCode('add', '系统ajax交互错误！');
                                            }
                                        });
                                    }
                                }
                            }, {
                                label: '关闭',
                                icon: 'fa fa-close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                        });

                    };

                    var openDialog4Updating = function () {
                        var selectedRowId = $("#jqGrid").jqGrid("getGridParam", "selrow");
                        if (selectedRowId == null | selectedRowId == "") {
                            getCode('check', '请选择行');
                            return;
                        }
                        //获得当前行各项属性
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">更新签名</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/shortMessage/signature_creation.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $('#id').val(values.id),
                                    $('#signature').val(values.signature),
                                    $('#type').val(values.type),
                                    $('#use').val(values.use),
                                    $('#remark').val(values.remark),
                                    $('#staffId').val(values.staffId)

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var use = $.trim($("#myform").find("#use").val());
                                    var json;
                                    if (use == "0") {
                                        json = {
                                            'id': selectedRowId,
                                            'licenseurl': $.trim($("#myform").find("#licenseurl").val()),
                                            'licensesize': $.trim($("#myform").find("#licensesize").val()),
                                            'licensefileName': $.trim($("#myform").find("#licensefileName").val()),
                                            'licenseStart': $.trim($("#myform").find("#licenseStart").val()),
                                            'licenseEnd': $.trim($("#myform").find("#licenseEnd").val()),
                                            'signature': $.trim($("#myform").find("#signature").val()),
                                            'type': $.trim($("#myform").find("#type").val()),
                                            'use': $.trim($("#myform").find("#use").val()),
                                            'staffId': $.trim($("#myform").find("#staffId").val()),
                                            'remark': $.trim($("#myform").find("#remark").val())
                                        };

                                    } else {
                                        json = {
                                            'id': selectedRowId,
                                            'authurl': $.trim($("#myform").find("#authurl").val()),
                                            'authsize': $.trim($("#myform").find("#authsize").val()),
                                            'authfileName': $.trim($("#myform").find("#authfileName").val()),
                                            'licenseurl': $.trim($("#myform").find("#licenseurl").val()),
                                            'licensesize': $.trim($("#myform").find("#licensesize").val()),
                                            'licensefileName': $.trim($("#myform").find("#licensefileName").val()),
                                            'licenseStart': $.trim($("#myform").find("#licenseStart").val()),
                                            'licenseEnd': $.trim($("#myform").find("#licenseEnd").val()),
                                            'authLicenseurl': $.trim($("#myform").find("#authLicenseurl").val()),
                                            'authLicensesize': $.trim($("#myform").find("#authLicensesize").val()),
                                            'authLicensefileName': $.trim($("#myform").find("#authLicensefileName").val()),
                                            'authLicenseStart': $.trim($("#myform").find("#authLicenseStart").val()),
                                            'authLicenseEnd': $.trim($("#myform").find("#authLicenseEnd").val()),
                                            'provesurl': $.trim($("#myform").find("#provesurl").val()),
                                            'provessize': $.trim($("#myform").find("#provessize").val()),
                                            'provesfileName': $.trim($("#myform").find("#provesfileName").val()),
                                            'signature': $.trim($("#myform").find("#signature").val()),
                                            'type': $.trim($("#myform").find("#type").val()),
                                            'use': $.trim($("#myform").find("#use").val()),
                                            'staffId': $.trim($("#myform").find("#staffId").val()),
                                            'remark': $.trim($("#myform").find("#remark").val())
                                        };
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
                                        fields: {}
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/shortMessage/signatureSave",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {
                                                    //将新行插入到末尾
                                                    dialogItself.close();
                                                    getCode('update', "更新成功!");
                                                    $('#jqGrid').trigger('reloadGrid');
                                                    /*$('#refresh_jqGrid').trigger('click');*/
                                                } else {
                                                    getCode('update', "更新失败!");
                                                }
                                            },

                                            error: function (textStatus, e) {
                                                getCode('update', "系统ajax交互错误!");

                                            }
                                        });
                                    }

                                }
                            }, {
                                label: '关闭',
                                icon: 'fa fa-close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                        });

                    };

                    var openDialog4Deleting = function (dialogItself) {
                        var id = $("#jqGrid").jqGrid("getGridParam", "selrow");
                        if (id == null | id == "") {
                            getCode('check', '请选择行');
                            return;
                        }

                        myConfirm('${ctx}/deleteUser', id);

                    };

                </script>
                <script>
                    $(function () {
                        $('.givepermission').click(function () {
                            alert($(this).parent())
                        })
                    })
                </script>
            </div>
        </div>

        <script src="${ctx}/static/js/bootstrap-treeview.js"></script>
    </div>
</div>

</body>

</html>
