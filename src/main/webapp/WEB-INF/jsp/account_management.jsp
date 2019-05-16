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
    <title>权限管理</title>

</head>

<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">

        <div class="ui-jqgrid">
            <table id="jqGrid"></table>
            <div id="jqGridPager"></div>
        </div>
        <div id="consoleDlg" style="display:none">
            <form id="consoleForm">
                <table class="formTable">
                    <tr>
                        <th>Customer ID</th>
                        <td><input type="text" class="textField" id="id" name="id"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Company Name</th>
                        <td><input type="text" class="textField" id="name" name="name"/>
                        </td>
                    </tr>
                    <tr>
                        <th>password</th>
                        <td><input type="text" class="textField" id="password" name="password"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <script type="text/javascript">

            $(document).ready(function () {
                $("#jqGrid").jqGrid({
                    url: '${ctx}/getUser',
                    // we set the changes to be made at client side using predefined word clientArray
                    editurl: 'clientArray',
                    datatype: "json",
                    colModel: [
                        {
                            label: 'Customer ID',
                            name: 'id',
                            width: 75,
                            key: true,
                            editable: true,
                            editrules: {required: true}
                        },
                        {
                            label: 'Company Name',
                            name: 'name',
                            width: 140,
                            editable: true // must set editable to true if you want to make the field editable
                        },
                        {
                            label: 'password',
                            name: 'password',
                            width: 100,
                            editable: true
                        }
                    ],
                    sortname: 'CustomerID',
                    sortorder: 'asc',
                    loadonce: true,
                    viewrecords: true,
                    height: $(window).height,
                    rowNum: 10,
                    pager: "#jqGridPager"
                });

                $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                    refresh: true,
                    edit: true,
                    add: true,
                    del: true,
                    search: true,
                    addfunc: openDialog4Adding,
                    editfunc: openDialog4Updating,
                    delfunc: openDialog4Deleting
                });


                //配置对话框
                $("#consoleDlg").dialog({
                    autoOpen: false,
                    modal: true      //设置对话框为模态对话框

                });

            });


            var openDialog4Adding = function () {

                var consoleDlg = $("#consoleDlg");
                var dialog = BootstrapDialog.show({
                    type: BootstrapDialog.TYPEer_DEFAULT,
                    title: "<span style=\"color: #ab8ce4\">新增一条数据</span>",
                    closable: false,
                    draggable: true,
                    cssClass: 'login-dialog',
                    message: $('<div></div>').load('${ctx}/template/user_role.jsp'),//加载弹出页面
                    size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                    /* onshown:function () {

                     },*/
                    //获取需要提交的数据
                    buttons: [{
                        id: 'btn-form-submit',
                        label: '提交',
                        icon: 'fa fa-check-circle',
                        cssClass: 'btn-primary',
                        action: function () {
                            var json = {
                                'name': $("#name").val(),
                                'password':$('#password').val(),
                                'roledesc':$('#roledesc').val(),

                            }
                            $("#form2").bootstrapValidator({
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
                                    name: {
                                        validators: {
                                            notEmpty: {
                                                message: '用户名不能为空'
                                            },
                                        }
                                    },
                                    password: {
                                        validators: {
                                            notEmpty: {
                                                message: '密码不能为空'
                                            },
                                        }
                                    },
                                    repassword: {
                                        validators: {
                                            notEmpty: {
                                                message: '密码不能为空'
                                            },
                                            identical: {
                                                field: 'password',
                                                message: '两次输入的密码不相符'
                                            }
                                        }
                                    },
                                    roledesc: {
                                        validators: {
                                            notEmpty: {
                                                message: '角色名不能为空！'
                                            },
                                        }
                                    }
                                }
                            });
                            var bootstrapValidator = $("#form2").data('bootstrapValidator');
                            bootstrapValidator.validate();
                            if (bootstrapValidator.isValid()) {
                                $.post("${ctx}/addUsers", json).done(function (data) {
                                    console.log(data);
                                    if( data){
                                        getCode(data)
                                    }else {
                                        $('#name').parents(".form-group").addClass("has-error");
                                        $('#name').parents(".form-group").removeClass("has-success");
                                        $('#name').siblings("i").remove();
                                        $('#name').after("<i class=\"form-control-feedback glyphicon glyphicon-remove\" data-bv-icon-for=\"name\" style=\"\"></i>");
                                        /* $('#name').after('<label id="la1" class="text-danger">用户名已存在</label>');
                                         $('#name').parents(".form-group").addClass("has-error");
                                         $('#name').parents(".form-group").removeClass("has-success");
                                         $('#name').siblings("i").remove();
                                         $('#name').after("<i class=\"form-control-feedback glyphicon glyphicon-remove\" data-bv-icon-for=\"name\" style=\"\"></i>");*/

                                        /* */
                                    }

                                }).fail(function (data) {

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
                var consoleDlg = $("#consoleDlg");
                //   var dialogButtonPanel = consoleDlg.siblings(".ui-dialog-buttonpane");
                consoleDlg.find("input").removeAttr("disabled");
                //dialogButtonPanel.find("button:not(:contains('取消'))").hide();
                //dialogButtonPanel.find("button:contains('修改')").show();

                consoleDlg.dialog({
                    title: "修改",
                    resizable: false,
                    width: 480,
                    buttons: {
                        "取消": function () {
                            $("#consoleDlg").dialog("close");
                        },
                        "修改": editItem
                    }
                });

                loadSelectedRowData();
                consoleDlg.dialog("open");

            };

            var openDialog4Deleting = function () {
                var consoleDlg = $("#consoleDlg");
                //   var dialogButtonPanel = consoleDlg.siblings(".ui-dialog-buttonpane");
                consoleDlg.find("input").attr("disabled", true);

                //dialogButtonPanel.find("button:not(:contains('取消'))").hide();
                // dialogButtonPanel.find("button:contains('删除')").show();
                consoleDlg.dialog("option", "title", "delete record");

                consoleDlg.dialog({
                    title: "删除",
                    resizable: false,
                    width: 480,
                    buttons: {
                        "取消": function () {
                            $("#consoleDlg").dialog("close");
                        },
                        "删除": deleteItem
                    }
                });
                loadSelectedRowData();
                consoleDlg.dialog("open");
            };

            var loadSelectedRowData = function () {
                //2016-03-18 当前选中的行
                var selectedRowId = $("#jqGrid").jqGrid("getGridParam", "selrow");
                //获得当前行各项属性
                var rowData = $("#jqGrid").jqGrid("getRowData", selectedRowId);

                if (!selectedRowId) {
                    alert("请先选择需要编辑的行!");
                    return false;
                } else {
                    var consoleDlg = $("#consoleDlg");

                    consoleDlg.find("#id").val(rowData.id);
                    consoleDlg.find("#password").val(rowData.password);
                    consoleDlg.find("#name").val(rowData.name);


                }
            };
            var addItem = function () {
                var consoleDlg = $("#consoleDlg");
                var id = $.trim(consoleDlg.find("#id").val());
                var name = $.trim(consoleDlg.find("#name").val());
                var password = $.trim(consoleDlg.find("#password").val());
                var params = {
                    "id": id,
                    "name": name,
                    "password": password
                };

                $.ajax({
                    url: "${ctx}/addUser",
                    data: params,
                    dataType: "json",
                    cache: false,
                    success: function (response) {
                        if (response != null) {
                            var dataRow = {
                                id: response.id,    //从server端获得系统分配的id
                                password: password,
                                name: name

                            };

                            var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                    "selrow");

                            $("#jqGrid").jqGrid("addRowData",
                                    response.id, dataRow, "last");    //将新行插入到末尾

                            consoleDlg.dialog("close");
                            alert("添加成功!");
                        } else {
                            alert("添加失败!");
                        }
                    },
                    error: function (textStatus, e) {
                        alert("系统ajax交互错误: " + textStatus);
                    }
                });

            };

            var editItem = function () {
                var consoleDlg = $("#consoleDlg");
                var id = $.trim(consoleDlg.find("#id").val());
                var name = $.trim(consoleDlg.find("#name").val());
                var password = $.trim(consoleDlg.find("#password").val());
                var params = {
                    "id": id,
                    "name": name,
                    "password": password
                };

                $.ajax({
                    url: "${ctx}/updateUser",
                    data: params,
                    dataType: "json",
                    cache: false,
                    success: function (response) {
                        if (response != null) {
                            var dataRow = {
                                id: id,
                                password: password,
                                name: name,

                            };

                            var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                    "selrow");

                            //将表格中对应记录更新一下
                            $("#jqGrid").jqGrid("setRowData", id, dataRow);

                            consoleDlg.dialog("close");
                            alert("修改成功!");
                        } else {
                            alert("修改失败!");
                        }
                    },
                    error: function (e) {
                        alert("系统ajax交互错误: ");
                    }
                });
            }

            var deleteItem = function () {
                var consoleDlg = $("#consoleDlg");
                var id = $.trim(consoleDlg.find("#id").val());
                var password = $.trim(consoleDlg.find("#password").val());
                var name = $.trim(consoleDlg.find("#name").val());

                var params = {
                    "id": id,
                    "password": password,
                    "name": name
                };

                $.ajax({
                    url: "${ctx}/deleteUser",
                    data: params,
                    dataType: "json",
                    cache: false,
                    success: function (data) {
                        if (data != null) {
                            $("#jqGrid").jqGrid("delRowData", id);

                            consoleDlg.dialog("close");
                            alert("删除成功!");
                        } else {
                            alert("删除失败!");
                        }
                    },
                    error: function (e) {
                        alert("系统ajax交互错误: ");
                    }
                });

            }

        </script>
    </div>
</div>

</body>
</html>
