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
    <title>企业会员数量报表</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>企业会员数量报表</h2>
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
                            url: '${ctx}/headquartersReport/getCompanyMembersTotal',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['id','企业商户名称', '所属渠道商', '会员总数','非微信会员总数','微信会员总数'],
                            colModel: [
                                {name: 'id', index: 'id', width: '10px', hidden: true},
                                {name: 'name', index: 'merchantName', width: '100px'},
                                {name: 'parentName', index: 'parentMerchantName', width: '100px'},
                                {name: 'totalMembers', index: 'totalMembers', width: '70px'},
                                {name: 'otherMembers', index: 'otherMembers', width: '50px'},
                                {name: 'wxMembers', index: 'wxMembers', width: '50px'}
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
                            }

                            ,
                            jsonReader: {
                                root: "rows",
                                page: "page",
                                total: "total",
                                records: "records",
                                repeatitems: false,
                                cell: "cell",
                                id: "id"
                            }


                        })
                        ;


                        $('#jqGrid').jqGrid('navGrid', '#jqGridPager', {
                            refresh: false,
                            edit: false,
                            add: false,
                            del: false,
                            search: false,
                            position: "right"
                        })

                    });


                </script>
            </div>
        </div>


    </div>
</div>

</body>
</html>
