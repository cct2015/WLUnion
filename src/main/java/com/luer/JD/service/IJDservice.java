package com.luer.JD.service;

import com.jd.open.api.sdk.JdException;
import com.luer.JD.bean.GoodInformation;
import com.luer.JD.bean.JdOrder;
import com.luer.JD.bean.JdSkuList;
import jd.union.open.category.goods.get.response.UnionOpenCategoryGoodsGetResponse;
import jd.union.open.coupon.query.response.UnionOpenCouponQueryResponse;
import jd.union.open.goods.jingfen.query.response.UnionOpenGoodsJingfenQueryResponse;
import jd.union.open.goods.promotiongoodsinfo.query.response.UnionOpenGoodsPromotiongoodsinfoQueryResponse;
import jd.union.open.goods.query.request.GoodsReq;
import jd.union.open.goods.query.response.UnionOpenGoodsQueryResponse;
import jd.union.open.order.query.request.OrderReq;
import jd.union.open.order.query.response.UnionOpenOrderQueryResponse;
import jd.union.open.promotion.bysubunionid.get.response.UnionOpenPromotionBysubunionidGetResponse;
import jd.union.open.promotion.byunionid.get.response.UnionOpenPromotionByunionidGetResponse;
import jd.union.open.promotion.common.get.response.UnionOpenPromotionCommonGetResponse;

import java.util.List;

public interface IJDservice {

    //关键词商品查询
    UnionOpenGoodsQueryResponse goodsQuery(GoodsReq goodsReq) throws  JdException;

    //获得通用的推广链接
    UnionOpenPromotionCommonGetResponse commonGetURL(GoodInformation goodInformation) throws JdException;

   //精粉商品查询
    UnionOpenGoodsJingfenQueryResponse JFgoodsQuery() throws  JdException;

    //获得商品详情
    UnionOpenGoodsPromotiongoodsinfoQueryResponse goodsinfoQuery(long id)  throws  JdException;

    // 通过subUnionId获取推广链接
    UnionOpenPromotionBysubunionidGetResponse getURLBysubunionid(String materialUrl,String subUnionId,String couponUrl)throws  JdException;

    //通过unionId获取推广链接
   // UnionOpenPromotionByunionidGetResponse getUrlByunionid(String materialUrl, String unionId,String subUnionId) throws  JdException;

    //订单查询
     UnionOpenOrderQueryResponse orderQuery(OrderReq orderReq) throws  JdException;


     //查询优惠券领取情况
     UnionOpenCouponQueryResponse couponQuery(String CouponUrls ) throws  JdException;

     //获得商品类目
     UnionOpenCategoryGoodsGetResponse getGoodsCategory(int parentId,int grade) throws  JdException;

    List<JdOrder> selectOrder(String merchantId, String beginTime, String endTime, String orderId);

    List<JdSkuList> selectOrderSkuListByID(String orderId);

    List<JdOrder> selectAgentOrder(String merchantId);

    List<JdOrder> getAgentOrder(String merchantId, String parentId, String beginTime, String endTime, String orderId);

}
