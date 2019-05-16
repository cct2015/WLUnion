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
    <title>模板创建</title>
    <style>
        .ui-jqgrid tr.jqgrow td {
            white-space: normal !important;
            height:auto;
            padding-top:2px;
            word-break:break-all;
        }
    </style>
</head>

<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">

        <input hidden="hidden" id="ctx" value="${ctx}">

        <div class="x_panel">
            <div class="x_title">
                <h2>模板创建</h2>
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
                            url: '${ctx}/SMSExecute/getSMSTemplateList',
                            styleUI: 'Bootstrap',
                            type:'post',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['模板Id', '名称', '模板内容','创建时间','更新时间', '审核状态','审核信息'],
                            colModel: [
                                {name: 'id', index: 'id', width: '50px'},
                                {name: 'name', index: 'name', width: '80px'},
                                {name: 'content', index: 'content', width: '120px'},
                                {name: 'createTime', index: 'createTime', width: '80px'},
                                {name: 'updateTime', index: 'updateTime', width: '80px'},
                                {name: 'auditStatus', index: 'auditStatus', width: '50px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch (rowObject.auditStatus) {
                                            case '0':
                                                return '审核中';
                                            case '1':
                                                return '审核失败';
                                            case '2':
                                                return '审核成功';
                                        }
                                    }},
                                {name: 'auditInfo', index: 'auditInfo', width: '120px'},
                                /*{name: 'status', index: 'status', width: '50px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch (rowObject.status) {

                                            case '1':
                                                return '正常使用';
                                            default:
                                                return "停用";
                                        }
                                    }}*/
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

                            caption: "删除",

                            buttonicon: "glyphicon-trash",

                            onClickButton: openDialog4Deleting,

                            position: "last"

                        });

                    });

                    function deleteTemplate(id){
                        myConfirm('${ctx}/SMSExecute/deleteSMSTemplate', id);

                    }
                    var openDialog4Adding = function () {

                        var consoleDlg = $("#consoleDlg");
                        consoleDlg.find("input").removeAttr("disabled");
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">模板创建</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/shortMessage/template_creation.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.get("${ctx}/listRolesNotPage", function (data) {
                                    $(data).each(function (index) {
                                        $('#roleName').append('<option value="' + this.id + '">' + this.rolename + '</option>');
                                    })
                                })
                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'type': $.trim($("#myform").find("#type").val()),
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'content': $.trim($("#myform").find("#content").val())
                                       /* 'staffId': $.trim($("#myform").find("#staffId").val())*/
                                    };
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
                                            name: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*模板名称不能为空'
                                                    }
                                                }
                                            },
                                            content: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*模板内容不能为空'
                                                    }
                                                }
                                            },

                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()){
                                        $.ajax({
                                            url: "${ctx}/SMSExecute/createSMSTemplate",
                                            data: json,
                                            type: "POST",
                                            dataType: "json",
                                            cache: false,
                                            success: function (res) {
                                                if (res != null) {
                                                    dialogItself.close();
                                                    getCode('add', res.msg);
                                                    $('#jqGrid').trigger('reloadGrid');
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
                    var openDialog4Deleting = function (dialogItself) {
                        var id = $("#jqGrid").jqGrid("getGridParam", "selrow");
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var auditStatus
                        if (id == null | id == "") {
                            getCode('check', '请选择行');
                            return;
                        }
                        if (values.auditStatus == '审核中') {
                            getCode('check', '审核中模板不能删除！');
                            return;
                        }

                        myConfirm('${ctx}/SMSExecute/deleteSMSTemplate', id);

                    };

                </script>
            </div>
        </div>
    </div>
</div>

</body>

</html>
