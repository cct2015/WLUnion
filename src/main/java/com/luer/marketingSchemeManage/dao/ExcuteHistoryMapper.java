package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.ExcuteHistory;
import com.luer.marketingSchemeManage.bean.ExcuteHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ExcuteHistoryMapper {
    int countByExample(ExcuteHistoryExample example);

    int deleteByExample(ExcuteHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(ExcuteHistory record);

    int insertSelective(ExcuteHistory record);

    List<ExcuteHistory> selectByExample(ExcuteHistoryExample example);

    ExcuteHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExcuteHistory record, @Param("example") ExcuteHistoryExample example);

    int updateByExample(@Param("record") ExcuteHistory record, @Param("example") ExcuteHistoryExample example);

    int updateByPrimaryKeySelective(ExcuteHistory record);

    int updateByPrimaryKey(ExcuteHistory record);

    List<ExcuteHistory> getExcuteHistoryList(@Param("planId") String planId);
}