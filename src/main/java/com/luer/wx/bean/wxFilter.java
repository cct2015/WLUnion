package com.luer.wx.bean;

import java.io.Serializable;

public class wxFilter implements Serializable {
    private boolean   is_to_all;

    public boolean isIs_to_all() {
        return is_to_all;
    }

    public void setIs_to_all(boolean is_to_all) {
        this.is_to_all = is_to_all;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    private int tag_id;
}
