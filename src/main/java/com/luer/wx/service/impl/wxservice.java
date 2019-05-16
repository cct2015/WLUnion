package com.luer.wx.service.impl;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
import com.luer.WxMsgCrypt.AesException;
import com.luer.comm.constants.RedisConstant;
import com.luer.comm.enums.msgtypeEnum;
import com.luer.comm.utils.*;
import com.luer.comm.bean.NameValue;
import com.luer.comm.enums.SourceEnum;
import com.luer.comm.enums.StatusEnum;
import com.luer.config.WechatOpenProperties;
import com.luer.membershipManage.dao.MarketingMemberMapper;
import com.luer.wx.bean.*;
import com.luer.wx.controller.WXController;
import com.luer.wx.dao.MarketingMerchantWxMapper;
import com.luer.wx.service.Iwxservice;
import com.luer.wx.service.SHA1;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.*;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.luer.WxMsgCrypt.WXBizMsgCrypt;

import static org.aspectj.bridge.MessageUtil.info;

@Service
public class wxservice implements Iwxservice {
    private static Logger log = LoggerFactory.getLogger(WXController.class);

    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @Autowired
    private MarketingMemberMapper marketingMemberMapper;
    @Autowired
    private MarketingMerchantWxMapper marketingMerchantWxMapper;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    RedisUtils redisUtils;
    public String getComponentVerifyTicket() {
        ServletContext application = webApplicationContext.getServletContext();
        if (application.getAttribute("VerifyTicketMap") != null) {
            return application.getAttribute("VerifyTicketMap").toString();
        }
        else {
                String ComponentVerifyTicket=(String)redisUtils.get(RedisConstant.WXTicket);
                application.setAttribute("VerifyTicketMap", ComponentVerifyTicket);
                return ComponentVerifyTicket;

        }
    }


    //设置ComponentVerifyTicket
    public void setComponentVerifyTicket(String ComponentVerifyTicket) {
        ServletContext application = webApplicationContext.getServletContext();
       // if (application.getAttribute("VerifyTicketMap") == null || "".equals(application.getAttribute("VerifyTicketMap").toString())) {
            application.setAttribute("VerifyTicketMap", ComponentVerifyTicket);
            redisUtils.set(RedisConstant.WXTicket,ComponentVerifyTicket);
      //  }
      //  else
      //  {
       //     application.setAttribute("VerifyTicketMap", ComponentVerifyTicket);
       // }
    }

    //2、获得平台令牌
    public String getWxComponentAccessToken() {

//        ServletContext application = webApplicationContext.getServletContext();
//        if (application.getAttribute("componentAccessTokenMap") != null) {
//            WeixinAccessToken tempToken = (WeixinAccessToken) application.getAttribute("componentAccessTokenMap");
//            if (System.currentTimeMillis() > tempToken.getExpirationTime())
//            {
//                return tempToken.getAccessToken();
//            }
//            else
//                {
//                return getComponentAccessToken();
//            }
//        } else {
            return getComponentAccessToken();
    //    }
    }

    //获得第三方平台的ComponentAccessToken（不是第三方用户）
    private String getComponentAccessToken() {
        ServletContext application = webApplicationContext.getServletContext();
        JSONObject json = new JSONObject();
        json.put("component_appid", wechatOpenProperties.getComponentAppId());
        json.put("component_appsecret", wechatOpenProperties.getComponentSecret());
        String ComponentVerifyTicket = getComponentVerifyTicket();
        if ("".equals(ComponentVerifyTicket) || ComponentVerifyTicket == null)
            return "";
        json.put("component_verify_ticket", ComponentVerifyTicket);
        String Url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
        // {"component_access_token":"61W3mEpU66027wgNZ_MhGHNQDHnFATkDa9-2llqrMBjUwxRSNPbVsMmyD-yq8wZETSoE5NQgecigDrSHkPtIYA", "expires_in":7200}
        String res = HttpUtil.post(Url, json.toString());

        //{"component_access_token":"16_hnBPuqcJKXN_bilc8EOWn2cy1R7F_FWCkyIxQZam1sYGLcV7kHQcJ5rId92gBEM1MdeGypPMN7NNJ37SPomgQgdO5X5NkzBvZs5iFmw7CBBRTpyiznwdcHcSsegxlQ1YUjhcStSjr8XZhhxEDPGeABAVHY","expires_in":7200}
        JSONObject obj = JSONObject.fromObject(res);
        if (obj.containsKey("component_access_token")) {
            if (obj.get("component_access_token") != null && !obj.get("component_access_token").equals("")) {
                application.setAttribute("componentAccessTokenMap", new WeixinAccessToken(obj.get("component_access_token").toString(),
                        System.currentTimeMillis() + Integer.parseInt(obj.get("expires_in").toString()) - 5));
                return obj.get("component_access_token").toString();
            }
        }
        return null;
    }

//    //获得第三方用户的access_token(不是第三方平台的)
//    @Override
//    public String getAccessToken() {
//        String APPID=wechatOpenProperties.getComponentAppId();
//        String APPSECRET=wechatOpenProperties.getComponentSecret();
//        String Url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET+"";
//        JSONObject obj = HttpUtil.get(Url,null);
//        if (obj.containsKey("access_token")) {
//            return obj.get("access_token").toString();
//        }
//        return null;
//    }
    //3、获得预授权码
    public String GetPrecode() {
        String component_access_token = getWxComponentAccessToken();
        if (component_access_token != null) {
            JSONObject json = new JSONObject();
            json.put("component_appid", wechatOpenProperties.getComponentAppId());
            String url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=" + component_access_token + "";
            String res = HttpUtil.post(url, json.toString());
            JSONObject obj = JSONObject.fromObject(res);
            log.info(obj.toString());
            return obj.get("pre_auth_code").toString();
        } else {
            log.info("没拿到component_access_token");
            return null;
        }
    }

    //获得某个微信公众号的授权令牌
    public String getWXAuthorizerAccessToken() {
        ServletContext application = webApplicationContext.getServletContext();
        if (application.getAttribute("authorizerAccessTokenMap") != null || !"".equals(application.getAttribute("authorizerAccessTokenMap"))) {
            WeixinAccessToken tempToken = (WeixinAccessToken) application.getAttribute("authorizerAccessTokenMap");
            if (System.currentTimeMillis() > tempToken.getExpirationTime()) {
                return tempToken.getAccessToken();
            } else {
                String authorizer_appid = application.getAttribute("authorizerAppid").toString();
                return refreshAuthorizerAccessToken(authorizer_appid);
            }
        } else {
            String authorizer_appid = application.getAttribute("authorizerAppid").toString();
            return refreshAuthorizerAccessToken(authorizer_appid);
        }
    }

