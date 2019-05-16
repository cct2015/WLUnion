package com.luer.marketingSchemeManage.service;

import com.luer.marketingSchemeManage.bean.ExcuteHistory;

import java.util.List;

/**
 * Created by 87961 on 2019/3/26.
 */
public interface ExcuteHistoryService {
    List<ExcuteHistory> getExcuteHistoryList(String planId);
}
