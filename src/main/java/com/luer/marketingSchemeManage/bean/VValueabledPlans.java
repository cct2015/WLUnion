package com.luer.marketingSchemeManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class VValueabledPlans implements Serializable {
    private String id;

    private String title;

    private Integer isDifferent;

    private String fromMerchantId;

    private String district;

    private String city;

    private String province;

    private String country;

    private String remark;

    public String getCouponUrl() {
        return couponUrl;
    }

    public void setCouponUrl(String couponUrl) {
        this.couponUrl = couponUrl;
    }

    String couponUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private String describe1;

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

    private String usageRule;

    private String supportStore;

    private Integer couponsNumber;

    private String acceptmerchant;

    private String merchant;

    private Integer status;

    private Date addTime;

    private String merchantId;

    private String content;

    public String getCouponsSource() {
        return couponsSource;
    }

    public void setCouponsSource(String couponsSource) {
        this.couponsSource = couponsSource;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    private String couponsSource;
    private Integer result;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIsDifferent() {
        return isDifferent;
    }

    public void setIsDifferent(Integer isDifferent) {
        this.isDifferent = isDifferent;
    }

    public String getFromMerchantId() {
        return fromMerchantId;
    }

    public void setFromMerchantId(String fromMerchantId) {
        this.fromMerchantId = fromMerchantId == null ? null : fromMerchantId.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1 == null ? null : describe1.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell == null ? null : tell.trim();
    }

    public String getCommissionTypeOne() {
        return commissionTypeOne;
    }

    public void setCommissionTypeOne(String commissionTypeOne) {
        this.commissionTypeOne = commissionTypeOne == null ? null : commissionTypeOne.trim();
    }

    public String getCommissionTypeTwo() {
        return commissionTypeTwo;
    }

    public void setCommissionTypeTwo(String commissionTypeTwo) {
        this.commissionTypeTwo = commissionTypeTwo == null ? null : commissionTypeTwo.trim();
    }

    public String getCommissionTypeThree() {
        return commissionTypeThree;
    }

    public void setCommissionTypeThree(String commissionTypeThree) {
        this.commissionTypeThree = commissionTypeThree == null ? null : commissionTypeThree.trim();
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType == null ? null : couponType.trim();
    }

    public String getPreferentialWay() {
        return preferentialWay;
    }

    public void setPreferentialWay(String preferentialWay) {
        this.preferentialWay = preferentialWay == null ? null : preferentialWay.trim();
    }

    public String getValueOne() {
        return valueOne;
    }

    public void setValueOne(String valueOne) {
        this.valueOne = valueOne == null ? null : valueOne.trim();
    }

    public String getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(String valueTwo) {
        this.valueTwo = valueTwo == null ? null : valueTwo.trim();
    }

    public String getValueTree() {
        return valueTree;
    }

    public void setValueTree(String valueTree) {
        this.valueTree = valueTree == null ? null : valueTree.trim();
    }

    public String getOtherDescripe() {
        return otherDescripe;
    }

    public void setOtherDescripe(String otherDescripe) {
        this.otherDescripe = otherDescripe == null ? null : otherDescripe.trim();
    }

    public String getUsageRule() {
        return usageRule;
    }

    public void setUsageRule(String usageRule) {
        this.usageRule = usageRule == null ? null : usageRule.trim();
    }

    public String getSupportStore() {
        return supportStore;
    }

    public void setSupportStore(String supportStore) {
        this.supportStore = supportStore == null ? null : supportStore.trim();
    }

    public Integer getCouponsNumber() {
        return couponsNumber;
    }

    public void setCouponsNumber(Integer couponsNumber) {
        this.couponsNumber = couponsNumber;
    }

    public String getAcceptmerchant() {
        return acceptmerchant;
    }

    public void setAcceptmerchant(String acceptmerchant) {
        this.acceptmerchant = acceptmerchant == null ? null : acceptmerchant.trim();
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}