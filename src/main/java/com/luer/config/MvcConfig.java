package com.luer.config;

import com.luer.comm.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private FileUtil fileUtil;
    //加入cors跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true).maxAge(3600);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //templates:html页面文件
        /*registry.addViewController("/login").setViewName("templates/login");*/
        //jsp:jsp页面文件
        registry.addViewController("/login").setViewName("jsp/login");
        /*邮箱改密码*/
        registry.addViewController("/sendEmail").setViewName("jsp/privilegeManage/sendEmail");
        registry.addViewController("/login").setViewName("jsp/login");
        registry.addViewController("/index").setViewName("jsp/index");
        registry.addViewController("/common/index").setViewName("jsp/index");
        registry.addViewController("/membershipManage/index82").setViewName("jsp/notsuccesspage");
        registry.addViewController("/membershipManage/index84").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index87").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index89").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index90").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index91").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index92").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index93").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index94").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index95").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index96").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index97").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index98").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index99").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index100").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index101").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index102").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index103").setViewName("jsp/notsuccesspage");
        registry.addViewController("/report/index104").setViewName("jsp/notsuccesspage");
        /**
         * 营销方案
         */
        //营销方案查看
        registry.addViewController("/plan/marketPlan").setViewName("jsp/marketingSchemeManage/marketingplan");
        //历史营销方案查看
        registry.addViewController("/plan/marketPlanHistory").setViewName("jsp/marketingSchemeManage/marketPlanHistory");
        //营销方案申请
        registry.addViewController("/plan/marketPlanApply").setViewName("jsp/marketingSchemeManage/marketingplanApply");
        //营销方案审核
        registry.addViewController("/plan/marketing_examine").setViewName("jsp/marketingSchemeManage/marketingplanExamine");
        //营销方案接受
        registry.addViewController("/plan/marketPlanAccept").setViewName("jsp/marketingSchemeManage/marketPlanAccept");
        //营销方案执行状态
        registry.addViewController("/plan/marketPlanExecuteStatus").setViewName("jsp/marketingSchemeManage/marketPlanExecuteStatus");
        //营销方案执行
        registry.addViewController("/plan/marketing_execute").setViewName("jsp/marketingSchemeManage/marketExecute");
        //营销方案触达
        registry.addViewController("/plan/marketTouchUp").setViewName("jsp/marketingSchemeManage/marketTouchUp");
        //下级企业营销方案
        registry.addViewController("/plan/marketinglowerlevel").setViewName("jsp/marketingSchemeManage/marketingplanlowerlevel");
        //行业
        /*registry.addViewController("/dataManage/baseIndustry").setViewName("jsp/dataManage/baseIndustry");*/

        registry.addViewController("/dataManage/baseIndustry").setViewName("jsp/dataManage/test_privilege");


        //总部
        /*registry.addViewController("/dataManage/marketingMerchantHead").setViewName("jsp/dataManage/marketingMerchantHead");*/
        //代理商商户资料（总部旗下）
        registry.addViewController("/dataManage/agentInformationHead").setViewName("jsp/dataManage/agentInformationHead");
        registry.addViewController("/dataManage/view").setViewName("jsp/dataManage/viewSubordinate");
        //企业商户资料（总部旗下）
        registry.addViewController("/dataManage/enterpriseInformationHead").setViewName("jsp/dataManage/enterpriseInformationHead");
        //代理商商户资料（自己）
        registry.addViewController("/dataManage/agentInformation").setViewName("jsp/dataManage/agentInformation");
        //系统名称资料
        registry.addViewController("/dataManage/systemFileManager").setViewName("jsp/dataManage/systemFileManager");
        //代理商登录页资料
        registry.addViewController("/dataManage/agentNameData").setViewName("jsp/dataManage/agentNameData");

        //企业商户资料（自己）
        registry.addViewController("/dataManage/enterpriseInformation").setViewName("jsp/dataManage/enterpriseInformation");
        //下级商户
        registry.addViewController("/dataManage/subordinateMerchantsInformation").setViewName("jsp/dataManage/subordinateMerchantsInformation");
        //商户
        registry.addViewController("/dataManage/marketingMerchant").setViewName("jsp/dataManage/marketingMerchant");
        //新建加盟
        registry.addViewController("/dataManage/marketingMerchantHead").setViewName("jsp/dataManage/newFranchise");

        /*标签管理*/
        /*网易*/
        registry.addViewController("/dataManage/labelManager").setViewName("jsp/dataManage/labelManager");
        /*自定义*/
        registry.addViewController("/dataManage/custom").setViewName("jsp/dataManage/customLabelManager");
        /**
         * 会员管理
         */
        //会员更新
        registry.addViewController("/membershipManage/memberUpdate").setViewName("jsp/membershipManage/memberUpdate");
        //会员资料
        registry.addViewController("/membershipManage/getMembers").setViewName("jsp/membershipManage/marketingMember");
        //我的会员
        registry.addViewController("/membershipManage/myMembers").setViewName("jsp/membershipManage/myMembers");
        //会员导入
        registry.addViewController("/membershipManage/memberLoad").setViewName("jsp/membershipManage/memberLoad");
        //Excel导入会员
        registry.addViewController("/membershipManage/importExcel").setViewName("jsp/membershipManage/upload");
        /**
         * 权限管理
         */
        //账户管理
        registry.addViewController("/auth/account_management").setViewName("jsp/privilegeManage/account_management");
        //角色管理
        registry.addViewController("/auth/role_management").setViewName("jsp/privilegeManage/role_management");
        //企业账号管理
        registry.addViewController("/auth/super_Account_Management").setViewName("jsp/privilegeManage/super_Account_Management");
        //渠道商账号管理
        registry.addViewController("/auth/agent_Account_Management").setViewName("jsp/privilegeManage/agent_Account_Management");

        //账号权限
        registry.addViewController("/auth/account_permissions").setViewName("jsp/privilegeManage/account_privilege");
        /*报表管理*/
        //总部报表
        registry.addViewController("/report/notWechatMembershipDstribute").setViewName("jsp/reportManage/notWechatMembershipDstribute");
        registry.addViewController("/report/wechatMembershipDstribute").setViewName("jsp/reportManage/wechatMembershipDstribute");
        registry.addViewController("/report/allMembershipDstribute").setViewName("jsp/reportManage/allMembershipDstribute");
        registry.addViewController("/report/company_numbersReport").setViewName("jsp/reportManage/totalMembershipDstribute");
        registry.addViewController("/report/marketing_historydoingAddReport").setViewName("jsp/reportManage/marketingPlanHistoryDoingReport");

        //渠道商报表
        registry.addViewController("/JD/JDAgentOrderList").setViewName("jsp/JD/JDAgentOrderList");
        //门店报表
        registry.addViewController("/JD/JDCompanyOrderList").setViewName("jsp/JD/JDCompanyOrderList");


        /**
         *
         * 短信管理
         * */
        //应用创建
        registry.addViewController("/shortMessage/application_creation").setViewName("jsp/shortMessage/application_creation");
        //签名创建
        registry.addViewController("/shortMessage/signature_creation").setViewName("jsp/shortMessage/signature_creation");
        //模板创
        registry.addViewController("/shortMessage/template_creation").setViewName("jsp/shortMessage/template_creation");
        //短信任务创建
        registry.addViewController("/shortMessage/phrase_task_creation").setViewName("jsp/shortMessage/phrase_task_creation");


        //微信
        registry.addViewController("/wx/authorizePage").setViewName("templates/wx/authorize");
        registry.addViewController("/wx/getMemberPage").setViewName("templates/wx/getMember");
        registry.addViewController("/wx/queryMemberPage").setViewName("templates/wx/queryMember");
       // registry.addViewController("/wx/sendMesagePage").setViewName("templates/wx/sendMesage");

        //素材管理
      //  registry.addViewController("/materialManage/").setViewName("templates/materialManage/MpNewsMaterialManage");

        //常见问题
        registry.addViewController("/problem/problemManager").setViewName("templates/sys/QAManage");
        registry.addViewController("/problem/problemAnswer").setViewName("templates/sys/questionList");
        registry.addViewController("/test/testPage").setViewName("templates/myTest/test");
        registry.addViewController("/test/merchantChoose").setViewName("/template/JD/merchantChoose.jsp");
        registry.addViewController("/showQuestion/look").setViewName("templates/sys/UpdateQAInfo");


        //微信模块

        registry.addViewController("/shortMessage/wxTemplateManager").setViewName("templates/wxTemplatesManage/WXManage");
        registry.addViewController("/showQuestion/wxInfo").setViewName("templates/wxTemplatesManage/WXInfo");





        //京东的
        registry.addViewController("/JD/JDgoodsList").setViewName("jsp/JD/JDgoodsList");
        //订单明细
        registry.addViewController("/JD/order").setViewName("jsp/JD/OrderResult");


        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        /** 文件路径 */
        registry.addResourceHandler("/profile/**").addResourceLocations("file:" + fileUtil.getDefaultBaseDir());


    }

}
