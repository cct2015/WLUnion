package com.luer.dataManage.service.Impl;

import com.luer.comm.constants.RedisConstant;
import com.luer.comm.utils.RedisUtils;
import com.luer.comm.utils.UuidUtils;
import com.luer.dataManage.bean.BaseIndustry;
import com.luer.dataManage.dao.BaseIndustryMapper;
import com.luer.dataManage.service.BaseIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BaseIndustryServiceImpl implements BaseIndustryService {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private BaseIndustryMapper baseIndustryMapper;

    @Override
    public void insert(BaseIndustry baseIndustry) {
        baseIndustry.setId(UuidUtils.getUUID());
        baseIndustryMapper.insert(baseIndustry);
        //先清空
        redisUtils.remove(RedisConstant.Industry);
        List<BaseIndustry> baseIndustryList = baseIndustryMapper.selectAll();
        redisUtils.set(RedisConstant.Industry, baseIndustryList);
    }

    @Override
    public void delete(String id) {
        baseIndustryMapper.deleteByPrimaryKey(id);
    }

    public List<String> getIdList(String id) {

        List<String> idList = new ArrayList<String>();

        return idList;
    }

    @Override
    public void updateById(BaseIndustry baseIndustry) {
        baseIndustryMapper.updateByPrimaryKeySelective(baseIndustry);
    }

    @Override
    public List<BaseIndustry> selectAll() {
        List<BaseIndustry> baseIndustryList = null;
        baseIndustryList = (List<BaseIndustry>) redisUtils.get(RedisConstant.Industry);
        if (baseIndustryList != null) {
            return baseIndustryList;
        } else {
            baseIndustryList = baseIndustryMapper.selectAll();
            redisUtils.set(RedisConstant.Industry, baseIndustryList);
        }
        return baseIndustryList;
    }

    @Override
    public List<BaseIndustry> selectById(String id) {
        List<BaseIndustry> baseIndustryList;
        if ("initbaseIndustry".equals(id)) {
            baseIndustryList = baseIndustryMapper.selectAll();
        } else {
            baseIndustryList = new ArrayList<BaseIndustry>();
            BaseIndustry baseIndustry = baseIndustryMapper.selectByPrimaryKey(id);
            baseIndustryList.add(baseIndustry);
        }

        return baseIndustryList;
    }
}
