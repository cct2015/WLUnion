package com.luer.marketingSchemeManage.bean;

import java.io.Serializable;
import java.util.Date;

public class ExcuteHistory implements Serializable {
    private String id;

    private String planId;

    private String excuteResult;

    private Integer excuteTimes;

    private Date excuteTime;

    private String excuteUser;

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

    public String getExcuteResult() {
        return excuteResult;
    }

    public void setExcuteResult(String excuteResult) {
        this.excuteResult = excuteResult == null ? null : excuteResult.trim();
    }

    public Integer getExcuteTimes() {
        return excuteTimes;
    }

    public void setExcuteTimes(Integer excuteTimes) {
        this.excuteTimes = excuteTimes;
    }

    public Date getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
    }

    public String getExcuteUser() {
        return excuteUser;
    }

    public void setExcuteUser(String excuteUser) {
        this.excuteUser = excuteUser == null ? null : excuteUser.trim();
    }
}