package com.luer.marketingSchemeManage.service.Impl;

import com.luer.marketingSchemeManage.bean.MarketingWxTemplate;
import com.luer.marketingSchemeManage.dao.MarketingWxTemplateMapper;
import com.luer.marketingSchemeManage.service.MarketingWxTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingWxTemplateServiceimpl implements MarketingWxTemplateService {
    @Autowired
    private MarketingWxTemplateMapper marketingWxTemplateMapper;
    @Override
    public List<MarketingWxTemplate> WxPlanInEnterprise(){
        return marketingWxTemplateMapper.selectByExample();
    }

    @Override
    public int  deleteWXEnterprise(String id){
        return marketingWxTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addPlanWXManage(MarketingWxTemplate marketingWxTemplate){
        return marketingWxTemplateMapper.insert(marketingWxTemplate);
    }

    @Override
    public int updateWXManage(MarketingWxTemplate marketingWxTemplate){
        return marketingWxTemplateMapper.updateByPrimaryKeySelective(marketingWxTemplate);
    }
}
