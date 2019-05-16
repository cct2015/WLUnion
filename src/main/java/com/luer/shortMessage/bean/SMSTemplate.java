package com.luer.shortMessage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SMSTemplate implements Serializable {
    //模板id
    private  String id;
    //企业员工id
    private String staffId;
    //模板类型2=通知类，3=营销类
    private String type;
    //模板名称
    private String name;
    //模板内容
    private String content;
    //模板状态，0未审核，1审核失败，2审核通过
    private  String auditStatus;
    //模板审核信息
    private String auditInfo;
    //模板创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    //模板更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    //模板启用状态，1正常使用，其他数字不能使用
    private String status;
}