    public String refreshAuthorizerAccessToken(String authorizer_appid) {
        String component_access_token = getComponentAccessToken();
        String Url = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=" + component_access_token + "";
//       {
//           "component_appid":"appid_value",
//               "authorizer_appid":"auth_appid_value",
//               "authorizer_refresh_token":"refresh_token_value",
//       }
        String authorizer_refresh_token = getAuthorizerRefreshToken(authorizer_appid);
        JSONObject json = new JSONObject();
        json.put("component_appid", wechatOpenProperties.getComponentAppId());
        json.put("authorizer_appid", authorizer_appid);
        json.put("authorizer_refresh_token", authorizer_refresh_token);
        String res = HttpUtil.post(Url, json.toString());
        //  String res="{\"authorizer_access_token\":\"16_6V8WJ3f8vbUcHklIsCLgVDFIftaU08Texufwh2gkdkmvrcodGeWhOtqWXqnPnWYrVXg2HY1pvu3WV0xWoCTL3l3vdVk2rJ2YrbCfFotbmb8Uao0J96kfjnHc1d_vsJ9Mz7urOataes8HHCW_REPeAJDERC\",\"expires_in\":7200,\"authorizer_refresh_token\":\"refreshtoken@@@PyZeMyoWYw6RprXrcHpbrFG-iQl4EsyKVLiNHjb9TvE\"}";
        JSONObject obj = JSONObject.fromObject(res);
        if (obj.get("authorizer_access_token") != null) {
            ServletContext application = webApplicationContext.getServletContext();
            application.setAttribute("authorizerAccessTokenMap", new WeixinAccessToken(obj.get("authorizer_access_token").toString(),
                    System.currentTimeMillis() + Integer.parseInt(obj.get("expires_in").toString()) - 5));
            // authorizer_refresh_token
            // 授权方的刷新令牌，刷新令牌主要用于第三方平台获取和刷新已授权用户的access_token，
            // 只会在授权时刻提供，请妥善保存。一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
            UpdateWxInfoSetting(authorizer_appid, obj.get("authorizer_refresh_token").toString());
            application.setAttribute("authorizerAppid", authorizer_appid);
            return obj.get("authorizer_access_token").toString();
        } else {
            return "NO refreshtoken";
        }
    }

    public boolean checkSignature(String timestamp, String nonce, String signature) {
        try {
            return SHA1.gen(new String[]{this.wechatOpenProperties.getComponentToken(), timestamp, nonce}).equals(signature);
        } catch (Exception var5) {
            System.out.println("Checking signature failed, and the reason is :" + var5.getMessage());
            return false;
        }
    }
    ///////////////以下是获得会员///////////////
    //导入微信公众号会员 返回导入的数目

    public String importMember(String appId) throws Exception {
        String access_token = refreshAuthorizerAccessToken(appId);
//        List<Member> memberList = new ArrayList<Member>();
//        Member member = null;
//        String openidstr="[\"oVD541Mk8slt42c5Ie3sqjikBs7I\",\"oVD541BFHornV8t4EaBMpqwug3Tk\",\"oVD541FyKxGf5-H0lXvwI9FJWHsU\",\"oVD541PLPgV5V22jWR6WAlgEpiXw\",\"oVD541N3JIZJUtf9vxyXw956IP9k\",\"oVD541Hb08MPJSz0cbn2PmZtvwJg\",\"oVD541CiRq5tV6ORDvj0KcVgOuNQ\",\"oVD541KXYlmNexj-RVOIgcBwOHGY\",\"oVD541MccpwkMzrY-YcaZaj9_-xg\",\"oVD541PSZHQQfnJ_MgcVprQgRERw\",\"oVD541HjUVJryQ7VxtBS1kjpVe04\",\"oVD541Jv91nhSIMa8m3uSnJ7q81Y\",\"oVD541J9IPTonVb3xZtaaT3hlZ0Y\",\"oVD541KJdc8sWX0UbmacZrn13ap4\",\"oVD541AS4Tkxr-grHaGtHx0kz6tg\",\"oVD541Fzutv2KrPECVk823sTS1O0\",\"oVD541DupYVgCkHHnHvIeLcGe-mg\",\"oVD541OS387aSO4yQ_szQjLe0tQ4\",\"oVD541DMEU0wL4_sb0EIxf4G89b4\",\"oVD541ORo4JwuaTMzjgFLu3NMzF4\",\"oVD541C2Aeh-fSl3__2PIdvBq8oE\",\"oVD541MKvOe0NZSaHA6hSfqsEj-4\"]";
//        JSONArray openids = JSONArray.parseArray(openidstr);
//
//        for (int i = 0; i < openids.size(); i++) {
//            String openid =openids.getString(i) ;
//            String card_id = "pVD541Gl-hkZt2qyKw_tqh9ybpF8";
//            String code = getReceiveCardCode(access_token,openid,card_id);
//            if (!"".equals(code) && code!=null) {
//                member = new Member();
//                member.setOpenId(openid);
//                member.setCardId(card_id);
//                member.setCode(code);
//                memberList.add(member);
//            }
//        }


        String loginMerchantId= GetSysUser.getSysUser().getMerchantId();
        String loginUser= GetSysUser.getSysUser().getUsername();
        //1、所有已经发的卡券
        //cardid="pbkV10to7gsPP0pASnC5zUdCENs"
       // {"errcode":0,"errmsg":"ok","card_id_list":["pbkV10to7gsPP0pASnC5zUdCENs0"],"total_num":1,"card_list":[]}
        com.alibaba.fastjson.JSONArray getCompleteCards = getCompleteCards(access_token);

        if (getCompleteCards == null || getCompleteCards.size() == 0)
            return "0";
        int total = 0;
        int memberTotal = 0;
        int timesTotal = 0;
        int timesCount = 0;
        String next_openid = "";
        String openid = "";
        String card_id = "";
        String code = "";
        Member member = null;
        com.alibaba.fastjson.JSONArray openids;
        int res = 0;
//
////       do {
//            //2、获得关注者
        openids = getUsers(access_token, next_openid, total, timesCount);
//            if (openids == null || openids.size()==0)
//                break;
//            next_openid=openids.get(openids.size()-1).toString();
//            timesTotal+=timesCount;
//
//            //3、获取用户已经领的卡券
        List<Member> memberList = new ArrayList<Member>();
        for (int i = 0; i < openids.size(); i++) {
            openid = openids.getString(i);
            for (int j = 0; j < getCompleteCards.size(); j++) {
                card_id = getCompleteCards.get(j).toString();
                code = getReceiveCardCode(access_token, openid, card_id);
                if (!"".equals(code) && code != null) {
                    member = new Member();
                    member.setOpenId(openid);
                    member.setCardId(card_id);
                    member.setCode(code);
                    memberList.add(member);
                }
            }
        }

//            //4、拉取会员手机号
//            if (memberList.size() > 0) {
        String phone = "";
        List<Member> resmemberList = new ArrayList<Member>();
        String phoneStr="";
        for (Member mb : memberList) {
            phone = getMemberInfo(access_token, mb.getCardId(), mb.getCode());
          //  phoneStr+=";|phone:"+phone+"|cardId:"+mb.getCardId()+"|code:"+mb.getCode();
            if (!"".equals(phone.trim()) && phone != null) {

                mb.setId(UuidUtils.getUUID());
                mb.setPhone(MD5Utils.encryption(phone.trim()));
                mb.setAppId(appId);
                mb.setAddTime(new Date());
                mb.setMerchantId(loginMerchantId);
                mb.setStatus(StatusEnum.NORMAL.getValue());
                mb.setSource(SourceEnum.weixin.getValue());
                mb.setAddUser(loginUser);
                resmemberList.add(mb);
            }
        }
        if (resmemberList.size()>0)
           res = AddMember(resmemberList);
//                if(res==0)//插入数据库失败
//                    break;
//                //统计会员
//                memberTotal+=memberList.size();
//            } else {
//                break;
//            }
//        // }
////        while(total>timesTotal);
//
 //      return phoneStr;
       //String.valueOf(phoneStr);
        return String.valueOf(res);
    }


