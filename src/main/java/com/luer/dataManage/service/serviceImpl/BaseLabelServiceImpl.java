package com.luer.dataManage.service.serviceImpl;

import com.luer.dataManage.bean.BaseLabel;
import com.luer.dataManage.dao.BaseLabelMapper;
import com.luer.dataManage.service.BaseLabelService;
import com.luer.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseLabelServiceImpl implements BaseLabelService {
    @Autowired
    private BaseLabelMapper baseLabelMapper;

    @Override
    public void insert(BaseLabel baseLabel) {
        baseLabel.setId(UUIDUtils.getUUID());
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
        List<BaseLabel> baseLabelList=baseLabelMapper.selectAll();
        return baseLabelList;
    }
}
