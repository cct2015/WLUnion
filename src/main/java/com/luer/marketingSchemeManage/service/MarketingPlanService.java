package com.luer.marketingSchemeManage.service;

import com.luer.marketingSchemeManage.bean.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by 87961 on 2018/12/18.
 */
public interface MarketingPlanService {

    String getMerchantId();

    String getUserName();

    List<MarketingPlan> getMarketingPlan();

    String addMarketingPlan(MarketingPlan marketingPlan);

    String updateMarketingPlan(MarketingPlan marketingPlan);

    //根据代理商id查询被代理的商户id列表
    List<String> selectMerchantByParentId(String id);

    //总部功能HQ
    //营销方案查看
    List<MarketingPlan> getMarketingPlanInHQByPlanStatus(String status);

    //查看历史营销方案
    List<MarketingPlan> getHistroyMarketingPlanInHQ(String planStatus);

    //代理商功能 Agent
    //下级企业营销方案查看(parentId 代理商商户id)
    List<MarketingPlan> getMarketingPlanInAgentByPlanStatus(String planStatus);

    //企业功能 Enterprise
    //查看营销方案 merchantId 商户merchantId
    List<MarketingPlan> getMarketingPlanInEnterprise(int status);

    MarketingPlan getMarketingPlanInEnterpriseById(String id);

    int addMarketingPlanInEnterprise(MarketingPlan marketingPlan);

    int deleteMarketingPlanInEnterprise(String id);

    int updateMarketingPlanInEnterprise(MarketingPlan marketingPlan);

    int couponMarketingPlanInEnterprise(String id, String arrayStr,String couponUrl,String couponsSource,  int isDifferent);

    //以下是对方案表，和方案标签关系表共同操作的增删改方法
    int addMarketingPlanDotInEnterprise(String marketingPlanStr, String marketingPlanLabelStr);

    int deleteMarketingPlanDotInEnterprise(String id);
    //int updateMarketingPlanDotInEnterprise(String marketingPlanStr,String marketingPlanLabelStr);

    //营销方案接受
    List<MarketingPlan> getCanAcceptMarketingPlanInEnterprise();

    //营销方案执行
    List<MarketingPlan> getExecutingMarketingPlanInEnterprise();

    //营销方案审核
    List<MarketingPlan> getCheckMarketingPlanInEnterprise();

    List<VPlanRecommend> getOtherMarketingPlan(int status);

    //接受或拒绝异业的营销方案
    int acceptMarketingPlanInEnterprise(MarketingPlanRecommend marketingPlanRecommend);

    List<MarketingPlan> getMarketingPlanExamine();

    int examineMarketingPlan(MarketingPlan marketingPlan);

    List<MarketingPlanPacking> getExecuteMarketingPlanPacking();

    List<MarketingPlan> getSelfExecuteMarketingPlanPacking();


    //获得要执行的营销方案列表,分页，包括异业推荐已经接受的和自己的
    List<VValueabledPlans> getExecutePlanList();

    //获得要触达的营销方案列表
    List<VValueabledPlans> getTouchPlanList();

    List<MarketingPlan> getMarketingPlanlower();

    void addMarketingPlanByJD(String merchants, String good) throws IOException;
}
