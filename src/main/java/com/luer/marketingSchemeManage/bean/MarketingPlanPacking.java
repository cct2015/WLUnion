package com.luer.marketingSchemeManage.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 87961 on 2018/12/28.
 */
@Data
@Getter
@Setter
public class MarketingPlanPacking implements Serializable {
    private String id;
    private String marketingPlanTitle;
    private String marketingPlanContent;
    private String companyName;
    private int Status;
    private int excutestatus;

}
