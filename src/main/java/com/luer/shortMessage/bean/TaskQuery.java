package com.luer.shortMessage.bean;

import lombok.Data;

@Data
public class TaskQuery {
    private String startStr;
    private String endStr;
    private String keyWord;
    private int offset;
    private int limit;
    private int filters;
}
