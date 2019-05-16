package com.luer.materialManage.service.impl;

import com.luer.comm.utils.HttpUtil;
import com.luer.materialManage.service.ImaterialManageservice;
import com.luer.wx.service.Iwxservice;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialManageservice implements ImaterialManageservice {

    @Autowired
    Iwxservice wxservice;
    @Override
    public JSONObject queryMaterialList (String appId, String msgtype,int offset)
    {
        String ACCESS_TOKEN=wxservice.refreshAuthorizerAccessToken(appId);
        String Url="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="+ACCESS_TOKEN+"";
        JSONObject json = new JSONObject();
        json.put("type", msgtype);
        json.put("offset", offset);
        json.put("count", 20);
        String res = HttpUtil.post(Url, json.toString());
        JSONObject obj = JSONObject.fromObject(res);
        return obj;
    }

}
