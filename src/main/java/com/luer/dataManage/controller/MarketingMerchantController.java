package com.luer.dataManage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.dataManage.bean.MarketingMerchant;
import com.luer.dataManage.bean.MerchantType;
import com.luer.dataManage.service.MarketingMerchantService;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.shortMessage.bean.SMSApp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/marketingMerchant")
public class MarketingMerchantController {
    @Autowired
    private MarketingMerchantService marketingMerchantService;

    @ResponseBody
    @RequestMapping("/insert")
    public ResultSet insert(MarketingMerchant marketingMerchant) {
        marketingMerchantService.insert(marketingMerchant);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultSet deleteById(String id) {
        marketingMerchantService.delete(id);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/updateById")
    public ResultSet updateById(MarketingMerchant marketingMerchant) {
        marketingMerchantService.updateById(marketingMerchant);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public JqgridResponse<MarketingMerchant> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectAll();
        return JqgridResponseContext.getJqgridResponse(filter,marketingMerchantList);
    }
    @ResponseBody
    @RequestMapping("/getParentMerchant")
    public List<MarketingMerchant> getParentMerchant() {
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.getParentMerchant();
        return marketingMerchantList;
    }

    @ResponseBody
    @RequestMapping(value = "/merchantAndUserInsert",method = RequestMethod.POST)
    public ResultSet merchantAndUserInsert(String jsonStr, SysUser sysUser) throws Exception {
        marketingMerchantService.merchantAndUserInsert(jsonStr,sysUser);
        return ResultSet.getSuccess();
    }
    //通过类型和级别查询商户
    @ResponseBody
    @RequestMapping("/selectByTypeAndStep")
    public JqgridResponse<MarketingMerchant> selectByTypeAndStep(JqgridFilter filter, @Param("type") int type,@Param("step") int step) {
        filter.refresh();
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectByTypeAndStep(type,step);
        return JqgridResponseContext.getJqgridResponse(filter,marketingMerchantList);
    }
    //通过类型和上级商户查询商户
    @ResponseBody
    @RequestMapping("/selectByTypeAndParentId")
    public JqgridResponse<MarketingMerchant> selectByTypeAndParentId(JqgridFilter filter, @Param("type") int type,@Param("parentId") String parentId) {
        filter.refresh();
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectByTypeAndParentId(type,parentId);
        return JqgridResponseContext.getJqgridResponse(filter,marketingMerchantList);
    }
    //获取所有商户
    @ResponseBody
    @RequestMapping("/selectMerchantByType")
    public JqgridResponse<MarketingMerchant> selectMerchantByType(JqgridFilter filter) {
        filter.refresh();
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectMerchantByType();
        return JqgridResponseContext.getJqgridResponse(filter,marketingMerchantList);
    }

    //获取所有商户(所有)
    @ResponseBody
    @RequestMapping("/selectMerchantListByType")
    public List<MarketingMerchant> selectMerchantListByType(JqgridFilter filter) {

        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectMerchantByType();
        return marketingMerchantList;
    }
    //通过id查询商户
    @ResponseBody
    @RequestMapping("/selectById")
    public JqgridResponse<MarketingMerchant> selectById(JqgridFilter filter,@Param("id") String id) {
        filter.refresh();
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectById(id);
        return JqgridResponseContext.getJqgridResponse(filter,marketingMerchantList);
    }

    @ResponseBody
    @RequestMapping("/getMerchantById")
    public MerchantType getMerchantById() {

        return  marketingMerchantService.getMerchantById();
    }

    //条件查询
//通过id查询商户
    @ResponseBody
    @RequestMapping("/selectByType")
    public JqgridResponse<MarketingMerchant> selectByType(JqgridFilter filter,@Param("selectType") String selectType,@Param("selectValue") String selectValue,@Param("merchantType") Integer merchantType) {
        filter.refresh();
        List<MarketingMerchant> marketingMerchantList = marketingMerchantService.selectByType(selectType,selectValue,merchantType);
        return JqgridResponseContext.getJqgridResponse(filter,marketingMerchantList);
    }
    //查询当前商户应用
    @ResponseBody
    @RequestMapping("/selectByNow")
    public JqgridResponse<SMSApp> selectByNow(JqgridFilter filter) {
        filter.refresh();
        List<SMSApp> smsAppList = marketingMerchantService.selectByNow();
        return JqgridResponseContext.getJqgridResponse(filter,smsAppList);
    }
}
