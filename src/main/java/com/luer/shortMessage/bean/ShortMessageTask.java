package com.luer.shortMessage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/*
 * 短信任务*/
@Data
public class ShortMessageTask {
    /*任务id*/
    private String id;
    /*员工id*/
    private long staffId;
    /*任务状态*/
    private long status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;

    private String sumCount;

    private String succeedCount;

    private String failedCount;

    private String name;

    private String attach;
    /*摸板id*/
    private String templateId;
    /*摸板id*/
    private String templateName;
    private List<Paras> parasList;

    private String clickCount;
    private String failInfo;


}
