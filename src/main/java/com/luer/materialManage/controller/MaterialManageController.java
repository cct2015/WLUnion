package com.luer.materialManage.controller;

import com.luer.comm.utils.GetSysUser;
import com.luer.materialManage.service.ImaterialManageservice;
import com.luer.wx.bean.MarketingMerchantWx;
import com.luer.wx.bean.WechatUser;
import com.luer.wx.service.Iwxservice;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/materialManage")
@Controller
public class MaterialManageController {

    @Autowired
    Iwxservice wxservice;
    @Autowired
    ImaterialManageservice materialManageservice;

    @RequestMapping(value = "/queryMaterialList", method = {RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryMaterialList(String appId, String msgtype,int offset ) {
        String Message="";
        JSONObject obj =null;
        try {
            obj = materialManageservice.queryMaterialList(appId, msgtype, offset);
        }
        catch(Exception ex)
        {
            Message="-444";
            return Message;
        }
        if(obj==null) return "-444";
        if(obj.containsKey("errcode"))
        {
             return "-444";
        }
        else
        {
            Message=obj.toString();
        }
        return Message;
    }
    @RequestMapping("/toMaterialManage")
    public String toMaterialManage(Model model) {
        //取得该登录用户的所有公众号
        String merchantId = GetSysUser.getSysUser().getMerchantId();//从登陆信息中获得
        List<MarketingMerchantWx> list=wxservice.getMerchantWX(merchantId);
        WechatUser user=null;
        for (MarketingMerchantWx item: list)
        {

            try {
                user = wxservice.GetUserAccessInfo(item.getAppId());
            }
            catch(Exception ex)
            {
                user=null;
            }
            if(user!=null)
            {
                item.setAppName(user.getNickName()+"(appId:"+item.getAppId()+")");
            }
            else {
                item.setAppName("未知");
            }
        }
        model.addAttribute("appIdList",list);
        return  "templates/materialManage/allMaterialManage";
    }
}
