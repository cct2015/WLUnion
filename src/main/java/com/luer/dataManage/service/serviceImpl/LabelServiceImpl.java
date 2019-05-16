package com.luer.dataManage.service.serviceImpl;

import com.luer.comm.MD5Utils;
import com.luer.dataManage.service.LabelService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cloud on 2018/12/17.
 */

@Service
public class LabelServiceImpl implements LabelService {

    /**
     * 获取标签接口
     * @return
     */
    @Override
    public Object getLabels() {

        String appKey = "0eeba984bc506258952fbf10d518801f";
        String appSecret = "c59918f0f0e6ed9ae5b2ff6f4a93366d7d4f26b0";

         appSecret = MD5Utils.md5(appKey+appSecret+System.currentTimeMillis());
        final String url = "https://ds.hz.netease.com/open-api/questionnaire/getConditionLabel";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("appSecret", appSecret);
        RestTemplate template = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String labels = response.getBody();

        return labels;
    }
}
