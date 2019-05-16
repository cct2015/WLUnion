package com.luer.WLapi.dao;

import com.luer.membershipManage.bean.MarketingMember;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface WLapiMapper {
    int importData(List<MarketingMember> list);
}
