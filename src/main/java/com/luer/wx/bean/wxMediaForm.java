package com.luer.wx.bean;

public class wxMediaForm {
    public wxMaterial getMpnews() {
        return mpnews;
    }

    public void setMpnews(wxMaterial mpnews) {
        this.mpnews = mpnews;
    }

    private wxMaterial mpnews;



    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getSend_ignore_reprint() {
        return send_ignore_reprint;
    }

    public void setSend_ignore_reprint(int send_ignore_reprint) {
        this.send_ignore_reprint = send_ignore_reprint;
    }

    private String msgtype;
    private int send_ignore_reprint;
}
