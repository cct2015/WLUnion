package com.luer.dataManage.dao;

import com.luer.dataManage.bean.MarketingBrand;
import com.luer.dataManage.bean.MarketingBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan
public interface MarketingBrandMapper {
    int countByExample(MarketingBrandExample example);

    int deleteByExample(MarketingBrandExample example);

    int deleteByPrimaryKey(String id);

    int deleteByMarketingId(String MarketingId);
    int insert(MarketingBrand record);

    int insertByMarketingBrandList(@Param("marketingBrandList")List<MarketingBrand> marketingBrandList);
    int insertSelective(MarketingBrand record);

    List<MarketingBrand> selectByExample(MarketingBrandExample example);

    MarketingBrand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingBrand record, @Param("example") MarketingBrandExample example);

    int updateByExample(@Param("record") MarketingBrand record, @Param("example") MarketingBrandExample example);

    int updateByPrimaryKeySelective(MarketingBrand record);

    int updateByPrimaryKey(MarketingBrand record);

    int getBrandNumber();
}