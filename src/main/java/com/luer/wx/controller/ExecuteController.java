package com.luer.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.luer.WxMsgCrypt.AesException;
import com.luer.WxMsgCrypt.WXBizMsgCrypt;
import com.luer.comm.bean.AjaxResult;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.enums.msgtypeEnum;
import com.luer.comm.utils.FileUtil;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.HttpUtil;
import com.luer.config.WechatOpenProperties;
import com.luer.marketingSchemeManage.bean.ExecutePlanPara;
import com.luer.wx.bean.*;
import com.luer.wx.service.Iwxservice;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/wxExecute")
public class ExecuteController {
    private static Logger log = LoggerFactory.getLogger(ExecuteController.class);
    @Autowired
    Iwxservice wxservice;
    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @Autowired
    private FileUtil fileUtil;

    //营销方案执行，精准营销
    @RequestMapping(value = "/executePlanAccurate", method = {RequestMethod.POST})
    @ResponseBody
    public String executePlanAccurate(ExecutePlanPara executePlanPara) {
        //以下调用网易接口
        String domainUrl = wechatOpenProperties.getDomainUrl();//这里是网易的地址
        String Url = domainUrl + "/open-api/wanglu/wechat/sendall";
        String ACCESS_TOKEN = wxservice.refreshAuthorizerAccessToken(executePlanPara.getAppId());
        // String ACCESS_TOKEN="19_TYPj3esXvhczTdn22gEt_mYDrFEBQrHIGAmMvJhaxETUsUtLdsrEGVM2yX4mIoT6qTtoULD0QNpSow-ZEZaCrcd4zyJRsTwZjcsgVcRQhAq01D49N6JulXPcTIrEV2m0nMv_Qb21Um4Oc8_XHNWbAIDLRA";
        //拼参数
        JSONObject json = new JSONObject();
        wxGroupNewForm groupNewForm = new wxGroupNewForm();
        groupNewForm.setAppId(executePlanPara.getAppId());
        groupNewForm.setAccess_token(ACCESS_TOKEN);
        json.put("groupNewForm", groupNewForm);
        json.put("tenantId", executePlanPara.getMerchantId());
        json.put("activityId", executePlanPara.getPlanId());
        if (executePlanPara.getMsgtype().equals(msgtypeEnum.mpnews.getValue())) {
            wxMaterial material = new wxMaterial();
            material.setMedia_id(executePlanPara.getMediaId());
            wxMediaForm mediaForm = new wxMediaForm();
            mediaForm.setMpnews(material);
            mediaForm.setMsgtype(msgtypeEnum.mpnews.getValue());
            mediaForm.setSend_ignore_reprint(1);
            json.put("mediaForm", mediaForm);
        } else if (executePlanPara.getMsgtype().equals(msgtypeEnum.text.getValue())) {
            wxContent content = new wxContent();
            content.setContent(executePlanPara.getContent());

            wxTextMediaForm mediaForm = new wxTextMediaForm();
            mediaForm.setMsgtype("text");
            mediaForm.setText(content);
            json.put("mediaForm", mediaForm);
        }
        String ParaStr = json.toString();
        //返回
        String res = HttpUtil.post(Url, ParaStr);
        JSONObject obj = JSONObject.parseObject(res);
        if (obj.containsKey("code")) {
            return obj.toString();
        } else {
            return "-444";
        }
    }

    //查询群发信息状态
    @RequestMapping(value = "/queryTask", method = {RequestMethod.POST})
    @ResponseBody
    public String queryTask(String merchantId, String taskId) {
        //以下调用网易接口
        String domainUrl = wechatOpenProperties.getDomainUrl();//这里是网易的地址
        String Url = domainUrl + "/open-api/wanglu/wechat/queryTask?tenantId=" + merchantId + "&taskId=" + taskId + "";
        //返回
        String res = HttpUtil.get(Url, null);
        JSONObject obj = JSONObject.parseObject(res);
        if (obj.containsKey("code")) {
            JSONObject resultobj = obj.getJSONObject("result");
            return resultobj.toString();
        } else if (obj.containsKey("errcode")) {
            return obj.toString();
        } else {
            return "444";
        }
    }


