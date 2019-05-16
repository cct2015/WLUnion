package com.luer.WLapi.service;

import com.luer.WLapi.bean.DataEn;
import com.luer.WLapi.bean.OutMessage;
import com.luer.comm.bean.ResultSet;

public interface IWLapiService {

    OutMessage insertPhones(String[] phones,String merchantId,String code);

    OutMessage importData(DataEn en);

    ResultSet queryOrder(DataEn en);
}
