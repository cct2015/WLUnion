package com.luer.JD.bean;

import lombok.Data;

/**
 * Created by 87961 on 2019/4/17.
 */
@Data
public class GoodInformation {
    //商品详情页链接
    private String materialId;

    //优惠劵链接
    private String couponUrl;

    private String subUnionId;
    //商品id
    private Long goodsId;


}
