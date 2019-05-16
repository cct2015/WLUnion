package com.luer.shortMessage.service.impl;

import com.luer.CellphoneInform.CheckSumBuilder;
import com.luer.comm.bean.NameValue;
import com.luer.comm.utils.DateUtil;
import com.luer.comm.utils.FileUtil;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.HttpUtil;
import com.luer.config.WechatOpenProperties;
import com.luer.dataManage.dao.MarketingMerchantMapper;
import com.luer.shortMessage.bean.*;
import com.luer.shortMessage.service.ISMSAppService;
import com.luer.shortMessage.service.ShortMessageService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.*;

@Service
@Transactional
public class ShortMessageServiceImpl implements ShortMessageService {
    @Autowired
    private WechatOpenProperties wechatOpenProperties;
    @Autowired
    private MarketingMerchantMapper marketingMerchantMapper;
    @Autowired
    private ISMSAppService sMSAppService;

    /*
     * 创建应用*/
    @Override
    public String appCreate(String name, String desc, Long staffId) {
        SMSApp smsApp2 = marketingMerchantMapper.getSMSApp(GetSysUser.getSysUser().getMerchantId());

        if (String.valueOf(smsApp2.getAppId()) == null | String.valueOf(smsApp2.getAppId()) == "") {
            return "应用已存在";
        }

        String result = null;
        String url = wechatOpenProperties.getDomainUrl() + "/open-api/sms/v1/app/create";
        String apikey = wechatOpenProperties.getApikey();
       /* name = String.valueOf((new Date()).getTime() / 1000L);
        desc = "X9u4xfjssh";
        staffId = 9694261l;*/
        List<NameValue> headerList = new ArrayList<>();
        NameValue item = new NameValue();
        item.setName("apikey");
        item.setValue(apikey);
        headerList.add(item);
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("desc", desc);
        json.put("staffId", "" + staffId);
        String params = json.toString();
        result = HttpUtil.post(url, params, headerList);
        JSONObject rj = JSONObject.fromObject(result);
        SMSApp smsApp = new SMSApp();
        if (rj.getString("code").equals("200")) {
            String rs = rj.getString("result");
            JSONObject resultJson = JSONObject.fromObject(rs);
            smsApp.setAppId(Long.parseLong(resultJson.getString("appId")));
            smsApp.setAppKey(resultJson.getString("appKey"));
            smsApp.setAppSecret(resultJson.getString("appSecret"));
            smsApp.setMerchantId(GetSysUser.getSysUser().getMerchantId());
            marketingMerchantMapper.updateSMSAppInfo(smsApp);
        }
        return result;
    }

    /*签名-创建|更新*/
    @Override
    public String signatureSave(ShortMessageSignature shortMessageSignature) {

        String result = null;
        String url = wechatOpenProperties.getDomainUrl() + "/open-api/sms/v1/signature/save";
        //请求头
        List<NameValue> headerList = sMSAppService.getHeaderList(GetSysUser.getSysUser().getMerchantId());
        //请求数据
        JSONObject json = new JSONObject();
        json.put("id", shortMessageSignature.getId());
        json.put("type", shortMessageSignature.getType());
        json.put("signature", shortMessageSignature.getSignature());
        json.put("use", shortMessageSignature.getUse());

        if (shortMessageSignature.getUse() == 1) {
            /*授权书*/
            FileMessage auth = new FileMessage();
            if (!(shortMessageSignature.getAuthfileName() == null | shortMessageSignature.getAuthfileName() == "")) {
                auth.setName(shortMessageSignature.getAuthfileName());
                auth.setSize(shortMessageSignature.getAuthsize());
                auth.setUrl(shortMessageSignature.getAuthurl());
            }
            json.put("auth", auth);
            /*授权单位营业执照，非自有产品时必须要填*/
            License authLicense = new License();
            FileMessage myAuthLicense = new FileMessage();
            if (!(shortMessageSignature.getAuthLicensefileName() == null | shortMessageSignature.getAuthLicensefileName() == "")) {
                myAuthLicense.setName(shortMessageSignature.getAuthLicensefileName());
                myAuthLicense.setSize(shortMessageSignature.getAuthLicensesize());
                myAuthLicense.setUrl(shortMessageSignature.getAuthLicenseurl());
            }
            authLicense.setFile(myAuthLicense);
            if (!("" == shortMessageSignature.getAuthLicenseStart() | shortMessageSignature.getAuthLicenseStart() == null)) {
                authLicense.setStart(String.valueOf(DateUtil.getTimeByDateString(shortMessageSignature.getAuthLicenseStart(), "yyyy-MM-dd")));
            }
            if (!("" == shortMessageSignature.getAuthLicenseEnd() | shortMessageSignature.getAuthLicenseEnd() == null)) {
                authLicense.setEnd(String.valueOf(DateUtil.getTimeByDateString(shortMessageSignature.getAuthLicenseEnd(), "yyyy-MM-dd")));
            }
            json.put("authLicense", authLicense);
            /*其它证明文件，非自有产品时必须要填*/
            FileMessage proves = new FileMessage();
            if (!(shortMessageSignature.getProvesfileName() == null | shortMessageSignature.getProvesfileName() == "")) {
                proves.setName(shortMessageSignature.getProvesfileName());
                proves.setSize(shortMessageSignature.getProvessize());
                proves.setUrl(shortMessageSignature.getProvesurl());
            }
            json.put("proves", proves);
        }
        json.put("remark", shortMessageSignature.getRemark());
        /*必填字段 执行方（被授权方）营业执照*/
        License license = new License();
        FileMessage myLicense = new FileMessage();
        if (!(shortMessageSignature.getLicensefileName() == null | shortMessageSignature.getLicensefileName() == "")) {
            myLicense.setName(shortMessageSignature.getLicensefileName());
            myLicense.setSize(shortMessageSignature.getLicensesize());
            myLicense.setUrl(shortMessageSignature.getLicenseurl());
        }
        license.setFile(myLicense);
        if (!("" == shortMessageSignature.getLicenseStart() | shortMessageSignature.getLicenseStart() == null)) {
            license.setStart(String.valueOf(DateUtil.getTimeByDateString(shortMessageSignature.getLicenseStart(), "yyyy-MM-dd")));
        }
        if (!("" == shortMessageSignature.getLicenseEnd() | shortMessageSignature.getLicenseEnd() == null)) {
            license.setEnd(String.valueOf(DateUtil.getTimeByDateString(shortMessageSignature.getLicenseEnd(), "yyyy-MM-dd")));
        }
        json.put("license", license);
        json.put("staffId", shortMessageSignature.getStaffId());
        String params = json.toString();
        result = HttpUtil.post(url, params, headerList);
        System.out.println("创建签名返回值=======" +result);
        return result;
    }

