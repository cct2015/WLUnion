<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>欢迎使用网陆数据联盟系统</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main" align="center" style="padding-bottom: 0px;height: 100%">
        <h1 style="font-family: 华文行楷"><b>平台整体情况</b></h1>
        <div id="information" style="background-color: rgba(252,252,252,0);margin-top: 0%;margin-left: 5%">

            <table width="100%" height="500px" style="text-align: center;background-color:#ffffff;border-collapse: separate;">
                <tr style="height: 100px" >
                    <td  width="15%">
                        <img style="padding-left: 10%;padding-top: 0%;height: 100px" src="${ctx}/static/images/memberNumber.png"/>
                    </td>
                    <td   width="15%" >
                        <div>
                            <label>当前平台会员数：</label>
                            <div id="memberNumber">memberNumber</div>
                        </div>
                    </td>
                    <td width="70%" rowspan="4"></td>
                </tr>
                <tr style="height:100px">
                    <td  >
                        <img style="padding-left: 10%;padding-top: 0%;height: 100px" src="${ctx}/static/images/merchantBrandNumber.png"/>
                    </td>
                    <td  >

                        <div>
                            <label>当前平台品牌数：</label>
                            <div id="merchantBrandNumber">merchantBrandNumber</div>
                        </div>

                    </td>

                </tr>
                <tr style="height: 25%">
                    <td  >
                        <img style="padding-left: 10%;padding-top: 0%;height: 100px" src="${ctx}/static/images/wxNumber.png"/>


                    </td>
                    <td  >
                        <div>
                            <label>当前平台公众号数：</label>
                            <div id="wxNumber">wxNumber</div>
                        </div>

                    </td>
                </tr>
                <tr style="height: 25%">
                    <td  >
                        <img  style="padding-left: 10%;padding-top: 0%;height: 100px" src="${ctx}/static/images/wxFansNumber.png"/>
                    </td>
                    <td  >
                        <div>
                            <label>当前平台粉丝量：</label>
                            <div id="wxFansNumber">wxFansNumber</div>
                        </div>

                    </td>

                </tr>
            </table>
        </div>
    </div>
</div>
<script>
    $.ajax({
        url: "${ctx}/merchantInformation/getMerchantInformation",
        data: '',
        dataType: "json",
        cache: false,
        success: function (response) {
            if (response != null) {
                document.getElementById("memberNumber").innerHTML=response.memberNumber;
                document.getElementById("merchantBrandNumber").innerHTML=response.merchantBrandNumber;
                document.getElementById("wxFansNumber").innerHTML=response.wxFansNumber;
                document.getElementById("wxNumber").innerHTML=response.wxNumber;
            } else {
                getCode('update', "加载失败!");

            }
        },

        error: function (textStatus, e) {
            getCode('update', "系统ajax交互错误!");

        }
    });


</script>
</body>
</html>