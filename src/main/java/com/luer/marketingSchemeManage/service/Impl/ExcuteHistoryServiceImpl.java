package com.luer.marketingSchemeManage.service.Impl;

import com.luer.marketingSchemeManage.bean.ExcuteHistory;
import com.luer.marketingSchemeManage.dao.ExcuteHistoryMapper;
import com.luer.marketingSchemeManage.service.ExcuteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 87961 on 2019/3/26.
 */
@Service
@Transactional
public class ExcuteHistoryServiceImpl implements ExcuteHistoryService {
    @Autowired
    private ExcuteHistoryMapper excuteHistoryMapper;

    @Override
    public List<ExcuteHistory> getExcuteHistoryList(String planId) {

        return excuteHistoryMapper.getExcuteHistoryList(planId);
    }
}
