package com.luer.wx.bean;

import java.io.Serializable;

public class wxTextMediaForm implements Serializable {

    wxContent text;
    String msgtype;
    public wxContent getText() {
        return text;
    }

    public void setText(wxContent text) {
        this.text = text;
    }



    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }


}
