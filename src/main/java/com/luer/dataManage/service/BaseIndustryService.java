package com.luer.dataManage.service;

import com.luer.dataManage.bean.BaseIndustry;

import java.util.List;

public interface BaseIndustryService {
    
    void insert(BaseIndustry baseIndustry);

    void delete(String id);

    void updateById(BaseIndustry baseIndustry);

    List<BaseIndustry> selectAll();

    List<BaseIndustry> selectById(String id);
}