    //1、所有已经发的卡券,这里是拉取所有的已经投放过的卡券，最多50种
    private  com.alibaba.fastjson.JSONArray getCompleteCards(String access_token) throws Exception {
        String Url="https://api.weixin.qq.com/card/batchget?access_token="+access_token+"";
        JSONObject json = new JSONObject();
        json.put("offset",0);
        json.put("count",50);
        json.put("status_list","[\"CARD_STATUS_DISPATCH\"]");
       // json.put("status_list","[\"CARD_STATUS_VERIFY_OK\"]");

         String res ="";
         try
         {
            res = HttpUtil.post(Url,json.toString());
         }
         catch(Exception ex)
         {
             res= ex.getMessage();
         }

      //  String res = "{\"errcode\":0,\"errmsg\":\"ok\",\"card_id_list\":[\"pVD541Gl-hkZt2qyKw_tqh9ybpF8\"],\"total_num\":1,\"card_list\":[]}";
        JSONObject obj = JSONObject.fromObject(res);
         if(obj.get("card_id_list")==null) return null;
        if ("".equals(obj.get("card_id_list").toString()) || "[]".equals(obj.get("card_id_list").toString())) {
            return null;
        } else {
            com.alibaba.fastjson.JSONArray cardids = com.alibaba.fastjson.JSONArray.parseArray(obj.get("card_id_list").toString());
            return cardids;
        }
    }

    //2、获得关注者列表，一次最多只能拉取10000条
    private com.alibaba.fastjson.JSONArray getUsers(String access_token, String next_openid, int total, int timesCount) {
    String Url="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token;
    if(!"".equals(next_openid))
        Url+="&next_openid="+next_openid+"";
         String res = HttpUtil.post(Url,null);
      //  String res = "{\"total\":22,\"count\":22,\"data\":{\"openid\":[\"oVD541Mk8slt42c5Ie3sqjikBs7I\",\"oVD541BFHornV8t4EaBMpqwug3Tk\",\"oVD541FyKxGf5-H0lXvwI9FJWHsU\",\"oVD541PLPgV5V22jWR6WAlgEpiXw\",\"oVD541N3JIZJUtf9vxyXw956IP9k\",\"oVD541Hb08MPJSz0cbn2PmZtvwJg\",\"oVD541CiRq5tV6ORDvj0KcVgOuNQ\",\"oVD541KXYlmNexj-RVOIgcBwOHGY\",\"oVD541MccpwkMzrY-YcaZaj9_-xg\",\"oVD541PSZHQQfnJ_MgcVprQgRERw\",\"oVD541HjUVJryQ7VxtBS1kjpVe04\",\"oVD541Jv91nhSIMa8m3uSnJ7q81Y\",\"oVD541J9IPTonVb3xZtaaT3hlZ0Y\",\"oVD541KJdc8sWX0UbmacZrn13ap4\",\"oVD541AS4Tkxr-grHaGtHx0kz6tg\",\"oVD541Fzutv2KrPECVk823sTS1O0\",\"oVD541DupYVgCkHHnHvIeLcGe-mg\",\"oVD541OS387aSO4yQ_szQjLe0tQ4\",\"oVD541DMEU0wL4_sb0EIxf4G89b4\",\"oVD541ORo4JwuaTMzjgFLu3NMzF4\",\"oVD541C2Aeh-fSl3__2PIdvBq8oE\",\"oVD541MKvOe0NZSaHA6hSfqsEj-4\"]},\"next_openid\":\"oVD541MKvOe0NZSaHA6hSfqsEj-4\"}";

        JSONObject obj = JSONObject.fromObject(res);
        if(obj.get("next_openid")==null) return null;
        next_openid = obj.get("next_openid").toString();
        timesCount = (Integer) obj.get("count");
        if ("".equals(next_openid))
            total = (Integer) obj.get("total");
        String data = obj.get("data").toString();
        JSONObject tempobj = JSONObject.fromObject(data);
        if ("".equals(tempobj.get("openid").toString()) || "[]".equals(tempobj.get("openid").toString())) {
            return null;
        } else {
            com.alibaba.fastjson.JSONArray openids = com.alibaba.fastjson.JSONArray.parseArray(tempobj.get("openid").toString());
            return openids;

        }
    }

    //3、获取用户已经领的卡券
    private String getReceiveCardCode(String access_token, String openid, String card_id) {
        String Url = "https://api.weixin.qq.com/card/user/getcardlist?access_token=" + access_token + "";
        //POST{
        //        "openid": "12312313",
        //       "card_id": "xxxxxxxxxx"
        // }
        JSONObject json = new JSONObject();
        json.put("openid", openid);
        json.put("card_id", card_id);
        String res = HttpUtil.post(Url, json.toString());
        //  String res="{\"errcode\":0,\"errmsg\":\"ok\",\"card_list\":[{\"card_id\":\"pVD541Gl-hkZt2qyKw_tqh9ybpF8\",\"code\":\"727343188400\"}],\"has_share_card\":false}";
        // {"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"727343188400"}],"has_share_card":false}
        //{"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"917078651777"}],"has_share_card":false}
        // {"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"940330773301"}],"has_share_card":false}
        // {"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"385859394915"}],"has_share_card":false}

        JSONObject tempobj = JSONObject.fromObject(res);
        String errcode = tempobj.get("errcode").toString();
        if ("0".equals(errcode)) {
            if (tempobj.get("card_list") == null) return "";
            List<CardCode> list = new ArrayList<CardCode>();
            list = com.alibaba.fastjson.JSON.parseArray(tempobj.get("card_list").toString(), CardCode.class);
            if (list.size() > 0)
                return list.get(0).getCode();
            else
                return "";
        } else {
            return "";
        }
    }

