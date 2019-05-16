package com.luer.privilegeManage.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.luer.comm.utils.SymmetricEncoder;
import com.luer.comm.utils.UuidUtils;
import com.luer.comm.utils.WlAuthentication;
import com.luer.privilegeManage.dao.SysUserMapper;
import com.luer.privilegeManage.service.WlauthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WlauthenticationServiceImpl implements WlauthenticationService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Map checkUserCookie(String str) {


        List a = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a);
        }
        System.out.println("str==" + str);
        Map endMap = new HashMap();
        String code = "1";
        String msg = "fail";
        if (str == null) {
            endMap.put("code", code);
            endMap.put("msg", msg);
            return endMap;
        }
        JSONObject newMap = JSONObject.parseObject(str);
        String timestamp = newMap.getString("timestamp");
        String uid = newMap.getString("uid");
        String ak = newMap.getString("ak");
        String authentication = newMap.getString("authentication");
        String sk = "wl163com";
        String cookieValue = newMap.getString("cookieValue");
        try {
            String value = URLDecoder.decode(cookieValue, "UTF-8");
            System.out.println("value"+value);
            Map map = new HashMap();
            map.put("timestamp", timestamp);
            map.put("uid", uid);
            map.put("ak", ak);
            map.put("authentication", authentication);
            map.put("cookieValue", value);


            if (WlAuthentication.checkAuthentication(map)) {
                /*System.out.println("timestamp==============" + "123");*/
                /*String cookieValue= Map.get("cookieValue").toString();*/
                if (decryptValue(cookieValue)) {
                    /*System.out.println("timestamp==============" + "456");*/
                    code = "0";
                    msg = "success";
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //判断cookie的值合法性
        endMap.put("code", code);
        endMap.put("msg", msg);

        return endMap;
    }


    @Override
    public Map getMap() {
        String timestamp = WlAuthentication.getTime();
        String uid = UuidUtils.getUUID();
        String ak = "wlunion";
        String sk = "wl163com";
        String authentication = WlAuthentication.getAuthentication(timestamp, uid, ak, sk);

        String cookieValue = "uvKz9Pe5qSLpogp4tNFsnTcbXrt%2B9C04KJ8%2FWGwm7Db0yw2TuD%2FhPmOFMvAWzJrKxtgV9X8vmn%2F%2B%0D%0AAkPPYzgOtQ%3D%3D";
        Map map = new HashMap();
        map.put("timestamp", timestamp);
        map.put("uid", uid);
        map.put("ak", ak);
        map.put("authentication", authentication);
        map.put("cookieValue", cookieValue);

        return map;
    }


    //解密+验证
    @Override
    public boolean  decryptValue(String str) {
        String value = "033ecb23cd1a417b91e08d3bdfdb5cba";
        boolean bool = false;

        //将参数解密
        String b = SymmetricEncoder.AESDncode(value, str);
        System.out.println(b);

        if (b != null && b.split(",").length == 3) {
            String[] strings = b.split(",");
            //获得用户id
            String usersId = strings[0];
            System.out.println("usersId==" + usersId);
            //用户商户号
            String merchantId = strings[1];
            System.out.println("merchantId==" + merchantId);
            //用户类型
            String userType = strings[2];
            //判断用户是否存在
            if (sysUserMapper.selectByPrimaryKey(usersId) != null) {
                bool = true;
            }
        }


      /*  if ("2477f6afc1414638a99a61c3bcc4e5d7".equals(str)) {
            bool = true;
        }*/

        return bool;
    }

    public static void main(String[] args) {
        (new WlauthenticationServiceImpl()).decryptValue("nQ3ouU11wzKiPBtNw4AS0HRdbCw3C8NP1TZNpr4939AjcrXLv6J%2FlP0V00rZf%2ByetMQmwCCurUTJ%0ACC%2F5aTguQ43MS%2F1xaryuyjJqECZzNNg%3D");
    }


}
