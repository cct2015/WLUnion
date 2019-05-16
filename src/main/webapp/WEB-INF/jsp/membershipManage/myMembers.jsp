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
    <title>我的会员</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <iframe src="http://wanglu.prophet.netease.com/member?tenantId=<%=com.luer.comm.utils.GetSysUser.getSysUser().getMerchantId().trim()%>" style="width: 100%;height: 100%;border: none;margin-bottom: 10px"></iframe>
    </div>
</div>
</body>
</html>
