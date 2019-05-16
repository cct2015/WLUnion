package com.luer.dataManage.dao;

import com.luer.dataManage.bean.BaseIndustry;
import com.luer.dataManage.bean.BaseIndustryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface BaseIndustryMapper {
    int countByExample(BaseIndustryExample example);

    int deleteByExample(BaseIndustryExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseIndustry record);

    int insertSelective(BaseIndustry record);

    List<BaseIndustry> selectByExample(BaseIndustryExample example);

    BaseIndustry selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseIndustry record, @Param("example") BaseIndustryExample example);

    int updateByExample(@Param("record") BaseIndustry record, @Param("example") BaseIndustryExample example);

    int updateByPrimaryKeySelective(BaseIndustry record);

    int updateByPrimaryKey(BaseIndustry record);

    List<BaseIndustry> selectAll();

    List<BaseIndustry> selectRoot();
}