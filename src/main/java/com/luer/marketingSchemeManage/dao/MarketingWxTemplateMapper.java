package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.MarketingWxTemplate;
import com.luer.marketingSchemeManage.bean.MarketingWxTemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketingWxTemplateMapper {
    int countByExample(MarketingWxTemplateExample example);

    int deleteByExample(MarketingWxTemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingWxTemplate record);

    int insertSelective(MarketingWxTemplate record);

    List<MarketingWxTemplate> selectByExample(MarketingWxTemplateExample example);
    List<MarketingWxTemplate> selectByExample();
    MarketingWxTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MarketingWxTemplate record, @Param("example") MarketingWxTemplateExample example);

    int updateByExample(@Param("record") MarketingWxTemplate record, @Param("example") MarketingWxTemplateExample example);

    int updateByPrimaryKeySelective(MarketingWxTemplate record);

    int updateByPrimaryKey(MarketingWxTemplate record);
}