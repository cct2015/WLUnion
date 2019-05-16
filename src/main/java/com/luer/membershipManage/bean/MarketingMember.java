package com.luer.membershipManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
public class MarketingMember  implements Serializable {
    private String id;

    private String merchantId;
    //企业名称
    private String merchantName;
    //企业的父级名称
    private String parentMerchantName;

    private Integer membersNum;

    private String phone;

    private Integer age;

    private String gender;

    private String image;

    private String openId;

    private String appId;

    private String name;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date addTime;

    private String addUser;

    private Integer status;

    private Integer source;

    private Date updateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

}