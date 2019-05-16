package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.MarketingPlanRecommend;
import com.luer.marketingSchemeManage.bean.MarketingPlanRecommendExample;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@MapperScan
@Component
public interface MarketingPlanRecommendMapper {
    int countByExample(MarketingPlanRecommendExample example);

    int deleteByExample(MarketingPlanRecommendExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingPlanRecommend record);

    int insertSelective(MarketingPlanRecommend record);

    List<MarketingPlanRecommend> selectByExample(MarketingPlanRecommendExample example);

    MarketingPlanRecommend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingPlanRecommend record, @Param("example") MarketingPlanRecommendExample example);

    int updateByExample(@Param("record") MarketingPlanRecommend record, @Param("example") MarketingPlanRecommendExample example);

    int updateByPrimaryKeySelective(MarketingPlanRecommend record);

    int updateByPrimaryKey(MarketingPlanRecommend record);

    //批次推荐营销计划
    int insertBatch(List<MarketingPlanRecommend> list);

    //接受或拒绝异业的营销计划
    int accptPlan(MarketingPlanRecommend marketingPlanRecommend);

    //根据方案id查询
    List<MarketingPlanRecommend> selectByPlanId(String planId);
}