    //4、拉取会员信息
    private String getMemberInfo(String access_token, String card_id, String code) {
        String Url = "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=" + access_token + "";
        //POST{
        //        "card_id": "pbLatjtZ7v1BG_ZnTjbW85GYc_E8",
        //        "code": "916679873278"
        //}
        JSONObject json = new JSONObject();
        json.put("card_id", card_id);
        json.put("code", code);
        String res ="";
        try {
             res = HttpUtil.post(Url, json.toString());
        }
        catch(Exception ex)
        {
            res=ex.getMessage();
        }
    //    return res;
        // String res="{\"errcode\":0,\"errmsg\":\"ok\",\"openid\":\"oVD541FyKxGf5-H0lXvwI9FJWHsU\",\"nickname\":\"Tammy\",\"membership_number\":\"917078651777\",\"bonus\":0,\"sex\":\"FEMAIL\",\"user_info\":{\"common_field_list\":[{\"name\":\"USER_FORM_INFO_FLAG_MOBILE\",\"value\":\"18717734042\",\"value_list\":[]},{\"name\":\"USER_FORM_INFO_FLAG_SEX\",\"value\":\"女\",\"value_list\":[]},{\"name\":\"USER_FORM_INFO_FLAG_BIRTHDAY\",\"value\":\"1995-07-13\",\"value_list\":[]},{\"name\":\"USER_FORM_INFO_FLAG_NAME\",\"value\":\"何姿谊\",\"value_list\":[]}],\"custom_field_list\":[]},\"user_card_status\":\"NORMAL\",\"has_active\":true}";
        // String res="{\"errcode\":0,\"errmsg\":\"ok\",\"openid\":\"oVD541PSZHQQfnJ_MgcVprQgRERw\",\"nickname\":\"陈韡娴\",\"membership_number\":\"\",\"bonus\":0,\"sex\":\"FEMAIL\",\"user_card_status\":\"NORMAL\",\"has_active\":false}";
        JSONObject obj = JSONObject.fromObject(res);
        String errcode = obj.get("errcode").toString();
        if ("0".equals(errcode)) {
            Object ob = obj.get("user_info");
            if (ob == null || "".equals(ob.toString())) return "";
            String user_info = ob.toString();
            JSONObject obj1 = JSONObject.fromObject(user_info);
            Object ob1 = obj1.get("common_field_list");
            if (ob1 == null || "".equals(ob1.toString())) return "";
            String common_field_listStr = ob1.toString();
            String phone = "";
            List<NameValue> common_field_list = new ArrayList<NameValue>();
            common_field_list = com.alibaba.fastjson.JSON.parseArray(common_field_listStr, NameValue.class);
            for (NameValue item : common_field_list) {
                if (item.getName().equals("USER_FORM_INFO_FLAG_MOBILE")) {
                    phone = item.getValue().toString();
                    break;
                }
            }
            return phone;
        } else {
            return "";
        }
    }

    //获取授权方的帐号基本信息
    public WechatUser GetUserAccessInfo(String appId) {
        String component_access_token = getComponentAccessToken();
        String authorizer_appid = appId;
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=" + component_access_token + "";
//    {
//        "component_appid":"appid_value" ,
//            "authorizer_appid": "auth_appid_value"
//    }
        JSONObject json = new JSONObject();
        json.put("component_appid", wechatOpenProperties.getComponentAppId());
        json.put("authorizer_appid", authorizer_appid);
        String res = HttpUtil.post(url, json.toString());
        JSONObject obj = JSONObject.fromObject(res);
        WechatUser wechatUser = new WechatUser();
        String authorizer_info = obj.get("authorizer_info").toString();
        JSONObject obj1 = JSONObject.fromObject(authorizer_info);
        wechatUser.setNickName(obj1.get("nick_name").toString());
        wechatUser.setAppId(appId);
        wechatUser.setUserName(obj1.get("user_name").toString());
        wechatUser.setHeadimgurl(obj1.get("head_img").toString());
        wechatUser.setPrincipalName(obj1.get("principal_name").toString());
        JSONObject obj2 = JSONObject.fromObject(obj1.get("service_type_info").toString());
        wechatUser.setServiceTypeinfo(obj2.get("id").toString());

        return wechatUser;
//    {
//        "authorizer_info": {
//        "nick_name": "微信SDK Demo Special",
//                "head_img": "http://wx.qlogo.cn/mmopen/GPy",
//                "service_type_info": { "id": 2 },
//        "verify_type_info": { "id": 0 },
//        "user_name":"gh_eb5e3a772040",
//                "principal_name":"腾讯计算机系统有限公司",
//                "business_info": {"open_store": 0, "open_scan": 0, "open_pay": 0, "open_card": 0,
//                "open_shake": 0},
//        "alias":"paytest01"
//        "qrcode_url":"URL",
//    },
//        "authorization_info": {
//        "authorization_appid": "wxf8b4f85f3a794e77",
//                "func_info": [
//        { "funcscope_category": { "id": 1 } },
//        { "funcscope_category": { "id": 2 } },
//        { "funcscope_category": { "id": 3 } }
//]
//    }
//    }
    }

