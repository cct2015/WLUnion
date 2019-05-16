package com.luer.dataManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.dataManage.bean.BaseIndustry;
import com.luer.dataManage.service.BaseIndustryService;
import com.luer.comm.bean.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/baseIndustry")
public class BaseIndustryController {
    @Autowired
    private BaseIndustryService baseIndustryService;

    @ResponseBody
    @RequestMapping("/insert")
    public ResultSet insert(BaseIndustry baseIndustry) {
        baseIndustryService.insert(baseIndustry);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultSet deleteById(String id) {
        baseIndustryService.delete(id);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/updateById")
    public ResultSet updateById(BaseIndustry baseIndustry) {
        baseIndustryService.updateById(baseIndustry);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public JqgridResponse<BaseIndustry> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<BaseIndustry> baseIndustryList = baseIndustryService.selectAll();
        return JqgridResponseContext.getJqgridResponse(filter, baseIndustryList);
    }

    @ResponseBody
    @RequestMapping("/selectAll2")
    public List<BaseIndustry> selectAll2() {
        List<BaseIndustry> baseIndustryList = baseIndustryService.selectAll();
        return baseIndustryList;
    }

    @ResponseBody
    @RequestMapping("/selectById")
    public List<BaseIndustry> selectById(String id) {

        List<BaseIndustry> baseIndustryList = baseIndustryService.selectById(id);
        return baseIndustryList;
    }
}
