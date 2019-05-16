package com.luer.wx.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class MarketingMerchantWx implements Serializable {
    private String appId;

    private String merchantId;

    private String merchantName;

    private String parentMerchantName;

    private String authorizerRefreshToken;

    private Date updateDate;

    private String appName;

    private String appFans;

    private String appMemberFans;


}