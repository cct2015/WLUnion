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
    <title>标签管理</title>

</head>

<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title" id="customLabel">
                <h2>标签管理--自定义标签</h2>

                <div class="clearfix">
                    &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="getHead()">一级标签</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="prohibitNetEaseLables('0')">禁用自定义标签</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="prohibitNetEaseLables('1')">启用自定义标签</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;<button style="margin-left: 45%" onclick="changeCustom()">网易标签</button>
                </div>
            </div>
            <div>
                <form id="formSearch" class="form-horizontal" style="text-align: center">
                    <div class="form-group" style="margin-top:15px;margin: 0 auto;text-align: center">
                        <div class="col-sm-2">
                            <select id="selectType" class="form-control" name="selectType">
                                <option value="1">标签名称</option>
                                <option value="2">按分类名称查询</option>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" id="selectValue" class="form-control" name="selectValue">
                        </div>
                        <div class="col-sm-1" style="text-align:center;">
                            <button type="button" id="find_btn" class="btn btn-primary">查询</button>
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
                            url: '${ctx}/baseLabel/selectBySource?source=' + 1,
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: [
                                'ID','级别','备注','上级标签' ,'标签名称', '标签序号', '是否必选', '是否必选', '描述', '是否禁用', '是否禁用', '操作'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'leaf', index: 'leaf', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true},
                                {name: 'parentKey', index: 'parentKey', width: '80px', hidden: true},
                                {name: 'text', index: 'text', width: '80px'},
                                {name: 'orderNo', index: 'orderNo', width: '80px'},
                                {name: 'isMust', index: 'isMust', width: '80px', hidden: true},
                                {
                                    name: 'isMustShow', index: 'isMustShow', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.isMust == 1) {
                                            return '必选';
                                        } else {
                                            return '可不选';
                                        }
                                    }
                                },
                                {name: 'description', index: 'description', width: '80px', hidden: true},
                                {name: 'isValid', index: 'isValid', width: '80px', hidden: true},
                                {
                                    name: 'isValidShow', index: 'isValidShow', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.isMust == 1) {
                                            return '未禁用';
                                        } else {
                                            return '禁用';
                                        }
                                    }
                                },

                                {
                                    name: 'status',
                                    index: 'status',
                                    width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var str = "<input type='button'  value='禁用' onclick=\"prohibit(' " + options.rowId + "',' " + 0 + "' )\"/>";
                                        if (rowObject.isValid == 0) {
                                            str = "<input type='button'  value='启用' onclick=\"prohibit(' " + options.rowId + " ',' " + 1 + "')\"/>";
                                        }


                                        return str;
                                    }

                                },
                            ],
                            /* gridComplete: function () {
                                 var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                                 for (var i = 0; i < ids.length; i++) {
                                     var id = ids[i];
                                     var editBtn = "<input type='button'  value='禁用' onclick=\"prohibit(' "+id+" ')\"/>";


                                     jQuery("#jqGrid").jqGrid('setRowData', ids[i], {detail: editBtn});

                                 }

                             },*/
                            rowNum: 15,
                            rowList: [20, 15, 30],
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

                        });
                    });
                    //条件查询
                    $(function () {
                        $("#find_btn").click(function () {
                            var selectType = $("#formSearch").find("#selectType").val();
                            var selectValue = $("#formSearch").find("#selectValue").val();
                            var source = 1;
                            $("#jqGrid").jqGrid('setGridParam', {
                                url: "${ctx}/baseLabel/selectByType",
                                datatype:'json',
                                postData: {
                                    'selectType': selectType,
                                    'selectValue': selectValue,
                                    'source': source,
                                }, //发送数据
                                page: 1
                            }).trigger("reloadGrid"); //重新载入
                        });
                    });

                    //window.find = find;
                    function prohibit(id, isValid) {
                        var json = {
                            'id': id,
                            'isValid': isValid
                        };
                        $.ajax({
                            url: "${ctx}/baseLabel/updateIsValid",
                            data: json,
                            dataType: "json",
                            cache: false,
                            success: function (response) {
                                if (response != null) {


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

                    var openDialog4Adding = function () {
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">添加标签</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/addBaseLabel.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseLabel/selectBySourceAndStep?source=" + 1 + "&step=" + 1,
                                    success: function (data) {
                                        $("#parentKey").append("<option selected=\"selected\" value='" + '' + "'>" + '' + "</option>");
                                        for (var i = 0; i < data.length; i++) {

                                            $("#parentKey").append("<option  value='" + data[i].keyss + "'>" + data[i].text + "</option>");


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
                                        'text': $.trim($("#myform").find("#text").val()),
                                        'isMust': $.trim($("#myform").find("#isMust").val()),
                                        'orderNo': $.trim($("#myform").find("#orderNo").val()),
                                        'isValid': 1,
                                        'description': $.trim($("#myform").find("#description").val()),
                                        'parentKey': $.trim($("#myform").find("#parentKey").val()),
                                        'leaf': $.trim($("#myform").find("#leaf").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
                                        'source': 1
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

                                            text: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标签名不能为空！'
                                                    },
                                                }
                                            },
                                            orderNo: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标签序号不能为空！'
                                                    },
                                                }
                                            },
                                            leaf: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标签级别不能为空！'
                                                    },
                                                }
                                            }


                                        }
                                    });

                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/baseLabel/insert",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {


                                                    dialogItself.close();
                                                    getCode('add', "添加成功!");
                                                    $('#jqGrid').trigger('reloadGrid');
                                                    /*$('#refresh_jqGrid').trigger('click');*/
                                                } else {
                                                    getCode('add', "添加失败!");

                                                }
                                            },

                                            error: function (textStatus, e) {
                                                getCode('add', "系统ajax交互错误!");

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
                            title: "<span style=\"color: #ab8ce4\">修改标签</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/addBaseLabel.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {    //标签
                                    $('#id').val(values.id),
                                    $('#text').val(values.text),
                                    $('#isMust').val(values.isMust),
                                    $('#leaf').val(values.leaf),
                                    $('#description').val(values.description),
                                    $('#remark').val(values.remark),
                                    $('#orderNo').val(values.orderNo)
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseLabel/selectBySourceAndStep?source=" + 1 + "&step=" + 1,
                                    success: function (data) {
                                        console.log(data);
                                        if (values.parentKey == "") {
                                            $("#parentKey").append("<option selected=\"selected\" value='" + '' + "'>" + '' + "</option>");
                                            for (var i = 0; i < data.length; i++) {

                                                $("#parentKey").append("<option  value='" + data[i].keyss + "'>" + data[i].text + "</option>");


                                            }
                                        } else {
                                            $("#parentKey").append("<option  value='" + '' + "'>" + '' + "</option>");
                                            for (var i = 0; i < data.length; i++) {
                                                if (values.parentKey == data[i].keyss) {
                                                    $("#parentKey").append("<option   selected=\"selected\" value='" + data[i].keyss + "'>" + data[i].text + "</option>");

                                                }
                                                $("#parentKey").append("<option   value='" + data[i].keyss + "'>" + data[i].text + "</option>");
                                            }
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
                                    var merchantType = 0;
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'text': $.trim($("#myform").find("#text").val()),
                                        'isMust': $.trim($("#myform").find("#isMust").val()),
                                        'orderNo': $.trim($("#myform").find("#orderNo").val()),
                                        'isValid': 1,
                                        'description': $.trim($("#myform").find("#description").val()),
                                        'parentKey': $.trim($("#myform").find("#parentKey").val()),
                                        'leaf': $.trim($("#myform").find("#leaf").val()),
                                        'remark': $.trim($("#myform").find("#remark").val()),
                                        'source': 1
                                    };
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

                                            text: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标签名不能为空！'
                                                    },
                                                }
                                            },
                                            orderNo: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标签序号不能为空！'
                                                    },
                                                }
                                            },
                                            leaf: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '标签级别不能为空！'
                                                    },
                                                }
                                            }


                                        }
                                    });

                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/baseLabel/updateById",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {


                                                    dialogItself.close();
                                                    getCode('update', "修改成功!");
                                                    $('#jqGrid').trigger('reloadGrid');
                                                    /!*$('#refresh_jqGrid').trigger('click');*!/
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


                </script>
            </div>
        </div>
    </div>
