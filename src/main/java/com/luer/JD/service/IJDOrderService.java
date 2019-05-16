package com.luer.JD.service;

import com.jd.open.api.sdk.JdException;
import com.luer.JD.bean.JdOrder;
import com.luer.JD.bean.JdSkuList;
import jd.union.open.order.query.response.UnionOpenOrderQueryResponse;

import java.util.List;

public  interface IJDOrderService {

    void orderInsert() throws JdException;
}
