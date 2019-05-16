package com.luer.dataManage.service.serviceImpl;

import com.luer.dataManage.bean.BaseIndustry;
import com.luer.dataManage.dao.BaseIndustryMapper;
import com.luer.dataManage.service.BaseIndustryService;
import com.luer.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseIndustryServiceImpl implements BaseIndustryService {
    @Autowired
    private BaseIndustryMapper baseIndustryMapper;

    @Override
    public void insert(BaseIndustry baseIndustry) {
        baseIndustry.setId(UUIDUtils.getUUID());
        baseIndustryMapper.insert(baseIndustry);
    }

    @Override
    public void delete(String id) {
        baseIndustryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(BaseIndustry baseIndustry) {
        baseIndustryMapper.updateByPrimaryKeySelective(baseIndustry);
    }

    @Override
    public List<BaseIndustry> selectAll() {
        List<BaseIndustry> baseIndustryList=baseIndustryMapper.selectAll();
        return baseIndustryList;
    }
}
