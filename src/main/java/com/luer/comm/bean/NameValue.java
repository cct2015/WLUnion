package com.luer.comm.bean;

import lombok.Data;

@Data
public class NameValue {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private Object value;
}
