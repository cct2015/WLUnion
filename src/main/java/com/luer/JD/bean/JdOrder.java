package com.luer.JD.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class JdOrder implements Serializable{
    private Long orderId;

    private Long finishTime;

    private Integer orderEmt;

    private Long orderTime;

    private Long parentId;

    private String payMonth;

    private Integer plus;

    private Long popId;

    private Long unionId;

    private String ext1;

    private Integer validCode;

    private String hasMore;
    //预估佣金
    private Double estimateFee;
    //商户名称
    private String merchantName;
    //顾客号码
    private String  customerId;

}