    /*
     * 上传文件*/
    @Override
    public FileMessage fileUpload(MultipartFile file) {
        FileMessage fileMessage = null;
        String result = null;
        SMSApp smsApp = marketingMerchantMapper.getSMSApp(GetSysUser.getSysUser().getMerchantId());
        String apikey = wechatOpenProperties.getApikey();
        String appId = String.valueOf(smsApp.getAppId());
        File myFile = FileUtil.ChangeFile(file);
        int type = 1;
        String url = wechatOpenProperties.getDomainUrl() + "/open-api/sms/v1/file/upload";
        //请求头
        List<NameValue> headerList = new ArrayList<>();
        NameValue apikeyItem = new NameValue();
        apikeyItem.setName("apikey");
        apikeyItem.setValue(apikey);
        headerList.add(apikeyItem);
        NameValue appIdItem = new NameValue();
        appIdItem.setName("appId");
        appIdItem.setValue(appId);
        headerList.add(appIdItem);
        //请求内容
        JSONObject json = new JSONObject();
        json.put("type", type);

        String params = json.toString();
        result = HttpUtil.uploadFile(url, myFile, params, headerList);
        System.out.println("上传文件返回值=======" +result);
        JSONObject rj = JSONObject.fromObject(result);

        if (rj.getString("code").equals("200")) {
            fileMessage = new FileMessage();
            String rs = rj.getString("result");
            JSONObject resultJson = JSONObject.fromObject(rs);
            fileMessage.setUrl(resultJson.getString("url"));
            fileMessage.setSize(resultJson.getString("size"));
            fileMessage.setName(file.getOriginalFilename());
        }
        return fileMessage;
    }

    /*
    签名查询*/
    @Override
    public List<ShortMessageSignature> signatureQuery() {
        List<NameValue> headerList = sMSAppService.getHeaderList(GetSysUser.getSysUser().getMerchantId());
        String url = wechatOpenProperties.getDomainUrl() + "/open-api/sms/v1/signature/query";
        List<ShortMessageSignature> shortMessageSignatureList = new ArrayList<>();
        ShortMessageSignature shortMessageSignature;
     /*JSONObject json = new JSONObject();
        json.put("apikey", APIKEY);
        json.put("appId", APPID);
        json.put("checksum", checksum);
        json.put("timestamp", String.valueOf(timeStamp));
        params = json.toString();
        String result = HttpUtil.get(url, params);*/
        String result = HttpUtil.post(url, "", headerList);
        JSONObject rj = JSONObject.fromObject(result);
        if (rj.getString("code").equals("200")) {
            String rs = rj.getString("result");
            JSONArray signatureJson = JSONArray.fromObject(rs);
            for (Object o : signatureJson) {
                shortMessageSignature = new ShortMessageSignature();
                JSONObject oJson = JSONObject.fromObject(o);
                String id = oJson.getString("id");
                shortMessageSignature.setId(Integer.parseInt(oJson.getString("id")));
                shortMessageSignature.setSignature(oJson.getString("signature"));
                shortMessageSignature.setStaffId(Integer.parseInt(oJson.getString("staffId")));
                shortMessageSignature.setUse(Integer.parseInt(oJson.getString("use")));
                shortMessageSignature.setType(Integer.parseInt(oJson.getString("type")));
                if (oJson.getString("auditInfo") != null && oJson.getString("auditInfo") != "") {
                    shortMessageSignature.setAuditInfo(oJson.getString("auditInfo"));
                }
                shortMessageSignature.setAuditStatus(oJson.getString("auditStatus"));
                Long dateLong = Long.valueOf(oJson.getString("createTime"));
                Long dateLongTwo = Long.valueOf(oJson.getString("updateTime"));
                shortMessageSignature.setCreateTime(new Date(dateLong));
                shortMessageSignature.setUpdateTime(new Date(dateLongTwo));
                if (oJson.getString("remark") != null && oJson.getString("remark") != "") {
                    shortMessageSignature.setRemark(oJson.getString("remark"));
                }
                shortMessageSignatureList.add(shortMessageSignature);
            }
        }
        return shortMessageSignatureList;
    }

