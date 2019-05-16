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
    <title>营销方案信息管理</title>

</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>营销方案</h2>
                <div class="clearfix"></div>
            </div>
            <div container>
                <div class="row">
                    <form id="formSearch" class="form-horizontal" >
                        <div class="form-group" >
                            <label  for="status" class="control-label col-sm-1">方案状态：</label>
                            <div class="col-sm-2">
                                <select class="form-control" id="status" name="status" class="selectpicker">
                                    <option value="0" selected="selected">未审核</option>
                                    <option value="1">审核通过</option>
                                    <option value="2">审核没通过</option>
                                </select>
                            </div>
                            <div >
                                <input type="button" value="查 询" onclick="Query();"
                                       class="btn btn-primary"/>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            <div class="x_content">
                <div>
                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>
                </div>
                <script type="text/javascript">
                    function Query() {
                        var status = $('#status').val();
                        console.log(status);
                        $("#jqGrid").jqGrid('setGridParam', {
                            url: '${ctx}/marketingPlan/getMarketingPlanInHQByPlanStatus',
                            postData: {status: status},
                            datatype:'json',
                            page: 1
                        }).trigger("reloadGrid");
                    }

                    $(document).ready(function () {
                        init();
                    });

                    function init() {
                       /* var status = $('#status').val();*/
                        $("#jqGrid").jqGrid({
                            url: '${ctx}/marketingPlan/getMarketingPlanInHQByPlanStatus',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            postData: {status: status},
                            rownumbers: true,
                            colNames: ['ID', '方案名称', '方案内容', '所属商户', '开始时间', '结束时间', '使用规则', 'status', '审核状态', '省', '市', '县', '联系账号', '联系手机', '佣金1', '佣金2', '佣金3', '优惠券', '抵用方式', '券值1', '券值2', '券值3', '活动描述',
                                '支持门店', '优惠卷数量', '创建人', '审核人', '创建时间', '是否异业', '优惠劵其他说明', '备注', '操作'],
                            colModel: [
                                {name: 'id', index: 'id', width: '30px', hidden: true},
                                {name: 'title', index: 'title', width: '50px',editable:true },
                                {name: 'content', index: 'content', width: '80px'},
                                {name: 'merchantId', index: 'merchantId', width: '80px', hidden: true},
                                {name: 'beginTime', index: 'beginTime', width: '80px'},
                                {name: 'endTime', index: 'endTime', width: '80px'},
                                {name: 'usageRule', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'status', index: 'status', width: '80px', hidden: true},
                                {
                                    name: 'ischeck', index: 'ischeck', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        switch (rowObject.status) {
                                            case 0:
                                                return '未审核';
                                            case 1:
                                                return '通过审核';
                                            case 2:
                                                return '未通过审核';
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

                                {name: 'supportStore', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'couponsNumber', index: 'usageRule', width: '80px', hidden: true},
                                {name: 'addUser', index: 'addUser', width: '80px', hidden: true},
                                {name: 'checker', index: 'checker', width: '80px', hidden: true},
                                {name: 'addTime', index: 'addTime', width: '80px',sorttype: "date"},
                                {name: 'isDifferent', index: 'isDifferent', width: '80px', hidden: true},
                                {name: 'otherDescripe', index: 'otherDescripe', width: '80px', hidden: true},
                                {name: 'remark', index: 'remark', width: '80px', hidden: true},
                                {
                                    name: 'detail', index: 'detail', width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        var Str = "<input type='button' onclick=\"Detail('" + options.rowId + "');\"  value='详情' />";
                                        //修改和删除

                                        return Str;
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
                            }


                        });

                       /* jQuery('#jqGrid').jqGrid('filterToolbar');*/
                        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                            refresh: true,
                            edit: false,
                            add: false,
                            del: false,
                            search: true,

                            position: "right"
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
                    function Detail(selectedRowId) {
                        debugger;
                        //获得当前行各项属性
                        var values = $("#jqGrid").jqGrid("getRowData", selectedRowId);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color: #ab8ce4\">数据详细</span><input type='hidden' id='detail' value='\"+values.id+\"' />",
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
                                    $('#describe').val(values.describe),
                                    $('#remark').val(values.remark),
                                    $('#usageRule').val(values.usageRule),
                                    $('#supportStore').val(values.supportStore),
                                    $('#couponsNumber').val(values.couponsNumber),
                                    $('#isDifferent').val(values.isDifferent),
                                    $('#otherDescripe').val(values.otherDescripe),

                                    getSelLabels(values.id),
                                    $('#myform').find('select,input,textarea,span').attr("disabled", "disabled");
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
                </script>
            </div>
        </div>


    </div>
</div>

</body>
</html>