    /////////////////以下是发送消息/////////////////
    //根据OpenID列表发送消息
    public String SendMessage(List<String> Openids, msgtypeEnum msgtype, MessageOb  messageob,String appId) {
        JSONObject json = new JSONObject();
        json.put("touser", Openids);
        json.put("msgtype", msgtype.getValue());
        String val=msgtype.getValue();
        switch (val)
        {
            case "mpnews":
                wxMaterial mpnewsob=new wxMaterial();
                mpnewsob.setMedia_id(messageob.getMedia_id());
                json.put("mpnews", mpnewsob);
                json.put("send_ignore_reprint",1);//转发
                break;
            case "text":
                json.put("text", messageob.getContent());
                break;
            case "voice":
                wxMaterial voiceob=new wxMaterial();
                voiceob.setMedia_id(messageob.getMedia_id());
                json.put("voice", voiceob);
                break;
            case "music":
                wxMaterial musicob=new wxMaterial();
                musicob.setMedia_id(messageob.getMedia_id());
                json.put("music", musicob);
                break;
            case "image":
                wxMaterial imageob=new wxMaterial();
                imageob.setMedia_id(messageob.getMedia_id());
                json.put("image", imageob);
                break;
            case "mpvideo":
                json.put("mpvideo", messageob);
                break;
            case "wxcard":

                break;
         default:
                break;
        }
        String access_token = refreshAuthorizerAccessToken(appId);
        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token + "";
        String res = HttpUtil.post(Url, json.toString());
        JSONObject obj = JSONObject.fromObject(res);
        String errcode = obj.get("errcode").toString();
        return errcode;
    }
    public String SendWXMessage(String JSONMessage,String appId)
    {
        //  if (Openids.length == 0) return false;
        //{
        //    "touser":[
        //           "OPENID1",
        //           "OPENID2"
        //            ],
        //  "msgtype": "text",
        //       "text": { "content": "hello from boxer."}
        //  }

//        String access_token = refreshAuthorizerAccessToken(appId);
//        JSONObject json = new JSONObject();
//        json.put("touser", Openids);
//        json.put("msgtype", "text");
//        json.put("text", "{\"content\": \"" + message + "\"}");
//        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token + "";
//        String res = HttpUtil.post(Url, json.toString());
        //{
        //    "errcode":0,
        //       "errmsg":"send job submission success",
        //       "msg_id":34182,
        //        "msg_data_id": 206227730
        //}
//        JSONObject obj = JSONObject.fromObject(res);
//        String errcode = obj.get("errcode").toString();
//        if ("0".equals(errcode)) {
//            return true;
//        } else {
//            return false;
//        }

        JSONObject json = JSONObject.fromObject(JSONMessage);
        String access_token = refreshAuthorizerAccessToken(appId);
        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token + "";
        String res = HttpUtil.post(Url, json.toString());
        JSONObject obj = JSONObject.fromObject(res);
        return obj.toString();
    }

    //根据OpenID列表发卡
    public boolean SendCard(String[] Openids, String cardId) {
        //    {
//        "touser":[
//        "OPENID1",
//                "OPENID2"
//   ],
//        "wxcard": {"card_id":"123dsdajkasd231jhksad"}
//        "msgtype":"wxcard"
//    }
        String access_token = getWXAuthorizerAccessToken();
        JSONObject json = new JSONObject();
        json.put("touser", Openids);
        json.put("msgtype", "wxcard");
        json.put("wxcard", "{\"card_id\": \"" + cardId + "\"}");
        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token + "";
        String res = HttpUtil.post(Url, json.toString());
        //{
        //    "errcode":0,
        //       "errmsg":"send job submission success",
        //       "msg_id":34182,
        //        "msg_data_id": 206227730
        //}
        JSONObject obj = JSONObject.fromObject(res);
        String errcode = obj.get("errcode").toString();
        if ("0".equals(errcode)) {
            return true;
        } else {
            return false;
        }
    }

//    private  String getAuthorizerAccessToken()
//    {
//        String component_access_token=getComponentAccessToken();
//        String Url= "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="+component_access_token+"";
////        {
////            "component_appid":"appid_value" ,
////                "authorization_code": "auth_code_value"
////        }
//        JSONObject json = new JSONObject();
//        json.put("component_appid", wechatOpenProperties.getComponentAppId());
//        json.put("authorization_code", authorization_code);
//        String res= HttpUtil.post(Url,json.toString());
//        JSONObject obj = JSONObject.fromObject(res);
////        {
////            "authorization_info": {
////            "authorizer_appid": "wxf8b4f85f3a794e77",
////                    "authorizer_access_token": "QXjUqNqfYVH0yBE1iI_7vuN_9gQbpjfK7hYwJ3P7xOa88a89-Aga5x1NMYJyB8G2yKt1KCl0nPC3W9GJzw0Zzq_dBxc8pxIGUNi_bFes0qM",
////                    "expires_in": 7200,
////                    "authorizer_refresh_token": "dTo-YCXPL4llX-u1W1pPpnp8Hgm4wpJtlR6iV0doKdY",
////                    "func_info": [
////            {
////                "funcscope_category": {
////                "id": 1
////            }
////            },
////            {
////                "funcscope_category": {
////                "id": 2
////            }
////            },
////            {
////                "funcscope_category": {
////                "id": 3
////            }
////            }
////]
////        }}
//
//        String authorization_info=obj.get("authorization_info").toString();
//        JSONObject obj1 = JSONObject.fromObject(authorization_info);
//        String authorizer_access_token=obj1.get("authorizer_access_token").toString();
//        String authorizer_refresh_token=obj1.get("authorizer_refresh_token").toString();
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        ServletContext application = webApplicationContext.getServletContext();
//        if(obj1.containsKey("authorizer_access_token"))
//        {
//            if(obj1.get("authorizer_access_token")!=null&&!obj1.get("authorizer_access_token").equals(""))
//            {
//                application.setAttribute("authorizerAccessTokenMap", new WeixinAccessToken(obj1.get("authorizer_access_token").toString(),
//                        System.currentTimeMillis()+Integer.parseInt(obj1.get("expires_in").toString())-5));
//                String authorizer_appid=obj1.get("authorizer_appid").toString();
//                application.setAttribute("authorizerAppid",authorizer_appid);
//                UpdateWxInfoSetting(authorizer_appid,obj1.get("authorizer_refresh_token").toString());
//                return json.get("authorizer_access_token").toString();
//            }
//        }
//        return null;
//    }


    //此token保存在数据库中,从数据库中取得AuthorizerRefreshToken
    private String getAuthorizerRefreshToken(String authorizer_appid) {
        Object ob = marketingMerchantWxMapper.getAuthorizerRefreshToken(authorizer_appid);
        if (ob != null)
            return ob.toString();
        else
            return "";
    }

    ////////////会员插入数据库，如果已经存在则忽略/////////
    private int AddMember(List<Member> memberList) {
        return marketingMemberMapper.add(memberList);
    }

    //初次授权后，以后是更新authorizerRefreshToken，
    // 设置公众号的信息，如果authorizerRefreshToken丢失需要公众号重新授权
    public int wxInfoSetting(String appid, String merchantId, String authorizerRefreshToken) {
        MarketingMerchantWx record = new MarketingMerchantWx();
        record.setAppId(appid);
        record.setMerchantId(merchantId);
        record.setAuthorizerRefreshToken(authorizerRefreshToken);
        record.setUpdateDate(new Date());
        if (marketingMerchantWxMapper.countIsExists(record) > 0) {
            return marketingMerchantWxMapper.updateByPrimaryKey(record);
        } else {
            return marketingMerchantWxMapper.insert(record);
        }
    }

