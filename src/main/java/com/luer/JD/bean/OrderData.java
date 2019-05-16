package com.luer.JD.bean;

import jd.union.open.order.query.response.OrderResp;
import jd.union.open.order.query.response.SkuInfo;
import net.sf.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderData  extends OrderResp   implements Serializable{

    public String getSkuRealList() {
        return skuRealList;
    }

    public void setSkuRealList(String skuRealList) {
        this.skuRealList = skuRealList;
    }

    private String skuRealList;
    //实付金额
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getEstimateCommission() {
        return estimateCommission;
    }

    public void setEstimateCommission(Double estimateCommission) {
        this.estimateCommission = estimateCommission;
    }

    //预估佣金
    private Double estimateCommission;


}
