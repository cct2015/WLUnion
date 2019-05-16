package com.luer.membershipManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.membershipManage.bean.MarketingMember;
import com.luer.membershipManage.service.MarketingMemberService;
import com.luer.comm.bean.ResultSet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.List;

@Controller
@RequestMapping("/marketingMember")
public class MarketingMemberController {
    @Autowired
    private MarketingMemberService marketingMemberService;

    @ResponseBody
    @RequestMapping("/insert")
    public ResultSet insert(MarketingMember marketingMember) {
        marketingMemberService.insert(marketingMember);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultSet deleteById(String id) {
        marketingMemberService.delete(id);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/updateById")
    public ResultSet updateById(MarketingMember marketingMember) {
        marketingMemberService.updateById(marketingMember);
        return ResultSet.getSuccess();
    }
    @ResponseBody
    @RequestMapping("/insertExcell")
    public ResultSet importExcel(@RequestParam("file") MultipartFile file) throws Exception{

        marketingMemberService.importExcelMember(file);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public JqgridResponse<MarketingMember> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<MarketingMember> marketingMemberList = marketingMemberService.selectAll();
        return JqgridResponseContext.getJqgridResponse(filter,marketingMemberList);
    }

}
