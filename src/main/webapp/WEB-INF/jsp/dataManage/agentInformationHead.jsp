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
    <title>渠道商资料（总部旗下）</title>
    <style>
        .modal login-dialog {
            width: 1000px;
            margin-left:15%;
            margin-top: 10%;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body" >
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>渠道商资料（总部旗下）</h2>
                <div class="clearfix"></div>
            </div>
            <div>
                <form id="formSearch" class="form-horizontal" >
                    <div class="form-group" >
                        <div class="col-sm-2">
                            <select id="selectType" class="form-control" name="selectType">
                                <option value="1">渠道商名称</option>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <input type="text" id="selectValue" class="form-control" name="selectValue">
                        </div>
                        <div class="col-sm-1" >
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
                            url: '${ctx}/marketingMerchant/selectByTypeAndParentId?type=' + 0 + '&parentId=' + '',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: [
                                'ID', '渠道商名称', '渠道商简称', '商户号', '行业Id', '行业类型', '联系人', '联系电话',
                                '国家', '省(直辖市)', '城市', '县(区)', '主营产品', '主营品牌', '商户类别', '商户类别',
                                '商户级别', '上级商户id', '上级商户', '银行对公账号', '开户名', '开户行', '企业地址', '纳税号',
                                '企业信用码/营业执照号', '备注', '添加时间', '添加人', '最后更新时间',
                                '最后一次修改人', '状态', '查看详情', '查看下级'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'companyName', index: 'companyName', width: '80px'},
                                {name: 'companyShort', index: 'companyShort', width: '80px'},
                                {name: 'marketingNo', index: 'marketingNo', width: '80px', hidden: true},
                                {name: 'industryId', index: 'industryId', width: '80px', hidden: true},
                                {name: 'industryName', index: 'industryName', width: '80px', hidden: true},
                                {name: 'contacter', index: 'contacter', width: '80px', hidden: true},
                                {name: 'tel', index: 'tel', width: '80px', hidden: true},
                                {name: 'country', index: 'country', width: '80px', hidden: true},
                                {name: 'province', index: 'province', width: '80px', hidden: true},
                                {name: 'city', index: 'city', width: '80px', hidden: true},
                                {name: 'district', index: 'district', width: '80px', hidden: true},
                                {name: 'mainProducts', index: 'mainProducts', width: '80px', hidden: true},
                                {name: 'mainBrand', index: 'mainBrand', width: '80px', hidden: true},
                                {name: 'merchantType', index: 'merchantType', width: '80px', hidden: true},
                                {
                                    name: 'merchantTypeShow', index: 'merchantTypeShow', width: '80px', hidden: true,
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.merchantType == 0) {
                                            return '渠道商户';
                                        } else {
                                            return '企业商户';
                                        }
                                    }
                                },
                                {name: 'step', index: 'step', width: '80px', hidden: true},
                                {name: 'parentId', index: 'parentId', width: '80px', hidden: true},
                                {name: 'parentName', index: 'parentName', width: '80px', hidden: true},
                                {name: 'bankUser', index: 'bankUser', width: '80px', hidden: true},
                                {name: 'bankNo', index: 'bankNo', width: '80px', hidden: true},
                                {name: 'bankAddress', index: 'bankAddress', width: '80px', hidden: true},
                                {name: 'address', index: 'address', width: '80px', hidden: true},
                                {name: 'faxNo', index: 'faxNo', width: '80px', hidden: true},
                                {name: 'creditCode', index: 'creditCode', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '120px'},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'lastUpdate', index: 'lastUpdate', width: '80px', hidden: true},
                                {name: 'lastUpdater', index: 'lastUpdater', width: '80px', hidden: true},
                                {
                                    name: 'status', index: 'status', width: '80px', hidden: true,
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.status == 0) {
                                            return '正常使用';
                                        } else {
                                            return '停用';
                                        }
                                    }
                                },
                                {
                                    name: 'detail',
                                    index: 'detail',
                                    width: '80px',

                                },
                                {
                                    name: 'viewSubordinate',
                                    index: 'viewSubordinate',
                                    width: '80px',

                                },
                            ],
                            gridComplete: function () {
                                var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                                for (var i = 0; i < ids.length; i++) {
                                    var id = ids[i];
                                    var editBtn = "<input type='button'  value='查看详情' onclick=\"find('" + id + "')\" />";

                                    /* "<a href='#' style='color:#f60' onclick=\"find('" + id + "')\"><div style='background-color:blanchedalmond;height:25px;width:70px'>查看详细</div></a>";*/
                                    jQuery("#jqGrid").jqGrid('setRowData', ids[i], {detail: editBtn});
                                    var editBtn2 = "<input type='button'  value='查看企业商户' onclick=\"view('" + id + "')\" />";

                                    /* "<a href='#' style='color:#f60' onclick=\"view('" + id + "')\"><div style='background-color:blanchedalmond;height:25px;width:70px'>查看企业商户</div></a>";*/
                                    jQuery("#jqGrid").jqGrid('setRowData', ids[i], {viewSubordinate: editBtn2});
                                }

                            },
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
                    //条件查询
                    $(function () {
                        $("#find_btn").click(function () {
                            var selectType = $("#formSearch").find("#selectType").val();
                            var selectValue = $("#formSearch").find("#selectValue").val();
                            var merchantType = 0;
                            $("#jqGrid").jqGrid('setGridParam', {
                                url: "${ctx}/marketingMerchant/selectByType",
                                datatype:'json',
                                postData: {
                                    'selectType': selectType,
                                    'selectValue': selectValue,
                                    'merchantType': merchantType
                                }, //发送数据
                                page: 1
                            }).trigger("reloadGrid"); //重新载入
                        });
                    });

                    //window.find = find;
                    function find(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        console.log(values);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">查看详情</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/dataManage/agentInformation.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            //数据回显
                            onshown: function () {


                                $('#id').val(values.id),
                                    $('#companyName').val(values.companyName),
                                    $('#companyShort').val(values.companyShort),
                                    $('#contacter').val(values.contacter),
                                    $('#tel').val(values.tel),
                                    $('#address').val(values.address),
                                    $('#mainProducts').val(values.mainProducts),
                                    $('#mainBrand').val(values.mainBrand),
                                    $('#step').val(values.step),
                                    $('#bankNo').val(values.bankNo),
                                    $('#bankAddress').val(values.bankAddress),
                                    $('#status').val(status),
                                    $('#creditCode').val(values.creditCode),
                                    $('#remark').val(values.remark),
                                    $('#bankUser').val(values.bankUser),
                                    $('#marketingNo').val(values.marketingNo),
                                    $('#faxNo').val(values.faxNo)
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

                    function view(id) {
                        window.location.href = "${ctx}/dataManage/view?parentId=" + id;
                    }

                    var openDialog4Adding = function () {
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPEer_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">新增渠道商</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/agentInformationAdd.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var merchantType = 0;
                                    var flag=$("#flag").val();
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'companyName': $.trim($("#myform").find("#companyName").val()),
                                        'companyShort': $.trim($("#myform").find("#companyShort").val()),
                                        'contacter': $.trim($("#myform").find("#contacter").val()),
                                        'tel': $.trim($("#myform").find("#tel").val()),
                                        'merchantType': merchantType,
                                        'step': $.trim($("#myform").find("#step").val()),
                                        'parentId': $.trim($("#myform").find("#parentId").val()),
                                        'bankNo': $.trim($("#myform").find("#bankNo").val()),
                                        'bankAddress': $.trim($("#myform").find("#bankAddress").val()),
                                        'status': $.trim($("#myform").find("#status").val()),
                                        'faxNo': $.trim($("#myform").find("#faxNo").val()),
                                        'marketingNo': $.trim($("#myform").find("#marketingNo").val()),
                                        'bankUser': $.trim($("#myform").find("#bankUser").val())
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

                                            companyName: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '企业名不能为空！'
                                                    },
                                                }
                                            },
                                            companyShort: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '企业简称不能为空！'
                                                    },
                                                }
                                            },
                                            contacter: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '联系人不能为空！'
                                                    },
                                                }
                                            },
                                            tel: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '联系电话不能为空！'
                                                    },
                                                    regexp: {
                                                        regexp: /^1(3|4|5|7|8)\d{9}$/,
                                                        message: '手机号格式不正确！'
                                                    },
                                                }
                                            },
                                            marketingNo: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '渠道商英文简称不能为空！'
                                                    },
                                                    stringLength: {
                                                        min: 2,
                                                        max: 6,
                                                        message: '简称长度不能小于2位或超过6位'
                                                    },
                                                    regexp: {
                                                        regexp:  /^[a-zA-Z]+$/,
                                                        message: '简称由2-6位的英文字母组成！！'
                                                    }
                                                }
                                            },
                                            name: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '用户名不能为空！'
                                                    },
                                                    regexp: {
                                                        regexp: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/,
                                                        message: '用户名由6-18位的字母和数字组成！！'
                                                    },

                                                    threshold: 2,//有2字符以上才发送ajax请求
                                                    remote: {//ajax验证。server result:{"valid",true or false}
                                                        url: "${ctx}/checkUserName",
                                                        message: '账号已存在,请重新输入',
                                                        delay: 1000,//ajax刷新的时间是1秒一次
                                                        type: 'POST',
                                                        //自定义提交数据，默认值提交当前input value
                                                        data: function(validator) {
                                                            return {
                                                                userName : $.trim($("#myform").find("#name").val())
                                                            };
                                                        }
                                                    }
                                                }
                                            },
                                            password: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '密码不能为空！'
                                                    },
                                                    regexp: {
                                                        regexp: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/,
                                                        message: '密码由6-18位的字母和数字组成！！'
                                                    },
                                                }
                                            }

                                        }
                                    });
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    setTimeout(function () {
                                        if (bootstrapValidator.isValid() === true){
                                            $.ajax({
                                                url: "${ctx}/marketingMerchant/merchantAndUserInsert",
                                                type: "post",
                                                data: {
                                                    "jsonStr": JSON.stringify(json),
                                                    "name": $("#name").val(),
                                                    "password": $("#password").val()
                                                },

                                                cache: false,
                                                success: function (response) {
                                                    if (response != null) {

                                                        dialogItself.close();
                                                        getCode('add', "添加成功!");
                                                        $('#jqGrid').trigger('reloadGrid');
                                                    } else {
                                                        getCode('add', "添加失败!");
                                                    }
                                                },
                                                error: function (textStatus, e) {
                                                    getCode('add', "系统ajax交互错误!")

                                                }
                                            });
                                        }
                                    },300);
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
                            title: "<span style=\"color: #ab8ce4\">修改渠道商</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/dataManage/agentInformation.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                //行业



                                $('#id').val(values.id),
                                $('#companyName').val(values.companyName),
                                $('#companyShort').val(values.companyShort),
                                $('#contacter').val(values.contacter),
                                $('#tel').val(values.tel),
                                $('#bankNo').val(values.bankNo),
                                $('#bankAddress').val(values.bankAddress),
                                $('#status').val(status),
                                $('#creditCode').val(values.creditCode),
                                $('#bankUser').val(values.bankUser),
                                $('#marketingNo').val(values.marketingNo),
                                $('#faxNo').val(values.faxNo)
                                //document.getElementById("userInformation").style.display="none";

                            },
                            buttons: [{
                                id: 'btn-form-submit',
                                label: '提交',
                                icon: 'fa fa-check-circle',
                                cssClass: 'btn-primary',
                                action: function (dialogItself) {  //点击事件
                                    var merchantType=0;
                                    var json = {
                                        'id': $.trim($("#myform").find("#id").val()),
                                        'companyName': $.trim($("#myform").find("#companyName").val()),
                                        'companyShort': $.trim($("#myform").find("#companyShort").val()),
                                        'contacter': $.trim($("#myform").find("#contacter").val()),
                                        'tel': $.trim($("#myform").find("#tel").val()),
                                        'merchantType': merchantType,
                                        'step': $.trim($("#myform").find("#step").val()),
                                        'bankNo': $.trim($("#myform").find("#bankNo").val()),
                                        'bankAddress': $.trim($("#myform").find("#bankAddress").val()),
                                        'status': $.trim($("#myform").find("#status").val()),
                                        'faxNo': $.trim($("#myform").find("#faxNo").val()),
                                        'bankUser': $.trim($("#myform").find("#bankUser").val())
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

                                            companyName: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '企业名不能为空！'
                                                    },
                                                }
                                            },
                                            companyShort: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '企业简称不能为空！'
                                                    },
                                                }
                                            },
                                            contacter: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '联系人不能为空！'
                                                    },
                                                }
                                            },
                                            tel: {
                                                validators: {
                                                    notEmpty: {
                                                        message: '联系电话不能为空！'
                                                    },
                                                    regexp: {
                                                        regexp: /^1(3|4|5|7|8)\d{9}$/,
                                                        message: '手机号格式不正确！'
                                                    },
                                                }
                                            }

                                        }
                                    });
                                    console.log(json);
                                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                                    bootstrapValidator.validate();
                                    if (bootstrapValidator.isValid()) {
                                        $.ajax({
                                            url: "${ctx}/marketingMerchant/updateById",
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
                        myConfirm('${ctx}/marketingMerchant/deleteById', id);


                    };
                </script>
            </div>
        </div>
    </div>
</div>
</body>
</html>
