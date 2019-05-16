package com.luer.marketingSchemeManage.service;

import com.luer.marketingSchemeManage.bean.MarketingPlanRecommend;

import java.util.List;

public interface MarketingPlanRecommendService {
    List<MarketingPlanRecommend> selectByPlanId(String planId);
}
