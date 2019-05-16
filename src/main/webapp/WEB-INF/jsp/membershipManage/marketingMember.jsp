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
    <title>会员列表</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>会员列表</h2>
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
                            url: '${ctx}/marketingMember/selectAll',
                            styleUI: 'Bootstrap',
                            editurl: 'clientArray',
                            datatype: "json",
                            rownumbers: true,
                            colNames: ['ID', '手机号', '姓名','性别','年龄',  '画像', 'openId', '所属公众号ID',  '电子邮件',  '来源','添加时间'],
                            colModel: [
                                {name: 'id', index: 'id', width: '10px', hidden: true},
                                {name: 'phone', index: 'sort', width: '200px'},
                                {name: 'name', index: 'name', width: '50px'},
                                {name: 'gender', index: 'parentId', width: '50px'},
                                {name: 'age', index: 'industryName', width: '50px'},
                                {name: 'image', index: 'image', width: '80px', hidden: true},
                                {name: 'openId', index: 'openId', width: '80px', hidden: true},
                                {name: 'appId', index: 'parentName', width: '120px'},
                                {name: 'email', index: 'email', width: '120px'},
                                {
                                    name: 'source',
                                    index: 'source',
                                    width: '50px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.source == 0) {
                                            return '公众号';
                                        } else {
                                            return '其他';
                                        }
                                    }
                                },
                                {name: 'addTime', index: 'addTime', width: '100px'},
                                /*{name: 'addUser', index: 'addUser', width: '80px'},*/
/*
                                {
                                    name: 'status',
                                    index: 'status',
                                    width: '80px',
                                    formatter: function (grid_id, options, rowObject) {
                                        if (rowObject.status == 0) {
                                            return '正常使用';
                                        } else {
                                            return '其他';
                                        }
                                    }
                                },
*/


                            ],
                            rowNum: 15,
                            rowList : [ 20, 15,30 ],
                            height: $(window).height,
                            autowidth: true,
                            pager: "#jqGridPager",
                            altRows: true,
                            /*rowList : [ 10, 15, 20 ],*/
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
                        })/*.navButtonAdd('#jqGridPager', {

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

                         })*/;

                    });


                </script>
            </div>
        </div>


    </div>
</div>

</body>
</html>
