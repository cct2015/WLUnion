package com.luer.reportManage.service.Impl;

import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.marketingSchemeManage.dao.MarketingPlanMapper;
import com.luer.membershipManage.bean.MarketingMember;
import com.luer.membershipManage.dao.MarketingMemberMapper;
import com.luer.reportManage.bean.MarketingPlanReport;
import com.luer.reportManage.bean.ReportForm;
import com.luer.reportManage.service.HeadquartersReportService;
import com.luer.wx.bean.MarketingMerchantWx;
import com.luer.wx.dao.MarketingMerchantWxMapper;
import com.luer.wx.service.impl.wxservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by 87961 on 2019/4/15.
 */
@Service
@Transactional
public class HeadquartersReportServiceImpl implements HeadquartersReportService {

    @Autowired
    private MarketingMerchantWxMapper marketingMerchantWxMapper;
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private MarketingMemberMapper marketingMemberMapper;
    @Autowired
    private MarketingPlanMapper marketingPlanMapper;

    @Autowired
    private wxservice weChatService;

    //企业公众号粉丝数量
    @Override
    public List<MarketingMerchantWx> getCompanyWXFans() {
        List<MarketingMerchantWx> marketingMerchantWxList=new ArrayList<>();
        List<MarketingMerchant> marketingMerchants=marketingMerchantMapper.selectByType();
        for(MarketingMerchant marketingMerchant:marketingMerchants){
            List<MarketingMerchantWx> marketingMerchantWxes=new ArrayList<>();
            marketingMerchantWxes=marketingMerchantWxMapper.getMerchantWX(marketingMerchant.getId());
            for (MarketingMerchantWx marketingMerchantWx:marketingMerchantWxes){
                marketingMerchantWx.setParentMerchantName(marketingMerchant.getParentName());
                marketingMerchantWx.setAppName(weChatService.GetUserAccessInfo(marketingMerchantWx.getAppId()).getNickName());
                marketingMerchantWx.setMerchantName(marketingMerchant.getCompanyName());
                marketingMerchantWx.setAppFans(weChatService.QueryFanSum(marketingMerchantWx.getAppId()));
                //暂时没有接口
                marketingMerchantWx.setAppMemberFans("");
                marketingMerchantWxList.add(marketingMerchantWx);
            }

        }

        return marketingMerchantWxList;
    }

    @Override
    public List<MarketingMerchant> getCompanyMembersCount() {
        List<MarketingMerchant> marketingMerchants=marketingMerchantMapper.selectByType();
        return marketingMerchants;
    }

    @Override
    public ReportForm getAllMembershipDistribute() {
        ReportForm reportForm=marketingMemberMapper.getAllMembershipDistribute();
        reportForm.setOtherMembers(reportForm.getOtherMembers()-reportForm.getWxMembers());
        return reportForm;
    }

    @Override
    public List<ReportForm> getCompanyMembersTotal() {
        List<ReportForm> reportForms=marketingMemberMapper.getCompanyMembersTotal();
        for(ReportForm reportForm:reportForms){
            if(null==reportForm.getWxMembers()){
                reportForm.setWxMembers(0);
            }
            reportForm.setOtherMembers(reportForm.getTotalMembers()-reportForm.getWxMembers());
        }
        return reportForms;
    }

    @Override
    public List<MarketingPlanReport> getCompanyHistoryPlans() {
        return marketingPlanMapper.getCompanyHistoryPlans();
    }

    @Override
    public Map getCompanyMembersAddByMonth(String addtime) {
        Map s= changeMonth(marketingMemberMapper.getCompanyMembersAddByMonth(addtime));
        return s;
    }
    public Map changeMonth(List<ReportForm> list) {
        Map<String, List> s = new HashMap<>();
        List<String> names = Arrays.asList("", "", "", "", "", "");
        List<String> counts = Arrays.asList("", "", "", "", "", "");
        int a = 0;
        for (ReportForm reportForm : list) {

            if (reportForm != null) {
                names.set(a, reportForm.getName());
                counts.set(a, reportForm.getTotalMembers().toString());
            }
            a++;
        }
        s.put("names", names);
        s.put("counts", counts);
        return s;
    }
}
