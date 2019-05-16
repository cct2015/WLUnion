package com.luer.dataManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Data
public class MarketingMerchant implements Serializable {

    private String id;

    private String companyName;

    private String companyShort;

    private String industryId;

    private String contacter;

    private String tel;

    private String district;

    private String city;

    private String province;

    private String country;

    private String address;

    private String mainProducts;

    private String mainBrand;

    private Integer merchantType;

    private Integer step;

    private String parentId;

    private String bankNo;

    private String bankAddress;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date addTime;

    private String addUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastUpdate;

    private String lastUpdater;

    private Integer status;

    private String faxNo;

    private String creditCode;
    //行业名称
    private String industryName;
    //上级商户名称
    private String parentName;

    private String marketingNo;

    private String bankUser;

    private String systemName;

    private byte[] systemIcon;

    private String acquirer;

    private Integer fans;

}