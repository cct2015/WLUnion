package com.luer.privilegeManage.dao;

import com.luer.privilegeManage.bean.MarketingWxSetting;
import com.luer.privilegeManage.bean.MarketingWxSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketingWxSettingMapper {
    int countByExample(MarketingWxSettingExample example);

    int deleteByExample(MarketingWxSettingExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingWxSetting record);

    int insertSelective(MarketingWxSetting record);

    List<MarketingWxSetting> selectByExample(MarketingWxSettingExample example);

    MarketingWxSetting selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingWxSetting record, @Param("example") MarketingWxSettingExample example);

    int updateByExample(@Param("record") MarketingWxSetting record, @Param("example") MarketingWxSettingExample example);

    int updateByPrimaryKeySelective(MarketingWxSetting record);

    int updateByPrimaryKey(MarketingWxSetting record);
}