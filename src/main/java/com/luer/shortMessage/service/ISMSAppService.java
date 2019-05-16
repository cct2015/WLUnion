package com.luer.shortMessage.service;

import com.luer.comm.bean.NameValue;
import com.luer.shortMessage.bean.SMSApp;
import com.luer.shortMessage.bean.SMSHeader;

import java.util.List;

public interface ISMSAppService {

     int updateSMSAppInfo(SMSApp en);
     List<NameValue> getHeaderList(String merchantId);
}
