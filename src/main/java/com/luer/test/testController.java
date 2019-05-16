package com.luer.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luer.comm.bean.NameValue;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.enums.SourceEnum;
import com.luer.comm.enums.StatusEnum;
import com.luer.comm.enums.msgtypeEnum;
import com.luer.comm.utils.*;
import com.luer.config.WechatOpenProperties;
import com.luer.wx.bean.*;
import com.luer.wx.service.Iwxservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class testController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    Iwxservice wxservice;
    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @RequestMapping(value = "/testA",method = RequestMethod.POST)
    @ResponseBody
    public ResultSet testA(String  val) {
        try {
            redisUtils.set("MyKey", val);
        }
        catch (Exception ex)
        {
            return  ResultSet.getSuccess(ex.toString());
        }
        return  ResultSet.getSuccess("写入成功");
    }

    @ResponseBody
    @RequestMapping(value = "/gettest",method = RequestMethod.POST)
    public ResultSet gettest() {
       String val=(String)redisUtils.get("MyKey");
        return  ResultSet.getSuccess(val);
    }

    @RequestMapping(value = "/totest")
    public String totest() {

        return "templates/myTest/test";
    }

    @RequestMapping(value = "/SendWX")
    @ResponseBody
    public String SendWX(String phone,String appId,String message) throws Exception
    {
        String access_token = wxservice.refreshAuthorizerAccessToken(appId);
        String openId=GetOpenId(phone,appId,access_token);

//        String[] Openids=new String[2];
//        Openids[0]=openId;
//        Openids[1]=openId;
//        wxContent content=new wxContent();
//        content.setContent(message);
//        JSONObject json = new JSONObject();
//        json.put("touser", Openids);
//        json.put("msgtype", "text");
//        json.put("text",content);
//        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + access_token + "";
//        String res = HttpUtil.post(Url, json.toString());
//        return res;

//        JSONObject json = new JSONObject();
//        json.put("touser", openId);
//        json.put("msgtype", "text");
//        wxContent content=new wxContent();
//        content.setContent(message);
//        json.put("text", content);
//        //URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN
//       // String Url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token+"";
//        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token="+access_token+"";
//        String objectStr = HttpUtil.post(Url, json.toString());
//          return objectStr;


      //  获得标签列表
        String res=wxservice.getwxTagList(appId,access_token);
        JSONObject obj = JSONObject.parseObject(res);
        int tagid=0;
        if(obj.containsKey("tags"))
        {
            JSONArray jsonArr = JSONArray.parseArray(obj.get("tags").toString());
            if(jsonArr.size()>0){
                JSONObject job=null;
                for(int i=0;i<jsonArr.size();i++){
                     job = jsonArr.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                     if(job.getString("name").equals("网陆临时用"))
                     {
                         tagid=job.getIntValue("id");
                         break;
                     }
                }
            }
        }
//        //创建标签
        if(tagid==0)
          {
              String tagidRes=wxservice.createTag(appId,access_token,"网陆临时用");
              JSONObject nextobj = JSONObject.parseObject(tagidRes);
              if(nextobj.containsKey("tag"))
                 {
                      JSONObject threeobj =obj.getJSONObject(nextobj.getString("tag"));
                      tagid=threeobj.getIntValue("id");
                 }

         }
       //拉人进群
        String[] openIds=new String[1];
        openIds[0]=openId;
        String  result=wxservice.batchtagging(openIds,appId,tagid,access_token);
        //对标签群发
//        {
//            "filter":{
//            "is_to_all":false,
//                    "tag_id":2
//        },
//            "text":{
//            "content":"CONTENT"
//        },
//            "msgtype":"text"
//        }
        wxFilter filter=new wxFilter();
        filter.setIs_to_all(false);
        filter.setTag_id(tagid);
//
//        //拼参数
        wxContent content=new wxContent();
        content.setContent(message);
        JSONObject json = new JSONObject();
        json.put("filter", filter);
        json.put("text", content);
        json.put("msgtype", msgtypeEnum.text.getValue());

        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+access_token+"";
        String objectStr = HttpUtil.post(Url, json.toString());

        //从标签中取消人
      // wxservice.batchuntagging(openIds,appId,tagid,access_token);
       return objectStr;
    }

    ////////////////////////////////////私有方法///////////////////////////////////////////
    //1、所有已经发的卡券,这里是拉取所有的已经投放过的卡券，最多50种
    private  com.alibaba.fastjson.JSONArray getCompleteCards(String access_token) throws Exception {
        String Url="https://api.weixin.qq.com/card/batchget?access_token="+access_token+"";
        net.sf.json.JSONObject json = new net.sf.json.JSONObject();
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
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(res);
        if(obj.get("card_id_list")==null) return null;
        if ("".equals(obj.get("card_id_list").toString()) || "[]".equals(obj.get("card_id_list").toString())) {
            return null;
        } else {
            com.alibaba.fastjson.JSONArray cardids = com.alibaba.fastjson.JSONArray.parseArray(obj.get("card_id_list").toString());
            return cardids;
        }
    }
   //2、获得所有关注者
    private com.alibaba.fastjson.JSONArray getUsers(String access_token, String next_openid, int total, int timesCount) {
        String Url="https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token;
        if(!"".equals(next_openid))
            Url+="&next_openid="+next_openid+"";
        String res = HttpUtil.post(Url,null);
        //  String res = "{\"total\":22,\"count\":22,\"data\":{\"openid\":[\"oVD541Mk8slt42c5Ie3sqjikBs7I\",\"oVD541BFHornV8t4EaBMpqwug3Tk\",\"oVD541FyKxGf5-H0lXvwI9FJWHsU\",\"oVD541PLPgV5V22jWR6WAlgEpiXw\",\"oVD541N3JIZJUtf9vxyXw956IP9k\",\"oVD541Hb08MPJSz0cbn2PmZtvwJg\",\"oVD541CiRq5tV6ORDvj0KcVgOuNQ\",\"oVD541KXYlmNexj-RVOIgcBwOHGY\",\"oVD541MccpwkMzrY-YcaZaj9_-xg\",\"oVD541PSZHQQfnJ_MgcVprQgRERw\",\"oVD541HjUVJryQ7VxtBS1kjpVe04\",\"oVD541Jv91nhSIMa8m3uSnJ7q81Y\",\"oVD541J9IPTonVb3xZtaaT3hlZ0Y\",\"oVD541KJdc8sWX0UbmacZrn13ap4\",\"oVD541AS4Tkxr-grHaGtHx0kz6tg\",\"oVD541Fzutv2KrPECVk823sTS1O0\",\"oVD541DupYVgCkHHnHvIeLcGe-mg\",\"oVD541OS387aSO4yQ_szQjLe0tQ4\",\"oVD541DMEU0wL4_sb0EIxf4G89b4\",\"oVD541ORo4JwuaTMzjgFLu3NMzF4\",\"oVD541C2Aeh-fSl3__2PIdvBq8oE\",\"oVD541MKvOe0NZSaHA6hSfqsEj-4\"]},\"next_openid\":\"oVD541MKvOe0NZSaHA6hSfqsEj-4\"}";

        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(res);
        if(obj.get("next_openid")==null) return null;
        next_openid = obj.get("next_openid").toString();
        timesCount = (Integer) obj.get("count");
        if ("".equals(next_openid))
            total = (Integer) obj.get("total");
        String data = obj.get("data").toString();
        net.sf.json.JSONObject tempobj = net.sf.json.JSONObject.fromObject(data);
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
        net.sf.json.JSONObject json = new net.sf.json.JSONObject();
        json.put("openid", openid);
        json.put("card_id", card_id);
        String res = HttpUtil.post(Url, json.toString());
        //  String res="{\"errcode\":0,\"errmsg\":\"ok\",\"card_list\":[{\"card_id\":\"pVD541Gl-hkZt2qyKw_tqh9ybpF8\",\"code\":\"727343188400\"}],\"has_share_card\":false}";
        // {"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"727343188400"}],"has_share_card":false}
        //{"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"917078651777"}],"has_share_card":false}
        // {"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"940330773301"}],"has_share_card":false}
        // {"errcode":0,"errmsg":"ok","card_list":[{"card_id":"pVD541Gl-hkZt2qyKw_tqh9ybpF8","code":"385859394915"}],"has_share_card":false}

        net.sf.json.JSONObject tempobj = net.sf.json.JSONObject.fromObject(res);
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
        net.sf.json.JSONObject json = new net.sf.json.JSONObject();
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
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(res);
        String errcode = obj.get("errcode").toString();
        if ("0".equals(errcode)) {
            Object ob = obj.get("user_info");
            if (ob == null || "".equals(ob.toString())) return "";
            String user_info = ob.toString();
            net.sf.json.JSONObject obj1 = net.sf.json.JSONObject.fromObject(user_info);
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
    private String GetOpenId(String onephone,String appId,String access_token) throws Exception {

        if(access_token==null)
         access_token = wxservice.refreshAuthorizerAccessToken(appId);


        // String loginMerchantId = GetSysUser.getSysUser().getMerchantId();
       // String loginUser = GetSysUser.getSysUser().getUsername();
        //1、所有已经发的卡券
        com.alibaba.fastjson.JSONArray getCompleteCards = getCompleteCards(access_token);
        if (getCompleteCards == null || getCompleteCards.size() == 0)
            return "";
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
        openids = getUsers(access_token, next_openid, total, timesCount);

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

        //4、拉取会员手机号
        String phone = "";
        List<Member> resmemberList = new ArrayList<Member>();
        String openId = "";
        for (Member mb : memberList) {
            phone = getMemberInfo(access_token, mb.getCardId(), mb.getCode());
            if (!"".equals(phone.trim()) && phone != null) {
                if (phone.equals(onephone)) {
                    openId = mb.getOpenId();
                    break;
                }

            }
        }
        return openId;
    }
}
