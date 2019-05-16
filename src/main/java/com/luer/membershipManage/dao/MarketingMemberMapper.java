package com.luer.membershipManage.dao;

import com.luer.membershipManage.bean.MarketingMember;
import com.luer.membershipManage.bean.MarketingMemberExample;
import java.util.List;

import com.luer.reportManage.bean.ReportForm;
import com.luer.wx.bean.MarketingMerchantWx;
import com.luer.wx.bean.Member;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface MarketingMemberMapper {
    int countByExample(MarketingMemberExample example);

    int deleteByExample(MarketingMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingMember record);

    //用于从微信公众号中导入会员
    int add(@Param("list") List<Member> list);
    int insertSelective(MarketingMember record);

    List<MarketingMember> selectByExample(MarketingMemberExample example);

    MarketingMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MarketingMember record, @Param("example") MarketingMemberExample example);

    int updateByExample(@Param("record") MarketingMember record, @Param("example") MarketingMemberExample example);

    int updateByPrimaryKeySelective(MarketingMember record);

    int updateByPrimaryKey(MarketingMember record);

    List<MarketingMember> selectAll();
    //获得商户所有的会员
    Integer getMemberCount(String marchantId);
    //获得商户所有的非微信会员
    Integer getMembersCount(String marchantId);
    //获得商户所有微信公众号下的会员
    Integer getWXMemberCount(String marchantId);
    //获得某一个公众号下的会员
    int getOneWXMemberCount(String appId);

    void importExcelMember(List<MarketingMember> marketingMembers);

    int getAllWXMemberCount();

    ReportForm getAllMembershipDistribute();

    List<ReportForm> getCompanyMembersTotal();

    List<ReportForm> getCompanyMembersAddByMonth(@Param("addtime") String addtime);
}