    //更新
    private int UpdateWxInfoSetting(String appid, String authorizerRefreshToken) {
        MarketingMerchantWx record = new MarketingMerchantWx();
        record.setAppId(appid);
        record.setAuthorizerRefreshToken(authorizerRefreshToken);
        return marketingMerchantWxMapper.updateByPrimaryKey(record);
    }

    //只用作第一次授权时的插入
    public void insertWxInfo(String authorization_code, String merchantId) {
        String component_access_token = getWxComponentAccessToken();
        String Url = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=" + component_access_token + "";
//        {
//            "component_appid":"appid_value" ,
//                "authorization_code": "auth_code_value"
//        }
        JSONObject json = new JSONObject();
        json.put("component_appid", wechatOpenProperties.getComponentAppId());
        json.put("authorization_code", authorization_code);
        String res = HttpUtil.post(Url, json.toString());
        JSONObject obj = JSONObject.fromObject(res);
//        {
//            "authorization_info": {
//            "authorizer_appid": "wxf8b4f85f3a794e77",
//                    "authorizer_access_token": "QXjUqNqfYVH0yBE1iI_7vuN_9gQbpjfK7hYwJ3P7xOa88a89-Aga5x1NMYJyB8G2yKt1KCl0nPC3W9GJzw0Zzq_dBxc8pxIGUNi_bFes0qM",
//                    "expires_in": 7200,
//                    "authorizer_refresh_token": "dTo-YCXPL4llX-u1W1pPpnp8Hgm4wpJtlR6iV0doKdY",
//                    "func_info": [
//            {
//                "funcscope_category": {
//                "id": 1
//            }
//            },
//            {
//                "funcscope_category": {
//                "id": 2
//            }
//            },
//            {
//                "funcscope_category": {
//                "id": 3
//            }
//            }
//]
//        }}

        String authorization_info = obj.get("authorization_info").toString();
        JSONObject obj1 = JSONObject.fromObject(authorization_info);
        if (obj1.containsKey("authorizer_access_token")) {
            String authorizer_access_token = obj1.get("authorizer_access_token").toString();
            String authorizer_refresh_token = obj1.get("authorizer_refresh_token").toString();
            String authorizer_appid = obj1.get("authorizer_appid").toString();
            ServletContext application = webApplicationContext.getServletContext();
            if (obj1.get("authorizer_access_token") != null && !obj1.get("authorizer_access_token").equals("")) {
                application.setAttribute("authorizerAccessTokenMap", new WeixinAccessToken(obj1.get("authorizer_access_token").toString(),
                        System.currentTimeMillis() + Integer.parseInt(obj1.get("expires_in").toString()) - 5));

                wxInfoSetting(authorizer_appid, merchantId, authorizer_refresh_token);

                application.setAttribute("authorizerAppid", authorizer_appid);

            }
        }

    }
//    public void SaveCurrAppId(String AppId)
//    {
//        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        ServletContext application = webApplicationContext.getServletContext();
//        application.setAttribute("authorizerAppid",AppId);
//    }

//    private String getCurrAppId() {
//        ServletContext application = webApplicationContext.getServletContext();
//        return application.getAttribute("authorizerAppid").toString();
//    }

    //获得商户所有的会员
    public String getMemberCount(String marchantId) {
        return marketingMemberMapper.getMemberCount(marchantId).toString() + "|" + marketingMemberMapper.getWXMemberCount(marchantId).toString();
    }

    //获得商户所有微信公众号下的会员
    public int getWXMemberCount(String marchantId) {
        return marketingMemberMapper.getWXMemberCount(marchantId);
    }

    //获得某一个公众号下的会员
    public int getOneWXMemberCount(String appId) {
        return marketingMemberMapper.getOneWXMemberCount(appId);
    }

    //获得当前公众号下的微信会员
//    public int getCurrWXMemberCount() {
//        String appId = getCurrAppId();
//        return getOneWXMemberCount(appId);
//    }

    public List<MarketingMerchantWx> getMerchantWX(String marchantId) {
        return marketingMerchantWxMapper.getMerchantWX(marchantId);
    }
    //对某个公众号接口调用次数的清零
    public boolean clearQuota(String appId)
    {
        String access_token=getAuthorizerRefreshToken(appId);
        String Url="https://api.weixin.qq.com/cgi-bin/clear_quota?access_token="+access_token+"";
        JSONObject json = new JSONObject();
        json.put("appid",appId);
        String res = HttpUtil.post(Url, json.toString());
        JSONObject obj = JSONObject.fromObject(res);
        String errcode = obj.get("errcode").toString();
        if(errcode.equals("0"))
        {
            return true;
        }
        else
        {
            return false;
        }
//     {
//       "errcode":0
//      "errmsg":"ok"
//
//     }
    }

