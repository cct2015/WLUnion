package com.luer.dataManage.service;

import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.bean.MerchantType;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.shortMessage.bean.SMSApp;

import java.util.List;


public interface MarketingMerchantService {
    
    void insert(MarketingMerchant marketingMerchant);

    void delete(String id);

    void updateById(MarketingMerchant marketingMerchant);

    List<MarketingMerchant> selectAll();

    void merchantAndUserInsert(String jsonStr, SysUser sysUser) throws Exception;

    List<MarketingMerchant> selectByTypeAndStep(int type, int step);

    //通过商户类型和上级企业查询
    List<MarketingMerchant> selectByTypeAndParentId(int type, String parentId);

    List<MarketingMerchant> selectById(String id);

    List<MarketingMerchant> getParentMerchant();

    List<MarketingMerchant> selectByType(String selectType, String selectValue , Integer merchantType);

    MerchantType getMerchantById();

    List<SMSApp> selectByNow();

    List<MarketingMerchant> selectMerchantByType();
}
