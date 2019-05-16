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
    <title>行业</title>
<style>
.div.right_col {
    margin-left: 230px;!important;
}

</style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main" <%--style="margin-left: 230px!important;"--%>>
        <div class="x_panel">
            <div class="x_title">
                <h2>行业</h2>
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
                            url: '${ctx}/baseIndustry/selectAll',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['ID', '顺序号', '行业名', '上级行业Id', '上级行业', '状态', '备注'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'sort', index: 'sort', width: '50px'},
                                {name: 'industryName', index: 'industryName', width: '80px'},
                                {name: 'parentId', index: 'parentId', width: '80px', hidden: true},
                                {name: 'parentName', index: 'parentName', width: '80px'},
                                {
                                    name: 'status',
                                    index: 'status',
                                    width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.status == 0) {
                                            return '正常使用';
                                        } else {
                                            return '停用';
                                        }
                                    }
                                },
                                {name: 'remark', index: 'remark', width: '80px'},
                            ],
                            rowNum: 15,
                            rowList : [ 20, 15,30 ],
                            height:
                            $(window).height,
                            autowidth:
                                true,
                            pager:
                                "#jqGridPager",
                            altRows:
                                true,
                            hidegrid:
                                false,
                            viewrecords:
                                true,
                            recordpos:
                                'left',
                            loadonce:
                                false,
                            multiselect:
                                false,
                            loadComplete:

                                function () {
                                }

                            ,
                            jsonReader: {
                                root: "rows",
                                page:
                                    "page",
                                total:
                                    "total",
                                records:
                                    "records",
                                repeatitems:
                                    false,
                                cell:
                                    "cell",
                                id:
                                    "id"
                            }


                        })
                        ;


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

                            caption: "修改",

                            buttonicon: "glyphicon-edit",

                            onClickButton: openDialog4Updating,

                            position: "last"

                        }).navButtonAdd('#jqGridPager', {

                            caption: "删除",

                            buttonicon: "glyphicon-trash",

                            onClickButton: openDialog4Deleting,

                            position: "last"

                        });

                    });


                    var openDialog4Adding = function () {

                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增一条数据</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/baseIndustry.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseIndustry/selectAll",
                                    success: function (data) {
                                        for (var i = 0; i < data.rows.length; i++) {
                                            $("#parentId").append("<option  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");

                                        }
                                    }
                                });
                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'industryName': $.trim($("#myform").find("#industryName").val()),
                                        'parentId': $.trim($("#myform").find("#parentId").val()),
                                        'sort': $.trim($("#myform").find("#sort").val()),
                                        'status': $.trim($("#myform").find("#status").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
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
                                        fields: {
                                            industryName: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '行业名不能为空！'
                                                    },
                                                }
                                            }, sort: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '顺序号不能为空！'
                                                    },
                                                }
                                            },
                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/baseIndustry/insert",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {
                                                    /*            var dataRow = {
                                                                    id: response.id,    //从server端获得系统分配的id
                                                                    industryName: $.trim($("#myform").find("#industryName").val()),
                                                                    parentId: $.trim($("#myform").find("#parentId").val()),
                                                                    sort: $.trim($("#myform").find("#sort").val()),
                                                                    status: $.trim($("#myform").find("#status").val()),
                                                                    remark: $.trim($("#myform").find("#remark").val()),

                                                                };

                                                                var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                                                    "selrow");

                                                                $("#jqGrid").jqGrid("addRowData",
                                                                    response.id, dataRow, "last");    //将新行插入到末尾
                                                                dialogItself.close();*/
                                                    dialogItself.close();
                                                    getCode('add', '添加成功');
                                                    $('#jqGrid').trigger('reloadGrid');
                                                    /*$('#refresh_jqGrid').trigger('click');*/
                                                } else {
                                                    getCode('add', '添加失败');

                                                }
                                            },

                                            error: function (textStatus, e) {
                                                getCode('add', '系统ajax交互错误');

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
                            title: "<span style=\"color: #ab8ce4\">修改条数据</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/baseIndustry.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseIndustry/selectAll",
                                    success: function (data) {
                                        for (var i = 0; i < data.rows.length; i++) {
                                            if (data.rows[i].id == values.parentId) {

                                                $("#parentId").append("<option selected=\"selected\"  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
                                                break;
                                            }

                                            $("#parentId").append("<option  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
                                        }
                                    }
                                });
                                var status = 0;
                                if (values.status == "停用") {
                                    status = 1;
                                }

                                $('#id').val(values.id),
                                    $('#industryName').val(values.industryName),
                                    $('#parentId').val(values.parentId),
                                    $('#sort').val(values.sort),
                                    $('#status').val(status),
                                    $('#remark').val(values.remark)


                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'industryName': $.trim($("#myform").find("#industryName").val()),
                                        'parentId': $.trim($("#myform").find("#parentId").val()),
                                        'sort': $.trim($("#myform").find("#sort").val()),
                                        'status': $.trim($("#myform").find("#status").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
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
                                            industryName: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '行业名不能为空！'
                                                    },
                                                }
                                            }, sort: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '顺序号不能为空！'
                                                    },
                                                }
                                            },
                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/baseIndustry/updateById",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {


                                                    dialogItself.close();
                                                    getCode('update', "修改成功!");
                                                    $('#jqGrid').trigger('reloadGrid');
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
                        myConfirm('${ctx}/baseIndustry/deleteById', id);


                    };


                </script>
            </div>
        </div>
    </div>
</div>

</body>
</html>
