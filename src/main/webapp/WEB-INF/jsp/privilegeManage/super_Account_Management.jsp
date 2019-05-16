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
    <title>权限管理</title>

</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>企业商户账号管理</h2>
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
                            url: '${ctx}/getCompanyUsersManagerment',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['企业名','用户名', '创建时间'],
                            colModel: [{name: 'industryName', index: 'industryName', width: '80px'},
                                {name: 'name', index: 'name', width: '80px'},
                                {name: 'addTime', index: 'addTime', width: '50px'},
                            ],
                            rowNum: 15,
                            rowList : [ 20, 15,30 ],
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
                        })/*.navButtonAdd('#jqGridPager', {

                            caption: "添加",

                            buttonicon: "glyphicon-plus",

                            onClickButton: openDialog4Adding,

                            position: "last"

                        })*/.navButtonAdd('#jqGridPager', {

                            caption: "修改",

                            buttonicon: "glyphicon-edit",

                            onClickButton: openDialog4Updating,

                            position: "last"

                        })/*.navButtonAdd('#jqGridPager', {

                            caption: "删除",

                            buttonicon: "glyphicon-trash",

                            onClickButton: openDialog4Deleting,

                            position: "last"

                        });*/

                    });


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
                            title: "<span style=\"color: #ab8ce4\">修改用户密码</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/super_Account_Management.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $('#id').val(values.id),
                                $('#name').val(values.name)

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'password': $.trim($("#myform").find("#password").val()),

                                    }
                                    $.ajax({
                                        url: "${ctx}/updatePassword",
                                        data: json,
                                        dataType: "json",
                                        cache: false,
                                        success: function (response) {
                                            if (response != null) {
                                                var dataRow = {
                                                    id: $.trim($("#myform").find("#id").val()),
                                                    password: $.trim($("#myform").find("#password").val()),

                                                };

                                                var srcrowid = $("#jqGrid").jqGrid("getGridParam",
                                                        "selrow");

                                                $("#jqGrid").jqGrid("setRowData", $.trim($("#myform").find("#id").val()), dataRow);    //将新行插入到末尾

                                                dialogItself.close();
                                                getCode('update',"修改成功!");
                                                $('#jqGrid').trigger('reloadGrid');
                                                /*$('#refresh_jqGrid').trigger('click');*/
                                            } else {
                                                getCode('update',"修改失败!");
                                            }
                                        },

                                        error: function (textStatus, e) {
                                            getCode('update',"系统ajax交互错误!");
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

                        console.log(rowData);
                        var params = {
                            "id": id
                        };
                        myConfirm('${ctx}/deleteUser',id);

                    };


                </script>
            </div>
        </div>


    </div>
</div>

</body>
</html>
