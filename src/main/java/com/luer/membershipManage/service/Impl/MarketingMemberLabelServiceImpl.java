package com.luer.membershipManage.service.Impl;

import com.luer.membershipManage.bean.MarketingMemberLabel;
import com.luer.membershipManage.dao.MarketingMemberLabelMapper;
import com.luer.membershipManage.service.MarketingMemberLabelService;
import com.luer.comm.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class MarketingMemberLabelServiceImpl implements MarketingMemberLabelService{
    @Autowired
    private MarketingMemberLabelMapper marketingMemberLabelMapper;

    @Override
    public void insert(MarketingMemberLabel marketingMemberLabel) {

        marketingMemberLabel.setId(UuidUtils.getUUID());
        marketingMemberLabelMapper.insert(marketingMemberLabel);
    }

    @Override
    public void delete(String id) {
        marketingMemberLabelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(MarketingMemberLabel marketingMemberLabel) {
        marketingMemberLabelMapper.updateByPrimaryKeySelective(marketingMemberLabel);
    }

    @Override
    public List<MarketingMemberLabel> selectAll() {
        List<MarketingMemberLabel> marketingMemberLabelList=marketingMemberLabelMapper.selectAll();
        return marketingMemberLabelList;
    }
}
