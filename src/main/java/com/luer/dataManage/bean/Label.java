package com.luer.dataManage.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cloud on 2018/12/18.
 */

@Data
public class Label implements Serializable {
    private String id;
    private String text;
    private String description;
    private String key;
    private String parentKey;
    private int  leaf;

}