</div>
<script>
    function changeCustom() {
        window.location.href = "${ctx}/dataManage/labelManager";
    }

    function getHead() {

        $("#jqGrid").jqGrid('setGridParam', {
            url: "${ctx}/baseLabel/selectBySourceAndStep",
            postData: {
                'source': 1,
                'step': 1
            }, //发送数据
            page: 1
        }).trigger("reloadGrid"); //重新载入

    }

    function prohibitNetEaseLables(isValid) {
        var json = {
            'source': 1,
            'isValid': isValid
        }
        $.ajax({
            url: "${ctx}/baseLabel/prohibitAll",
            data: json,
            type: "get",
            dataType: "json",
            cache: false,
            success: function (response) {
                if (response != null) {


                    if (isValid == 0) {
                        getCode('update', "禁用成功!");
                    } else {
                        getCode('update', "启用成功!");
                    }

                    $('#jqGrid').trigger('reloadGrid');
                    /*$('#refresh_jqGrid').trigger('click');*/
                } else {
                    if (isValid == 0) {
                        getCode('update', "禁用失败!");
                    } else {
                        getCode('update', "启用失败!");
                    }


                }
            },

            error: function (textStatus, e) {
                getCode('update', "系统ajax交互错误!");

            }
        });
    }
</script>
</body>
</html>
