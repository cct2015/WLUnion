package com.luer.shortMessage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*签名*/
@Data
public class ShortMessageSignature implements Serializable {

    private int id;

    private int type;

    private String signature;

    private int use;

    private String remark;

    private int staffId;

    private FileMessage auth;
    private String authurl;
    private String authsize;
    private String authfileName;


    private FileMessage authLicense;
    private String authLicenseurl;
    private String authLicensesize;
    private String authLicensefileName;

    private String authLicenseStart;

    private String authLicenseEnd;

    private FileMessage proves;
    private String provesurl;
    private String provessize;
    private String provesfileName;


    private FileMessage license;
    private String licenseurl;
    private String licensesize;
    private String licensefileName;

    private String licenseStart;

    private String licenseEnd;

    //返回值字段
    private String auditInfo;
    private String auditStatus;
    //模板创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //模板更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;



}
