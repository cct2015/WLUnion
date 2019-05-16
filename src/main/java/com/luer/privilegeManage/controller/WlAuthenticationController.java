package com.luer.privilegeManage.controller;

import com.alibaba.fastjson.JSONObject;
import com.luer.comm.utils.HttpUtil;
import com.luer.comm.utils.WlAuthentication;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.service.WlauthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@Controller
@RequestMapping("/authentication")
public class WlAuthenticationController {
    @Autowired
    private WlauthenticationService wlauthenticationService;

    /*
     *   通过cookie值校验用户合法性的接口
     */
    @ResponseBody
    @PostMapping("/JudgingWlAuthentication")
    public Map judgingWlAuthentication(String str) {


        return wlauthenticationService.checkUserCookie(str);
    }

    /*
     *获取用户信息cookie的key
     */
    @ResponseBody
    @PostMapping("/getUserCookie")
    public String getUserCookie() throws UnsupportedEncodingException {
        SysUser sysUser = new SysUser();
        sysUser.setId("23c5bdc24809453f89c56a0d0900a2b0");
        sysUser.setUserType("4");
        sysUser.setMerchantId("73c981b046944f1391af5b8e01e29b3d");
        String result = WlAuthentication.getUserCookieValue(sysUser);
        //System.out.println("result========"+result);
        String cookieValue = URLEncoder.encode(result, "UTF-8");
        //System.out.println("cookieValue========"+cookieValue);
        return result;


    }

    @ResponseBody
    @PostMapping("/getJson")
    public Map getJson() {
        /*System.out.println(wlauthenticationService.decryptValue("zkwbZVeFujyaZ64M16MUmVMZIno2k7TwcIg9vq//q21AtxZEdGPpJVxEBKAIvzTg"));*/
        Map map = wlauthenticationService.getMap();
        return map;
    }

    @ResponseBody
    @PostMapping("/testWlauthentication")
    public String testWlauthentication() {


        Map map = wlauthenticationService.getMap();
        String json = JSONObject.toJSONString(map);
        String result = HttpUtil.httpGet("http://59.111.61.184:8080/WLUnion/authentication/JudgingWlAuthentication", "POST", map);
        return result;
    }


}
