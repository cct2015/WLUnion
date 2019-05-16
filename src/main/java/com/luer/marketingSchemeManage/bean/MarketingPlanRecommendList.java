package com.luer.marketingSchemeManage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class MarketingPlanRecommendList implements Serializable {
    private String merchantId;
    private String couponUrl;
}
