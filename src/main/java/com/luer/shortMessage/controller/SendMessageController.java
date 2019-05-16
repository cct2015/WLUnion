package com.luer.shortMessage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luer.comm.bean.NameValue;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.HttpUtil;
import com.luer.config.WechatOpenProperties;
import com.luer.marketingSchemeManage.bean.ExecutePlanPara;
import com.luer.shortMessage.bean.Paras;
import com.luer.shortMessage.bean.SMSTemplate;
import com.luer.shortMessage.service.ISMSAppService;
import com.luer.wx.bean.wxGroupNewForm;
import com.luer.wx.service.Iwxservice;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/SMSExecute")
@Controller
public class SendMessageController {

    @Autowired
    Iwxservice wxservice;
    @Autowired
    private WechatOpenProperties wechatOpenProperties;

    @Autowired
    private ISMSAppService sMSAppService;

    //短信任务-新建，实际是传给网易参数，由网易的接口创建
    @RequestMapping(value = "/executePlanSMS", method = {RequestMethod.POST})
    @ResponseBody
    public ResultSet executePlanSMS(String planId, long templateId, String name, String paras) {
        //以下调用网易接口
        String domainUrl = wechatOpenProperties.getSMSdomainUrl();//这里是网易的地址
        String Url = domainUrl + "/api/wanglu/sms/task/create";
        String merchantId = GetSysUser.getSysUser().getMerchantId();
        List<NameValue> headerList = sMSAppService.getHeaderList(merchantId);

        //拼参数
        JSONObject json = new JSONObject();
        json.put("templateId", templateId);
        json.put("name", name);

        List<Paras> paraList = new ArrayList<>();
        Paras onepara = null;
        if (paras.indexOf("|") > 0) {
            String[] arr = paras.split("\\|");
            for (int i = 0; i < arr.length; i++) {
                onepara = new Paras();
                onepara.setParam(arr[i]);
                onepara.setType(1);//1是普通，2是转短链接
                paraList.add(onepara);
            }
        } else {
            onepara = new Paras();
            onepara.setParam(paras);
            onepara.setType(1);//1是普通，2是转短链接
            paraList.add(onepara);
        }
        json.put("params", paraList);

        json.put("attach", "营销信息");//附件信息，不会对此字段做任何操作
        json.put("staffId", 7788);
        json.put("entId", merchantId);
        json.put("marketingId", planId);
        /*json.put("targetType", 2);
        json.put("target", "[18321933143,18600163949,13472585009,13120892136]");*/
         json.put("targetType", 4);
         json.put("target", "[18321933143,18600163949,13472585009,13120892136]");

        String ParaStr = json.toString();
        //返回
        System.out.println("短信任务参数=======" + ParaStr);
        String res = HttpUtil.post(Url, ParaStr, headerList);
        net.sf.json.JSONObject rj = net.sf.json.JSONObject.fromObject(res);
        System.out.println("短信任务返回值=======" + res);
        if (rj.getString("code").equals("200")) {
            res="短信任务创建成功";
            return ResultSet.getSuccess(res);
        }else{
            res=rj.getString("message");
            return ResultSet.getFail(res);
        }

        //return ResultSet.getSuccess();
    }

    //创建短信模板
    @RequestMapping(value = "/createSMSTemplate", method = {RequestMethod.POST})
    @ResponseBody
    public ResultSet createSMSTemplate(int type, String name, String content) {
//        int type = 2;                              //模板类别，2是通知类 3是运营类
//        String name = "优惠信息模板";               //模板名
//        String content = "消费超过%s元的，8折优惠"; //模板内容
        //以下调用网易接口
        String domainUrl = wechatOpenProperties.getDomainUrl();//这里是网易的地址
        String Url = domainUrl + "/open-api/sms/v1/template/save";
        //String Url = domainUrl + "/open-api/sms/v1/template/save";
        String merchantId = GetSysUser.getSysUser().getMerchantId();
        List<NameValue> headerList = sMSAppService.getHeaderList(merchantId);
        //拼参数
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("name", name);
        json.put("content", content);
        json.put("staffId", 7788);
        String ParaStr = json.toString();
        //返回

        String res = HttpUtil.post(Url, ParaStr, headerList);
        System.out.println("创建短信模板返回值=======" + res);
        net.sf.json.JSONObject rj = net.sf.json.JSONObject.fromObject(res);
        if (rj.getString("code").equals("200")) {
            res="短信模板创建成功";
            return ResultSet.getSuccess(res);
        }else{
            res=rj.getString("message");
            return ResultSet.getFail(res);
        }
        //return res;
    }

