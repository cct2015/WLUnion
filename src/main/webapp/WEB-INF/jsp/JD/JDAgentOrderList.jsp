<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <title>京东券月分佣月报表</title>
    <style>
        input:focus {
            border: red solid 1px;
        }
        .login-dialog .modal-dialog {
             width: 1400px;
         }
    </style>
</head>

<body class="nav-md">
<div class="right_col" role="main">
    <div class="container body" style="height: 100%; width: 100%;">
        <div class="x_title">
            <h2>明细汇总</h2>
            <div class="clearfix"></div>
        </div>
        <div>
            <form id="formSearch" class="form-horizontal">
                <div class="row" style="padding-right: 2%">
                    <div class="form-group col-sm-3">
                        <label for="beginTime" class="col-sm-4 control-label">开始时间:</label>
                        <div class=" input-group col-sm-6 date form_datetime hasDatepicker  "
                             data-date="" data-date-format="yyyy-mm-dd hh:ii">
                            <input class="form-control" readonly="readonly" type="text" value="" name="beginTime"
                                   id="beginTime" placeholder="开始时间">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="endTime" class="col-sm-4 control-label">结束时间:</label>
                        <div class=" input-group  date form_datetime hasDatepicker col-sm-6"
                             data-date="" data-date-format="yyyy-mm-dd hh:ii">
                            <input class="form-control" readonly="readonly" type="text" value="" name="endTime"
                                   id="endTime"
                                   placeholder="结束时间">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                    </div>

                    <div class="form-group col-sm-3">
                        <label for="merchantId" class="col-sm-4 control-label">企业选择:</label>
                        <div class="col-sm-6">
                            <select id="merchantId" class="form-control" name="selectType">
                                <option value="">选择企业</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="orderId" class="col-sm-4 control-label">订单号:</label>
                        <div class="col-sm-6">
                            <input type="text" id="orderId" class="form-control" name="orderId">
                        </div>
                        <div class="col-sm-1">
                            <button type="button" id="find_btn" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>
        <div class="row" style="width: 100%">
            <table id="jqGrid"></table>
            <div id="jqGridPager"></div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    $(function () {
        initdatepicker();
        InitGrid();
        $.get("${ctx}/marketingMerchant/selectByTypeAndParentId?type="+ 1 + '&parentId=' + '<%=request.getSession().getAttribute("merchantId") %>', function (data) {
            for (var i = 0; i < data.rows.length; i++) {
                $("#merchantId").append("<option value='" + data.rows[i].id + "'>" + data.rows[i].companyName + "</option>");
            }
        })
    });
    //订单条件查询
    $(function () {
        $("#find_btn").click(function () {
            var merchantId = $("#formSearch").find("#merchantId").val();
            var beginTime = $("#formSearch").find("#beginTime").val();
            var endTime = $("#formSearch").find("#endTime").val();
            var orderId = $("#formSearch").find("#orderId").val();
            var parentId='<%=request.getSession().getAttribute("merchantId") %>';
            $("#jqGrid").jqGrid('setGridParam', {
                url: "${ctx}/JD/getAgentOrder",
                datatype:'json',
                postData: {
                    'merchantId': merchantId,
                    'parentId': parentId,
                    'beginTime': beginTime,
                    'endTime': endTime,
                    'orderId': orderId
                }, //发送数据
                page: 1
            }).trigger("reloadGrid"); //重新载入
        });
    });
    function DateFormat(date, fmt) {
        var o = {
            "M+": date.getMonth() + 1,                 //月份
            "d+": date.getDate(),                    //日
            "h+": date.getHours(),                   //小时
            "m+": date.getMinutes(),                 //分
            "s+": date.getSeconds(),                 //秒
            "q+": Math.floor((date.getMonth() + 3) / 3), //季度
            "S": date.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    function initdatepicker() {
        $('.form_datetime').datetimepicker({
            minView: 'month',
            format: "yyyy-mm-dd",
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1
        });
    }
    function InitGrid() {
        jQuery("#jqGrid").jqGrid({
            url: '${ctx}/JD/selectAgentOrder?merchantId='+'<%=request.getSession().getAttribute("merchantId") %>',
            styleUI: 'Bootstrap',
            editurl: 'clientArray',
            datatype: "json",
            mtype: "POST",
            rownumbers: true,
            colNames: [
                '订单号', '订单状态', '下单时间',
                '预估佣金','结算时间', '下单设备','商户名称','客户ID','操作'],
            colModel: [
                {name: 'orderId', index: 'orderId', width: '80px'},
                {
                    name: 'validCode', index: 'status', width: '80px',
                    formatter: function (grid_id, options, rowObject) {
                        switch (rowObject.validCode) {
                            case -1:
                                return '未知';
                            case 2:
                                return '无效-拆单';
                            case 3:
                                return '无效-取消';
                            case 4:
                                return '无效-京东帮帮主订单';
                            case 5:
                                return '无效-账号异常';
                            case 6:
                                return '无效-赠品类目不返佣';
                            case 7:
                                return '无效-校园订单';
                            case 8:
                                return '无效-企业订单';
                            case 9:
                                return '无效-团购订单';
                            case 10:
                                return '无效-开增值税专用发票订单';
                            case 11:
                                return '无效-乡村推广员下单';
                            case 12:
                                return '无效-自己推广自己下单';
                            case 13:
                                return '无效-违规订单';
                            case 14:
                                return '无效-来源与备案网址不符';
                            case 15:
                                return '待付款';
                            case 16:
                                return '已付款';
                            case 17:
                                return '已完成';
                            case 18:
                                return '已结算';
                        }
                    }
                },
                {
                    name: 'orderTime', index: 'orderTime', width: '100px',
                    formatter: function (grid_id, options, rowObject) {
                        var date = new Date(rowObject.orderTime);
                        return DateFormat(date, 'yyyy年MM月dd日hh时mm分');
                    }
                },
                {name: 'estimateFee', index: 'estimateFee', width: '80px'},
                {
                    name: 'payMonth', index: 'payMonth', width: '80px',
                    formatter: function (grid_id, options, rowObject) {
                        // var date = new Date(rowObject.payMonth);
                        //   return DateFormat(date, 'yyyy年MM月dd日hh时mm分');
                        return "--";

                    }
                },
                {
                    name: 'orderEmt', index: 'orderEmt', width: '80px',
                    formatter: function (grid_id, options, rowObject) {
                        if (rowObject.orderEmt == 1) {
                            return "PC";
                        }
                        else {
                            return "无线";
                        }
                    }
                },
                {name: 'merchantName', index: 'merchantName', width: '80px'},
                {name: 'customerId', index: 'customerId', width: '80px'},
                {
                    name: 'detail', index: 'detail', width: '80px',
                    formatter: function (grid_id, options, rowObject) {
                        return "<input type='button' onclick=\"commissionDetail('" + options.rowId + "');\"  value='查看明细' />";
                    }
                }
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
            sortable: true,
            sortname: 'orderTime',
            sortorder: "asc",
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
                id: "orderId"
            }
        });

        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
            refresh: true,
            edit: false,
            add: false,
            del: false,
            search: false,
            position: "right"
        });
    }

    function commissionDetail(rowId) {
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPE_DEFAULT,
            title: "<span style=\"color:#73879C\">佣金详细</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/JD/commissionDetail.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            //数据回显
            onshown: function () {
                initGridDetail(rowId);
                },
            buttons: [
                {
                    label: '关闭',
                    icon: 'fa fa-close',
                    action: function (dialogItself) {
                        dialogItself.close();
                    }
                }]
        });
    }

    function initGridDetail(rowId) {

        $("#jqGridDetail").jqGrid({
            url: "${ctx}/JD/selectOrderSkuListByID?orderId="+rowId,
            styleUI: 'Bootstrap',
            editurl: 'clientArray',
            datatype: "json",
            mtype: "POST",
            rownumbers: true,
            colNames: [
                 '商品名称', '商品编号', '数量', '售后中数量', '退货中数量', '付款金额', '佣金比例', '分成比例', '预估佣金', '实际金额', '实际佣金','联合营销方'],
            colModel: [
                {name: 'skuName', index: 'skuName', width: '180px'},
                {name: 'skuId', index: 'skuId', width: '110px'},
                {name: 'skuNum', index: 'skuNum', width: '60px'},
                {name: 'frozenSkuNum', index: 'frozenSkuNum', width: '100px'},
                {name: 'skuReturnNum', index: 'skuReturnNum', width: '100px'},
                {name: 'estimateCosPrice', index: 'estimateCosPrice', width: '100px'},
                {name: 'commissionRate', index: 'commissionRate', width: '90px'},
                {name: 'subSideRate', index: 'subSideRate', width: '90px'},
                {name: 'estimateFee', index: 'estimateFee', width: '90px'},
                {name: 'actualCosPrice', index: 'actualCosPrice', width: '90px'},
                {name: 'actualFee', index: 'actualFee', width: '90px'},
                {name: 'merchantName', index: 'merchantName', width: '100px'}
            ],
            gridComplete: function () {

            },
            height: $(window).height,
            autowidth: true,
            autoheight: true,
            altRows: true,
            hidegrid: false,
            viewrecords: true,
            recordpos: 'left',
            loadonce: false,
            multiselect: false,
            loadComplete: function (data) {
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
    }
</script>
</body>
</html>