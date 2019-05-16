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
    <title>异业营销方案接受</title>
    <style>
        .login-dialog .modal-dialog {
            width: 1000px;
        }

        .login-dialog2 .modal-dialog {
            width: 500px;
            height:500px
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>异业营销方案接受</h2>
                <div class="clearfix"></div>
            </div>
            <div style="margin-left: auto; margin-right: auto; margin-top: 5px">
                <div style="display: inline; width: 80px; float: left; margin-left: 10px; font-size: 15px; padding-top: 6px">接受状态：</div>
                <div style="display: inline; width: 135px; float: left">
                    <select class="form-control" id="status" name="status" style="height: 35px;width: 130px; ">
                        <option value="0"  selected="selected">待接受</option>
                        <option value="1">已接受</option>
                        <option value="2">已拒绝</option>
                    </select>
                </div>
                <div style="display: inline; width: 100px; float: left; margin-left: 10px">
                    <input type="button" value="查 询" onclick="Query();" style="width: 90px;height: 35px; " class="icon-search"/>
                </div>
            </div>
            <div class="x_content" style="margin-top: 10px">
                <div>
                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>
                </div>
                <script type="text/javascript">
                    function Query()
                    {
                        var status=$('#status').val();
                        $("#jqGrid").jqGrid('setGridParam',{
                            url: '${ctx}/marketingPlan/getOtherMarketingPlanList',
                            postData:{status:status},
                            datatype:'json',
                            page:1
                        }).trigger("reloadGrid");
                    }

                    $(document).ready(function ()
                    {
                        var status=$('#status').val();
                        $("#jqGrid").jqGrid({
                            url: '${ctx}/marketingPlan/getOtherMarketingPlanList',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            postData:{status:status},
                            rownumbers: true,
                            colNames: ['ID', '方案名称', '方案内容', '方案提供方', '开始时间', '结束时间', '审核状态','接受状态', '省', '市', '县', '联系账号', '联系手机', '佣金1', '佣金2', '佣金3', '优惠券', '抵用方式', '券值1', '券值2', '券值3', '活动描述', '创建人', '审核人', '推送方式', '备注','推送时间',  '效果预测','方案接受'],
                            colModel: [
                                {name: 'id', index: 'id', width: '30px', hidden: true},
                                {name: 'title', index: 'title', width: '50px'},
                                {name: 'content', index: 'content', width: '80px'},
                                {name: 'merchant', index: 'merchant', width: '80px'},
                                {name: 'beginTime', index: 'beginTime', width: '80px'},
                                {name: 'endTime', index: 'endTime', width: '80px'},
                                {name: 'status', index: 'status', width: '80px', hidden: true},
                                {name: 'statusName', index: 'statusName', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch(rowObject.status )
                                        {
                                            case 0:
                                                return '待接受';
                                            case 1:
                                                return '已接受';
                                            case 2:
                                                return '已拒绝';
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
                                },

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
                                {name: 'describe', index: 'describe', width: '80px', hidden: true},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'checker', index: 'checker', width: '80px', hidden: true},
                                {name: 'isDifferent', index: 'isDifferent', width: '80px', hidden: true},
                                {name: 'otherDescripe', index: 'otherDescripe', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '80px'},
                                {
                                    name: 'detail', index: 'detail', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Str ="";
                                        Str = "<input type='button' onclick=\"forecast('" + rowObject.id + "');\"  value='查看预测' />";
                                        return Str;
                                    }
                                },
                                {name: 'accept', index: 'examine', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Str ="";
                                        if(rowObject.status==0)
                                            Str = "<input type='button' onclick=\"find('" + rowObject.id + "');\"  value='方案接受' />";
                                        else
                                            Str ="已处理"
                                        return Str;
                                    }

                                },

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
                        window.find = find;

                        function find(id) {
                            var values = $("#jqGrid").jqGrid("getRowData", id);
                            var dialog = BootstrapDialog.show({
                                type: BootstrapDialog.TYPE_DEFAULT,
                                title: "<span style=\"color:#73879C\">方案接受</span>" +
                                "<input type='hidden' id='id' value='" + id + "'>",
                                closable: false,
                                draggable: true,
                                cssClass: 'api-blacklist-form-add',
                                message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanaccept.jsp'),//加载弹出页面
                                size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                                //数据回显
                                buttons: [{
                                    id: 'btn-form-submit',
                                    label: '提交',
                                    icon: 'fa fa-check-circle',
                                    cssClass: 'btn-primary',
                                    action: function (dialogItself) {  //点击事件
                                        var json = {
                                            'planId': id,
                                            'status': $.trim($("#myform").find("#status").val())
                                        };
                                        $.ajax({
                                            url: "${ctx}/marketingPlan/acceptMarketingPlanInEnterprise",
                                            data: json,
                                            dataType: "json",
                                            cache: false,
                                            success: function (response) {
                                                if (response != null) {
                                                    dialogItself.close();
                                                    getCode('add', "接受方案成功!");
                                                    $('#jqGrid').setGridParam({datatype:'json'}).trigger('reloadGrid');
                                                    /*$('#refresh_jqGrid').trigger('click');*/
                                                } else {
                                                    getCode('add', "接受方案失败!");
                                                }
                                            },

                                            error: function (textStatus, e) {
                                                getCode('add', "系统ajax交互错误!");
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
                        }

                    });

                    //预测
                    function forecast(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">适配人群数量</span>" +
                                "<input type='hidden' id='id' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'login-dialog2',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingResultGuest.jsp?planId='+values.id),//加载弹出页面
                            size: BootstrapDialog.SIZE_NORMAL,//弹出框大小。
                            //数据回显
                            buttons: [{
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
    </div>
</div>

</body>
</html>
