package com.luer.dataManage.service;

import com.luer.comm.bean.TreeViewItem;
import com.luer.dataManage.bean.BaseLabel;

import java.util.List;

public interface BaseLabelService {
    void insert(BaseLabel baseLabel);

    void delete(String id);

    void updateById(BaseLabel baseLabel);

    List<BaseLabel> selectAll();

    void addBaseLabels();

    List<BaseLabel> getOneStepLabelExclude();

    List<BaseLabel> getLabelChildren(String parent_key);

    List<TreeViewItem> get163LabelCity();

    List<BaseLabel> selectByType(String selectType, String selectValue,Integer source);

    List<BaseLabel> selectBySource(Integer source);

    List<BaseLabel> selectBySourceAndStep(Integer source, Integer step);

    void updateIsValid(String id, Integer isValid);

    void prohibitAll(Integer source, Integer isValid);
}
