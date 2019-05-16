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
    <title>非微信会员导入</title>
</head>
<body>

<div class="container body">
    <div class="right_col" role="main" align="center">

        <%--<div >--%>
            <%--<br>--%>
            <%--<!-- multiple表示允许同时上传多个文件，class=“file-loading”表示标签的样式。这里很重要，如果class="file"，则中文化不能生效 -->--%>
            <%--<input id="excelFile" type="file" name="file">--%>
        <%--</div>--%>
            <div style="margin-top: 10%;font-size: 30px">
                <a href="${ctx}/static/excelfile/Excel.xlsx"> <button style="border-radius: 5px">点击下载EXCEL会员导入模板</button></a>
            </div>
            <div style="margin-top: 10%;font-size: 30px">
            <form  method="post" enctype="multipart/form-data" name="upfile" id="importModel">
                <input type="file" class="test" name="excelFile" style="color: #00aeef">
                <%--<input type="submit" name="btnUpload" value="上传Excel文件">--%>
                <%--<input type="button" value="上传" onclick="confirm()" id="upfile">--%>
                <input type="button" id="upfile" class="btn btn-primary btn-sm" style="width: 136px;height:46px;" value="提交"/>
            </form>
            </div>
    </div>
</div>
<script>
    $(function () {
        $("#upfile").click(function () {
            console.log("+++++++++++++");
            var formData = new FormData($("#importModel")[0]);
            console.log(formData);
           $.ajax({
             type : 'post',
             url : '${ctx}/marketingMember/insertExcell',
             dataType : 'json',
             data : formData,
             contentType: false,
             processData: false,
             success : function(data){
                 getCode("add", "导入成功")
             },error:function () {
                   getCode("check", "导入失败")
             }
             });

        })
    })

</script>

</body>

</html>
