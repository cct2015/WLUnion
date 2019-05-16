package com.luer.dataManage.dao;

import com.luer.dataManage.bean.MerchantDefineData;
import com.luer.dataManage.bean.MerchantDefineDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MerchantDefineDataMapper {
    int countByExample(MerchantDefineDataExample example);

    int deleteByExample(MerchantDefineDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(MerchantDefineData record);

    int insertSelective(MerchantDefineData record);

    List<MerchantDefineData> selectByExample(MerchantDefineDataExample example);

    MerchantDefineData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MerchantDefineData record, @Param("example") MerchantDefineDataExample example);

    int updateByExample(@Param("record") MerchantDefineData record, @Param("example") MerchantDefineDataExample example);

    int updateByPrimaryKeySelective(MerchantDefineData record);

    int updateByPrimaryKey(MerchantDefineData record);

    MerchantDefineData selectByUrl(@Param("url") String url);

    List<MerchantDefineData> getMerchantDefineDataList();
}