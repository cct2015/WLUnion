package com.luer.JD.service.impl;

import com.jd.open.api.sdk.JdException;
import com.luer.JD.bean.JdOrder;
import com.luer.JD.bean.JdSkuList;
import com.luer.JD.dao.JdOrderMapper;
import com.luer.JD.dao.JdSkuListMapper;
import com.luer.JD.service.IJDOrderService;
import com.luer.JD.service.IJDservice;
import jd.union.open.order.query.request.OrderReq;
import jd.union.open.order.query.response.OrderResp;
import jd.union.open.order.query.response.SkuInfo;
import jd.union.open.order.query.response.UnionOpenOrderQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class JDOrderServiceImpl implements IJDOrderService {

    @Autowired
    private JdOrderMapper jdOrderMapper;
    @Autowired
    private JdSkuListMapper jdSkuListMapper;

    @Autowired
    private IJDservice iJDservice;

    //每小时的0分0秒开始执行
    @Scheduled(cron = "0 0 * * * *")
    @Transactional
    public void orderInsert() throws JdException {
        Calendar calendar = Calendar.getInstance();
        OrderReq orderReq = new OrderReq();
        orderReq.setPageNo(1);
        orderReq.setPageSize(20);
        orderReq.setType(1);
        int hour = 0;
        int year = 0;
        int month = 0;
        int day = 0;
        String monthStr = "";
        String dayStr = "";
        String TimeStr = "";
        List<JdOrder> jdOrderList = new ArrayList<>();//主表内容
        List<JdSkuList> jdSkuListList = new ArrayList<>();//子表内容
        int count = 24 * 31;
        for (int i = 0; i < count; i++) {
            if (i != 0) {
                calendar.add(Calendar.HOUR, -1);
            }
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            monthStr = "0" + String.valueOf(month);
            monthStr = monthStr.substring(monthStr.length() - 2);

            day = calendar.get(Calendar.DATE);
            dayStr = "0" + String.valueOf(day);
            dayStr = dayStr.substring(dayStr.length() - 2);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            TimeStr = String.valueOf(year) + monthStr + dayStr + String.valueOf(hour);
            ////////////////////////////////////////
            orderReq.setTime(TimeStr);
            UnionOpenOrderQueryResponse response = iJDservice.orderQuery(orderReq);
            if (response != null) {
                OrderResp[] OrderResp = response.getData();
                if (OrderResp != null && OrderResp.length > 0) {

                    SkuInfo[] skuInfos = null;
                    JdOrder jdOrder = null;
                    JdSkuList jdSkuList = null;

                    for (OrderResp resp : OrderResp) {
                        jdOrder = new JdOrder();
                        jdOrder.setOrderId(resp.getOrderId());
                        jdOrder.setFinishTime(resp.getFinishTime());
                        jdOrder.setOrderEmt(resp.getOrderEmt());
                        jdOrder.setOrderTime(resp.getOrderTime());
                        jdOrder.setParentId(resp.getParentId());
                        jdOrder.setPayMonth(resp.getPayMonth());
                        jdOrder.setPlus(resp.getPlus());
                        jdOrder.setPopId(resp.getPopId());
                        jdOrder.setUnionId(resp.getUnionId());
                        jdOrder.setExt1(resp.getExt1());
                        jdOrder.setValidCode(resp.getValidCode());
                        jdOrder.setHasMore("false");
                        jdOrderList.add(jdOrder);

                        skuInfos = resp.getSkuList();
                        Long orderid = resp.getOrderId();
                        //子表
                        for (SkuInfo skuInfo : skuInfos) {
                            jdSkuList = new JdSkuList();
                            jdSkuList.setOrderId(orderid);
                            jdSkuList.setSkuId(skuInfo.getSkuId());
                            jdSkuList.setActualCosPrice(skuInfo.getActualCosPrice());
                            jdSkuList.setActualFee(skuInfo.getActualFee());
                            jdSkuList.setCommissionRate(skuInfo.getCommissionRate());
                            jdSkuList.setEstimateCosPrice(skuInfo.getEstimateCosPrice());
                            jdSkuList.setEstimateFee(skuInfo.getEstimateFee());
                            jdSkuList.setFinalRate(skuInfo.getFinalRate());
                            jdSkuList.setCid1(skuInfo.getCid1());
                            jdSkuList.setFrozenSkuNum(skuInfo.getFrozenSkuNum());
                            jdSkuList.setPid(skuInfo.getPid());
                            jdSkuList.setPositionId(skuInfo.getPositionId());
                            jdSkuList.setPrice(skuInfo.getPrice());
                            jdSkuList.setCid2(skuInfo.getCid2());
                            jdSkuList.setSiteId(skuInfo.getSiteId());
                            jdSkuList.setSkuName(skuInfo.getSkuName());
                            jdSkuList.setSkuNum(skuInfo.getSkuNum());
                            jdSkuList.setSkuReturnNum(skuInfo.getSkuReturnNum());
                            jdSkuList.setSubSideRate(skuInfo.getSubSideRate());
                            jdSkuList.setSubsidyRate(skuInfo.getSubsidyRate());
                            jdSkuList.setCid3(skuInfo.getCid3());
                            jdSkuList.setUnionAlias(skuInfo.getUnionAlias());
                            jdSkuList.setUnionTag(skuInfo.getUnionTag());
                            jdSkuList.setUnionTrafficGroup(skuInfo.getUnionTrafficGroup());
                            jdSkuList.setValidCode(skuInfo.getValidCode());
                            jdSkuList.setSubUnionId(skuInfo.getSubUnionId());
                            jdSkuList.setTraceType(skuInfo.getTraceType());
                            jdSkuList.setPayMonth(skuInfo.getPayMonth());
                            jdSkuList.setPopId(skuInfo.getPopId());
                            jdSkuList.setExt1(skuInfo.getExt1());
                            jdSkuListList.add(jdSkuList);
                        }
                    }

                }

            }

        }
        //最后插入
        if (jdOrderList.size() > 0) {
            int res1 = jdOrderMapper.orderListInsert(jdOrderList);
        }
        if (jdSkuListList.size() > 0) {
            int res2 = jdSkuListMapper.skulistInsert(jdSkuListList);
        }

    }
}



