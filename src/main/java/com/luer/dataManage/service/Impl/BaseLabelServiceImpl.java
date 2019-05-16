package com.luer.dataManage.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luer.comm.bean.TreeViewItem;
import com.luer.comm.constants.RedisConstant;
import com.luer.comm.utils.InterfaceUtil;
import com.luer.comm.utils.RedisUtils;
import com.luer.comm.utils.UuidUtils;
import com.luer.dataManage.bean.BaseLabel;
import com.luer.dataManage.dao.BaseLabelMapper;
import com.luer.dataManage.service.BaseLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BaseLabelServiceImpl implements BaseLabelService {
    @Autowired
    private BaseLabelMapper baseLabelMapper;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void insert(BaseLabel baseLabel) {
        baseLabel.setId(UuidUtils.getUUID());
        baseLabel.setKeyss(UuidUtils.getUUID());
        baseLabelMapper.insert(baseLabel);
    }

    @Override
    public void delete(String id) {
        baseLabelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(BaseLabel baseLabel) {
        baseLabelMapper.updateByPrimaryKeySelective(baseLabel);
    }

    @Override
    public List<BaseLabel> selectAll() {
        List<BaseLabel> baseLabelList = null;
        baseLabelList = (List<BaseLabel>) redisUtils.get(RedisConstant.LabelList);
        if (baseLabelList != null) {
            return baseLabelList;
        } else {
            baseLabelList = baseLabelMapper.selectAll();
            redisUtils.set(RedisConstant.LabelList, baseLabelList);
        }
        return baseLabelList;
    }

    @Override
    public void addBaseLabels() {
//调用标签接口
        ResponseEntity<JSONObject> response = InterfaceUtil.getResponse("/open-api/questionnaire/getConditionLabel");
        JSONObject labels = response.getBody();

        JSONObject jsonobject = JSON.parseObject(labels.toJSONString());
        JSONObject data = jsonobject.getJSONObject("data");
        JSONObject json = JSON.parseObject(data.toJSONString());
        String items = json.getString("items");


        JSONArray createArray = JSONArray.parseArray(items);

        List<BaseLabel> list = JSONObject.parseArray(createArray.toJSONString(), BaseLabel.class);
        baseLabelMapper.deleteAll();
        baseLabelMapper.insertBaseLabelList(list);

    }

    //获得所有的一级标签 最多50个
    @Override
    public List<BaseLabel> getOneStepLabelExclude() {
        //先注释掉redis,以后去掉注释
        List<BaseLabel> baseLabelList = null;
//        baseLabelList=(List<BaseLabel>) redisUtils.get(RedisConstant.OneStepLabelExclude);
//        if(baseLabelList!=null) {
//            return baseLabelList;
//        }else {
        baseLabelList = baseLabelMapper.getOneStepLabelExclude();
//            redisUtils.set(RedisConstant.OneStepLabelExclude,baseLabelList);
//        }
        return baseLabelList;
    }

    //找下级标签
    @Override
    public List<BaseLabel> getLabelChildren(String parentKey) {
        List<BaseLabel> baseLabelList = null;
       /* baseLabelList = (List<BaseLabel>) redisUtils.get(parentKey);*/

        if (baseLabelList != null) {
            return baseLabelList;
        } else {
            baseLabelList = baseLabelMapper.getLabelChildren(parentKey);
            redisUtils.set(parentKey, baseLabelList);
        }
        return baseLabelList;
    }

    @Override
    public List<TreeViewItem> get163LabelCity() {
        //先注释掉redis,以后去掉注释
        List<TreeViewItem> baseLabelList = null;
//        baseLabelList=(List<TreeViewItem>) redisUtils.get(RedisConstant.W163LabelCity);
//        if(baseLabelList!=null) {
//            return baseLabelList;
//        }else {
        baseLabelList = baseLabelMapper.get163LabelCity();
//            redisUtils.set(RedisConstant.W163LabelCity,baseLabelList);
//        }
        return baseLabelList;
    }

    @Override
    public List<BaseLabel> selectByType(String selectType, String selectValue, Integer source) {
        List<BaseLabel> baseLabelList = null;
        if ("1".equals(selectType)) {
            baseLabelList = baseLabelMapper.selectByText(selectValue, source);
        } else if ("2".equals(selectType)) {
            BaseLabel baseLabel = baseLabelMapper.selectByTextHead(selectValue, source);

            baseLabelList = baseLabelMapper.getLabelChildren(baseLabel.getKeyss());

        }

        return baseLabelList;
    }

    @Override
    public List<BaseLabel> selectBySource(Integer source) {
        return baseLabelMapper.selectBySource(source);
    }

    @Override
    public List<BaseLabel> selectBySourceAndStep(Integer source, Integer step) {

        if (step == 1) {

            List<BaseLabel> baseLabelList = baseLabelMapper.selectBySourceAndStep(source);

            return baseLabelList;
        }
        return null;
    }

    @Override
    public void updateIsValid(String id, Integer isValid) {
        BaseLabel baseLabel = new BaseLabel();
        baseLabel.setId(id);
        baseLabel.setIsValid(isValid);

        baseLabelMapper.updateByPrimaryKeySelective(baseLabel);
    }

    @Override
    public void prohibitAll(Integer source, Integer isValid) {


        baseLabelMapper.prohibitAllBySource(source, isValid);
    }
}
