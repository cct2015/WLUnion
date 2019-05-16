package com.luer.marketingSchemeManage.service.Impl;

import com.luer.comm.utils.UuidUtils;
import com.luer.dataManage.bean.BaseLabel;
import com.luer.dataManage.bean.BaseLabelExample;
import com.luer.dataManage.dao.BaseLabelMapper;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabel;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabelExample;
import com.luer.marketingSchemeManage.bean.SelPlanLabels;
import com.luer.marketingSchemeManage.dao.MarketingPlanLabelMapper;
import com.luer.marketingSchemeManage.service.MarketingPlanLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：EVEA
 * @date：2018/12/20 10:21
 **/
@Service
@Transactional
public class MarketingPlanLabelServiceImpl implements MarketingPlanLabelService {
    @Autowired
    private MarketingPlanLabelMapper marketingPlanLabelMapper;
    @Autowired
    private BaseLabelMapper baseLabelMapper;
    @Override
    public List<String> findLabelIdByPlanId(String planId){
        List<String> stringList = null;
        MarketingPlanLabelExample example = new MarketingPlanLabelExample();
        MarketingPlanLabelExample.Criteria criteria =  example.createCriteria();
        criteria.andPlanIdEqualTo(planId);
        List<MarketingPlanLabel> marketingPlanLabelList = marketingPlanLabelMapper.selectByExample(example);
        stringList = new ArrayList();
        for(MarketingPlanLabel marketingPlanLabel:marketingPlanLabelList){
            stringList.add(marketingPlanLabel.getLabelId());
        }
        return stringList;
    }

    @Override
    public List<BaseLabel> findLabelByPlanId(String planId){
        List<String> labelIdList = findLabelIdByPlanId(planId);
        BaseLabelExample example = new BaseLabelExample();
        BaseLabelExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(labelIdList);
        return  baseLabelMapper.selectByExample(example);
    }

    @Override
    public int addMarketingPlanLabel(MarketingPlanLabel marketingPlanLabel){
        marketingPlanLabel.setId(UuidUtils.getUUID());
        return marketingPlanLabelMapper.insert(marketingPlanLabel);
    }

    @Override
    public int delMarketingPlanLabel(String id){
        return marketingPlanLabelMapper.deleteByPrimaryKey(id);
    }

    //获得某个营销计划的所有选择的标签
    @Override
    public List<SelPlanLabels> getSelLabels(String planId)
    {
        List<SelPlanLabels> list=marketingPlanLabelMapper.getSelLabels(planId);
       return  list;
    }


}
