<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>非微信会员导入</title>
    <style>
        #upload{
            width: 100%;
            height: 300px;
        }
    </style>
</head>
<body class="nav-md">
<div class="container body" >
    <div class="right_col" role="main">
        <div id="upload">
    <form  method="post" enctype="multipart/form-data">
        <div style="text-align:right;padding:5px">
            <a id="test" class="btn btn-success btn-sm" href="${ctx}/static/excelfile/Excel.xlsx"
               title="下载" style="background-color: deepskyblue">
                <i class="fa fa-arrow-circle-down">
                    <span style="font-size:larger;font-weight:200;color:whitesmoke">请下载上传模板.xlsx</span>
                </i>
            </a>
        </div>
        <div >
            <br>
            <!-- multiple表示允许同时上传多个文件，class=“file-loading”表示标签的样式。这里很重要，如果class="file"，则中文化不能生效 -->
            <input id="excelFile" type="file" name="file">
        </div>
    </form>
    </div>
    </div>
</div>
<script>
    <%--$(function(){--%>
        <%--$('#test').click(function(){--%>
            <%--$.post('${ctx}/itembank/creatExcel',function () {--%>
                <%--alert("您的模板已经下载在D盘中!");--%>
            <%--});--%>
        <%--})--%>
    <%--})--%>
    $('#excelFile').fileinput({
        language: 'zh', //设置语言
        uploadUrl: '${ctx}/marketingMember/insertExcell', //上传的地址
        allowedFileExtensions: ["xlsx"],//接收的文件后缀
        uploadAsync : false,
        execlEncoding:'UTF-8',
        showCaption: true,//是否显示标题
        browseClass: "btn btn-info", //按钮样式
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        showPreview: true, //是否显示预览
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",

    });
</script>
</body>
</html>