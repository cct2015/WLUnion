package com.luer.marketingSchemeManage.service.Impl;

import com.luer.marketingSchemeManage.bean.MarketingPlanRecommend;
import com.luer.marketingSchemeManage.dao.MarketingPlanRecommendMapper;
import com.luer.marketingSchemeManage.service.MarketingPlanRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarketingPlanRecommendServiceImpl implements MarketingPlanRecommendService {
    @Autowired
    private MarketingPlanRecommendMapper marketingPlanRecommendMapper;

    @Override
    public List<MarketingPlanRecommend> selectByPlanId(String planId) {
        return marketingPlanRecommendMapper.selectByPlanId(planId);
    }
}
