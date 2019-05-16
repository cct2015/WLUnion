package com.luer.dataManage.service.serviceImpl;

import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.dataManage.service.MarketingMerchantService;
import com.luer.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketingMerchantServiceImpl implements MarketingMerchantService {
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;

    @Override
    public void insert(MarketingMerchant marketingMerchant) {
        marketingMerchant.setId(UUIDUtils.getUUID());
        marketingMerchantMapper.insert(marketingMerchant);
    }

    @Override
    public void delete(String id) {
        marketingMerchantMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(MarketingMerchant marketingMerchant) {
        marketingMerchantMapper.updateByPrimaryKeySelective(marketingMerchant);
    }

    @Override
    public List<MarketingMerchant> selectAll() {
        List<MarketingMerchant> marketingMerchantList= marketingMerchantMapper.selectAll();
        return marketingMerchantList;
    }
}
