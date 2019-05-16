package com.luer.wx.bean;

import java.io.Serializable;

public class CardCode implements Serializable {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    private String card_id;
}
