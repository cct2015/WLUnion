package com.luer.comm.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cloud on 2018/12/18.
 */
public class InterfaceUtil {
    public static  ResponseEntity<JSONObject> getResponse(String urls){
        String appKey = "0eeba984bc506258952fbf10d518801f";
        String appSecret = "c59918f0f0e6ed9ae5b2ff6f4a93366d7d4f26b0";
        long time = System.currentTimeMillis();

        final String url = "https://ds.hz.netease.com"+urls;
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("appKey", appKey);
        requestHeaders.add("appSecret", DigestUtils.sha1Hex(appKey+appSecret+time));
        requestHeaders.add("time", String.valueOf(time));
        RestTemplate template = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        ResponseEntity<JSONObject> response = template.exchange(url, HttpMethod.GET, requestEntity, JSONObject.class);
        return response;
    }
}
