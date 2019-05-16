<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="planId" value="${pageContext.request.getParameter('planId')}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8"/>
    <title>效果预测</title>
    <script>
        $(function(){
            var marketId="${planId}";
            getPersonsPackage(marketId)
        });
        function getPersonsPackage(marketId)
        {
            $.ajax({
                url: "${ctx}/marketingPlan/getPersonsPackage",
                dataType: "json",
                type: 'post',
                data: {marketId:marketId},
                cache: false,
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                success: function (data) {
                    var Str=JSON.stringify(data);
                 //  alert(result);
                    if(Str=="[]")
                    {
                        $("#result").html('没有获得有效的人群包');
                    }
                   else
                   {
                       var result=data.result;
                       if(result==null)
                       {
                           $("#result").html('没有获得有效的人群包');
                       }
                       else
                       {
                           $("#result").html("适配人群数量："+result);
                       }

                    }
                },
                error: function (status,error) {
                    alert("系统错误:" + error);
                }
            });
        }
    </script>
</head>
<body class="nav-md">
<div class="container body">
    <div class="container" role="main" id="result" style="width: 80%;height: 100%; font-size: 18px; color: red">
        <%--<iframe src='http://wanglu.prophet.netease.com/api/wanglu/customerGroup/qty?tenantId=<%=com.luer.comm.utils.GetSysUser.getSysUser().getMerchantId().trim()%>&marketId=${planId}' style="width: 100%;height: 100%;border: none;margin-bottom: 10px"></iframe>--%>
    </div>
</div>
</body>
</html>
