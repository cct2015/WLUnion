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
    <title>企业非微信会员分布</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>企业非微信会员分布</h2>
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
                            url: '${ctx}/headquartersReport/getCompanyMembersCount',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['ID', '企业商户名称', '所属渠道商','非微信会员数量'],
                            colModel: [
                                {name: 'id', index: 'id', width: '10px', hidden: true},
                                {name: 'companyName', index: 'companyName', width: '200px'},
                                {name: 'parentName', index: 'parentName', width: '50px'},
                                {name: 'fans', index: 'fans', width: '50px'}

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
                            loadonce: false,
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
                                id: "merchantId"
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
