package com.luer.WLapi.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class DataEn implements Serializable {
    private String merchantId;

    private String code;

    private long  timestamp;

    private String  token;

    private String phones;

    private String personId;

}
