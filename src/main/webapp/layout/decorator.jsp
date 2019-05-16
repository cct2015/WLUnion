<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <link href="${ctx}/static/css/jquery-ui.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="${ctx}/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="${ctx}/static/jqGrid/css/ui.jqgrid-bootstrap.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${ctx}/static/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${ctx}/static/vendors/build/css/custom.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/notifIt.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/static/icon.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/static/css/bootstrap-select.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx}/static/css/bootstrapValidator.css"/>
    <link rel="stylesheet" href="${ctx}/static/zTree/css/css/zTreeStyle.css" type="text/css">
    <link href="${ctx}/static/zTree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css"/>
    <style>
        a {
            background-color: #2C4257;
        }

        ul {
            background-color: #2C4257;
        }

        li {
            background-color: #2C4257;
        }

        . li > a {
            background-color: #2C4257;
            background: linear-gradient(#2C4257, #2C4257), #2C4257;
        !important;
        }

        .left_col {
            background-color: #2C4257
        }

        .menu_section {
            background-color: #2C4257
        }

        .nav_title {
            background-color: #2C4257
        }

        .ui-jqgrid tr.jqgrow td {
            white-space: normal !important;
            height: auto;
            vertical-align: text-top;
            padding-top: 2px;
        }

        .user-profile {
            width: 350px;
        }

        .navbar-nav .open .dropdown-menu {
            position: absolute;
            background: #fff;
            margin-top: 0;
            border: 1px solid #D9DEE4;
            -webkit-box-shadow: none;
            right: 0;
            left: auto;
            width: 350px;
        }

        .notifit_confirm_bg {
            position: absolute;
            height: 1000px;
            z-index: 9
        }

        .notifit_confirm {
            position: absolute;
            z-index: 10
        }
    </style>
</head>
<body class="nav-md">
<script src="${ctx}/static/jqGrid/js/jquery.min.js"></script>
<%--<script src="${ctx}/static/js/vendors/jquery/dist/jquery.min.js"></script>--%>
<!-- Bootstrap -->
<script src="${ctx}/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>

<script src="${ctx}/static/js/jquery-ui.js"></script>

<!-- We support more than 40 localizations -->
<script src="${ctx}/static/jqGrid/js/i18n/grid.locale-cn.js"></script>
<!-- This is the Javascript file of jqGrid -->
<script src="${ctx}/static/jqGrid/js/jquery.jqGrid.min.js"></script>

<script src="${ctx}/static/js/bootstrap-dialog.min.js"></script>
<script src="${ctx}/static/js/bootstrapValidator.js"></script>
<script src="${ctx}/static/js/notifIt.min.js"></script>
<script src="${ctx}/static/js/utils/CommonTools.js"></script>

<script src="${ctx}/static/js/bootstrap-select.min.js"></script>
<script src="${ctx}/static/js/jquery.form.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${ctx}/static/js/bootstrap-datetimepicker.js"></script>
<script src="${ctx}/static/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/static/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ctx}/static/zTree/js/jquery.ztree.excheck.js"></script>
<!-- Bootstrap fileinput上传插件-->
<link href="${ctx}/static/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
<script src="${ctx}/static/js/fileinput.js" type="text/javascript"></script>
<script src="${ctx}/static/js/zh.js" type="text/javascript"></script>
<script src="${ctx}/static/js/clipboard.min.js" type="text/javascript"></script>
<%--报表Echart--%>
<script src="${ctx}/static/js/echarts.js"></script>
<div class="container body" style="background-color:#2C4257">
    <div class="main_container">
        <%--左侧导航栏--%>
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view" <%--style="background-color:#2C4257"--%>>
                <div class="navbar nav_title" <%--style="border: 0;background-color:#2C4257"--%>>
                    <a href="${ctx}/common/index" class="site_title"><i class="fa fa-paw"></i> <span
                            id="dataNameView" <%--style="background-color:#2C4257"--%>></span></a>
                </div>

                <div class="clearfix"></div>

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section" <%--style="background-color:#2C4257 "--%>>
                        <ul class="nav side-menu">
                            <sec:authorize access="hasAuthority('/data_manager')">
                                <li><a <%--style="background-color:#2C4257 "--%>><i class="fa fa-home"></i>资料管理 <span
                                        class="fa
            fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <sec:authorize access="hasAuthority('/dataManage/marketingMerchantHead')">
                                            <li><a href="${ctx}/dataManage/marketingMerchantHead ">总部资料</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/agentInformationHead')">
                                            <li><a href="${ctx}/dataManage/agentInformationHead">渠道商资料</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/enterpriseInformationHead')">
                                            <li><a href="${ctx}/dataManage/enterpriseInformationHead">企业商户资料</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/baseIndustry')">
                                            <li><a href="${ctx}/dataManage/baseIndustry">行业类别</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/labelManager')">
                                            <li><a href="${ctx}/dataManage/labelManager">标签管理</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/agentNameData')">
                                            <li><a href="${ctx}/dataManage/agentNameData">代理商登录页资料</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/agentInformation')">
                                            <li><a href="${ctx}/dataManage/agentInformation">渠道商资料</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/systemFileManager')">
                                            <li><a href="${ctx}/dataManage/systemFileManager">系统名称资料</a></li>
                                        </sec:authorize>
                                        <sec:authorize
                                                access="hasAuthority('/dataManage/subordinateMerchantsInformation')">
                                            <li>
                                                <a href="${ctx}/dataManage/subordinateMerchantsInformation">渠道商下级企业资料</a>
                                            </li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/dataManage/enterpriseInformation')">
                                            <li><a href="${ctx}/dataManage/enterpriseInformation">企业商户资料</a></li>
                                        </sec:authorize>
                                    </ul>
                                </li>
                            </sec:authorize>

                            <sec:authorize access="hasAuthority('/Membership_management')">
                                <li><a><i class="fa fa-table"></i> 会员管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <sec:authorize access="hasAuthority('/wx/authorizePage')">
                                            <li><a href="${ctx}/wx/authorizePage">公众号授权</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/member_introduction')">
                                            <li class="sub_menu"><a>会员导入<span class="fa fa-chevron-down"></span></a>
                                                <ul class="nav child_menu">
                                                    <sec:authorize access="hasAuthority('/wx/getMemberPage')">
                                                        <li><a href="${ctx}/wx/getMemberPage">微信会员导入</a></li>
                                                    </sec:authorize>
                                                    <sec:authorize access="hasAuthority('/membershipManage/importExcel')">
                                                        <li><a href="${ctx}/membershipManage/importExcel">非微信会员导入</a></li>
                                                    </sec:authorize>
                                                </ul>

                                            </li>
                                        </sec:authorize>


                                            <%--<sec:authorize access="hasAuthority('/member_renewal')">
                                                <li><a href="${ctx}/membershipManage/index82">会员更新 </a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/membershipManage/getMembers')">
                                            <li><a href="${ctx}/membershipManage/getMembers">会员列表 </a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/membershipManage/myMembers')">
                                            <li><a href="${ctx}/membershipManage/myMembers">我的会员 </a></li>
                                        </sec:authorize>
                                    </ul>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('/Marketing_program')">
                                <li><a><i class="fa fa-edit"></i> 营销方案 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <sec:authorize access="hasAuthority('/plan/marketPlan')">
                                            <li><a href="${ctx}/plan/marketPlan">营销方案查看</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/plan/marketPlanHistory')">
                                            <li><a href="${ctx}/plan/marketPlanHistory">历史营销方案</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/plan/marketPlanApply')">
                                            <li><a href="${ctx}/plan/marketPlanApply">营销方案申请</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/plan/marketing_examine')">
                                            <li><a href="${ctx}/plan/marketing_examine">营销方案审核</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/plan/marketPlanAccept')">
                                            <li><a href="${ctx}/plan/marketPlanAccept">异业营销方案接受</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/plan/marketing_execute')">
                                            <li><a href="${ctx}/plan/marketing_execute">营销方案执行</a></li>
                                        </sec:authorize>
                                            <%--<sec:authorize access="hasAuthority('/plan/marketTouchUp')">
                                                <li><a href="${ctx}/plan/marketTouchUp">营销方案触达</a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/plan/marketPlanExecuteStatus')">
                                            <li><a href="${ctx}/plan/marketPlanExecuteStatus">营销方案状态查看</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/plan/marketinglowerlevel')">
                                            <li><a href="${ctx}/plan/marketinglowerlevel">下级企业营销方案</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/materialManage/toMaterialManage')">
                                            <li><a href="${ctx}/materialManage/toMaterialManage">素材管理</a></li>
                                        </sec:authorize>
                                    </ul>
                                </li>
                            </sec:authorize>

                            <sec:authorize access="hasAuthority('/report_management')">
                                <li><a><i class="fa fa-bar-chart-o"></i> 报表管理<span
                                        class="fa fa-chevron-down"></span></a>
                                        <%--总部--%>
                                    <ul class="nav child_menu">
                                        <sec:authorize access="hasAuthority('/report/allMembershipDstribute')">
                                            <li><a href="${ctx}/report/allMembershipDstribute">平台会员数量</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/report/company_numbersReport')">
                                            <li><a href="${ctx}/report/company_numbersReport">企业会员数量报表</a></li>
                                        </sec:authorize>
                                            <%--<sec:authorize access="hasAuthority('/company_numbersAddReport')">
                                                <li><a href="${ctx}/report/index87">会员月增加数量报表</a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/report/notWechatMembershipDstribute')">
                                            <li><a href="${ctx}/report/notWechatMembershipDstribute">企业非微信会员分布</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/report/wechatMembershipDstribute')">
                                            <li><a href="${ctx}/report/wechatMembershipDstribute">企业微信会员分布</a></li>
                                        </sec:authorize>
                                            <%--<sec:authorize access="hasAuthority('/marketing_doingAddReport')">
                                                <li><a href="${ctx}/report/index93">企业执行中方案月统计报表</a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/report/marketing_historydoingAddReport')">
                                            <li><a href="${ctx}/report/marketing_historydoingAddReport">企业历史方案数量统计报表</a>
                                            </li>
                                        </sec:authorize>
                                            <%--<sec:authorize access="hasAuthority('/marketing_monthAddReport')">
                                                <li><a href="${ctx}/report/index89">方案月增加数量统计报表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/marketing_doingEffectReport')">
                                                <li><a href="${ctx}/report/index90">总平台执行效果</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/marketing_commissionReport')">
                                                <li><a href="${ctx}/report/index91">平台分佣月报表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/member_tagsReport')">
                                                <li><a href="${ctx}/report/index92">平台会员标签</a></li>
                                            </sec:authorize>--%>
                                            <%--代理商--%>
                                            <%--<sec:authorize access="hasAuthority('/month_commissionReport')">
                                                <li><a href="${ctx}/report/index94">月分佣报表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/marketing_countMonthReport')">
                                                <li><a href="${ctx}/report/index95">企业营销方案数量月统计表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/marketing_KPIReport')">
                                                <li><a href="${ctx}/report/index96">企业营销方案月执行效果KPI显示表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/company_memberCountReport')">
                                                <li><a href="${ctx}/report/index97">企业会员数量统计表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/company_tagsCountReport')">
                                                <li><a href="${ctx}/report/index98">企业会员标签大类统计表</a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/JD/JDAgentOrderList')">
                                            <li><a href="${ctx}/JD/JDAgentOrderList">京东券月分佣月报表</a></li>
                                        </sec:authorize>
                                            <%--企业--%>
                                            <%--<sec:authorize access="hasAuthority('/company_memberNumsCountReport')">
                                                <li><a href="${ctx}/report/index99">企业会员数量统计</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/company_memberNewsAddReport')">
                                                <li><a href="${ctx}/report/index100">企业会员新增月报表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/marketing_ExecuteReport')">
                                                <li><a href="${ctx}/report/index101">营销方案执行效果</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/marketing_countNumsReport')">
                                                <li><a href="${ctx}/report/index102">营销方案月统计数量</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/commission_MonthReport')">
                                                <li><a href="${ctx}/report/index103">业绩月报表</a></li>
                                            </sec:authorize>
                                            <sec:authorize access="hasAuthority('/people_classifyReport')">
                                                <li><a href="${ctx}/report/index104">人群归类统计</a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/JD/JDCompanyOrderList')">
                                            <li><a href="${ctx}/JD/JDCompanyOrderList">京东券月分佣月报表</a></li>
                                        </sec:authorize>
                                    </ul>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('/Privilege_management')">
                                <li><a><i class="fa fa-desktop"></i> 权限管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <sec:authorize access="hasAuthority('/auth/role_management')">
                                            <li><a href="${ctx}/auth/role_management">角色管理</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/auth/account_management')">
                                            <li><a href="${ctx}/auth/account_management">账号管理</a></li>
                                        </sec:authorize>

                                        <sec:authorize access="hasAuthority('/auth/agent_Account_Management')">
                                            <li><a href="${ctx}/auth/agent_Account_Management">渠道商账号管理</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/auth/super_Account_Management')">
                                            <li><a href="${ctx}/auth/super_Account_Management">企业商户账号管理</a></li>
                                        </sec:authorize>

                                    </ul>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('/SMSManagement')">
                                <li><a><i class="fa fa-sticky-note-o"></i> 模板管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                            <%--<sec:authorize access="hasAuthority('/shortMessage/application_creation')">
                                                <li><a href="${ctx}/shortMessage/application_creation">应用创建</a></li>
                                            </sec:authorize>--%>
                                        <sec:authorize access="hasAuthority('/shortMessage/signature_creation')">
                                            <li><a href="${ctx}/shortMessage/signature_creation">短信签名创建</a></li>
                                        </sec:authorize>

                                        <sec:authorize access="hasAuthority('/shortMessage/template_creation')">
                                            <li><a href="${ctx}/shortMessage/template_creation">短信模板创建</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/shortMessage/phrase_task_creation')">
                                            <li><a href="${ctx}/shortMessage/phrase_task_creation">短信任务查询</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/shortMessage/wxTemplateManager')">
                                            <li><a href="${ctx}/shortMessage/wxTemplateManager">微信模板管理</a></li>
                                        </sec:authorize>

                                    </ul>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="hasAuthority('/otherTarget')">
                                <li><a><i class="fa fa-google-plus-circle"></i>我们的服务<span
                                        class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <sec:authorize access="hasAuthority('/problem/problemManager')">
                                            <li><a href="${ctx}/problem/problemManager">常见问题管理</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/problem/problemAnswer')">
                                            <li><a href="${ctx}/problem/problemAnswer">常见问题解答</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/JD/JDgoodsList')">
                                            <li><a href="${ctx}/JD/JDgoodsList">京东商品</a></li>
                                        </sec:authorize>
                                        <sec:authorize access="hasAuthority('/JD/JDgoodsList')">
                                            <li><a href="${ctx}/JD/order">订单明细</a></li>
                                        </sec:authorize>
                                    </ul>
                                </li>
                            </sec:authorize>
                            <%--<li><a><i class="fa fa-bar-chart-o"></i> 公众号操作<span class="fa fa-chevron-down"></span></a>--%>
                            <%--<ul class="nav child_menu">--%>

                            <%--<li><a href="${ctx}/wx/authorizePage">公众号授权</a></li>--%>
                            <%--<li><a href="${ctx}/wx/getMemberPage">公众号会员导入</a></li>--%>
                            <%--<li><a href="${ctx}/wx/sendMesagePage">群发消息</a></li>--%>

                            <%--</ul>--%>
                            <%--</li>--%>


                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small" style="background-color: #2C4257">
                    <a data-toggle="tooltip" data-placement="top" title="Settings" style="background-color: #2C4257">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen" style="background-color: #2C4257">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock" style="background-color: #2C4257">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="${ctx}/logout" style="background-color:
        #2C4257">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <%--头部--%>
        <!-- top navigation -->
        <div class="top_nav" id="myTopNav" oncontextmenu=self.event.returnValue=false>
            <div class="nav_menu" style="background-color:#2C4257">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <i style="color: white">当前用户：<label id="myName"></label></i>&nbsp;&nbsp;&nbsp;&nbsp;
                                <img style="background-color: black;margin-right: 0px"
                                     src="${ctx}/static/images/setting.png"/>
                                <%--设置--%>
                                <%--<span class=" fa fa-angle-down"></span>--%>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right" style="background-color: white">

                                <li><a href="${ctx}/logout" style="background-color: white"><i
                                        class="fa fa-sign-out pull-right"></i> 退出</a></li>
                                <li><a href="#" id="updatePassword" style="background-color: white"><i
                                        class="glyphicon glyphicon-edit pull-right"></i>
                                    修改密码</a></li>
                                <li><a href="#" id="updateEmail" style="background-color: white"><i
                                        class="glyphicon glyphicon-edit pull-right"></i>
                                    用户邮箱管理</a></li>
                            </ul>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->
        <sitemesh:write property='body'/>


        <!-- footer content -->
        <footer>
            <div id="showFoot" style="text-align:center;">
                2019 &copy;上海陆尔信息科技有限公司
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->

    </div>
</div>
<!-- jQuery -->
<%--<script src="${ctx}/static/vendors/jquery/dist/jquery.min.js"></script>--%>
<!-- FastClick -->
<script src="${ctx}/static/vendors/fastclick/lib/fastclick.js"></script>

<!-- Custom Theme Scripts -->
<script src="${ctx}/static/vendors/build/js/custom.min.js"></script>

<script>
    $.jgrid.defaults.width = 1203;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var url = '';
    var id = '';
    function getCode(type, message) {

        if (type == 'add') {
            notif({
                msg: message,
                timeout: 2000,
                position: "center",
                type: "success"
            });
        }
        if (type == 'update') {
            notif({
                msg: message,
                position: "center",
                bgcolor: "#2fff5f",
                timeout: 2000,
                color: "#f19c65"

            });
        }
        if (type == 'delete') {
            notif({
                'type': 'success',
                'msg': message,
                timeout: 2000,
                'position': 'center'
            })
        }
        if (type == 'check') {
            notif({
                type: "warning",
                msg: message,
                position: "center",
                timeout: 2000,
                opacity: 0.8
            });
        }


    }

    function myConfirm(url1, id1) {
        url = url1;
        id = id1;
        notif_confirm({
            'message': '确认删除?',
            'textaccept': '确认!',
            'textcancel': '取消',
            'fullscreen': true,
            'callback': myCallback
        });


    }


    var myCallback = function (choice) {
        console.log('choice', choice);
        console.log('url', url);
        /* var id = $("#jqGrid").jqGrid("getGridParam", "selrow");*/
        console.log('id', id);
        if (choice) {

            var json = {
                'id': id
            }
            $.post(url, json).done(function (data) {
                notif({
                    'type': 'success',
                    'msg': '删除成功!',
                    'timeout': 1000,
                    'position': 'center'
                })

                getCode('delete', '删除成功');
                $('#jqGrid').trigger('reloadGrid');
            }).fail(function (data) {
                notif({
                    'type': 'success',
                    'msg': '删除失败!',
                    'timeout': 1000,
                    'position': 'center'
                })

            });

        } else {
            notif({
                'type': 'error',
                'msg': '取消成功！',
                'timeout': 1000,
                'position': 'center'
            })

        }
    }

    /*获取数据联盟名称*/
    $.ajax({
        url: "${ctx}/marketingMerchant/getMerchantById",
        dataType: "json",
        type: 'POST',
        cache: false,
        success: function (data) {
            if (data.merchantType == "3") {
                var v = "网陆数据联盟";
            } else {
                var v = data.name;
            }


            $("#dataNameView").html(v);

        },
        error: function (status, e) {
            alert("系统错误:" + e);
        }
    });
    $("#menu_toggle").click(function () {

        setTimeout(function () {
            console.log($("#x_panel").width() * 0.98);
            $("#jqGrid").setGridWidth($(".x_panel").width() * 0.99);
        }, 100);


    });
    $("#updatePassword").click(function () {
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPEer_DEFAULT,
            title: "<span style=\"color: #ab8ce4\">修改密码</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/privilegeManage/updatePassword.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            onshown: function () {
                $.ajax({
                    url: '${ctx}/getname',
                    async: false,
                    method: 'post',
                    success: function (data) {
                        $('#name').val(data.data);
                    }
                })
            },
            buttons: [{
                id: 'btn-form-submit',
                label: '提交',
                icon: 'fa fa-check-circle',
                cssClass: 'btn-primary',
                action: function (dialogItself) { //点击事件
                    var flag = $("#flag").val();
                    var json = {
                        'name': $.trim($("#myform").find("#name").val()),
                        'password': $.trim($("#myform").find("#password").val())
                    };
                    $("#myform").bootstrapValidator({
                        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                        message: '通用的验证失败消息',//好像从来没出现过
                        feedbackIcons: {//根据验证结果显示的各种图标
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            oldPassword: {
                                validators: {
                                    notEmpty: {
                                        message: '*密码不能为空'
                                    },
                                    threshold: 2,//有2字符以上才发送ajax请求
                                    remote: {//ajax验证。server result:{"valid",true or false}
                                        url: "${ctx}/checkOldPassword",
                                        message: '密码输入错误',
                                        delay: 1000,//ajax刷新的时间是1秒一次
                                        type: 'POST',
                                        //自定义提交数据，默认值提交当前input value
                                        data: function (validator) {
                                            return {
                                                name: $.trim($("#myform").find("#name").val()),
                                                password: $.trim($("#myform").find("#oldPassword").val())
                                            };
                                        }
                                    }
                                }
                            },
                            password: {
                                validators: {
                                    notEmpty: {
                                        message: '*新密码不能为空'
                                    }
                                }
                            },
                            repassword: {
                                validators: {
                                    notEmpty: {
                                        message: '*确认密码不能为空'
                                    },
                                    identical: {
                                        field: 'password',
                                        message: '*两次输入密码不一致'
                                    }
                                }
                            }
                        }
                    });
                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                    bootstrapValidator.validate();
                    setTimeout(function () {
                        if (bootstrapValidator.isValid() === true) {
                            $.ajax({
                                url: "${ctx}/updateSysUserPassword",
                                data: json,
                                dataType: "json",
                                cache: false,
                                success: function (response) {
                                    dialogItself.close();
                                    getCode('update', '修改成功！');
                                },
                                error: function () {
                                    getCode('check', '系统错误！');
                                }
                            });
                        }
                    }, 300);

                }
            }, {
                label: '关闭',
                icon: 'fa fa-close',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }]
        });
    })
    $("#updateEmail").click(function () {
        var dialog = BootstrapDialog.show({
            type: BootstrapDialog.TYPEer_DEFAULT,
            title: "<span style=\"color: #ab8ce4\">修改邮箱信息</span>",
            closable: false,
            draggable: true,
            cssClass: 'login-dialog',
            message: $('<div></div>').load('${ctx}/template/privilegeManage/updateEmail.jsp'),//加载弹出页面
            size: BootstrapDialog.SIZE_WIDE,//弹出框大小。
            onshown: function () {
                $.ajax({
                    url: '${ctx}/getSysUserByName',
                    async: false,
                    method: 'post',
                    success: function (data) {
                        $('#name').val(data.name);
                        $('#oldEmail').val(data.email);
                    }
                })
            },
            buttons: [{
                id: 'btn-form-submit',
                label: '提交',
                icon: 'fa fa-check-circle',
                cssClass: 'btn-primary',
                action: function (dialogItself) { //点击事件
                    var flag = $("#flag").val();
                    var json = {
                        'name': $.trim($("#myform").find("#name").val()),
                        'email': $.trim($("#myform").find("#email").val())
                    };
                    $("#myform").bootstrapValidator({
                        live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                        message: '通用的验证失败消息',//好像从来没出现过
                        feedbackIcons: {//根据验证结果显示的各种图标
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            oldPassword: {
                                validators: {
                                    notEmpty: {
                                        message: '*密码不能为空'
                                    },
                                }
                            },
                            email: {
                                validators: {
                                    notEmpty: {
                                        message: '*邮箱不能为空'
                                    },
                                    emailAddress: {
                                        message: '邮箱地址格式有误'
                                    }
                                }
                            }
                        }
                    });
                    var bootstrapValidator = $("#myform").data('bootstrapValidator');
                    bootstrapValidator.validate();
                    if (bootstrapValidator.isValid()) {
                        $.ajax({
                            url: "${ctx}/updateSysUserEmail",
                            data: json,
                            dataType: "json",
                            cache: false,
                            success: function (response) {
                                dialogItself.close();
                                getCode('update', '修改成功！');
                            },
                            error: function () {
                                getCode('check', '系统错误！');
                            }
                        });
                    }

                }
            }, {
                label: '关闭',
                icon: 'fa fa-close',
                action: function (dialogItself) {
                    dialogItself.close();
                }
            }]
        });
    })
    $.ajax({
        url: '${ctx}/getname',
        async: false,
        method: 'post',
        success: function (data) {
            document.getElementById("myName").innerHTML = data.data;

        }
    })
</script>
<style>
    div.container {
        margin: 0px !important;
        padding: 0px !important;
        width: 100% !important;
    }
</style>
</body>
</html>



