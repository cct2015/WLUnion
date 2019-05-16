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
    <title>异业营销方案执行状态</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>异业营销方案执行状态</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div>
                    <table id="jqGrid">
                    </table>
                    <div id="jqGridPager"></div>
                </div>
                <script type="text/javascript">
                    $(document).ready(function () {
                        $("#jqGrid").jqGrid({
                            url: '${ctx}/marketingPlan/getExecuteMarketingPlanPacking',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['Id', '方案名称', '方案内容', '匹配企业', '接受状态','是否执行'],
                            colModel: [
                                {name: 'id', index: 'id', width: '30px', hidden: true,key:true},
                                {name: 'marketingPlanTitle', index: 'marketingPlanTitle', width: '50px',
                                    cellattr: function(rowId) {
                                        //合并单元格
                                        return 'id=\'marketingPlanTitle' + rowId + "\'";
                                    }},
                                {name: 'marketingPlanContent', index: 'marketingPlanContent', width: '80px',
                                    cellattr: function(rowId) {
                                        //合并单元格
                                        return 'id=\'marketingPlanContent' + rowId + "\'";
                                    }},
                                {name: 'companyName', index: 'companyName', width: '80px'},
                                {
                                    name: 'status', index: 'status1', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                            // NEW(0, "未审核"),
                                            // PASS(1, "审核通过"),
                                            // NOTPASS(2, "审核不通过"),
                                            // EXECUTING(3, "执行中"),
                                            // EXCUTEOVER(4, "执行完毕"),
                                            // TOUCHING(5, "触达中"),
                                            // TOUCHOVER(6, "触达完毕")
                                        //是否接受
                                        switch(rowObject.status )
                                        {
                                            case 0:
                                                return '新建';
                                            case 1:
                                                return '已接受';
                                            case 2:
                                                return '拒绝接受';
                                            default:
                                                return "";
                                        }

                                    }
                                },
                                {
                                    name: 'excutestatus', index: 'excutestatus', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch(rowObject.excutestatus)
                                        {
                                            case 3:
                                                return '执行中';
                                            case 4:
                                                return '执行完毕';
                                            case 5:
                                                return '触达中';
                                            case 6:
                                                return '触达完毕';
                                            default:
                                                return "待完成功能";
                                        }

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
                            multiselect: false,
                            sortable:true,
                            sortname:'addTime',
                            sortorder:'desc',
                            reloadAfterSubmit:true,
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
                            },
                            gridComplete: function () {

                                    var gridName = "jqGrid";
                                    Merger(gridName, 'marketingPlanTitle');
                                    Merger(gridName, 'marketingPlanContent');


                            },



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
                    function findDetail(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">查看详情</span>" +
                            "<input type='hidden' id='id' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplyDetail.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
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
                    function Merger(gridName, CellName) {
                        //得到显示到界面的id集合
                        var mya = $("#" + gridName + "").getDataIDs();
                        //当前显示多少条
                        var length = mya.length;
                        for (var i = 0; i < length; i++) {
                            //从上到下获取一条信息
                            var before = $("#" + gridName + "").jqGrid('getRowData', mya[i]);
                            //定义合并行数
                            var rowSpanTaxCount = 1;
                            for (j = i + 1; j <= length; j++) {
                                console.log("length==========="+length);
                                //和上边的信息对比 如果值一样就合并行数+1 然后设置rowspan 让当前单元格隐藏
                                var end = $("#" + gridName + "").jqGrid('getRowData', mya[j]);
                                if (before[CellName] == end[CellName]) {
                                    rowSpanTaxCount++;
                                    $("#" + gridName + "").setCell(mya[j], CellName, '', { display: 'none' });
                                } else {
                                    rowSpanTaxCount = 1;
                                    break;
                                }
                                $("#" + CellName + "" + mya[i] + "").attr("rowspan", rowSpanTaxCount);
                            }
                        }
                    }

                </script>
            </div>
        </div>
    </div>
</div>

</body>
</html>
