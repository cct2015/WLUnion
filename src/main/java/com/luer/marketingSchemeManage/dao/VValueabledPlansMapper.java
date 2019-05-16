package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.VValueabledPlans;
import com.luer.marketingSchemeManage.bean.VValueabledPlansExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface VValueabledPlansMapper {
    int countByExample(VValueabledPlansExample example);

    int deleteByExample(VValueabledPlansExample example);

    int insert(VValueabledPlans record);

    int insertSelective(VValueabledPlans record);

    List<VValueabledPlans> selectByExampleWithBLOBs(VValueabledPlansExample example);

    List<VValueabledPlans> selectByExample(VValueabledPlansExample example);

    int updateByExampleSelective(@Param("record") VValueabledPlans record, @Param("example") VValueabledPlansExample example);

    int updateByExampleWithBLOBs(@Param("record") VValueabledPlans record, @Param("example") VValueabledPlansExample example);

    int updateByExample(@Param("record") VValueabledPlans record, @Param("example") VValueabledPlansExample example);
}