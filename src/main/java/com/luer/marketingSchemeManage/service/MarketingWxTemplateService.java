package com.luer.marketingSchemeManage.service;

import com.luer.marketingSchemeManage.bean.MarketingWxTemplate;

import java.util.List;

public interface MarketingWxTemplateService {
   List<MarketingWxTemplate> WxPlanInEnterprise();
   int  deleteWXEnterprise(String id);

  int addPlanWXManage(MarketingWxTemplate marketingWxTemplate);

  int updateWXManage(MarketingWxTemplate marketingWxTemplate);
}
