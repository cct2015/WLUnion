package com.luer.marketingSchemeManage.controller;

import com.alibaba.fastjson.JSONObject;
import com.luer.comm.bean.ResultSet;
import com.luer.dataManage.bean.BaseLabel;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabel;
import com.luer.marketingSchemeManage.bean.SelPlanLabels;
import com.luer.marketingSchemeManage.service.MarketingPlanLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：EVEA
 * @date：2018/12/20 11:19
 **/
@RestController
@RequestMapping("/MarketingPlanLabel")
public class MarketingPlanLabelController {
    @Autowired
    private MarketingPlanLabelService marketingPlanLabelService;

    //根据方案id查询标签对象
    @RequestMapping("/findLabelByPlanId")
    public List<BaseLabel> findLabelByPlanId(String planId){
        return marketingPlanLabelService.findLabelByPlanId(planId);
    }

    @RequestMapping("/addMarketingPlanLabel")
    public ResultSet addMarketingPlanLabel(MarketingPlanLabel marketingPlanLabel){
        marketingPlanLabelService.addMarketingPlanLabel(marketingPlanLabel);
        return ResultSet.getSuccess();
    }

    @RequestMapping("/delMarketingPlanLabel")
    public ResultSet delMarketingPlanLabel(String id){
        marketingPlanLabelService.delMarketingPlanLabel(id);
        return ResultSet.getSuccess();
    }

    @RequestMapping("/getSelLabels")
    public List<SelPlanLabels> getSelLabels(String planId){
        List<SelPlanLabels> list=marketingPlanLabelService.getSelLabels(planId);
        return list;
    }
}
