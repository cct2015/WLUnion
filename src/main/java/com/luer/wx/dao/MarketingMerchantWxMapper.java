package com.luer.wx.dao;

import com.luer.wx.bean.MarketingMerchantWx;
import com.luer.wx.bean.MarketingMerchantWxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface MarketingMerchantWxMapper {
    int countByExample(MarketingMerchantWxExample example);

    int deleteByExample(MarketingMerchantWxExample example);

    int deleteByPrimaryKey(String appId);

    int insert(@Param("record")MarketingMerchantWx record);

    int insertSelective(MarketingMerchantWx record);

    List<MarketingMerchantWx> selectByExample(MarketingMerchantWxExample example);

    MarketingMerchantWx selectByPrimaryKey(String appId);

    int updateByExampleSelective(@Param("record") MarketingMerchantWx record, @Param("example") MarketingMerchantWxExample example);

    int updateByExample(@Param("record") MarketingMerchantWx record, @Param("example") MarketingMerchantWxExample example);

    int updateByPrimaryKeySelective(MarketingMerchantWx record);

    int updateByPrimaryKey(@Param("record") MarketingMerchantWx record);

    int countIsExists(@Param("record") MarketingMerchantWx record);

    String getAuthorizerRefreshToken(@Param("authorizerAppid") String authorizerAppid);

    //获得某个商户的所有公众号列表
    List<MarketingMerchantWx> getMerchantWX(String marchantId);

    int countNumber();
}