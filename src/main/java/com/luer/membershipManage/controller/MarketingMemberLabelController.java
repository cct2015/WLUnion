package com.luer.membershipManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.membershipManage.bean.MarketingMemberLabel;
import com.luer.membershipManage.service.MarketingMemberLabelService;
import com.luer.comm.bean.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/marketingMemberLabel")
public class MarketingMemberLabelController {
    @Autowired
    private MarketingMemberLabelService marketingMemberLabelService;

    @ResponseBody
    @RequestMapping("/insert")
    public ResultSet insert(MarketingMemberLabel marketingMemberLabel) {
        marketingMemberLabelService.insert(marketingMemberLabel);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultSet deleteById(String id) {
        marketingMemberLabelService.delete(id);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/updateById")
    public ResultSet updateById(MarketingMemberLabel marketingMemberLabel) {
        marketingMemberLabelService.updateById(marketingMemberLabel);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public JqgridResponse<MarketingMemberLabel> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<MarketingMemberLabel> marketingMemberLabelList = marketingMemberLabelService.selectAll();
        return JqgridResponseContext.getJqgridResponse(filter,marketingMemberLabelList);
    }
}
