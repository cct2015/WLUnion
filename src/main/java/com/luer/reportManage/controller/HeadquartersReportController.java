package com.luer.reportManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.membershipManage.bean.MarketingMember;
import com.luer.reportManage.bean.MarketingPlanReport;
import com.luer.reportManage.bean.ReportForm;
import com.luer.reportManage.service.HeadquartersReportService;
import com.luer.wx.bean.MarketingMerchantWx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 87961 on 2019/4/15.
 */
@Controller
@RequestMapping("/headquartersReport")
public class HeadquartersReportController {

    @Autowired
    private HeadquartersReportService headquartersReportService;
//获取各个企业微信公众号粉丝及会员数量
    @ResponseBody
    @RequestMapping("/getCompanyWXFans")
    public JqgridResponse<MarketingMerchantWx> getCompanyWXFans(JqgridFilter filter) {
        filter.refresh();
        List<MarketingMerchantWx> marketingMerchantWxList = headquartersReportService.getCompanyWXFans();
        return JqgridResponseContext.getJqgridResponse(filter, marketingMerchantWxList);
    }
    //获取各个企业非微信公众号会员数量
    @ResponseBody
    @RequestMapping("/getCompanyMembersCount")
    public JqgridResponse<MarketingMerchant> getCompanyMembersCount(JqgridFilter filter) {
        filter.refresh();
        List<MarketingMerchant> marketingMembersCount = headquartersReportService.getCompanyMembersCount();
        return JqgridResponseContext.getJqgridResponse(filter, marketingMembersCount);
    }
    //平台会员数量
    @ResponseBody
    @RequestMapping("/getAllMembershipDistribute")
    public ReportForm getAllMembershipDistribute(){
        ReportForm reportForm=headquartersReportService.getAllMembershipDistribute();
        return reportForm;
    }
    //企业会员数量报表
    @ResponseBody
    @RequestMapping("/getCompanyMembersTotal")
    public JqgridResponse<ReportForm> getCompanyMembersTotal(JqgridFilter filter) {
        filter.refresh();
        List<ReportForm> reportForms = headquartersReportService.getCompanyMembersTotal();
        return JqgridResponseContext.getJqgridResponse(filter, reportForms);
    }
    //会员月增加数量报表
    @ResponseBody
    @RequestMapping("/getCompanyMembersAddByMonth")
    public Map getCompanyMembersAddByMonth(String addtime) {

        Map  map = headquartersReportService.getCompanyMembersAddByMonth(addtime);
        return map;
    }
    //企业历史营销方案数量报表
    @ResponseBody
    @RequestMapping("/getCompanyHistoryPlans")
    public JqgridResponse<MarketingPlanReport> getCompanyHistoryPlans(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlanReport> marketingPlanReports = headquartersReportService.getCompanyHistoryPlans();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanReports);
    }
}
