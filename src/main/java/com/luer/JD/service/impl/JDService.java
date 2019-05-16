package com.luer.JD.service.impl;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.luer.JD.bean.GoodInformation;
import com.luer.JD.bean.JdOrder;
import com.luer.JD.bean.JdSkuList;
import com.luer.JD.dao.JdOrderMapper;
import com.luer.JD.dao.JdSkuListMapper;
import com.luer.JD.service.IJDservice;
import com.luer.config.WechatOpenProperties;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import jd.union.open.category.goods.get.request.CategoryReq;
import jd.union.open.category.goods.get.request.UnionOpenCategoryGoodsGetRequest;
import jd.union.open.category.goods.get.response.UnionOpenCategoryGoodsGetResponse;
import jd.union.open.coupon.query.request.UnionOpenCouponQueryRequest;
import jd.union.open.coupon.query.response.UnionOpenCouponQueryResponse;
import jd.union.open.goods.jingfen.query.request.JFGoodsReq;
import jd.union.open.goods.jingfen.query.request.UnionOpenGoodsJingfenQueryRequest;
import jd.union.open.goods.jingfen.query.response.UnionOpenGoodsJingfenQueryResponse;
import jd.union.open.goods.promotiongoodsinfo.query.request.UnionOpenGoodsPromotiongoodsinfoQueryRequest;
import jd.union.open.goods.promotiongoodsinfo.query.response.UnionOpenGoodsPromotiongoodsinfoQueryResponse;
import jd.union.open.goods.query.request.GoodsReq;
import jd.union.open.goods.query.request.UnionOpenGoodsQueryRequest;
import jd.union.open.goods.query.response.UnionOpenGoodsQueryResponse;
import jd.union.open.order.query.request.OrderReq;
import jd.union.open.order.query.request.UnionOpenOrderQueryRequest;
import jd.union.open.order.query.response.UnionOpenOrderQueryResponse;
import jd.union.open.promotion.bysubunionid.get.request.UnionOpenPromotionBysubunionidGetRequest;
import jd.union.open.promotion.bysubunionid.get.response.UnionOpenPromotionBysubunionidGetResponse;
import jd.union.open.promotion.byunionid.get.request.UnionOpenPromotionByunionidGetRequest;
import jd.union.open.promotion.byunionid.get.response.UnionOpenPromotionByunionidGetResponse;
import jd.union.open.promotion.common.get.request.UnionOpenPromotionCommonGetRequest;
import jd.union.open.promotion.common.get.response.UnionOpenPromotionCommonGetResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class JDService implements IJDservice {

    @Autowired
    private JdOrderMapper jdOrderMapper;
    @Autowired
    private JdSkuListMapper jdSkuListMapper;
    /*@Autowired
    private MarketingMerchantMapper marketingMerchantMapper;*/
    @Autowired
    private WechatOpenProperties wechatOpenProperties;

    private String appKey = "f9a60fc1d544e2444521320044ccb58d";
    private String appSecret = "aa90716f49f14cedaab820abdd5933ee";
    private String SERVER_URL = "https://router.jd.com/api";
    private String accessToken = "ece3b6ab1c8b87a71e6a847aea23d4ca6d0792c129cbdb02e2f7834e72d4129a25e8dfc734ff9da7";

    //关键词商品查询列表
    public UnionOpenGoodsQueryResponse goodsQuery(GoodsReq goodsReq) throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenGoodsQueryRequest request = new UnionOpenGoodsQueryRequest();
        request.setGoodsReqDTO(goodsReq);
        UnionOpenGoodsQueryResponse response = client.execute(request);
        return response;
    }

    //查询京精粉商品列表
    // setEliteId频道id：1-好券商品,2-京粉APP-jingdong.大咖推荐,3-小程序-jingdong.好券商品,
    // 4-京粉APP-jingdong.主题街1-jingdong.服装运动,5-京粉APP-jingdong.主题街2-jingdong.精选家电,
    // 6-京粉APP-jingdong.主题街3-jingdong.超市,7-京粉APP-jingdong.主题街4-jingdong.居家生活,10-9.9专区,
    // 11-品牌好货-jingdong.潮流范儿,12-品牌好货-jingdong.精致生活,13-品牌好货-jingdong.数码先锋,
    // 14-品牌好货-jingdong.品质家电,15-京仓配送,16-公众号-jingdong.好券商品,17-公众号-jingdong.9.9,
    // 18-公众号-jingdong.京仓京配
    public UnionOpenGoodsJingfenQueryResponse JFgoodsQuery() throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenGoodsJingfenQueryRequest request = new UnionOpenGoodsJingfenQueryRequest();
        JFGoodsReq goodsReq = new JFGoodsReq();
        goodsReq.setEliteId(11);
        request.setGoodsReq(goodsReq);
        UnionOpenGoodsJingfenQueryResponse response = client.execute(request);
        return response;
    }

    //获得商品通用的推广链接
    public UnionOpenPromotionCommonGetResponse commonGetURL(GoodInformation goodInformation) throws JdException {

        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);

        UnionOpenPromotionCommonGetRequest request = new UnionOpenPromotionCommonGetRequest();
        jd.union.open.promotion.common.get.request.PromotionCodeReq promotionCodeReq = new jd.union.open.promotion.common.get.request.PromotionCodeReq();
        promotionCodeReq.setMaterialId(goodInformation.getMaterialId());
        promotionCodeReq.setSubUnionId(goodInformation.getSubUnionId());
        request.setPromotionCodeReq(promotionCodeReq);
        UnionOpenPromotionCommonGetResponse response = client.execute(request);

        return response;
    }

    //获得商品详情
    public UnionOpenGoodsPromotiongoodsinfoQueryResponse goodsinfoQuery(long id) throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenGoodsPromotiongoodsinfoQueryRequest request = new UnionOpenGoodsPromotiongoodsinfoQueryRequest();
        request.setSkuIds(String.valueOf(id));
        UnionOpenGoodsPromotiongoodsinfoQueryResponse response = client.execute(request);
        return response;
    }

    // 通过subUnionId获取推广链接
    public UnionOpenPromotionBysubunionidGetResponse getURLBysubunionid(String materialUrl, String subUnionId, String couponUrl) throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenPromotionBysubunionidGetRequest request = new UnionOpenPromotionBysubunionidGetRequest();
        jd.union.open.promotion.bysubunionid.get.request.PromotionCodeReq promotionCodeReq = new jd.union.open.promotion.bysubunionid.get.request.PromotionCodeReq();
        promotionCodeReq.setMaterialId(materialUrl);
        promotionCodeReq.setSubUnionId(subUnionId);
        if (StringUtils.isNotEmpty(couponUrl)) {
            promotionCodeReq.setCouponUrl(couponUrl);
        }
        request.setPromotionCodeReq(promotionCodeReq);
        UnionOpenPromotionBysubunionidGetResponse response = client.execute(request);
        return response;
    }

    //通过unionId获取推广链接
