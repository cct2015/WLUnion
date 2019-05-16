package com.luer.dataManage.bean;

import lombok.Data;

/**
 * Created by 87961 on 2019/3/15.
 */
@Data
public class MerchantInformation {
    //微信公众号数量
    private int wxNumber;
    //微信公众号粉丝数量
    private int wxFansNumber;
    //品牌数量
    private int merchantBrandNumber;
    //会员数量
    private int memberNumber;


}
