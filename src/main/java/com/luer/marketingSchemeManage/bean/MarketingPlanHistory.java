package com.luer.marketingSchemeManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MarketingPlanHistory {
    private String id;

    private String planId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    private String sendUser;

    private Integer wxCount;

    private Integer phoneCount;

    private Integer isDifferent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser == null ? null : sendUser.trim();
    }

    public Integer getWxCount() {
        return wxCount;
    }

    public void setWxCount(Integer wxCount) {
        this.wxCount = wxCount;
    }

    public Integer getPhoneCount() {
        return phoneCount;
    }

    public void setPhoneCount(Integer phoneCount) {
        this.phoneCount = phoneCount;
    }

    public Integer getIsDifferent() {
        return isDifferent;
    }

    public void setIsDifferent(Integer isDifferent) {
        this.isDifferent = isDifferent;
    }
}