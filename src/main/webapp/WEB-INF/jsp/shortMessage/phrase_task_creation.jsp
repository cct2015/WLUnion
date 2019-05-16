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
    <title>短信任务查询</title>
    <style>
        .year {
            margin-left: 5px;
        }

        .month {
            margin-left: 5px;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">

        <input hidden="hidden" id="ctx" value="${ctx}">

        <div class="x_panel">
            <div class="x_title">
                <h2>短信任务查询</h2>
                <div class="clearfix"></div>
            </div>
            <div>
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group">
                        <div class="form-group col-md-5 col-lg-offset-1">
                            <label for="selectMonth" class=" col-sm-3 control-label">*月份：</label>
                            <div class=" input-group  date datetime hasDatepicker  "
                                 data-date="" data-date-format="yyyy-mm-dd hh:ii">
                                <input class="form-control col-sm-3" readonly="readonly" type="text" value=""
                                       name="selectMonth"
                                       id="selectMonth" placeholder="月份">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                            </div>

                        </div>
                        <div class="form-group col-sm-1">
                            <button type="button" id="find_btn" class="form-control btn btn-primary">查询</button>
                        </div>
                    </div>

                </form>
            </div>
            <div class="x_content">

                <div>
                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>
                </div>
                <script type="text/javascript">
                    $(document).ready(function () {

                        $("#jqGrid").jqGrid({
                            url: '${ctx}/shortMessage/taskQueryByTask',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            postData: {startStr: getCurrentMonthFirst(), endStr: getCurrentMonthLast()},
                            rownumbers: true,
                            colNames: ['Id', '任务名称', '摸板名称', '摸板id', '创建时间', '总数', '成功发送量', '失败发送量', '失败信息', '点击量', 'attach', '任务状态'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'name', index: 'name', width: '80px'},
                                {name: 'templateName', index: 'templateName', width: '80px'},
                                {name: 'templateId', index: 'templateId', width: '80px', hidden: true},
                                {name: 'sendTime', index: 'sendTime', width: '150px'},
                                {name: 'sumCount', index: 'sumCount', width: '80px'},
                                {name: 'succeedCount', index: 'succeedCount', width: '80px'},
                                {name: 'failedCount', index: 'failedCount', width: '80px'},
                                {name: 'failInfo', index: 'failInfo', width: '80px'},
                                {name: 'clickCount', index: 'clickCount', width: '80px'},
                                {name: 'attach', index: 'attach', width: '80px', hidden: true},
                                {name: 'status', index: 'status', width: '80px'},
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
                        })

                    });

                    var openDialog4Adding = function () {

                        var consoleDlg = $("#consoleDlg");
                        consoleDlg.find("input").removeAttr("disabled");
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增账号</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/account_management.jsp'),//加载弹出页面
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
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'email': $.trim($("#myform").find("#email").val()),
                                        'password': $.trim($("#myform").find("#password").val()),
                                        'roleName': $.trim($("#myform").find("#roleName").val())
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
                                                        message: '*账号不能为空'
                                                    },
                                                    threshold: 2,//有2字符以上才发送ajax请求
                                                    remote: {//ajax验证。server result:{"valid",true or false}
                                                        url: "${ctx}/checkUserName",
                                                        message: '用户名已存在,请重新输入',
                                                        delay: 1000,//ajax刷新的时间是1秒一次
                                                        type: 'POST',
                                                        //自定义提交数据，默认值提交当前input value
                                                        data: function (validator) {
                                                            return {
                                                                userName: $.trim($("#myform").find("#name").val())
                                                            };
                                                        }
                                                    }
                                                }
                                            },
                                            password: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*新密码不能为空'
                                                    }
                                                }
                                            },
                                            email: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '邮箱不能为空'
                                                    },
                                                    emailAddress: {
                                                        message: '邮箱地址格式有误'
                                                    },
                                                }
                                            },
                                            repassword: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*确认密码不能为空'
                                                    },
                                                    identical: {
                                                        field: 'password',
                                                        message: '*两次输入密码不一致'
                                                    }
                                                }
                                            }
                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/addSysUser",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {
                                                    var dataRow = {
                                                        id: response.id,    //从server端获得系统分配的id
                                                        password: response.password,
                                                        name: response.name
                                                    };
                                                    dialogItself.close();
                                                    getCode('add', '添加成功！')
                                                    $('#jqGrid').trigger('reloadGrid');
                                                    /*$('#refresh_jqGrid').trigger('click');*/
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
                            title: "<span style=\"color: #ab8ce4\">修改账号</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/privilegeManage/account_management.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.get("${ctx}/listRolesNotPage", function (data) {
                                    $(data).each(function (index) {
                                        $('#roleName').append('<option value="' + this.id + '">' + this.rolename + '</option>');
                                    })
                                })
                                $('#roleName').find('option').each(function () {
                                    if (this.text() == values.roleName) {
                                        this.attr("selected", "selected");
                                    }
                                })
                                $('#roleName').find('option'),
                                    $('#id').val(values.id),
                                    $('#email').val(values.email),
                                    $('#password').val(values.password),
                                    $('#name').val(values.name)
                                $("#name").attr("disabled", "disabled");
                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'name': $.trim($("#myform").find("#name").val()),
                                        'password': $.trim($("#myform").find("#password").val()),
                                        'email': $.trim($("#myform").find("#email").val())
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
                                            password: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*新密码不能为空'
                                                    }
                                                }
                                            },
                                            email: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '用户邮箱不能为空'
                                                    }, regexp: {
                                                        regexp: /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
                                                        message: '邮箱格式不正确'
                                                    },
                                                }
                                            },
                                            repassword: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '*确认密码不能为空'
                                                    },
                                                    identical: {
                                                        field: 'password',
                                                        message: '*两次输入密码不一致'
                                                    }
                                                }
                                            }
                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/updateUser",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {
                                                    //将新行插入到末尾
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

                        myConfirm('${ctx}/deleteUser', id);

                    };

                    // 获取当前月的第一天

                    function getCurrentMonthFirst() {
                        var date = new Date();
                        date.setDate(1);
                        var y = date.getFullYear();
                        var m = date.getMonth() + 1;
                        var d = date.getDate();
                        return y + "-" + m + "-" + d;
                    }

                    // 获取当前月的最后一天
                    function getCurrentMonthLast() {
                        var date = new Date();
                        var currentMonth = date.getMonth();
                        var nextMonth = ++currentMonth;
                        var nextMonthFirstDay = new Date(date.getFullYear(), nextMonth, 1);
                        var oneDay = 1000 * 60 * 60 * 24;
                        var lastDate = new Date(nextMonthFirstDay - oneDay);
                        var y = lastDate.getFullYear();
                        var m = lastDate.getMonth() + 1;
                        var d = lastDate.getDate();
                        return y + "-" + m + "-" + d;
                    }

                    //条件查询
                    $(function () {

                        $("#find_btn").click(function () {
                            var selectMonth = $("#formSearch").find("#selectMonth").val();
                            console.log(selectMonth);
                            if(selectMonth!=""&&selectMonth!=null){
                                var str=selectMonth.split("-");
                                console.log(str);
                                var y = str[0];
                                var m = str[1];
                                var startStr=y + "-" + m + "-" + 1;
                                var lastDay= new Date(y,m,0).getDate();
                                var endStr=y + "-" + m + "-" + lastDay;
                                $("#jqGrid").jqGrid('setGridParam', {
                                    url: "${ctx}/shortMessage/taskQueryByTask",
                                    datatype: 'json',
                                    postData: {
                                        startStr: startStr, endStr:endStr
                                    }, //发送数据
                                    page: 1
                                }).trigger("reloadGrid"); //重新载入
                            }


                        });
                    });
                </script>
                <script>
                    $(function () {
                        $('.givepermission').click(function () {
                            alert($(this).parent())
                        })
                    })

                    $('.datetime').datetimepicker({
                        format: 'yyyy-mm',
                        autoclose: true,
                        todayBtn: false,
                        startView: 'year',
                        minView: 'year',
                        maxView: 'decade',
                        language: 'zh-CN',
                    });
                </script>
            </div>
        </div>

        <script src="${ctx}/static/js/bootstrap-treeview.js"></script>
    </div>
</div>

</body>

</html>