//    public UnionOpenPromotionByunionidGetResponse getUrlByunionid(String materialUrl, Long unionId, String subUnionId) throws  JdException
//    {
//        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
//        UnionOpenPromotionByunionidGetRequest request = new UnionOpenPromotionByunionidGetRequest();
//        jd.union.open.promotion.byunionid.get.request.PromotionCodeReq promotionCodeReq = new jd.union.open.promotion.byunionid.get.request.PromotionCodeReq();
//        promotionCodeReq.setMaterialId(materialUrl);
//        promotionCodeReq.setUnionId(unionId);
//
//        request.setPromotionCodeReq(promotionCodeReq);
//        UnionOpenPromotionByunionidGetResponse response = client.execute(request);
//
//        return response;
//    }

    //订单查询
    public UnionOpenOrderQueryResponse orderQuery(OrderReq orderReq) throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenOrderQueryRequest unionOpenOrderQueryRequest = new UnionOpenOrderQueryRequest();
        unionOpenOrderQueryRequest.setOrderReq(orderReq);
        UnionOpenOrderQueryResponse response = client.execute(unionOpenOrderQueryRequest);
        return response;
    }

    //查询优惠券领取情况
    public UnionOpenCouponQueryResponse couponQuery(String CouponUrls) throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenCouponQueryRequest request = new UnionOpenCouponQueryRequest();
        request.setCouponUrls(new String[]{CouponUrls});
        UnionOpenCouponQueryResponse response = client.execute(request);
        return response;

    }

    //获得商品类目
    public UnionOpenCategoryGoodsGetResponse getGoodsCategory(int parentId, int grade) throws JdException {
        JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);
        UnionOpenCategoryGoodsGetRequest request = new UnionOpenCategoryGoodsGetRequest();
        CategoryReq categoryReq = new CategoryReq();
        categoryReq.setGrade(grade);
        categoryReq.setParentId(parentId);
        request.setReq(categoryReq);
        UnionOpenCategoryGoodsGetResponse response = client.execute(request);
        return response;
    }

    @Override
    public List<JdOrder> selectOrder(String merchantId, String beginTime, String endTime, String orderId) {
        long id=0l;
        Long beginDateNum=0l;
        Long endDateNum=0l;
        if(orderId!=null&&""!=orderId){
            id = Long.parseLong(orderId);
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate =null;
        Date endDate =null;
        try {
            if(beginTime!=null&&beginTime!=""){
                beginDate = format.parse(beginTime);
                beginDateNum=beginDate.getTime();
            }
            if(endTime!=null&&endTime!=""){
                endDate = format.parse(endTime);
                endDateNum=endDate.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jdOrderMapper.selectOrder(merchantId, beginDateNum, endDateNum, id);
    }

    @Override
    public List<JdSkuList> selectOrderSkuListByID(String orderId) {
        return jdSkuListMapper.selectOrderSkuListByID(Long.parseLong(orderId));
    }

    @Override
    public List<JdOrder> selectAgentOrder(String merchantId) {
        return jdOrderMapper.selectAgentOrder(merchantId);
    }

    @Override
    public List<JdOrder> getAgentOrder(String merchantId, String parentId, String beginTime, String endTime, String orderId) {
        long id=0l;
        Long beginDateNum=0l;
        Long endDateNum=0l;
        if(orderId!=null&&""!=orderId){
            id = Long.parseLong(orderId);
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate =null;
        Date endDate =null;
        try {
            if(beginTime!=null&&beginTime!=""){
                beginDate = format.parse(beginTime);
                beginDateNum=beginDate.getTime();
            }
            if(endTime!=null&&endTime!=""){
                endDate = format.parse(endTime);
                endDateNum=endDate.getTime();
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jdOrderMapper.getAgentOrder(merchantId,parentId,beginDateNum, endDateNum, id);
    }

}
