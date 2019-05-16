package com.luer.JD.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class JdSkuList extends JdSkuListKey implements Serializable{
    private Double actualCosPrice;

    private Double actualFee;

    private Double commissionRate;

    private Double estimateCosPrice;

    private Double estimateFee;

    private Double finalRate;

    private Long cid1;

    private Long frozenSkuNum;

    private String pid;

    private Long positionId;

    private Double price;

    private Long cid2;

    private Long siteId;

    private String skuName;

    private Long skuNum;

    private Long skuReturnNum;

    private Double subSideRate;

    private Double subsidyRate;

    private Long cid3;

    private String unionAlias;

    private String unionTag;

    private Integer unionTrafficGroup;

    private Integer validCode;

    private String subUnionId;

    private Integer traceType;

    private Integer payMonth;

    private Long popId;

    private String ext1;

    private String merchantName;
}