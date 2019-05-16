package com.luer.sys.dao;

import com.luer.sys.bean.SysQa;
import com.luer.sys.bean.SysQaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysQaMapper {
    int countByExample(SysQaExample example);

    int deleteByExample(SysQaExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysQa record);

    int insertSelective(SysQa record);

//    List<SysQa> qamangePlanInEnterprise(SysQaExample example);
    List<SysQa> selectByExample(SysQaExample example);
    List<SysQa> selectByExample();
    SysQa selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(SysQa sysQa);

    int updateByExampleSelective(@Param("record") SysQa record, @Param("example") SysQaExample example);

    int updateByExample(@Param("record") SysQa record, @Param("example") SysQaExample example);

    int updateByPrimaryKeySelective(SysQa sysQa);

    List<SysQa> QuestionAnser();

    List<SysQa> selectAnser(SysQa question);

    List<SysQa> ShowAll(SysQa id);

    List<SysQa> mohucha(SysQa question);

    int Allinsert(List<SysQa> list);

}