<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <style>
        .modal .modal-dialog {
            width: 1100px;
            margin-left: 15%;
            margin-top: 10px;
        }

    </style>
</head>
<body>
<div class="container">
    <%--<script src="${ctx}/static/jqGrid/js/jquery.jqGrid.min.js"></script>
    <script src="${ctx}/static/jqGrid/js/jquery.min.js"></script>
    <script src="${ctx}/static/jqGrid/js/jquery.jqGrid.min.js"></script>--%>
    <%--<script src="${ctx}/static/js/jquery-ui.js"></script>

    <script src="${ctx}/static/js/bootstrap-dialog.min.js"></script>--%>
        <%--<link href="${ctx}/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">--%>
            <div class="x_title">
                <div class="clearfix"></div>
            </div>
            <div hidden="hidden">
                <input type="text" id="goodsId" value="">
                <input type="text" id="materialId" value="">
                <input type="text" id="couponUrl" value="">
            </div>


                    <table id="jqGrid"></table>
                    <div id="jqGridPager"></div>

                <script type="text/javascript">
                    var checkBox=[];
                    var cPage=0;
                    $(document).ready(function () {
                        $("#jqGrid").jqGrid({
                            url: '${ctx}/marketingMerchant/selectMerchantByType',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: [
                                'ID', '商户名称', '商户简称', '商户号', '行业Id', '行业类型', '联系人', '联系电话',
                                '国家', '省(直辖市)', '城市', '县(区)', '主营产品', '主营品牌', '商户类别', '商户类别',
                                '商户级别', '上级商户id', '上级商户', '收单机构acquirer', '收单机构', '银行对公账号', '开户名', '开户行', '企业地址', '纳税号',
                                '企业信用码/营业执照号', '备注', '添加时间', '添加人', '最后更新时间',
                                '最后一次修改人', '状态', '查看详情'],
                            colModel: [
                                {name: 'id', index: 'id', width: '80px', hidden: true},
                                {name: 'companyName', index: 'companyName', width: '80px'},
                                {name: 'companyShort', index: 'companyShort', width: '80px'},
                                {name: 'marketingNo', index: 'marketingNo', width: '80px', hidden: true},
                                {name: 'industryId', index: 'industryId', width: '80px', hidden: true},
                                {name: 'industryName', index: 'industryName', width: '80px'},
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
                                    name: 'merchantTypeShow', index: 'merchantTypeShow', width: '80px',
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
                                {name: 'parentName', index: 'parentName', width: '80px'},
                                {name: 'acquirer', index: 'acquirer', width: '80px', hidden: true},
                                {
                                    name: 'acquirer1', index: 'acquirer1', width: '80px', hidden: true,
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.acquirer == 0) {
                                            return '银联';
                                        } else if (rowObject.acquirer == 1) {
                                            return '杉德';
                                        } else {
                                            return '银联/杉德';
                                        }
                                    }
                                },
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

                            ],
                            gridComplete: function () {
                                var ids = jQuery("#jqGrid").jqGrid('getDataIDs');
                                for (var i = 0; i < ids.length; i++) {
                                    var id = ids[i];
                                    var editBtn = "<input type='button'  value='查看详情' onclick=\"find('" + id + "')\" />";
                                    jQuery("#jqGrid").jqGrid('setRowData', ids[i], {detail: editBtn});
                                }

                            },
                            rowNum: 15,
                            rowList: [20, 15, 30],
                            height: $(window).height,
                            width:$(".modal-dialog").width()*0.97,
                            pager:"#jqGridPager",
                            altRows:true,
                            hidegrid:false,
                            viewrecords:true,
                            recordpos:'left',
                            loadonce:false,
                            multiselect: true,
                            onPaging:function (pgButton) {
                                cPage++; //翻页事件
                            },
                            loadComplete:function (data) {
                                if (cPage == 0) {
                                    checkBox = [];//每次加载清空选中状态
                                }
                                cPage = 0;
                                var rowArr = data.rows;
                                if (checkBox.length > 0) {
                                    for (var i = 0; i < rowArr.length; i++) {
                                        for (var j = 0; j < checkBox.length; j++) {
                                            if (rowArr[i].id == checkBox[j].id) {
                                                $("#jqGrid").jqGrid('setSelection', rowArr[i].id);
                                                break;
                                            }
                                        }
                                    }
                                }
                            },onSelectRow:function(rowId,status){
                                if(status){
                                    if (checkBox.indexOf(rowId) == -1){
                                        var values = $("#jqGrid").jqGrid("getRowData", rowId);
                                        checkBox.push(values);
                                    }
                                }else{
                                    deleteCheckBox(rowId);
                                }
                            },
                            jsonReader: {
                                root: "rows",
                                page:"page",
                                total:"total",
                                records:"records",
                                repeatitems:false,
                                cell:"cell",
                                id:"id"
                            }


                        });
                        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                            refresh: false,
                            edit: false,
                            add: false,
                            del: false,
                            search: false,
                            position: "right"
                        });
                    });

                    function find(id) {
                        var values = $("#jqGrid").jqGrid("getRowData", id);
                        var dialog = BootstrapDialog.show({
                            type: BootstrapDialog.TYPE_DEFAULT,
                            title: "<span style=\"color:#73879C\">查看详情</span>",
                            closable: false,
                            draggable: true,
                            cssClass: 'api-blacklist-form-add',
                            message: $('<div></div>').load('${ctx}/template/dataManage/marketingMerchant.jsp'),//加载弹出页面
                            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
                            //数据回显
                            onshown: function () {
                                //行业
                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/baseIndustry/selectAll",
                                    success: function (data) {
                                        for (var i = 0; i < data.rows.length; i++) {
                                            if (data.rows[i].id == values.industryId) {
                                                $("#industryId").append("<option selected=\"selected\"  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
                                                continue;
                                            }
                                            $("#industryId").append("<option  value='" + data.rows[i].id + "'>" + data.rows[i].industryName + "</option>");
                                        }
                                    }
                                });
                                $("#merchantType").children("option[value='" + values.merchantType + "']").attr("selected", "selected");

                                $.ajax({
                                    type: "POST",
                                    url: "${ctx}/marketingMerchant/selectAll",
                                    success: function (data) {
                                        for (var i = 0; i < data.rows.length; i++) {
                                            if (data.rows[i].id == values.parentId) {
                                                $("#parentId").append("<option selected=\"selected\" value='" + data.rows[i].id + "'>" + data.rows[i].companyName + "</option>");
                                                continue;
                                            }
                                            if (data.rows[i].id != values.id) {
                                                $("#parentId").append("<option  value='" + data.rows[i].id + "'>" + data.rows[i].companyName + "</option>");
                                            }
                                        }
                                    }
                                });

                                $.get("${ctx}" + "/static/json/location.min.json", function (data) {
                                    for (var key in data) {
                                        if (data[key].code == values.province) {
                                            $("#province").append("<option selected='selected' value='" + data[key].code + "'>" + data[key].name + "</option>");
                                        }
                                        $("#province").append("<option value='" + data[key].code + "'>" + data[key].name + "</option>");
                                        for (var keys in data[key].cities) {
                                            if (data[key].code == $("#province").val()) {
                                                if (data[key].cities[keys].code == values.city) {
                                                    $("#city").append("<option selected='selected' value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                                                }
                                                $("#city").append("<option value='" + data[key].cities[keys].code + "'>" + data[key].cities[keys].name + "</option>");
                                                for (var keyss in data[key].cities[keys].districts) {
                                                    if (data[key].cities[keys].code == $("#city").val()) {
                                                        if (keyss == values.district) {
                                                            $("#district").append("<option selected='selected' value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                                        }
                                                        $("#district").append("<option value='" + keyss + "'>" + data[key].cities[keys].districts[keyss] + "</option>");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                })
                                var status = 0;
                                if (values.status == "停用") {
                                    status = 1;
                                }
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
                                    $('#acquirer').val(values.acquirer),
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
                    function deleteCheckBox(rowId){
                        for(var i = 0; i < checkBox.length; i++){
                            if (checkBox[i].id == rowId){
                                //根据索引值删除checkBox中的数据
                                checkBox.splice(i,1);
                            }
                        }
                    }
                </script>



</div>
</body>
</html>
