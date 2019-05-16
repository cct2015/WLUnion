package com.luer.wx.bean;

import java.io.Serializable;

public class wxContent implements Serializable {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String  content;
}
