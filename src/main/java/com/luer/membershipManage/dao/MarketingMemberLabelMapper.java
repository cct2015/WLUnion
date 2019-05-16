package com.luer.membershipManage.dao;

import com.luer.membershipManage.bean.MarketingMemberLabel;
import com.luer.membershipManage.bean.MarketingMemberLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface MarketingMemberLabelMapper {
    int countByExample(MarketingMemberLabelExample example);

    int deleteByExample(MarketingMemberLabelExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingMemberLabel record);

    int insertSelective(MarketingMemberLabel record);

    List<MarketingMemberLabel> selectByExample(MarketingMemberLabelExample example);

    MarketingMemberLabel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingMemberLabel record, @Param("example") MarketingMemberLabelExample example);

    int updateByExample(@Param("record") MarketingMemberLabel record, @Param("example") MarketingMemberLabelExample example);

    int updateByPrimaryKeySelective(MarketingMemberLabel record);

    int updateByPrimaryKey(MarketingMemberLabel record);

    List<MarketingMemberLabel> selectAll();
}