package com.luer.marketingSchemeManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class MarketingPlan implements Serializable {
    private String id;

    private String title;

    private String content;

    private Integer isDifferent;

    private String merchantId;

    private String merchant;
    private String district;

    private String city;

    private String province;

    private String country;

    private String remark;

    private String checker;

    private String selLabelKeys;

    private String merchantName;

    private String couponUrl;

    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    private String addUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    private String lastUpdater;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private String describe;

    private String name;

    private String tell;

    private String commissionTypeOne;

    private String commissionTypeTwo;

    private String commissionTypeThree;

    private String couponType;

    private String preferentialWay;

    private String valueOne;

    private String valueTwo;

    private String valueTree;

    private String otherDescripe;

    private Integer planStatus;

    private String usageRule;

    private String supportStore;

    private Integer couponsNumber;

    private Integer couponsSource;


}