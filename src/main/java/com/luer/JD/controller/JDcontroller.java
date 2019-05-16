package com.luer.JD.controller;

import com.alibaba.fastjson.JSONObject;
import com.jd.open.api.sdk.JdException;
import com.luer.JD.bean.GoodInformation;
import com.luer.JD.bean.JdOrder;
import com.luer.JD.bean.JdSkuList;
import com.luer.JD.bean.OrderData;
import com.luer.JD.service.IJDOrderService;
import com.luer.JD.service.IJDservice;
import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.sys.bean.SysQa;
import jd.union.open.category.goods.get.response.UnionOpenCategoryGoodsGetResponse;
import jd.union.open.coupon.query.response.UnionOpenCouponQueryResponse;
import jd.union.open.goods.jingfen.query.response.UnionOpenGoodsJingfenQueryResponse;
import jd.union.open.goods.promotiongoodsinfo.query.response.UnionOpenGoodsPromotiongoodsinfoQueryResponse;
import jd.union.open.goods.query.request.GoodsReq;
import jd.union.open.goods.query.response.UnionOpenGoodsQueryResponse;
import jd.union.open.order.query.request.OrderReq;
import jd.union.open.order.query.response.OrderResp;
import jd.union.open.order.query.response.SkuInfo;
import jd.union.open.order.query.response.UnionOpenOrderQueryResponse;
import jd.union.open.promotion.bysubunionid.get.response.UnionOpenPromotionBysubunionidGetResponse;
import jd.union.open.promotion.byunionid.get.response.UnionOpenPromotionByunionidGetResponse;
import jd.union.open.promotion.common.get.response.UnionOpenPromotionCommonGetResponse;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@RequestMapping("/JD")
@Controller
public class JDcontroller {
    @Autowired
    private IJDservice ijDservice;
    @Autowired
    private IJDOrderService jDOrderService;

