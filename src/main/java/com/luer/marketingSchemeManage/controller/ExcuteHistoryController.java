package com.luer.marketingSchemeManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.marketingSchemeManage.bean.ExcuteHistory;
import com.luer.marketingSchemeManage.bean.MarketingPlan;
import com.luer.marketingSchemeManage.service.ExcuteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 87961 on 2019/3/26.
 */
@Controller
public class ExcuteHistoryController {
    @Autowired
    private ExcuteHistoryService excuteHistoryService;

    @RequestMapping("/getExcuteHistoryList")
    @ResponseBody
    public JqgridResponse<ExcuteHistory> getExcuteHistoryList(JqgridFilter filter, String planId) {
        filter.refresh();
        List<ExcuteHistory> excuteHistoryList = excuteHistoryService.getExcuteHistoryList(planId);
        return JqgridResponseContext.getJqgridResponse(filter, excuteHistoryList);
    }
}
