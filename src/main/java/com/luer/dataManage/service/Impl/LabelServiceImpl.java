package com.luer.dataManage.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luer.comm.utils.InterfaceUtil;
import com.luer.dataManage.bean.BaseLabel;
import com.luer.dataManage.bean.Label;
import com.luer.dataManage.dao.BaseLabelMapper;
import com.luer.dataManage.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cloud on 2018/12/17.
 */
@Transactional
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private BaseLabelMapper baseLabelMapper;
    /**
     * 获取标签接口
     * @return
     */
    @Override
    public Object getLabels() {

       //调用标签接口
        ResponseEntity<JSONObject> response = InterfaceUtil.getResponse("/open-api/questionnaire/getConditionLabel");
        JSONObject labels = response.getBody();

        JSONObject jsonobject = JSON.parseObject(labels.toJSONString());
        JSONObject data = jsonobject.getJSONObject("data");
        JSONObject json = JSON.parseObject(data.toJSONString());
        String items = json.getString("items");
        JSONArray createArray= JSONArray.parseArray(items);

        List<BaseLabel> list = JSONObject.parseArray(createArray.toJSONString(), BaseLabel.class);

       /* for(int i=0;i<createArray.size();i++){
            String id = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("id");
            String text = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("text");
            String descriptions = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("description");
            int length = descriptions.length();
           *//* JSONObject description = JSONObject.parseObject(descriptions );
            int size = description.size();*//*

         *//*   String srs1 = description.get("srs1").toString();
            String srs2 = description.get("srs2").toString();*//*
            String key = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("key");
            String parentKey = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("parentKey");
            String leaf = JSONObject.parseObject(JSONObject.toJSONString(createArray.get(i))).getString("leaf");
        }
*/

        return list;
    }
}
