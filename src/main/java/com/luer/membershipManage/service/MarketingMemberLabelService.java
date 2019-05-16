package com.luer.membershipManage.service;

import com.luer.membershipManage.bean.MarketingMemberLabel;

import java.util.List;


public interface MarketingMemberLabelService {

    void insert(MarketingMemberLabel marketingMemberLabel);

    void delete(String id);

    void updateById(MarketingMemberLabel marketingMemberLabel);

    List<MarketingMemberLabel> selectAll();
}
