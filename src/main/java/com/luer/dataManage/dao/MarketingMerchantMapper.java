package com.luer.dataManage.dao;

import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.bean.MarketingMerchantExample;
import java.util.List;

import com.luer.shortMessage.bean.SMSApp;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface MarketingMerchantMapper {
    int countByExample(MarketingMerchantExample example);

    int deleteByExample(MarketingMerchantExample example);

    int deleteByPrimaryKey(String id);

    int insert(MarketingMerchant record);

    int insertSelective(MarketingMerchant record);

    List<MarketingMerchant> selectByExampleWithBLOBs(MarketingMerchantExample example);

    List<MarketingMerchant> selectByExample(MarketingMerchantExample example);

    MarketingMerchant selectByPrimaryKey(String id);

    int updateByExampleWithBLOBs(@Param("record") MarketingMerchant record, @Param("example") MarketingMerchantExample example);


    int updateByExampleSelective(@Param("record") MarketingMerchant record, @Param("example") MarketingMerchantExample example);

    int updateByExample(@Param("record") MarketingMerchant record, @Param("example") MarketingMerchantExample example);

    int updateByPrimaryKeySelective(MarketingMerchant record);

    int updateByPrimaryKeyWithBLOBs(MarketingMerchant record);

    int updateByPrimaryKey(MarketingMerchant record);

    List<MarketingMerchant> selectAll();

    List<MarketingMerchant> selectEnterpriseMerchant();


    List<MarketingMerchant> selectByTypeAndStep(@Param("merchantType") int type, @Param("step")int step);

    MarketingMerchant selectHead(@Param("id") String id);

    List<MarketingMerchant> selectByTypeAndParentId(@Param("merchantType")int type, @Param("parentId")String parentId);

    List<MarketingMerchant> selectByType();

    MarketingMerchant selectById(String id);

    List<MarketingMerchant> getParentMerchant(@Param("id")String merchantId);

    List<MarketingMerchant> selectByCompanyName(@Param("selectValue")String selectValue,@Param("merchantType")Integer merchantType,@Param("parentId")String parentId);

    List<MarketingMerchant> selectByIndustryName(@Param("selectValue")String selectValue,@Param("merchantType")Integer merchantType,@Param("parentId")String parentId);

    List<MarketingMerchant> selectByAddress(@Param("selectValue")String selectValue,@Param("merchantType")Integer merchantType,@Param("parentId")String parentId);

    List<MarketingMerchant> selectByMainProducts(@Param("selectValue")String selectValue,@Param("merchantType")Integer merchantType,@Param("parentId")String parentId);

    List<MarketingMerchant> selectByMainBrand(@Param("selectValue")String selectValue,@Param("merchantType")Integer merchantType,@Param("parentId")String parentId);

    MarketingMerchant getParentCompany(@Param("parentId")String parentId);

   int updateSMSAppInfo(SMSApp en);

    SMSApp getSMSApp(String merchantId);

    int getFunsSum();

    List<MarketingMerchant> selectMerchantByType();

    int getMerchantCountToday(String mytime);
}