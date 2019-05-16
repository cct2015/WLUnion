package com.luer.marketingSchemeManage.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExecutePlanPara implements Serializable {

    private String planId;
    private String mode;
    private String merchantId;
    private String appId;
    private String content;
    private String templateId;
    private String paras;
    private String mediaId;
    private String msgtype;
    private int tag;
    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }


    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }




}
