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
    <title>营销方案执行</title>
    <style>
        .login-dialog .modal-dialog {
            width: 1000px;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>营销方案执行</h2>
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
                            url: '${ctx}/marketingPlan/getExecutePlanList',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            colNames: [
                                'Id',
                                '方案名称',
                                '方案内容',
                                '方案提供方',
                                '推送方式',
                                // '触达方式',
                                'status',
                                '执行状态',
                                'merchantId',
                                'beginTime',
                                'endTime',
                                'usageRule',
                                'province',
                                'city',
                                'district',
                                'name',
                                'tell',
                                'commissionTypeOne',
                                'commissionTypeTwo',
                                'commissionTypeThree',
                                'couponType',
                                'preferentialWay',
                                'valueOne',
                                'valueTwo',
                                'valueTree',
                                'describe1',
                                'supportStore',
                                'couponsNumber',
                                'addUser',
                                'checker',
                                'addTime',
                                'otherDescripe',
                                'remark',
                                'isDifferent',
                                'couponUrl',
                                '方案详情',
                                '精准营销',
                                '广泛营销',
                                '短信营销'

                            ],
                            colModel: [
                                {name: 'id', index: 'id', width: '30px', hidden: true},
                                {name: 'title', index: 'title', width: '50px'},
                                {name: 'content', index: 'content', width: '100px'},
                                {name: 'merchant', index: 'merchant', width: '80px'},
                                {
                                    name: 'isDifferent1', index: 'isDifferent1', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.isDifferent == 1) {
                                            return "异业营销";
                                        }
                                        else
                                            return "垂直营销";
                                    }
                                },

                                // {name: 'touchMode', index: 'touchMode', width: '80px'},
                                {name: 'status', index: 'status', width: '80px', hidden: true},
                                {
                                    name: 'status1', index: 'status1', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch (rowObject.status) {
                                            case 0:
                                                return '待接受';
                                            case 1:
                                                return '已接受';
                                            case 2:
                                                return '拒绝接受';
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
                                }
                                ,
                                {name: 'merchantId', index: 'merchantId', width: '80px', hidden: true},
                                {name: 'beginTime', index: 'beginTime', width: '80px', hidden: true},
                                {name: 'endTime', index: 'endTime', width: '80px', hidden: true},
                                {name: 'usageRule', index: 'usageRule', width: '80px', hidden: true},
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
                                {name: 'describe1', index: 'describe', width: '80px', hidden: true},
                                {name: 'supportStore', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'couponsNumber', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'checker', index: 'checker', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '80px', hidden: true},
                                {name: 'otherDescripe', index: 'otherDescripe', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true},
                                {name: 'couponUrl', index: 'couponUrl', width: '80px', hidden: true},
                                {name: 'isDifferent', index: 'isDifferent', width: '80px', hidden: true},
                                {
                                    name: 'detail', index: 'detail', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var detailBtn = "<input type='button'  onclick=\"findDetail('" + options.rowId + "')\" value='查看'  />";
                                        return detailBtn;
                                    }
                                },
                                {
                                    name: 'clickExecute', index: 'clickExecute', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var executeBtn = "<input type='button'  onclick=\"execute('" + options.rowId + "')\" value='执 行'  />";
                                        return executeBtn;
                                    }
                                },
                                {
                                    name: 'clickExecuteAll', index: 'clickExecute', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var executeBtn = "<input type='button'  onclick=\"executeAll('" + options.rowId + "')\" value='执 行'  />";
                                        return executeBtn;
                                    }
                                },//广泛营销
                                {
                                    name: 'clickExecuteAll', index: 'clickExecuteAll', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var executeBtn = "<input type='button'  onclick=\"executeSMS('" + options.rowId + "')\" value='执 行'  />";
                                        return executeBtn;
                                    }
                                },//短信营销
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
                        })
                    });

                    function findDetail(selectedRowId) {
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">查看详情</span>" +
                            "<input type='hidden' id='id' value='" + values.id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplyDetail.jsp'),//加载弹出页面
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
                                    $('#describe').val(values.describe1),
                                    $('#remark').val(values.remark),
                                    $('#usageRule').val(values.usageRule),
                                    $('#supportStore').val(values.supportStore),
                                    $('#couponsNumber').val(values.couponsNumber),
                                    $('#isDifferent').val(values.isDifferent),
                                    $('#otherDescripe').val(values.otherDescripe),
                                    getSelLabels(values.id),
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

                    function getPersonsPackage(marketId) {
                        var person = 0;
                        $.ajax({
                            url: "${ctx}/marketingPlan/getPersonsPackage",
                            dataType: "json",
                            type: 'post',
                            data: {marketId: marketId},
                            cache: false,
                            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                            success: function (data) {
                                var Str = JSON.stringify(data);
                                //  alert(result);
                                if (Str == "[]") {
                                    person = 0
                                }
                                else {
                                    var result = data.result;
                                    if (result == null) {
                                        person = 0;
                                    }
                                    else {
                                        person = data.result;
                                    }

                                }
                            },
                            error: function (status, error) {
                                person = 0;
                            }
                        });
                        return person;
                    }


                    //精准营销，针对网易的
                    function execute(id) {
                        var person = getPersonsPackage(id);
                        if (person == 0) {
                            getCode('update', "暂没生成人群包，此营销计划还不能进行精准营销！");
                            return;
                        }

                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">营销方案精准营销</span>" +
                            "<input type='hidden' id='id' value='" + id + "'>" +
                            "<input type='hidden' id='merchantId' value='" + values.merchantId + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/ExecuteConfirm.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $('#id').val(values.id);
                                $('#couponUrl').val(values.couponUrl);
                                $('#title').val(values.title);
                                $('#merchantId').val(values.merchantId);
                                GetAllWxInfo(values.merchantId);

                                //获取所有封面图片
                                var id = values.id;
                                var coverType = "cover";
                                var sourceMaterialType = "sourceMaterial";
                                //获取所有封面图片
                                fileCoverShow(id, coverType);
                                //获取所有素材图片
                                sourceMaterialShow(id, sourceMaterialType);

                                $("#phoneMode").attr('checked', false);
                                $("#templateDiv").css("display", "none");
                                $("#paraDiv").css("display", "none");
                            },
                            //数据回显
                            buttons: [
                                {
                                    label: '提交执行',
                                    icon: 'fa fa-check-circle',
                                    cssClass: 'btn-primary',
                                    action: function (dialogItself) {
                                        var mode = "";
                                        if ($("#wxMode").is(':checked')) {
                                            mode = $.trim($("#wxMode").val());
                                        }

                                        if ($("#phoneMode").is(':checked')) {
                                            if (mode == "") {
                                                mode = $.trim($("#phoneMode").val());
                                            }
                                            else {
                                                mode += "," + $.trim($("#phoneMode").val());
                                            }
                                        }
                                        if (mode == "") {
                                            getCode('update', "请选择触达方式！");
                                            return;
                                        }
                                        var appId = $("input[name='wx']:checked").val();
                                        if (appId == "") {
                                            getCode('update', "请选择公众号！");
                                            return;
                                        }

                                        var mediaId = $("#mediaId").val();
                                        var msgtype = $("#msgtype").val();
                                        var content = $("#summernote").summernote('code');
                                        if (msgtype == "text") {
                                            if ($.trim(content).length < 10 || content == '<p><br></p>') {
                                                getCode('update', "请先设置微信内容！");
                                                return;
                                            }
                                        }

                                        if ($.trim(mediaId).length == 0) {
                                            getCode('update', "请输入微信营销内容！");
                                            return;
                                        }
                                        var paradata = {
                                            planId: $.trim($("#id").val()),
                                            mode: mode,
                                            merchantId: $.trim($("#merchantId").val()),
                                            appId: appId,
                                            mediaId: mediaId,
                                            msgtype: msgtype,
                                            content: content
                                        }

                                        $.ajax({
                                            url: "${ctx}/wxExecute/executePlanAccurate",
                                            data: paradata,
                                            dataType: "text",
                                            cache: false,
                                            type: 'POST',
                                            success: function (response) {
                                                var responseob = JSON.parse(response);
                                                if (responseob.code == 200) {
                                                    alert("发送成功");
                                                    //修改数据库记录

                                                }
                                                else {
                                                    alert("发送失败");
                                                }
                                                //  $("#msg").html(response);
                                                // if(response=="-444")
                                                // {
                                                //     alert("请求失败");
                                                // }
                                                // else
                                                // {
                                                //     var Message="请求成功";
                                                //     var responseob=JSON.parse(response);
                                                //     if(responseob.code==200) {
                                                //         switch (responseob.result.state) {
                                                //             case 1:
                                                //                 Message += "，当前状态为“待发送”,原因：" + response.result.reason;
                                                //                 break;
                                                //             case 2:
                                                //                 Message += ",当前状态为“发送中”";
                                                //                 break;
                                                //             case 3:
                                                //                 Message += ",当前状态为“发送成功”";
                                                //                 break;
                                                //             case 4:
                                                //                 Message += ",当前状态为“发送失败”,原因：" + response.result.reason;
                                                //                 break;
                                                //             default:
                                                //                 Message = "未知的错误";
                                                //                 break;
                                                //         }
                                                //     }
                                                //     else
                                                //     {
                                                //
                                                //     }
                                                //     alert(Message);
                                                //  }

                                            }, error: function (textStatus, e) {
                                                alert("系统错误:" + e);
                                            }
                                        });
                                    }
                                },
                                <%--{--%>
                                <%--label: '获得粉丝(用户)列表',--%>
                                <%--icon: 'fa fa-check-circle',--%>
                                <%--cssClass: 'btn-primary',--%>
                                <%--action: function (dialogItself) {--%>

                                <%--var appId=$("input[name='wx']:checked").val();--%>
                                <%--if(appId=="")--%>
                                <%--{--%>
                                <%--getCode('update', "请选择公众号！");--%>
                                <%--return;--%>
                                <%--}--%>

                                <%--var paradata = {--%>
                                <%--appId:appId--%>
                                <%--}--%>
                                <%--$.ajax({--%>
                                <%--url: "${ctx}/wxExecute/executePlanGetwebchatUser",--%>
                                <%--data: paradata,--%>
                                <%--dataType: "text",--%>
                                <%--cache: false,--%>
                                <%--type: 'POST',--%>
                                <%--contentType:'application/x-www-form-urlencoded; charset=UTF-8',--%>
                                <%--success: function (response) {--%>
                                <%--$("#msg").html(response);--%>
                                <%--}, error: function (textStatus, e) {--%>
                                <%--alert("系统错误:"+e);--%>
                                <%--}--%>
                                <%--});--%>
                                <%--}--%>
                                <%--},--%>
                                <%--{--%>
                                <%--label: '获得提交的参数',--%>
                                <%--icon: 'fa fa-check-circle',--%>
                                <%--cssClass: 'btn-primary',--%>
                                <%--action: function (dialogItself) {--%>
                                <%--var mode = "";--%>
                                <%--if ($("#wxMode").is(':checked')) {--%>
                                <%--mode = $.trim($("#wxMode").val());--%>
                                <%--}--%>

                                <%--if ($("#phoneMode").is(':checked')) {--%>
                                <%--if (mode == "") {--%>
                                <%--mode= $.trim($("#phoneMode").val());--%>
                                <%--}--%>
                                <%--else {--%>
                                <%--mode += ","+$.trim($("#phoneMode").val());--%>
                                <%--}--%>
                                <%--}--%>
                                <%--if (mode == "") {--%>
                                <%--getCode('update', "请选择触达方式！");--%>
                                <%--return;--%>
                                <%--}--%>
                                <%--var appId=$("input[name='wx']:checked").val();--%>
                                <%--if(appId=="")--%>
                                <%--{--%>
                                <%--getCode('update', "请选择公众号！");--%>
                                <%--return;--%>
                                <%--}--%>

                                <%--var mediaId=$("#mediaId").val();--%>
                                <%--var msgtype=$("#msgtype").val();--%>
                                <%--var content=$("#summernote").summernote('code');--%>
                                <%--if(msgtype=="text")--%>
                                <%--{--%>
                                <%--if($.trim(content).length<10 || content=='<p><br></p>')--%>
                                <%--{--%>
                                <%--getCode('update', "请先设置微信内容！");--%>
                                <%--return;--%>
                                <%--}--%>
                                <%--}--%>

                                <%--if($.trim(mediaId).length==0)--%>
                                <%--{--%>
                                <%--getCode('update', "请输入微信营销内容！");--%>
                                <%--return;--%>
                                <%--}--%>
                                <%--var paradata = {--%>
                                <%--planId: $.trim($("#id").val()),--%>
                                <%--mode: mode,--%>
                                <%--merchantId: $.trim($("#merchantId").val()),--%>
                                <%--appId:appId,--%>
                                <%--mediaId:mediaId,--%>
                                <%--msgtype:msgtype,--%>
                                <%--content:content--%>
                                <%--}--%>

                                <%--$.ajax({--%>
                                <%--url: "${ctx}/wxExecute/executePlanAccuratePara",--%>
                                <%--data: paradata,--%>
                                <%--dataType: "text",--%>
                                <%--cache: false,--%>
                                <%--type: 'POST',--%>
                                <%--contentType:'application/x-www-form-urlencoded; charset=UTF-8',--%>
                                <%--success: function (response) {--%>
                                <%--$("#msg").html(response);--%>
                                <%--}, error: function (textStatus, e) {--%>
                                <%--alert("系统错误:"+e);--%>
                                <%--}--%>
                                <%--});--%>
                                <%--}--%>
                                <%--},--%>
                                {
                                    label: '关闭',
                                    icon: 'fa fa-close',
                                    action: function (dialogItself) {
                                        dialogItself.close();
                                    }
                                }


                            ]
                        });
                    }

                    //广泛营销，可以只针对某个标签（群）
                    function executeAll(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">营销方案广泛营销</span>" +
                            "<input type='hidden' id='id' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/ExecuteConfirmAll.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $('#id').val(values.id);
                                $('#couponUrl').val(values.couponUrl);
                                $('#title').val(values.title);
                                $('#merchantId').val(values.merchantId);

                                GetAllWxInfo(values.merchantId);

                                //获取所有封面图片
                                var id = values.id;
                                var coverType = "cover";
                                var sourceMaterialType = "sourceMaterial";
                                //获取所有封面图片
                                fileCoverShow(id, coverType);
                                //获取所有素材图片
                                sourceMaterialShow(id, sourceMaterialType);
                            },
                            //数据回显
                            buttons: [
                                {
                                    label: '群发粉丝',
                                    icon: 'fa fa-check-circle',
                                    cssClass: 'btn-primary',
                                    action: function (dialogItself) {
                                        var summernoteStr = $('#summernote').summernote();
                                        console.log(summernoteStr);
                                        var markupStr = $('#summernote').summernote('code');
                                        console.log(markupStr);
                                        var mediaId = $("#thumbMediaId").val();
                                        if (mediaId == null || mediaId == undefined) {
                                            getCode("check", "请选择封面");
                                            return;
                                        }
                                        var appId = $("input[name='wx']:checked").val();
                                        if (appId == null || appId == undefined) {
                                            getCode("check", "请选择公众号");
                                            return;
                                        }
                                        var tag = $("#tag").val();
                                        if (tag == null || tag == undefined) {
                                            getCode("check", "请选择群发对象");
                                            return;
                                        }
                                        executePlanAll(mediaId, appId, tag);


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
                    }

                    //短信营销
                    function executeSMS(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">营销方案短信营销</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/sendPlanSMS.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            onshown: function () {
                                $('#planId').val(values.id);
                                $('#title').val(values.title);
                                $('#couponUrl').val(values.couponUrl);
                            },
                            //数据回显
                            buttons: [
                                {
                                    label: '发送短信',
                                    icon: 'fa fa-check-circle',
                                    cssClass: 'btn-primary',
                                    action: function (dialogItself) {
                                        SendSMS(dialogItself);
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
                    }

                    //提交手机短信任务
                    function SendSMS(dialogItself) {
                        var templateId = $("#templateId").val();
                        var name = $("#name").val();
                        var paras = $("#paras").val();
                        var planId = $("#planId").val();
                        if (templateId.length == 0) {
                            alert("请选择短信模板");
                            return;
                        }

                        if (name.length == 0) {
                            alert("请填写短信任务名");
                            return;
                        }

                        if (paras.length == 0) {
                            alert("请填写参数");
                            return;
                        }
                        $.ajax({
                            url: "${ctx}/SMSExecute/executePlanSMS",
                            dataType: "json",
                            type: 'POST',
                            contenttype: 'application/json',
                            data: {templateId: templateId, name: name, paras: paras, planId: planId},
                            cache: false,
                            success: function (res) {
                                if (res != null) {
                                    dialogItself.close();
                                    getCode('add', res.msg)
                                    /*$('#jqGrid').trigger('reloadGrid');*/
                                } else {
                                    getCode('add', '添加失败！');
                                }
                            },
                            error: function (status, e) {
                                alert("系统错误:" + e);
                            }
                        });
                    }

                    //获得某个营销计划所有的标签
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

                    //获得某个商户的所有公众号
                    function GetAllWxInfo(merchantId) {
                        if (merchantId == null || merchantId == "")
                            return;

                        $.ajax({
                            url: "${ctx}/wxExecute/getAllWxInfo",
                            dataType: "json",
                            type: 'POST',
                            data: {merchantId: merchantId},
                            cache: false,
                            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                            success: function (result) {
                                var htmlStr = "<无>";
                                var count = 0;
                                var radioId = "";
                                $.each(result, function (index, item) {
                                    count = index + 1;
                                    radioId = "radio" + count;
                                    if (htmlStr == "<无>") {
                                        htmlStr = "<input type=\"radio\" checked=\"checked\"  onclick=\"getAppId();\"  name=\"wx\" id=\"" + radioId + "\" value=\"" + item.appId + "\"/>" + item.appName + "";
                                        $("#appIdCover").val(item.appId);
                                        $("#appIdImg").val(item.appId);
                                        if ($("#divtag").length > 0) {
                                            getwxTagList(item.appId);
                                        }

                                    }
                                    else {
                                        htmlStr += "<br /><input type=\"radio\" onclick=\"getAppId();\" name=\"wx\" id=\"" + radioId + "\" value=\"" + item.appId + "\"/>" + item.appName + "";
                                    }

                                });

                                $('#wxCount').val(count);
                                $('#wxInfoDiv').html(htmlStr);

                            },
                            error: function (error) {
                                alert("系统错误:" + error);
                            }
                        });
                    }

                    //    htmlStr += "<input type=\"checkbox\" checked=\"checked\"  onclick=\"getAppId();\"  " +
                    //  "name=\"wx\" id=\"" + radioId + "\" value=\"" + item.appId + "\"/>" + item.nick_name + "("+item.appId+")";
                    //广泛营销
                    function executePlanAll(mediaId, appId, tag) {
                        $.ajax({
                            url: "${ctx}/wxExecute/executePlanAll",
                            dataType: "json",
                            type: 'POST',
                            data: {mediaId: mediaId, appId: appId, tag: tag},
                            cache: false,
                            success: function (result) {
                                var Str = JSON.stringify(result);
                                alert(Str);
                                // if(result=="0" || result==0)
                                // {
                                //     alert("群发成功");
                                // }
                                // else
                                // {
                                //     alert("群发失败");
                                // }
                            },
                            error: function (error) {
                                alert("系统错误:" + error);
                            }
                        });
                    }

                    //获得某个公众号下所有的标签（群）
                    function getwxTagList(appId) {
                        $.ajax({
                            url: "${ctx}/wxExecute/getwxTagList",
                            dataType: "Json",
                            type: 'post',
                            data: {appId: appId},
                            cache: false,
                            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                            success: function (result) {
                                if (result == null) {
                                    return;
                                }
                                $("#tag").empty();
                                $("#tag").append("<option value=\"-1\">全部</option>");
                                $.each(result, function (index, item) {
                                    $("#tag").append("<option value=\"" + item.id + "\">" + item.name + "</option>");
                                });
                                $("#tag").val("-1");
                            },
                            error: function (error) {
                                alert("系统错误:" + error);
                            }
                        });
                    }

                    function fileCoverShow(id, type) {
                        var test = window.location.href;
                        var coverData = {
                            id: id,
                            type: type
                        };

                        //获取所有封面图片
                        $.ajax({
                            type: "POST",
                            url: "${ctx}/common/getAllPathFile",
                            data: coverData,
                            success: function (img) {
                                document.getElementById("galleryfileCover").innerHTML = "";
                                var div = document.createElement("div");
                                for (var i = 0; i < img.length; i++) {

                                    var url = img[i];
                                    // 创建 一个FileReader对象
                                    var reader = new FileReader();
                                    var box = document.createElement("img");
                                    box.setAttribute("src", url);
                                    box.className = 'img';
                                    var imgBox = document.createElement("div");
                                    imgBox.style.display = 'inline-block';
                                    imgBox.className = 'img-item';
                                    imgBox.dataset.filename = img[i];
                                    imgBox.appendChild(box);
                                    var body = document.getElementsByClassName("galleryfileCover")[0];
                                    body.appendChild(imgBox);
                                    $(imgBox).click(function () {
                                        var filename = $(this).data("filename");
                                        var path = {
                                            path: filename
                                        };
                                        var spanList = document.getElementsByClassName("select");
                                        for (var i = 0; i < spanList.length; i++) {
                                            spanList[i].style.display = "none";
                                        }
                                        var selectIcon = document.createElement("span");
                                        selectIcon.className = 'select';
                                        selectIcon.innerText = '√';
                                        $(this).append(selectIcon);
                                        $('#fileCover').val(filename);
                                    })
                                }
                            },
                            error: function (textStatus, e) {
                                getCode('add', "coverData系统ajax交互错误!");
                            }
                        });

                    }

                    //获取所有素材图片
                    function sourceMaterialShow(id, type) {

                        var sourceMaterialData = {
                            id: id,
                            type: type
                        };
                        var applyUrl = "${ctx}/common/getAllPathFile";
                        $.ajax({
                            type: "POST",
                            url: "${ctx}/common/getAllPathFile",
                            data: sourceMaterialData,
                            success: function (img) {
                                document.getElementById("galleryfileImg").innerHTML = "";
                                var div = document.createElement("div");
                                for (var i = 0; i < img.length; i++) {
                                    var url = img[i];
                                    // 创建 一个FileReader对象
                                    var reader = new FileReader();
                                    var box = document.createElement("img");
                                    box.setAttribute("src", url);
                                    box.className = 'imgTwo';
                                    //box.dataset.filename = img[i];
                                    var imgBox = document.createElement("div");
                                    imgBox.style.display = 'inline-block';
                                    imgBox.className = 'img-itemTwo';
                                    imgBox.dataset.filename = img[i];

                                    imgBox.appendChild(box);
                                    var body = document.getElementsByClassName("galleryfileImg")[0];
                                    body.appendChild(imgBox);
                                    $(imgBox).click(function () {
                                        var filename = $(this).data("filename");
                                        var spanList = document.getElementsByClassName("selectTwo");
                                        for (var i = 0; i < spanList.length; i++) {
                                            spanList[i].style.display = "none";
                                        }
                                        var selectIcon = document.createElement("span");
                                        selectIcon.className = 'selectTwo';
                                        selectIcon.innerText = '√';
                                        $(this).append(selectIcon);
                                        // $(this).style("color:red");
                                        $('#fileImg').val(filename);

                                        var path = {
                                            path: filename
                                        };
                                    })
                                }
                            },
                            error: function (textStatus, e) {
                                getCode('add', "sourceMaterialData系统ajax交互错误!");
                            }
                        });
                    };
                </script>
            </div>
        </div>
    </div>
</div>
</body>
</html>
