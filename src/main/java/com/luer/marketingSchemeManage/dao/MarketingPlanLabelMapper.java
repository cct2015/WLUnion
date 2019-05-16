package com.luer.marketingSchemeManage.dao;

import com.luer.dataManage.bean.BaseLabel;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabel;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabelExample;
import java.util.List;

import com.luer.marketingSchemeManage.bean.SelPlanLabels;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MarketingPlanLabelMapper {
    int countByExample(MarketingPlanLabelExample example);

    int deleteByExample(MarketingPlanLabelExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingPlanLabel record);

    int insertSelective(MarketingPlanLabel record);

    List<MarketingPlanLabel> selectByExample(MarketingPlanLabelExample example);

    MarketingPlanLabel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingPlanLabel record, @Param("example") MarketingPlanLabelExample example);

    int updateByExample(@Param("record") MarketingPlanLabel record, @Param("example") MarketingPlanLabelExample example);

    int updateByPrimaryKeySelective(MarketingPlanLabel record);

    int updateByPrimaryKey(MarketingPlanLabel record);
    //批量插入营销计划标签
    int insertBatch(List<MarketingPlanLabel> list);

    //获得某个营销计划的详细标签
    List<SelPlanLabels> getSelLabels(@Param("planId") String planId);

    //删除某个营销计划的所有标签
   int deletePlanLabels(@Param("planId") String planId);

}