    @Override
    public ShortMessageTask messageTaskDetail(String id) {
        String url = wechatOpenProperties.getDomainUrl() + "/app-api/sms/test/task/detail";
        //String url = wechatOpenProperties.getDomainUrl() + "/app-api/sms/v1/task/detail";
        //请求头
        List<NameValue> headerList = sMSAppService.getHeaderList(GetSysUser.getSysUser().getMerchantId());
        //请求数据
        JSONObject json = new JSONObject();
        json.put("id", id);
        String params = json.toString();
        String result = HttpUtil.post(url, params, headerList);
        JSONObject obj = JSONObject.fromObject(result);
        if (obj.getLong("node") == 200) {
            String template = obj.getString("template");
            String estatus = obj.getString("status");
            String total = obj.getString("toyal");
            JSONObject jsonObj = obj.getJSONObject("details");
            String eid = jsonObj.getString("id");
            String phone = jsonObj.getString("phone");
            JSONArray param = jsonObj.getJSONArray("param");
            String status = jsonObj.getString("status");
            Long sendTime = jsonObj.getLong("sendTime");
            String staffId = jsonObj.getString("staffId");
        }

        return null;
    }

    @Override
    public String taskCount() {
        List<NameValue> headerList = sMSAppService.getHeaderList(GetSysUser.getSysUser().getMerchantId());
        String url = wechatOpenProperties.getDomainUrl() + "/open-api/sms/v1/task/count";
        String result = HttpUtil.post(url, "", headerList);
        return result;
    }

    @Override
    public List<ShortMessageTask> taskQueryByTask(TaskQuery taskQuery) {
        List<NameValue> headerList = sMSAppService.getHeaderList(GetSysUser.getSysUser().getMerchantId());
        String url = wechatOpenProperties.getDomainUrl() + "/open-api/sms/v1/task/queryByTask";
        String params = null;
        JSONObject json = new JSONObject();
        long startTime = DateUtil.getTimeByDateString(taskQuery.getStartStr(), "yyyy-MM-dd");
        long endTime = DateUtil.getTimeByDateString(taskQuery.getEndStr(), "yyyy-MM-dd");
        json.put("startTime", String.valueOf(startTime));
        json.put("endTime", String.valueOf(endTime));
        if (taskQuery.getKeyWord() != "" && taskQuery.getKeyWord() != null) {
            json.put("keyword", taskQuery.getKeyWord());
        }
       /* json.put("offset",taskQuery.getOffset());
        json.put("limit",taskQuery.getLimit());
        json.put("filters",taskQuery.getFilters());*/
        params = json.toString();
        String result = HttpUtil.post(url, params, headerList);
        List<ShortMessageTask> shortMessageTaskList = new ArrayList<>();
        ShortMessageTask shortMessageTask;
        JSONObject rj = JSONObject.fromObject(result);
        if (rj.getString("code").equals("200")) {
            String resultStr = rj.getString("result");
            JSONObject resultJson = JSONObject.fromObject(resultStr);
            String data = resultJson.getString("data");
            JSONArray dataList = JSONArray.fromObject(data);
            for (Object o : dataList) {
                shortMessageTask = new ShortMessageTask();
                JSONObject oJson = JSONObject.fromObject(o);
                String template = oJson.getString("template");
                JSONObject templateJson = JSONObject.fromObject(template);
                shortMessageTask.setTemplateId(templateJson.getString("id"));
                shortMessageTask.setTemplateName(templateJson.getString("name"));
                shortMessageTask.setAttach(oJson.getString("attach"));
                shortMessageTask.setSumCount(oJson.getString("sumCount"));
                shortMessageTask.setSucceedCount(oJson.getString("succeedCount"));
                shortMessageTask.setFailedCount(oJson.getString("failedCount"));
                shortMessageTask.setId(oJson.getString("id"));
                shortMessageTask.setName(oJson.getString("name"));
                shortMessageTask.setClickCount(oJson.getString("clickCount"));
                shortMessageTask.setFailInfo(oJson.getString("failInfo"));
                Long dateLong = Long.valueOf(oJson.getString("sendTime"));
                shortMessageTask.setSendTime(new Date(dateLong));
                shortMessageTaskList.add(shortMessageTask);
            }

        }
        return shortMessageTaskList;
    }
}
