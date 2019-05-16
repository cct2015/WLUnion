package com.luer.marketingSchemeManage.service;

import com.luer.dataManage.bean.BaseLabel;
import com.luer.marketingSchemeManage.bean.MarketingPlanLabel;
import com.luer.marketingSchemeManage.bean.SelPlanLabels;

import java.util.List;

/**
 * @author：EVEA
 * @date：2018/12/20 10:08
 **/
//营销方案对应标签
public interface MarketingPlanLabelService {
    //根据方案id查询标签id
    List<String> findLabelIdByPlanId(String planId);
    //根据方案id查询标签对象
    List<BaseLabel> findLabelByPlanId(String planId);

    int addMarketingPlanLabel(MarketingPlanLabel marketingPlanLabel);
    int delMarketingPlanLabel(String id);

    //获得某个营销计划的所有选择的标签
     List<SelPlanLabels> getSelLabels(String id);


}
