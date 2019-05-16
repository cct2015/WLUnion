package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.MarketingPlanHistory;
import com.luer.marketingSchemeManage.bean.MarketingPlanHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketingPlanHistoryMapper {
    int countByExample(MarketingPlanHistoryExample example);

    int deleteByExample(MarketingPlanHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingPlanHistory record);

    int insertSelective(MarketingPlanHistory record);

    List<MarketingPlanHistory> selectByExample(MarketingPlanHistoryExample example);

    MarketingPlanHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingPlanHistory record, @Param("example") MarketingPlanHistoryExample example);

    int updateByExample(@Param("record") MarketingPlanHistory record, @Param("example") MarketingPlanHistoryExample example);

    int updateByPrimaryKeySelective(MarketingPlanHistory record);

    int updateByPrimaryKey(MarketingPlanHistory record);
}