package com.luer.wx.bean;

import java.io.Serializable;

public class wxGroupNewForm implements Serializable {
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    private   String appId;
    private String access_token;
}
