package com.luer.marketingSchemeManage.controller;

import com.luer.marketingSchemeManage.bean.MarketingPlanRecommend;
import com.luer.marketingSchemeManage.service.MarketingPlanRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marketingPlanRecommend")
public class MarketingPlanRecommendController {
    @Autowired
    private MarketingPlanRecommendService marketingPlanRecommendService;

    /*根据fang方案id查询*/
    @ResponseBody
    @RequestMapping("/selectByPlanId")
    public List<MarketingPlanRecommend> selectByPlanId(String planId) {
        System.out.println("planId=================="+planId);
        List<MarketingPlanRecommend> marketingPlanRecommendList = marketingPlanRecommendService.selectByPlanId(planId);
        System.out.println("size=================="+marketingPlanRecommendList.size());
        return marketingPlanRecommendList;
    }

}
