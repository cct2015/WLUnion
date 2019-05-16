package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.MarketingPlan;
import com.luer.marketingSchemeManage.bean.MarketingPlanExample;

import java.util.List;

import com.luer.marketingSchemeManage.bean.VValueabledPlansExample;
import com.luer.reportManage.bean.MarketingPlanReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MarketingPlanMapper {
    int countByExample(MarketingPlanExample example);

    int deleteByExample(MarketingPlanExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingPlan record);

    int insertSelective(MarketingPlan record);

    List<MarketingPlan> selectByExample(MarketingPlanExample example);

    MarketingPlan selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingPlan record, @Param("example") MarketingPlanExample example);

    int updateByExample(@Param("record") MarketingPlan record, @Param("example") MarketingPlanExample example);

    int updateByPrimaryKeySelective(MarketingPlan record);

    int updateByPrimaryKey(MarketingPlan record);

    List<MarketingPlan> getMarketingPlanList(@Param("merchant_id") String merchantId);

    List<MarketingPlan> getMarketingPlanExamine(@Param("merchant_id") String merchantId);


    List<MarketingPlan> getMarketingPlanlower(List<String> merchantids);

    int couponMarketingPlan(@Param("couponUrl") String couponUrl, @Param("couponsSource") String couponsSource, @Param("id") String id);

    //根据状态查询所有营销方案
    List<MarketingPlan> selectByStatus(String status);

    //查询所有营销方案
    List<MarketingPlan> selectAll();

    //根据id修改方案状态
    void updatePlanStatusById(@Param("id") String id, @Param("planStatus") Integer planStatus);

    List<MarketingPlanReport> getCompanyHistoryPlans();
}