    //根据OpenIds发微信
    public String executePlanByOpenIds(String content, String appId) throws Exception {
        List<String> Openids = new ArrayList<>();
        Openids.add("obkV10rtWwZ3WQNjMOiEOAvBHrIE");
        Openids.add("obkV10pvPXpdZcSaxxSs2xlxXyBo");
        msgtypeEnum msgtype = msgtypeEnum.text;
        MessageOb messageob = new MessageOb();
        messageob.setContent("<a href='www.163.com'>打开看看</a>");
        return wxservice.SendMessage(Openids, msgtype, messageob, appId);

    }

    //营销方案执行，广泛营销,单不能根据openid列表群发
    @RequestMapping(value = "/executePlanAll", method = {RequestMethod.POST})
    @ResponseBody
    public String executePlanAll(String mediaId, String appId, int tag) throws Exception {
        //wx4d02d7b56d532299 订阅号
        //wx62219b3da7a62d14 服务号
        wxFilter filter = new wxFilter();
        if (tag == -1) {
            filter.setIs_to_all(true);
        } else {
            filter.setIs_to_all(false);
            filter.setTag_id(tag);
        }
        wxMaterial mpnews = new wxMaterial();
        mpnews.setMedia_id(mediaId);
        //拼参数
        JSONObject json = new JSONObject();
        json.put("filter", filter);
        json.put("mpnews", mpnews);
        json.put("msgtype", msgtypeEnum.mpnews.getValue());
        json.put("send_ignore_reprint", 0);
        String paraStr = json.toString();
        String ACCESS_TOKEN = wxservice.refreshAuthorizerAccessToken(appId);
        String Url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + ACCESS_TOKEN + "";
        //返回
        String res = HttpUtil.post(Url, paraStr);
        //JSONObject obj = JSONObject.parseObject(res);
        // if(obj.containsKey("errcode"))
        // {
        //      return obj.getString("errcode").toString();
        //  }
        return res;
    }

    //上传图文素材
    //文字和图片（或音频，视频）混合，单纯的文字不需要这个,上传图文信息，返回MediaId
    @RequestMapping(value = "/uploadMediaAndText", method = {RequestMethod.POST})
    @ResponseBody
    public String uploadMediaAndText(String thumbMediaId, String appId, String content) throws Exception {
        String ACCESS_TOKEN = wxservice.refreshAuthorizerAccessToken(appId);
        String Url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + ACCESS_TOKEN + "";
        MediaAndText mediaAndText = new MediaAndText();
        mediaAndText.setThumb_media_id(thumbMediaId);
        mediaAndText.setTitle("优惠信息");
        mediaAndText.setContent(content);
        mediaAndText.setShow_cover_pic(1);
        mediaAndText.setDigest("优惠多多");
        List<MediaAndText> list = new ArrayList<MediaAndText>();
        list.add(mediaAndText);

        JSONObject json = new JSONObject();
        json.put("articles", list);
        String res = HttpUtil.post(Url, json.toString());
        JSONObject obj = JSONObject.parseObject(res);
        if (obj.containsKey("media_id")) {
            return obj.getString("media_id").toString();
        }
        return "";
    }

    //设置封面图片,返回thumbMediaId
    @RequestMapping(value = "/uploadCover", method = {RequestMethod.POST})
    @ResponseBody
    public String uploadCover(@RequestParam("filePath") String filePath, @RequestParam("appIdCover") String appIdCover, HttpServletRequest request) throws Exception {

        String path = fileUtil.changeIpToUrl(filePath);
        File file = FileUtil.getFileByURL(path);
        if (file.length() == 0) {
            file = null;
        } else {
            String ACCESS_TOKEN = wxservice.refreshAuthorizerAccessToken(appIdCover);
            String TYPE = "thumb";
            String Url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + ACCESS_TOKEN + "&type=" + TYPE + "";
            String res = HttpUtil.formUpload(Url, file);

            JSONObject obj = JSONObject.parseObject(res);
            if (obj.containsKey("thumb_media_id")) {
                return obj.getString("thumb_media_id").toString();
            }
            return "";
        }
        return "";
    }

