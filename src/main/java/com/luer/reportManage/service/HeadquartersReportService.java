package com.luer.reportManage.service;

import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.membershipManage.bean.MarketingMember;
import com.luer.reportManage.bean.MarketingPlanReport;
import com.luer.reportManage.bean.ReportForm;
import com.luer.wx.bean.MarketingMerchantWx;

import java.util.List;
import java.util.Map;

/**
 * Created by 87961 on 2019/4/15.
 */
public interface HeadquartersReportService {
    List<MarketingMerchantWx> getCompanyWXFans();

    List<MarketingMerchant> getCompanyMembersCount();

    ReportForm getAllMembershipDistribute();

    List<ReportForm> getCompanyMembersTotal();

    List<MarketingPlanReport> getCompanyHistoryPlans();

    Map getCompanyMembersAddByMonth(String addtime);
}
