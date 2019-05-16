package com.luer.shortMessage.service.impl;

import com.luer.comm.bean.NameValue;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.MD5Utils;
import com.luer.config.WechatOpenProperties;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.shortMessage.bean.SMSApp;
import com.luer.shortMessage.bean.SMSHeader;
import com.luer.shortMessage.service.ISMSAppService;
import com.luer.shortMessage.service.ShortMessageService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SMSAppService implements ISMSAppService {

    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @Autowired
    private ShortMessageService shortMessageService;

    @Override
    public List<NameValue> getHeaderList(String merchantId) {
        List<NameValue> headerList = new ArrayList<>();
        SMSApp sMSApp = marketingMerchantMapper.getSMSApp(merchantId);
        if (sMSApp == null || sMSApp.getAppKey() == null) {
            return headerList;
        }
        MarketingMerchant marketingMerchant = marketingMerchantMapper.selectByPrimaryKey(merchantId);
        if (sMSApp.getAppKey() == null || "".equals(sMSApp.getAppKey())) {
            shortMessageService.appCreate(marketingMerchant.getCompanyShort(), marketingMerchant.getCompanyName(), 10002L);
            sMSApp = marketingMerchantMapper.getSMSApp(merchantId);
        }
        System.out.println("sMSApp=====应用信息=====" + sMSApp);
        // String apikey=wechatOpenProperties.getApikey();
        String apikey = "0a9UgPEim26dDxN2gDUm4mYuUZEar6xZ";

        NameValue item = new NameValue();
        item.setName("apikey");
        item.setValue(apikey);
        headerList.add(item);

        item = new NameValue();
        item.setName("appId");
        item.setValue(sMSApp.getAppId());
        headerList.add(item);
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String checksum = DigestUtils.md5Hex(String.format("%s%s%s", sMSApp.getAppSecret(), timeStamp, sMSApp.getAppKey()));

        item = new NameValue();
        item.setName("checksum");
        item.setValue(checksum);
        headerList.add(item);

        item = new NameValue();
        item.setName("timestamp");
        item.setValue(timeStamp);
        headerList.add(item);

        return headerList;
    }

    @Override
    public int updateSMSAppInfo(SMSApp en) {
        return marketingMerchantMapper.updateSMSAppInfo(en);
    }
}