    //精粉商品查询
    @RequestMapping(value = "/JFgoodsQuery", produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenGoodsJingfenQueryResponse JFgoodsQuery() throws JdException {
        return ijDservice.JFgoodsQuery();
    }

    //关键字商品查询
    @RequestMapping(value = "/goodsQuery",produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenGoodsQueryResponse goodsQuery(GoodsReq goodsReq) throws JdException {
       // GoodsReq goodsReq=new GoodsReq();
       // goodsReq.setIsCoupon(1);
       // goodsReq.setPageSize(1);
        UnionOpenGoodsQueryResponse res=ijDservice.goodsQuery(goodsReq);
        return res;
    }

    //查询某个商品的详细信息
    @RequestMapping(value = "/goodsInfoQuery",produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenGoodsPromotiongoodsinfoQueryResponse goodsInfoQuery(long id) throws JdException {
        return ijDservice.goodsinfoQuery(id);
    }

    // 通过subUnionId获取推广链接
    @RequestMapping(value = "/getURLBysubunionid", produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenPromotionBysubunionidGetResponse getURLBysubunionid(String materialUrl, String subUnionId, String couponUrl) throws JdException {
        //这里的subUnionId是终极推广方的ID
        return ijDservice.getURLBysubunionid(materialUrl, subUnionId, couponUrl);
    }

    //通过unionId获取推广链接
//    @RequestMapping(value = "/getUrlByunionid")
//    @ResponseBody
//    public UnionOpenPromotionByunionidGetResponse getUrlByunionid(String materialUrl, String unionId,String subUnionId) throws JdException {
//        return ijDservice.getUrlByunionid(materialUrl, unionId,subUnionId);
//    }

    //获得商品通用的推广链接
    @RequestMapping(value = "/commonGetURL", method = {RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenPromotionCommonGetResponse commonGetURL(GoodInformation goodInformation) throws JdException {
        return ijDservice.commonGetURL(goodInformation);
    }
    //订单查询
    @RequestMapping(value = "/orderQuery", produces = "application/json;charset=utf-8")
    @ResponseBody
    public JqgridResponse<OrderData> orderQuery(JqgridFilter filter) throws JdException {
        OrderReq orderReq = new OrderReq();
        orderReq.setPageNo(filter.getPage());
        orderReq.setPageSize(20);
        orderReq.setType(1);
        orderReq.setTime("2019041916");
        UnionOpenOrderQueryResponse response = ijDservice.orderQuery(orderReq);
        OrderResp[] orderRespArray=response.getData();
        SkuInfo[] skuList;
        List<OrderResp> list = Arrays.asList(orderRespArray);
        List<OrderData> orderlist=new ArrayList<>();
        OrderData order=null;
        Double Allmoney=0.0;
        Double AllestimateCommission=0.0;
        for(OrderResp resOrder :list)
        {
             order=new OrderData();
             skuList=resOrder.getSkuList();
             Allmoney=0.0;
             AllestimateCommission=0.0;
             for(SkuInfo skuInfo:skuList)
             {
                 Allmoney=Allmoney+skuInfo.getEstimateCosPrice()*skuInfo.getSkuNum();
                 AllestimateCommission=AllestimateCommission+skuInfo.getEstimateFee()*skuInfo.getSkuNum();
             }
             order.setMoney(Allmoney);
             order.setEstimateCommission(AllestimateCommission);
             order.setSkuRealList(JSONObject.toJSONString(skuList));
             order.setFinishTime(resOrder.getFinishTime());
             order.setOrderEmt(resOrder.getOrderEmt());
             order.setOrderId(resOrder.getOrderId());
             order.setOrderTime(resOrder.getOrderTime());
             order.setParentId(resOrder.getParentId());
             order.setPayMonth(resOrder.getPayMonth());
             order.setPlus(resOrder.getPlus());
             order.setPopId(resOrder.getPopId());
             order.setSkuList(resOrder.getSkuList());
             order.setUnionId(resOrder.getUnionId());
             order.setExt1(resOrder.getExt1());
             order.setValidCode(resOrder.getValidCode());
             orderlist.add(order);
        }
        return JqgridResponseContext.getJqgridResponse(filter, orderlist);
    }
    //定时任务测试
    @RequestMapping(value = "/orderQueryTest", produces = "application/json;charset=utf-8")
    @ResponseBody
    public void orderInsert() throws JdException {
        jDOrderService.orderInsert();
   }

    //优惠券领取情况查询
    @RequestMapping(value = "/couponQuery", produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenCouponQueryResponse couponQuery(String CouponUrls) throws JdException {
        return ijDservice.couponQuery(CouponUrls);
    }


    //获得商品类目
    @RequestMapping(value = "/getGoodsCategory", produces = "application/json;charset=utf-8")
    @ResponseBody
    public UnionOpenCategoryGoodsGetResponse getGoodsCategory(int parentId, int grade) throws JdException {
        return ijDservice.getGoodsCategory(parentId, grade);
    }
    //订单查询
    @ResponseBody
    @RequestMapping("/selectOrder")
    public JqgridResponse<JdOrder> selectOrder(JqgridFilter filter, @Param("merchantId") String merchantId, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("orderId") String orderId) {
        filter.refresh();
        List<JdOrder> jdOrders=ijDservice.selectOrder(merchantId,beginTime,endTime,orderId);
        return JqgridResponseContext.getJqgridResponse(filter,jdOrders);
    }

    //渠道商订单初始化
    @ResponseBody
    @RequestMapping("/selectAgentOrder")
    public JqgridResponse<JdOrder> selectAgentOrder(JqgridFilter filter, @Param("merchantId") String merchantId) {
        filter.refresh();
        List<JdOrder> jdOrders=ijDservice.selectAgentOrder(merchantId);
        return JqgridResponseContext.getJqgridResponse(filter,jdOrders);
    }
    //渠道商订单查询
    @ResponseBody
    @RequestMapping("/getAgentOrder")
    public JqgridResponse<JdOrder> getAgentOrder(JqgridFilter filter, @Param("merchantId") String merchantId, @Param("parentId") String parentId,@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("orderId") String orderId) {
        filter.refresh();
        List<JdOrder> jdOrders=ijDservice.getAgentOrder(merchantId,parentId,beginTime,endTime,orderId);
        return JqgridResponseContext.getJqgridResponse(filter,jdOrders);
    }
    //获取订单商品明细查询
    @ResponseBody
    @RequestMapping("/selectOrderSkuListByID")
    public JqgridResponse<JdSkuList> selectOrderSkuListByID(JqgridFilter filter,@Param("orderId") String orderId) {
        filter.refresh();
        List<JdSkuList> jdSkuLists=ijDservice.selectOrderSkuListByID(orderId);
        return JqgridResponseContext.getJqgridResponse(filter,jdSkuLists);
    }
}