    //和微信公众号平台对话，处理全网检测发布，回复微信xml
    @Override
   public  void  handleAcceptMessage(HttpServletRequest request, HttpServletResponse response)
    {
        String msgSignature = request.getParameter("msg_signature");
        if(!StringUtils.isNotBlank(msgSignature)){
            return;
        }
        String timestamp=request.getParameter("timestamp");
        String encrypt_type=request.getParameter("encrypt_type");
        String nonce=request.getParameter("nonce");
        String msg_signature=request.getParameter("msg_signature");
//        log.info("timestamp:"+timestamp);
//        log.info("encrypt_type:"+encrypt_type);
//        log.info("nonce:"+nonce);
//        log.info("msg_signature:"+msg_signature);
        /* 验证通过后 */
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader in = request.getReader();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            String xml = sb.toString();

            log.info("微信推送的原生：" + xml);
            // String encodingAesKey =WeChatContants.encodingAesKey;// 第三方平台组件加密密钥
            //   String appId=WeChatContants.THRID_APPID;//从xml中解析
            xml=xml.replace("AppId","ToUserName");
            WXBizMsgCrypt pc = new WXBizMsgCrypt(wechatOpenProperties.getComponentToken(), wechatOpenProperties.getComponentAesKey(), wechatOpenProperties.getComponentAppId());
            xml = pc.decryptMsg(msg_signature, timestamp, nonce, xml);
            log.info("解密后的：" + xml);
//        Map<String, String> parseXml = WeChatUtils.parseXml(xml);
////        String msgType=parseXml.get("MsgType");
////        String toUserName=parseXml.get("ToUserName");
////        String fromUserName=parseXml.get("FromUserName");
            Document doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String msgType = rootElt.elementText("MsgType");
            String toUserName = rootElt.elementText("ToUserName");
            String fromUserName = rootElt.elementText("FromUserName");
            if ("event".equals(msgType)) {
                log.info("---全网发布接入检测-------------事件消息--------");
                String event = rootElt.elementText("Event");
                replyEventMessage(request, response, event, toUserName, fromUserName);
            } else if ("text".equals(msgType)) {
                log.info("---全网发布接入检测-------------文本消息--------");
                String content = rootElt.elementText("Content");
                processTextMessage(request, response, content, toUserName, fromUserName);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void replyEventMessage(HttpServletRequest request, HttpServletResponse response, String event, String toUserName, String fromUserName) throws DocumentException, IOException {
        String content = event + "from_callback";
        //---全网发布接入检测-------------事件回复消息  content="+content + "toUserName="+toUserName+"fromUserName="+fromUserName
        replyTextMessage(request,response,content,toUserName,fromUserName);
    }

    /**
     * 回复微信服务器"文本消息"
     */
    private void replyTextMessage(HttpServletRequest request, HttpServletResponse response, String content, String toUserName, String fromUserName) throws DocumentException, IOException {
        Long createTime = Calendar.getInstance().getTimeInMillis() / 1000;
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA["+fromUserName+"]]></ToUserName>");
        sb.append("<FromUserName><![CDATA["+toUserName+"]]></FromUserName>");
        sb.append("<CreateTime>"+createTime+"</CreateTime>");
        sb.append("<MsgType><![CDATA[text]]></MsgType>");
        sb.append("<Content><![CDATA["+content+"]]></Content>");
        sb.append("</xml>");
        String replyMsg = sb.toString();

        String returnvaleue = "";
        try {
            WXBizMsgCrypt pc = new WXBizMsgCrypt(wechatOpenProperties.getComponentToken(),  wechatOpenProperties.getComponentAesKey(),wechatOpenProperties.getComponentAppId());
            returnvaleue = pc.encryptMsg(replyMsg, createTime.toString(), "easemob");
        } catch (AesException e) {
            e.printStackTrace();
        }
        output(response, returnvaleue);
    }
    /**
     * 统一回复微信服务器
     */
    private void output(HttpServletResponse response,String returnvaleue) throws IOException {
        try {
            PrintWriter pw = response.getWriter();
            pw.write(returnvaleue);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////
    private void processTextMessage(HttpServletRequest request, HttpServletResponse response,String content,String toUserName, String fromUserName) throws IOException, DocumentException {
        if("TESTCOMPONENT_MSG_TYPE_TEXT".equals(content)){
            String returnContent = content+"_callback";
            replyTextMessage(request,response,returnContent,toUserName,fromUserName);
        }else if(StringUtils.startsWithIgnoreCase(content, "QUERY_AUTH_CODE")){
            output(response, "");
            //接下来客服API再回复一次消息
            replyApiTextMessage(request,response,content.split(":")[1],fromUserName);
        }
    }

    private void replyApiTextMessage(HttpServletRequest request, HttpServletResponse response, String auth_code, String fromUserName) throws DocumentException, IOException {
        String authorization_code = auth_code;
        // 得到微信授权成功的消息后，应该立刻进行处理！！相关信息只会在首次授权的时候推送过来
        log.info("------step.1----使用客服消息接口回复粉丝----逻辑开始-------------------------");
        try {
            ApiComponentToken apiComponentToken = new ApiComponentToken();
            apiComponentToken.setComponent_appid(wechatOpenProperties.getComponentAppId());
            apiComponentToken.setComponent_appsecret(wechatOpenProperties.getComponentSecret());
           // String ticket = readFile();
            String ticket=getComponentVerifyTicket();
            apiComponentToken.setComponent_verify_ticket(ticket);
           // String component_access_token = JwThirdAPI.getAccessToken(apiComponentToken);
            String component_access_token = getComponentAccessToken();

            log.info("------step.2----使用客服消息接口回复粉丝------- component_access_token = "+component_access_token + "---------authorization_code = "+authorization_code);
            net.sf.json.JSONObject authorizationInfoJson = getApiQueryAuthInfo(wechatOpenProperties.getComponentAppId(), authorization_code, component_access_token);
            log.info("------step.3----使用客服消息接口回复粉丝-------------- 获取authorizationInfoJson = "+authorizationInfoJson);
           net.sf.json.JSONObject infoJson = authorizationInfoJson.getJSONObject("authorization_info");
            String authorizer_access_token = infoJson.getString("authorizer_access_token");


            Map<String,Object> obj = new HashMap<String,Object>();
            Map<String,Object> msgMap = new HashMap<String,Object>();
            String msg = auth_code + "_from_api";
            msgMap.put("content", msg);

            obj.put("touser", fromUserName);
            obj.put("msgtype", "text");
            obj.put("text", msgMap);
            sendMessage(obj, authorizer_access_token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private  JSONObject getApiQueryAuthInfo(String component_appid,String authorization_code,String component_access_token) throws Exception{
        String api_query_auth_url = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=xxxx";
        String requestUrl = api_query_auth_url.replace("xxxx", component_access_token);
        Map<String,String> mp = new HashMap<String,String>();
        mp.put("component_appid", component_appid);
        mp.put("authorization_code", authorization_code);
        JSONObject obj = JSONObject.fromObject(mp);
        System.out.println("-------------------3、使用授权码换取公众号的授权信息---requestUrl------------------------"+requestUrl);
       String obStr = HttpUtil.post(requestUrl, obj.toString());
        JSONObject result=JSONObject.fromObject(obStr);
        if (result.has("errcode")) {
            log.error("获取第三方平台access_token！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
            throw new Exception("获取第三方平台access_token！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
        }
        return result;
    }
    private  String sendMessage(Map<String,Object> obj,String ACCESS_TOKEN){
        JSONObject json = JSONObject.fromObject(obj);
        System.out.println("--------发送客服消息---------json-----"+json.toString());
        // 调用接口获取access_token
        String send_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        String url = send_message_url.replace("ACCESS_TOKEN",ACCESS_TOKEN);
        return  HttpUtil.post(url, json.toString());
    }
    //获得某个公众号下所有标签（群）
    public String getwxTagList(String appId,String token) {
        String ACCESS_TOKEN="";
        if(token!=null)
        {
            ACCESS_TOKEN=token;
        }
        else {
             ACCESS_TOKEN = refreshAuthorizerAccessToken(appId);
        }
        String Url = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token="+ACCESS_TOKEN+"";
        //返回
        String res = HttpUtil.get(Url, null);
//        JSONObject obj = JSONObject.fromObject(res);
//        if(obj.containsKey("tags"))
//        {
//            return obj.get("tags").toString();
//        }
       return res;
    }
    //获得公众号下所有关注者数目
    public String  QueryFanSum(String appId)
    {
        String ACCESS_TOKEN=refreshAuthorizerAccessToken(appId);
        String Url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+ACCESS_TOKEN+"";
        //返回
        String res = HttpUtil.get(Url, null);
        JSONObject obj = JSONObject.fromObject(res);
        if(obj.containsKey("total"))
        {
            return obj.get("total").toString();
        }
        return "0";
    }
    //创建标签
    public String createTag(String appId,String token,String name)
    {
        String ACCESS_TOKEN="";
        if(token!=null)
        {
            ACCESS_TOKEN=token;
        }
        else {
            ACCESS_TOKEN = refreshAuthorizerAccessToken(appId);
        }
        String Url = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token="+ACCESS_TOKEN+"";
       // {   "tag" : {     "name" : "广东"//标签名   } }

        Map<String,Object> namemp = new HashMap<String,Object>();
        namemp.put("name", name);
        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("tag",namemp);
        JSONObject obj = JSONObject.fromObject(mp);

        //返回
        String res = HttpUtil.get(Url, obj.toString());
//        JSONObject nextobj = JSONObject.fromObject(res);
//        if(nextobj.containsKey("tag"))
//        {
//            JSONObject threeobj =obj.getJSONObject("tag");
//            return Integer.parseInt(threeobj.get("id").toString());
//        }
        return res;
    }
    //为用户批量打标签
    public   String batchtagging(String[] openIds,String appId,int tagid,String token)
    {
        String ACCESS_TOKEN="";
        if(token!=null)
        {
            ACCESS_TOKEN=token;
        }
        else {
            ACCESS_TOKEN = refreshAuthorizerAccessToken(appId);
        }
        String Url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token="+ACCESS_TOKEN+"";
//        {
//            "openid_list" : [//粉丝列表
//            "ocYxcuAEy30bX0NXmGn4ypqx3tI0",
//                    "ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"   ],
//            "tagid" : 134
//        }

        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("openid_list",openIds);
        mp.put("tagid",tagid);
        JSONObject obj = JSONObject.fromObject(mp);
      //  return obj.toString();
        //返回
       String res = HttpUtil.get(Url, obj.toString());
//        JSONObject nextobj = JSONObject.fromObject(res);
//        if(nextobj.containsKey("errcode"))
//        {
//            return Integer.parseInt(nextobj.get("errcode").toString());
//        }
       return res;
    }

    //为用户取消标签
    public  String  batchuntagging(String[] openIds,String appId,int tagid,String token)
    {
        String ACCESS_TOKEN="";
        if(token!=null)
        {
            ACCESS_TOKEN=token;
        }
        else {
            ACCESS_TOKEN = refreshAuthorizerAccessToken(appId);
        }
        String Url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token="+ACCESS_TOKEN+"";
//        {
//            "openid_list" : [//粉丝列表
//            "ocYxcuAEy30bX0NXmGn4ypqx3tI0",
//                    "ocYxcuBt0mRugKZ7tGAHPnUaOW7Y"   ],
//            "tagid" : 134
//        }

        Map<String,Object> mp = new HashMap<String,Object>();
        mp.put("openid_list",openIds);
        mp.put("tagid",tagid);
        JSONObject obj = JSONObject.fromObject(mp);

        //返回
        String res = HttpUtil.get(Url, obj.toString());
//        JSONObject nextobj = JSONObject.fromObject(res);
//        if(nextobj.containsKey("errcode"))
//        {
//            return Integer.parseInt(nextobj.get("errcode").toString());
//        }
        return res;
    }

    /////////////以下方法是测试////////////
    public String getTicket() {
        ServletContext application = webApplicationContext.getServletContext();
        if (application.getAttribute("VerifyTicketMap") != null)
            return application.getAttribute("VerifyTicketMap").toString();
        else
            return "No Ticket";
    }

    //返回会员的数目
//    public int getMember()
//    {
//        String access_token=getWXAuthorizerAccessToken();
//        //1、所有已经发的卡券
//        String [] getCompleteCards=getCompleteCards(access_token);
//        if(getCompleteCards==null || getCompleteCards.length==0)
//            return 0;
//        int total=0;
//        int memberTotal=0;
//        int timesTotal=0;
//        int timesCount=0;
//        String next_openid="";
//        String openid = "";
//        String card_id = "";
//        String code = "";
//        Member member=null;
//        String[] openids;
//        int  res=0;
//        do {
//            //2、获得关注者
//            openids = getUsers(access_token, next_openid, total,timesCount);
//            if (openids == null || openids.length == 0)
//                break;
//            next_openid=openids[openids.length-1];
//            timesTotal+=timesCount;
//
//            //3、获取用户已经领的卡券
//            List<Member> memberList = new ArrayList<Member>();
//            for (int i = 0; i < openids.length; i++) {
//                openid = openids[i];
//                for (int j = 0; j < getCompleteCards.length; j++) {
//                    card_id = getCompleteCards[j];
//                    code = getReceiveCardCode(access_token, openid, card_id);
//                    if (!"".equals(code)) {
//                        member = new Member();
//                        member.setOpenId(openid);
//                        member.setCardId(card_id);
//                        member.setCode(code);
//                        memberList.add(member);
//                    }
//                }
//            }
//            //得到当前的微信公众号的APPID
//            String AppId=getCurrAppId();
//            //4、拉取会员手机号
//            if (memberList.size() > 0) {
//                String phone = "";
//                for (Member mb : memberList) {
//                    phone = getMemberInfo(access_token, mb.getCardId(), mb.getCode());
//                    if ("".equals(phone)) {
//                        memberList.remove(mb);
//                    } else {
//                        mb.setAppId(UuidUtils.getUUID());
//                        mb.setPhone(phone);
//                        mb.setAppId(AppId);
//                        mb.setAddTime(new Date());
//                        mb.setStatus(StatusEnum.NORMAL.getValue());
//                        mb.setSource(SourceEnum.weixin.getValue());
//                    }
//                }
//                res=AddMember(memberList);
//                if(res==0)//插入数据库失败
//                    break;
//                //统计会员
//                memberTotal+=memberList.size();
//            } else {
//                break;
//            }
//        }
//        while(total>timesTotal);
//        return memberTotal;
//    }

}