    //删除短信模板
    @RequestMapping(value = "/deleteSMSTemplate")
    @ResponseBody
    public String deleteSMSTemplate(long id) {
        String domainUrl = wechatOpenProperties.getDomainUrl();//这里是网易的地址
        String Url = domainUrl + "/open-api/sms/v1/template/delete";
        //String Url = domainUrl + "/open-api/sms/v1/template/delete";
        String merchantId = GetSysUser.getSysUser().getMerchantId();
        List<NameValue> headerList = sMSAppService.getHeaderList(merchantId);
        //拼参数
        JSONObject json = new JSONObject();
        json.put("id", id);
        String ParaStr = json.toString();
        //返回
        String res = HttpUtil.post(Url, ParaStr, headerList);
        return res;
    }

    //获得模板列表
    @RequestMapping(value = "/getSMSTemplateList")
    @ResponseBody
    public List<SMSTemplate> getSMSTemplateList() {
        return getAllTemplate();
    }

    private List<SMSTemplate> getAllTemplate() {
        List<SMSTemplate> smsTemplateList = new ArrayList<>();
        String domainUrl = wechatOpenProperties.getDomainUrl();//这里是网易的地址
        String Url = domainUrl + "/open-api/sms/v1/template/query";
        //String Url = domainUrl + "/open-api/sms/v1/template/query";
        String merchantId = GetSysUser.getSysUser().getMerchantId();
        List<NameValue> headerList = sMSAppService.getHeaderList(merchantId);
        //拼参数
        JSONObject json = new JSONObject();
        json.put("sortBy", "createTime");
        json.put("order", "desc");

        String ParaStr = json.toString();
        //返回
        String res = "";
        try {
            res = HttpUtil.post(Url, ParaStr, headerList);
            JSONObject obj = JSONObject.parseObject(res);
            if (!obj.containsKey("code")) {
                return smsTemplateList;
            } else if (obj.getLong("code") == 200) {
                JSONObject result = JSONObject.parseObject(obj.get("result").toString());
                JSONArray listArray = (JSONArray) result.get("data");
                for (int i = 0; i < listArray.size(); i++) {
                    SMSTemplate smsTemplate = new SMSTemplate();
                    JSONObject template = listArray.getJSONObject(i);
                    System.out.println(template);
                    Long dateLong = Long.valueOf(template.get("createTime").toString());
                    Long dateLongTwo = Long.valueOf(template.get("updateTime").toString());
                    smsTemplate.setAuditInfo(template.get("auditInfo").toString());
                    smsTemplate.setAuditStatus(template.get("auditStatus").toString());
                    smsTemplate.setContent(template.get("content").toString());
                    smsTemplate.setCreateTime(new Date(dateLong));
                    smsTemplate.setId(template.get("id").toString());
                    smsTemplate.setName(template.get("name").toString());
                    smsTemplate.setStaffId(template.get("staffId").toString());
                    smsTemplate.setStatus(template.get("status").toString());
                    smsTemplate.setType(template.get("type").toString());
                    smsTemplate.setUpdateTime(new Date(dateLongTwo));
                    smsTemplateList.add(smsTemplate);
                }
                System.out.println(smsTemplateList.size());
                return smsTemplateList;

            } else {
                return smsTemplateList;
            }
        } catch (Exception ex) {
            return smsTemplateList;
        }

    }

    @RequestMapping(value = "/sendPlanSMSPage")
    public String sendPlanSMSPage(Model model) {
        //  String res=getAllTemplate();
        //  List<SMSTemplate> list=JSONObject.parseArray(res,SMSTemplate.class);
        //   model.addAttribute("templatelist",list);
        return "templates/marketingSchemeManage/sendPlanSMS";
    }


}

