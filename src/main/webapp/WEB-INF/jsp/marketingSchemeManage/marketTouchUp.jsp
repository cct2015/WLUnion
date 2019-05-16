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
    <title>营销方案触达</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>营销方案触达</h2>
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
                            url: '${ctx}/marketingPlan/getTouchPlanList',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['Id',
                                '方案名称',
                                '方案内容',
                                '方案提供方',
                                '触达方式',
                                '执行状态',
                                '方案详情',
                                '方案触达',
                                'merchantId',
                               'beginTime',
                               'endTime',
                               'status',
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
                               'usageRule',
                               'supportStore',
                               'couponsNumber',
                               'addUser',
                              'checker',
                              'addTime',
                              'isDifferent',
                              'otherDescripe',
                              'remark'

                            ],
                            colModel: [
                                {name: 'id', index: 'id', hidden: true},
                                {name: 'title', index: 'title', width: '80px'},
                                {name: 'content', index: 'content', width: '80px'},
                                {name: 'merchant', index: 'merchant', width: '80px'},

                                {name: 'touchMode', index: 'touchMode', width: '80px'},
                                {
                                    name: 'status1', index: 'status1', width: '80px',
                                    formatter: function (grid_id, options, rowObject)
                                    {
                                        switch(rowObject.status)
                                        {
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
                                },

                                {
                                    name: 'detail', index: 'detail', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        debugger;
                                        var Str ="<input type='button' onclick=\"findDetail('" +options.rowId + "');\"  value='查看详情' />";
                                        return Str;
                                    }

                                },
                                {
                                    name: 'clickExecute', index: 'clickExecute', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Str ="";
                                        if (rowObject.status == 4)
                                        {
                                            var Str ="<input type='button' onclick=\"execute('" + rowObject.id + "');\"  value='方案触达' />";

                                        }
                                        return Str;
                                    }

                                }
                                ,

                                {name: 'merchantId', index: 'merchantId', width: '80px', hidden: true},
                                {name: 'beginTime', index: 'beginTime', width: '80px', hidden: true},
                                {name: 'endTime', index: 'endTime', width: '80px', hidden: true},
                                {name: 'status', index: 'status', width: '80px', hidden: true},
                                {name: 'province', index: 'province', width: '80px', hidden: true},
                                {name: 'city', index: 'city', width: '80px', hidden: true},
                                {name: 'district', index: 'district', width: '80px', hidden: true},
                                {name: 'name', index: 'name', width: '80px', hidden: true},
                                {name: 'tell', index: 'tell', width: '80px', hidden: true},
                                {name: 'commissionTypeOne', index: 'commissionTypeOne', width: '80px', hidden: true},
                                {name: 'commissionTypeTwo', index: 'commissionTypeTwo', width: '80px', hidden: true},
                                { name: 'commissionTypeThree', index: 'commissionTypeThree', width: '80px', hidden: true},
                                {name: 'couponType', index: 'couponType', width: '80px', hidden: true},
                                {name: 'preferentialWay', index: 'preferentialWay', width: '80px', hidden: true},
                                {name: 'valueOne', index: 'valueOne', width: '80px', hidden: true},
                                {name: 'valueTwo', index: 'valueTwo', width: '80px', hidden: true},
                                {name: 'valueTree', index: 'valueTree', width: '80px', hidden: true},
                                {name: 'describe1', index: 'describe', width: '80px', hidden: true},
                                {name: 'usageRule', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'supportStore', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'couponsNumber', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'checker', index: 'checker', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '80px', hidden: true},
                                {name: 'isDifferent', index: 'isDifferent', width: '80px', hidden: true},
                                {name: 'otherDescripe', index: 'otherDescripe', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true}

                            ],
                            // gridComplete: function () {
                            //     var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                            //     for (var i = 0; i < ids.length; i++) {
                            //         var id = ids[i];
                            //         var values = $("#jqGrid").jqGrid("getRowData", id);
                            //         var detailBtn = "<a href='#' style='color:#f60' onclick=\"findDetail('" + id + "')\"><div style='background-color:bisque;height:25px;width:70px'>查看方案</div></a>";
                            //         var executeBtn = "<a href='#' style='color:#f60' onclick=\"execute('" + id + "')\"><div style='background-color:bisque;height:25px;width:70px'>点击触达</div></a>";
                            //         jQuery("#jqGrid").jqGrid('setRowData', ids[i], {
                            //             detail: detailBtn,
                            //             clickExecute:executeBtn
                            //         });
                            //     }
                            // },
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
                            message: $('<div></div>').load('${ctx}/template/marketingSchemeManage/marketingplanApplyDetail.jsp'),
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
                                    $('#content').val(values.content)
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
                    function execute(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">方案触达</span>" +
                            "<input type='hidden' id='id' value='" + id + "'>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/notsuccesspage.jsp'),//加载弹出页面
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
                </script>
            </div>
        </div>
    </div>
</div>

</body>
</html>
