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
    <title>角色管理</title>

</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">

        <input hidden="hidden" id="ctx" value="${ctx}">

        <div class="x_panel">
            <div class="x_title">
                <h2>角色管理</h2>
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
                            url: '${ctx}/listRoles',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['Id','角色名', '创建人', '备注', '操作'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'rolename', index: 'rolename', width: '80px'},
                                {name: 'createUser', index: 'createUser', width: '50px'},
                                {name: 'remark', index: 'remark', width: '80px'},
                                {name: 'Edit', index: 'Edit', sortable: false, align: "center", width: "100px"},
                            ],

                            gridComplete: function () {
                                var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                                for (var i = 0; i < ids.length; i++) {
                                    var id = ids[i];
                                    /*var editBtn = "<a href='#' style='color:#f60' onclick='OpenAllocationDialog()' >Edit</a>";*/
                                    var editBtn = "<a href='#' style='color:#f60' onclick=\"givepermisson('" + id + "')\"><div style='display:block;\n" +
                                        "width:80px;\n" +
                                        "height:30px;\n" +
                                        "background-color:#333333;\n" +
                                        "color:#FFFFFF;\n" +
                                        "text-align:center;\n" +
                                        "font-size:14px;\n" +
                                        "line-height:30px;\n" +
                                        "border-radius: 25px;\n" +
                                        "border:none;\n" +
                                        "box-shadow:none;\n" +
                                        "text-decoration: none;\n" +
                                        "transition: box-shadow 0.5s;\n" +
                                        "-webkit-transition: box-shadow 0.5s;'>授予权限</div></a>";
                                    jQuery("#jqGrid").jqGrid('setRowData', ids[i], {Edit: editBtn});
                                }

                            },
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

                        var consoleDlg = $("#consoleDlg");
                        consoleDlg.find("input").removeAttr("disabled");
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增角色</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/role_management.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.ajax({
                                    url: "${ctx}/getname",
                                    data: '',
                                    dataType: "json",
                                    cache: false,
                                    success: function (response) {
                                        $('#createUser').val(response.data)

                                    },

                                    error: function (textStatus, e) {
                                        getCode('add', "系统ajax交互错误！");
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
                                        'rolename': $.trim($("#myform").find("#rolename").val()),
                                        'createUser': $.trim($("#myform").find("#createUser").val()),
                                        'remark': $.trim($("#myform").find("#remark").val())
                                    };
                                    $.ajax({
                                        url: "${ctx}/addRole",
                                        data: json,
                                        dataType: "json",
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {

                                                dialogItself.close();
                                                getCode('add', "添加成功！");
                                                $('#jqGrid').trigger('reloadGrid');
                                                /*$('#refresh_jqGrid').trigger('click');*/
                                            } else {
                                                getCode('add', "添加失败！");
                                            }
                                        },

                                        error: function (textStatus, e) {
                                            getCode('add', "系统ajax交互错误！");
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
                            title: "<span style=\"color: #ab8ce4\">修改角色</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/role_management.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseIndustry/selectAll",
                                    success: function (data) {
                                        for (var i = 0; i < data.length; i++) {
                                            if (data[i].id == values.parentId) {

                                                $("#parentId").append("<option selected=\"selected\"  value='" + data[i].id + "'>" + data[i].industryName + "</option>");
                                                break;
                                            }

                                            $("#parentId").append("<option  value='" + data[i].id + "'>" + data[i].industryName + "</option>");
                                        }
                                    }
                                });

                                $('#id').val(values.id),
                                    $('#rolename').val(values.rolename),
                                    $('#createUser').val(values.createUser),
                                    $('#remark').val(values.remark)

                                $("#createUser").attr("disabled", "disabled");
                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'rolename': $.trim($("#myform").find("#rolename").val()),
                                        'createUser': $.trim($("#myform").find("#createUser").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
                                    }
                                    $.ajax({
                                        url: "${ctx}/update",
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
                        var rowData = $("#jqGrid").jqGrid("getRowData", id);

                        var params = {
                            "id": id
                        };
                        myConfirm('${ctx}/deleteRole', id);

                    };

                    function givepermisson(id) {
                        var ctx = $('#ctx').val();
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\"><i></i>授予权限</span>" +
                            "<input type='hidden' id='roleId' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/systemmanager/authmanager.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $('#roleId').val(id);

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {
                                    var treeObj = $.fn.zTree.getZTreeObj("tree"),
                                        nodes = treeObj.getCheckedNodes(true);
                                    for (var i = 0; i < nodes.length; i++) {
                                        nodes[i].roleId = id
                                    }
                                    $.ajax({
                                        type: "post",
                                        url: "/gavePermission",
                                        dataType: "json",
                                        contentType: "application/json",
                                        data: JSON.stringify(nodes),
                                        success: function (data) {
                                            getCode('add', "授权成功");
                                        },
                                        error: function (msg) {
                                            getCode('check', "授权失败");
                                        }
                                    });
                                    dialogItself.close();
                                    /*$.post(ctx + '/gavePermission', {JSON.stringify(nodes)}, function (data) {
                                        getCode('add',"成功");
                                    });*/
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

                </script>
            </div>
        </div>

        <script src="${ctx}/static/js/bootstrap-treeview.js"></script>
    </div>
</div>

</body>

</html>