    //上传图片，返回url
    @RequestMapping(value = "/uploadImage", method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(String filePath, String appIdImg, HttpServletRequest request) throws Exception {

        String path = fileUtil.changeIpToUrl(filePath);
        File file = FileUtil.getFileByURL(path);
        if (file.length() == 0) {
            file = null;
        } else {
            String ACCESS_TOKEN = wxservice.refreshAuthorizerAccessToken(appIdImg);
            String Url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=" + ACCESS_TOKEN + "";
            String res = HttpUtil.formUpload(Url, file);
            JSONObject obj = JSONObject.parseObject(res);
            if (obj.containsKey("url")) {
                return obj.getString("url").toString();
            }
            return "";
        }
        return "";
    }

    //获得某个商户的所有微信公众号
    @RequestMapping(value = "/getAllWxInfo", method = {RequestMethod.POST})
    @ResponseBody
    public List<MarketingMerchantWx> getAllWxInfo(String merchantId) {
        List<MarketingMerchantWx> list = wxservice.getMerchantWX(merchantId);
        WechatUser user = null;
        for (MarketingMerchantWx item : list) {
            try {
                user = wxservice.GetUserAccessInfo(item.getAppId());
            } catch (Exception ex) {
                user = null;
            }
            if (user != null) {
                item.setAppName(user.getNickName() + "(appId:" + item.getAppId() + ")");
            } else {
                item.setAppName("未知");
            }
        }
        return list;
    }

    //获得标签列表
    @RequestMapping(value = "/getwxTagList", method = {RequestMethod.POST}, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getwxTagList(String appId) {

        return wxservice.getwxTagList(appId, null);

    }

    //转化成UTF-8
    public String toUTF(String arg) {
        if (arg != null && arg.trim().length() > 0) {
            try {
                arg = new String(arg.getBytes("GBK"), "UTF-8");
            } catch (Exception e) {
            }
        } else {
            arg = "";
        }
        return arg;
    }

    //////////////////////////////////////一下测试用方法，以后删除/////////////////////////////
    //只输出参数
    @RequestMapping(value = "/executePlanAccuratePara", method = {RequestMethod.POST})
    @ResponseBody
    public String executePlanAccuratePara(ExecutePlanPara executePlanPara) {
        //以下调用网易接口
        String domainUrl = wechatOpenProperties.getDomainUrl();//这里是网易的地址
        String Url = domainUrl + "/open-api/wanglu/wechat/sendall";
        String ACCESS_TOKEN = wxservice.refreshAuthorizerAccessToken(executePlanPara.getAppId());
        //拼参数
        JSONObject json = new JSONObject();
        wxGroupNewForm groupNewForm = new wxGroupNewForm();
        groupNewForm.setAppId(executePlanPara.getAppId());
        groupNewForm.setAccess_token(ACCESS_TOKEN);
        json.put("groupNewForm", groupNewForm);
        json.put("tenantId", executePlanPara.getMerchantId());
        json.put("activityId", executePlanPara.getPlanId());
        if (executePlanPara.getMsgtype().equals(msgtypeEnum.mpnews.getValue())) {
            wxMaterial material = new wxMaterial();
            material.setMedia_id(executePlanPara.getMediaId());
            wxMediaForm mediaForm = new wxMediaForm();
            mediaForm.setMpnews(material);
            mediaForm.setMsgtype(msgtypeEnum.mpnews.getValue());
            mediaForm.setSend_ignore_reprint(1);
            json.put("mediaForm", mediaForm);
        } else if (executePlanPara.getMsgtype().equals(msgtypeEnum.text.getValue())) {
            wxContent content = new wxContent();
            content.setContent(executePlanPara.getContent());

            wxTextMediaForm mediaForm = new wxTextMediaForm();
            mediaForm.setMsgtype("text");
            mediaForm.setText(content);
            json.put("mediaForm", mediaForm);
        }
        String ParaStr = json.toString();
        String Str = "公众号是：" + executePlanPara.getAppId() + "\n\r" + "---JSON参数是：" + ParaStr;
        return toUTF(Str);
    }

    //获得粉丝列表
    @RequestMapping(value = "/executePlanGetwebchatUser", method = {RequestMethod.POST})
    @ResponseBody
    public String executePlanGetwebchatUser(String appId) {
        String access_token = wxservice.refreshAuthorizerAccessToken(appId);
        String Url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + access_token;
        String res = HttpUtil.post(Url, null);
        net.sf.json.JSONObject obj = net.sf.json.JSONObject.fromObject(res);
        String data = obj.get("data").toString();
        String Str = "公众号是：" + appId + "\n\r ---用户列表" + data;
        return toUTF(Str);
    }
}





