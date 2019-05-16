package com.luer.marketingSchemeManage.controller;


import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.marketingSchemeManage.bean.MarketingWxTemplate;
import com.luer.marketingSchemeManage.service.MarketingWxTemplateService;
import com.luer.sys.bean.SysQa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping(value = "/WxManage")
public class WxTemplateController {
@Autowired
    private MarketingWxTemplateService marketingWxTemplateService;
    @RequestMapping(value = "/WXPlanInEnterprise")
    @ResponseBody
    public JqgridResponse<MarketingWxTemplate> getWX_PlanInEnterprise(JqgridFilter filter) {
        filter.refresh();
        List<MarketingWxTemplate> MarketingWxTemplateList = marketingWxTemplateService.WxPlanInEnterprise();
        return JqgridResponseContext.getJqgridResponse(filter, MarketingWxTemplateList);
    }
    @RequestMapping(value = "/deleteWXPlanDotInEnterprise")//
    @ResponseBody
    public ResultSet deleteMarketingWX_PlanDotInEnterprise(String id){
        int num=marketingWxTemplateService.deleteWXEnterprise(id);
        return ResultSet.getSuccess();
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @RequestMapping(value = "/addWXPlanQAManage")
    @ResponseBody
    public ResultSet addPlanWX_Manage(MarketingWxTemplate marketingWxTemplate){
        marketingWxTemplate.setAddTime(new Date());
        marketingWxTemplate.setAddUser(GetSysUser.getSysUser().getUsername());
        marketingWxTemplate.setMerchantid(GetSysUser.getSysUser().getMerchantId());
        int num=marketingWxTemplateService.addPlanWXManage(marketingWxTemplate);

        return ResultSet.getSuccess();
    }

    @RequestMapping(value = "/updateWXManage",method = RequestMethod.POST)
    @ResponseBody
    public ResultSet updateWX_Manage(MarketingWxTemplate marketingWxTemplate){

        int num=marketingWxTemplateService.updateWXManage(marketingWxTemplate);

        return ResultSet.getSuccess();
    }
}
