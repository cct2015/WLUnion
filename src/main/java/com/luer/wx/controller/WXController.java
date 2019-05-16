package com.luer.wx.controller;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.config.WechatOpenProperties;
import com.luer.wx.bean.MarketingMerchantWx;
import com.luer.wx.bean.Member;
import com.luer.wx.bean.WechatUser;
import com.luer.WxMsgCrypt.AesException;
import com.luer.WxMsgCrypt.PKCS7Encoder;
import com.luer.WxMsgCrypt.SHA1;
import com.luer.WxMsgCrypt.WXBizMsgCrypt;
import com.luer.WxMsgCrypt.AesException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.luer.wx.service.Iwxservice;

//import org.w3c.dom.Document;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


@Controller
@RequestMapping("/wx")
public class WXController {
    private static Logger log = LoggerFactory.getLogger(WXController.class);

    @Autowired
    Iwxservice wxservice;
    @Autowired
    private WechatOpenProperties wechatOpenProperties;

    //授权事件接收URL
    //http://www.wanglu163.com/accept
    //用于接收取消授权通知、授权成功通知、授权更新通知，也用于接收ticket，
    // ticket是验证平台方的重要凭据，服务方在获取component_access_token时需要提供最新推送的ticket
    // 以供验证身份合法性。此ticket作为验证服务方的重要凭据，请妥善保存。
    @RequestMapping(value = "/accept", method = {RequestMethod.POST})
    public void accept(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        String signature = request.getParameter("signature");
        String msgSignature = request.getParameter("msg_signature");
        String encType = request.getParameter("encrypt_type");

        if (!StringUtils.isNotBlank(msgSignature))
            return;
        if (!StringUtils.equalsIgnoreCase("aes", encType)
                || !wxservice.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader in = request.getReader();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        String xml = sb.toString();//原始 Xml
        ////////////////////////////////////////////////////////////
        xml = xml.replace("AppId", "ToUserName");
        WXBizMsgCrypt pc = new WXBizMsgCrypt(wechatOpenProperties.getComponentToken(), wechatOpenProperties.getComponentAesKey(), wechatOpenProperties.getComponentAppId());
        xml = pc.decryptMsg(msgSignature, timestamp, nonce, xml);
        processAuthorizationEvent(xml);
        output(response, "success");
    }

    private void processAuthorizationEvent(String xml) throws com.luer.WxMsgCrypt.AesException {
        Document doc;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String ticket = rootElt.elementText("ComponentVerifyTicket");
            if (ticket != null) {
                wxservice.setComponentVerifyTicket(ticket);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void output(HttpServletResponse response, String returnvaleue) {
        try {
            PrintWriter pw = response.getWriter();
            pw.write(returnvaleue);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //公众号消息与事件接收URL
    //http://www.wanglu163.com/$APPID$/acceptEvent
    //该URL用于接收已授权公众号的消息和事件，消息内容、消息格式、签名方式、加密方式与普通公众号接收的一致，
    // 唯一区别在于签名token和加密symmetric_key使用的是服务方申请时所填写的信息。由于消息具体内容不会变更，
    // 故根据消息内容里的ToUserName，服务方是可以区分出具体消息所属的公众号。
    @RequestMapping(value = "/{APPID}/acceptEvent", method = {RequestMethod.GET, RequestMethod.POST})
    public void acceptEvent(@PathVariable String APPID, HttpServletRequest request, HttpServletResponse response) {
        try {
            log.info(APPID + "进入acceptEvent+++++++++++++++++++++++++++++++++");
            wxservice.handleAcceptMessage(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //引导授权
    @RequestMapping(value = "/wxAuth")
    public void wxAu(HttpServletRequest request, HttpServletResponse response) {
        String ComponentAppId = wechatOpenProperties.getComponentAppId();
        String redirect_uri = wechatOpenProperties.getRedirect_uri();
        String pre_auth_code = wxservice.GetPrecode();
        if (pre_auth_code == null || pre_auth_code=="") {
            return;
        }
        String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=" + ComponentAppId + "&pre_auth_code=" + pre_auth_code + "&redirect_uri=" + redirect_uri + "";
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    //授权后回调
    //授权后回调URI，得到授权码（authorization_code）和过期时间
    @RequestMapping(value = "/authorCallback")
    public String authorCallback(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorization_code = request.getParameter("auth_code");
        String expires_in = request.getParameter("expires_in");

        //获得authorizer_refresh_token保存到数据库
        String merchantId = GetSysUser.getSysUser().getMerchantId();//从登陆信息中获得
        wxservice.insertWxInfo(authorization_code, merchantId);
        String pager = "templates/wx/getMember";
        return pager;
    }

    ////////统计会员////////
    //获得商户所有的会员
    @RequestMapping(value = "/getMemberCount", method = {RequestMethod.GET})
    @ResponseBody
    public ResultSet getMemberCount(HttpServletRequest request, HttpServletResponse response) {
        String merchantId = GetSysUser.getSysUser().getMerchantId();//从登陆信息中获得
        String res = wxservice.getMemberCount(merchantId);
        return ResultSet.getSuccess(new String(res));
    }

    //获得商户所有微信会员
    @RequestMapping(value = "/getWXMemberCount", method = {RequestMethod.GET})
    @ResponseBody
    public int getWXMemberCount(HttpServletRequest request, HttpServletResponse response) {
        String merchantId = GetSysUser.getSysUser().getMerchantId();//从登陆信息中获得
        return wxservice.getWXMemberCount(merchantId);
    }

    //获得当前公众号下的会员
//    @RequestMapping(value = "/getOneWXMemberCount", method = {RequestMethod.GET})
//    @ResponseBody
//    public int getCurrWXMemberCount(HttpServletRequest request, HttpServletResponse response)
//    {
//        return wxservice.getCurrWXMemberCount();
//    }

    //获得商户的所有公众号列表
    @RequestMapping(value = "/getMerchantWX", method = {RequestMethod.GET})
    @ResponseBody
    public List<MarketingMerchantWx> getMerchantWX(HttpServletRequest request, HttpServletResponse response) {
        String merchantId = GetSysUser.getSysUser().getMerchantId();//从登陆信息中获得
        List<MarketingMerchantWx> list = wxservice.getMerchantWX(merchantId);
        return list;
    }

    //封装一个公用的接口供网易调用，用于发信息，可以文字信息，可以图片，可以视频，可以混合
    //参见：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1481187827_i0l21
   // 参数JSONMessage格式：
    //{
    //    "touser":[
    //           "OPENID1",
    //           "OPENID2"
    //            ],
    //  "msgtype": "text",
    //       "text": { "content": "hello from boxer."}
    //  }
    // 参数appId：公众号的appID
    // 返回格式：
    //{
    //    "errcode":0,
    //       "errmsg":"send job submission success",
    //       "msg_id":34182,
    //        "msg_data_id": 206227730
    //}
    //接口访问路径：www.wanglu163.com/wx/sendWXMessage
    @RequestMapping(value = "/sendWXMessage", method = {RequestMethod.POST})
    @ResponseBody
    public String sendWXMessage(String JSONMessage,String appId)
    {
        return  wxservice.SendWXMessage(JSONMessage,appId);
//        if (res) {
//            return ResultSet.getSuccess(new String("发送成功"));
//        } else {
//            return ResultSet.getSuccess(new String("发送失败"));
//        }
    }

    //某个公众号接口调用次数的清零
    @RequestMapping(value = "/clearQuota", method = {RequestMethod.POST})
    @ResponseBody
    public ResultSet clearQuota(String appId) {
        boolean res = wxservice.clearQuota(appId);
        if (res) {
            return ResultSet.getSuccess(new String("清零成功"));
        } else {
            return ResultSet.getSuccess(new String("清零失败"));
        }

    }

    //导入公众号下会员
    @RequestMapping(value = "/importMember", method = RequestMethod.POST)
    @ResponseBody
    public ResultSet importMember(String appId) {

        String res = "";
        try {
            res = wxservice.importMember(appId);
        } catch (Exception ex) {
            res = ex.getMessage();
        }
        return ResultSet.getSuccess(new String(res.toString()));
    }

    //获得某个公众号详细信息
    @RequestMapping(value = "/getWXInfo", method = {RequestMethod.POST})
    @ResponseBody
    public WechatUser getWXInfo(String appId) {
        return wxservice.GetUserAccessInfo(appId);
    }

    @RequestMapping(value = "/QueryFanSum", method = {RequestMethod.POST})
    @ResponseBody
    public String  QueryFanSum(String appId)
    {
        return wxservice.QueryFanSum(appId);
    }

    ////////////////以下测试方法，以后删除///////////////////

    @RequestMapping(value = "/getTicket", method = {RequestMethod.POST})
    @ResponseBody
    public ResultSet getTicket() {
        String res = wxservice.getComponentVerifyTicket();
        return ResultSet.getSuccess(new String(res));
//        String msgSignature="418f73112ed7775020942487e8f98fe1a3fd97dd";
//        String    timestamp="1545390770";
//        String    nonce="1029289627";
//        String    xml="<xml>    <AppId><![CDATA[wx7acb3d2f0c05d7b5]]></AppId>    <Encrypt><![CDATA[QoHmPwgcnyh8bSfU7SdKe4Bzlwy7/OvIcAo/tgZqEirg9uOceLP2ftxhsWFUe/CJCCoQ4dj8+DQPPk3BjhMJ1SUpy8NMyfq450gNf35VLnfhEB4x7PYC5WKw51oj1r+CJ/uDUD0KJlg1L7Ua5/z7eF3DWike+sVzpMxkqrlZMU+kEMXi/V5ASlJToSqVrtFiEVF+2b9MqqTvl1W2iTGrLx4yKnEb01n4slay3pzpl6m3dPZZdstQmswzuY8K5wTxHYwIIa95OlBkknLYol1st6//JN8SLE9gzhbUbpf0OGgvfOA+xkWFJSo98H+1rFec3dt444e3QqfQgz2HgCrc1+2Ty8XjvAcnV42CtbHiHp7kYZeokqvP8V0J8WHf7luB/aHDHedsu0wx7fVXVCLNJH1cg6WVwPBTCdHSkEPFGyovDnjBeO7Snj9Wu/3hyqIWTJUuRr9gpItaUY3noWmuZw==]]></Encrypt></xml>";
//        xml=xml.replace("AppId","ToUserName");
//       // String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
//        try {
//            WXBizMsgCrypt pc = new WXBizMsgCrypt(wechatOpenProperties.getComponentToken(), wechatOpenProperties.getComponentAesKey(), wechatOpenProperties.getComponentAppId());
//            String xmlStr = pc.decryptMsg(msgSignature, timestamp, nonce, xml);
//            xmlStr=xmlStr.replace("AppId","ToUserName");
//            //<xml><AppId><![CDATA[wx7acb3d2f0c05d7b5]]></AppId>
//            //<CreateTime>1545390770</CreateTime>
//            //<InfoType><![CDATA[component_verify_ticket]]></InfoType>
//            //<ComponentVerifyTicket><![CDATA[ticket@@@wgndnb-HpQWbSHRpLrtLJEgFvWcbocDN7QaZinS3ergjHDBA82QZLIFzX3RDQbr8FKQNPxF4E2BzxvwBUCGUtQ]]></ComponentVerifyTicket>
//            //</xml>
//          //  processAuthorizationEvent(xmlStr);
//            String res = wxservice.getComponentVerifyTicket();
//            return ResultSet.getSuccess(res);
//        }
//        catch(Exception ex)
//        {
//            return ResultSet.getSuccess(ex.toString());
//        }
    }

    @RequestMapping(value = "/getComponentAccessToken", method = {RequestMethod.GET})
    @ResponseBody
    public ResultSet getComponentAccessToken() {

        String res = wxservice.getWxComponentAccessToken();
        return ResultSet.getSuccess(new String(res));
    }

    @RequestMapping(value = "/getWXAuthorizerAccessToken", method = {RequestMethod.GET})
    @ResponseBody
    public ResultSet getWXAuthorizerAccessToken() {
        String res = wxservice.getWXAuthorizerAccessToken();
        return ResultSet.getSuccess(new String(res));
    }

    @RequestMapping(value = "/getAccessToken", method = {RequestMethod.POST})
    @ResponseBody
    public ResultSet getAccessToken(String appId) {
        String res = wxservice.refreshAuthorizerAccessToken(appId);
        return ResultSet.getSuccess(new String(res));
    }



//    @RequestMapping(value = "/getMember",method = {RequestMethod.POST})
//    @ResponseBody
//    public int getMember(HttpServletRequest request, HttpServletResponse response) {
//        return wxservice.getMember();
//    }

}



