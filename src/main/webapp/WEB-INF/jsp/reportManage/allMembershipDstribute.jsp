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
    <title>企业微信会员分布</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="right_col" role="main">
        <div class="x_panel">
            <div class="x_title">
                <h2>平台会员数量</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div id="main" style="margin:auto;width: 1000px;height:450px;"></div>
                <script type="text/javascript">
                    var servicedata=[];
                    var legenddata=[];
                    var myChart = echarts.init(document.getElementById('main'));
                    option = {
                        title : {
                            text: '平台会员数量构成',
                            subtext: '网陆数据',
                            x:'center'
                        },
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: legenddata
                        },
                        series : [
                            {
                                name: '数据统计',
                                type: 'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data:servicedata,
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    $(function () {
                        $.ajax({
                            url: '${ctx}/headquartersReport/getAllMembershipDistribute',
                            dataType: "json",
                            type: 'POST',
                            cache: false,
                            success:function (data) {
                                for(var i=0;i<2;i++){
                                    var obj=new Object();
                                    if(i==0){
                                        obj.value=data.otherMembers;
                                        obj.name='其他会员';
                                        legenddata[i]='其他会员';
                                    }else {
                                        obj.value=data.wxMembers;
                                        obj.name='微信会员';
                                        legenddata[i]='微信会员';
                                    }
                                    servicedata[i]=obj;

                                }
                                myChart.setOption(option);
                            },
                            error: function (status, e) {
                                getCode("check","系统错误!")
                            }

                        });
                    })

                </script>
            </div>
        </div>


    </div>
</div>

</body>
</html>
