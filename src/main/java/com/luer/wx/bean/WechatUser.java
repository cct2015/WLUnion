package com.luer.wx.bean;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 微信用户实体类
 *
 */
public class WechatUser implements Serializable {

    private static final long serialVersionUID = -4681067645282292327L;

    // openId，标识该公众号下面的该用户的唯一Id
    @JsonProperty("openid")
    private String openId;
    // 用户昵称
    @JsonProperty("nick_name")
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("user_name")
    private String userName;

    // 性别
    @JsonProperty("sex")
    private int sex;
    // 省份
    @JsonProperty("province")
    private String province;
    // 城市
    @JsonProperty("city")
    private String city;
    // 区
    @JsonProperty("country")
    private String country;
    // 头像图片地址
    @JsonProperty("headimgurl")
    private String headimgurl;
    // 语言
    @JsonProperty("language")
    private String language;
    // 用户权限
    @JsonProperty("privilege")
    private String[] privilege;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    private String appId;

    public String getServiceTypeinfo() {
        return serviceTypeinfo;
    }

    public void setServiceTypeinfo(String serviceTypeinfo) {
        this.serviceTypeinfo = serviceTypeinfo;
    }

    @JsonProperty("service_type_info")
    private String serviceTypeinfo;


    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    @JsonProperty("principal_name")
    private String principalName;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
