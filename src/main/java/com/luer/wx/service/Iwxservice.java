package com.luer.wx.service;

import com.luer.comm.enums.msgtypeEnum;
import com.luer.wx.bean.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface Iwxservice {
    String getWxComponentAccessToken();

    void handleAcceptMessage(HttpServletRequest request, HttpServletResponse response);

    String GetPrecode();

    boolean checkSignature(String timestamp, String nonce, String signature);

    String getComponentVerifyTicket();

    WechatUser GetUserAccessInfo(String appId);

    void setComponentVerifyTicket(String ComponentVerifyTicket);

    String getWXAuthorizerAccessToken();

    int wxInfoSetting(String appid, String merchantId, String authorizerRefreshToken);

    void insertWxInfo(String authorization_code, String merchantId);

    //获得商户所有的会员
    String getMemberCount(String marchantId);

    //获得商户所有微信公众号下的会员
    int getWXMemberCount(String marchantId);

    //获得某一个公众号下的会员
    int getOneWXMemberCount(String appId);

    //获得当前公众号下的会员
    // int getCurrWXMemberCount();
    String importMember(String appId) throws Exception;

    //获得某个商户的公众号列表
    List<MarketingMerchantWx> getMerchantWX(String marchantId);
     String refreshAuthorizerAccessToken(String appId);
     //发消息
     String SendWXMessage(String JSONMessage,String appId);
      //某个公众号接口调用次数的清零
      boolean clearQuota(String appId);
     //String getAccessToken();
     String SendMessage(List<String> Openids, msgtypeEnum msgtype, MessageOb messageob, String appId);

     //获得某个公众号下所有标签（群）
    //List<wxTag>
     String getwxTagList(String appId,String token);

     //创建标签
     String createTag(String appId,String token,String name);
    //为用户批量打标签
    String batchtagging(String[] openIds,String appId,int tagid,String token);

    //为用户取消标签
    String  batchuntagging(String[] openIds,String appId,int tagid,String token);
    /////////测试方法以后删除/////////////
     String getTicket();

     //获得某公众号下的关注者数据
     String  QueryFanSum(String appId);
}
