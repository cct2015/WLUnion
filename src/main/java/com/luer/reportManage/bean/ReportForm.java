package com.luer.reportManage.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 87961 on 2019/4/24.
 */
@Data
public class ReportForm implements Serializable {
    //id用于存放数据id
    private String id;
    //微信会员数量
    private Integer wxMembers;
    //其他会员数量
    private Integer otherMembers;
    //总会员数量
    private  Integer totalMembers;
    //企业名称
    private String name;
    //上级商户名称
    private String parentName;

}
