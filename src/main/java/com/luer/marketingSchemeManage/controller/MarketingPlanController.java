package com.luer.marketingSchemeManage.controller;

import com.alibaba.fastjson.JSONObject;
import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.HttpUtil;
import com.luer.config.WechatOpenProperties;
import com.luer.marketingSchemeManage.bean.*;
import com.luer.marketingSchemeManage.service.MarketingPlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87961 on 2018/12/18.
 */
@RestController
@RequestMapping("/marketingPlan")
public class MarketingPlanController {
    @Autowired
    private MarketingPlanService marketingPlanService;
    @Autowired
    private WechatOpenProperties wechatOpenProperties;

    @RequestMapping("/selectAll")
    public JqgridResponse<MarketingPlan> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlan> marketingPlans = marketingPlanService.getMarketingPlan();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlans);
    }

    @RequestMapping("/addMarketingPlan")
    public void addMarketingPlan(MarketingPlan marketingPlan) {
        String id = marketingPlanService.addMarketingPlan(marketingPlan);
    }
    @RequestMapping("/addMarketingPlanByJD")
    public ResultSet addMarketingPlanByJD(String merchants,String good) throws IOException {
         marketingPlanService.addMarketingPlanByJD(merchants,good);
        return ResultSet.getSuccess();
    }

    @RequestMapping("/updateMarketingPlan")
    public String updateMarketingPlan(MarketingPlan marketingPlan) {
        String id = marketingPlanService.updateMarketingPlan(marketingPlan);
        return id;
    }

    ////////////////总部功能//////////////////
    //营销方案查看(planStatus 方案执行状态 ** 不传默认显示全部((下同)))
    @RequestMapping("/getMarketingPlanInHQByPlanStatus")
    public JqgridResponse<MarketingPlan> getMarketingPlanInHQByPlanStatus(JqgridFilter filter, @Param("status") String status) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getMarketingPlanInHQByPlanStatus(status);
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    //查看历史营销方案
    @RequestMapping("/getHistroyMarketingPlanInHQ")
    public JqgridResponse<MarketingPlan> getHistroyMarketingPlanInHQ(JqgridFilter filter, @Param("planStatus") String planStatus) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getHistroyMarketingPlanInHQ(planStatus);
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    ///////////代理商功能/////////////////
    //下级企业营销方案查看(parentId 代理商商户id)
    @RequestMapping("/getMarketingPlanInAgentByPlanStatus")
    public JqgridResponse<MarketingPlan> getMarketingPlanInAgentByPlanStatus(JqgridFilter filter, String planStatus) {
        List<MarketingPlan> marketingPlanList = marketingPlanService.getMarketingPlanInAgentByPlanStatus(planStatus);
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    ///////////企业功能/////////////////
    //查看营销方案(增删改查)
    //merchantId 商户merchantId
    @RequestMapping("/getMarketingPlanInEnterprise")//获得当前企业的营销方案
    public JqgridResponse<MarketingPlan> getMarketingPlanInEnterprise(JqgridFilter filter, int status) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getMarketingPlanInEnterprise(status);
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    //获取渠道商下级企业的营销方案
    @RequestMapping("/getMarketingPlanlower")
    public JqgridResponse<MarketingPlan> getMarketingPlanlower(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getMarketingPlanlower();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    //或得待审核方案
    @RequestMapping("/getMarketingPlanExamine")//获得当前企业的营销方案
    public JqgridResponse<MarketingPlan> getMarketingPlanExamine(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getMarketingPlanExamine();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    //获得异业推荐的营销方案列表
    @RequestMapping("/getOtherMarketingPlanList")
    public JqgridResponse<VPlanRecommend> getOtherMarketingPlanList(JqgridFilter filter, int status) {
        filter.refresh();
        List<VPlanRecommend> marketingPlanList = marketingPlanService.getOtherMarketingPlan(status);
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    @RequestMapping("/getMarketingPlanInEnterpriseById")//跟据方案id获得方案
    public MarketingPlan getMarketingPlanInEnterpriseById(JqgridFilter filter, String id) {
        return marketingPlanService.getMarketingPlanInEnterpriseById(id);
    }

    @ResponseBody
    @RequestMapping("/addMarketingPlanInEnterprise")//添加营销方案
    public ResultSet addMarketingPlanInEnterprise(MarketingPlan marketingPlan) {
        int num = marketingPlanService.addMarketingPlanInEnterprise(marketingPlan);
        return ResultSet.getSuccess();
    }

    @RequestMapping("/deleteMarketingPlanDotInEnterprise")//删除营销方案和对应标签关系
    public ResultSet deleteMarketingPlanDotInEnterprise(String id) {
        int num = marketingPlanService.deleteMarketingPlanDotInEnterprise(id);
        return ResultSet.getSuccess();
    }

    @RequestMapping("/updateMarketingPlanInEnterprise")//更新营销方案
    public ResultSet updateMarketingPlanInEnterprise(MarketingPlan marketingPlan) {
        int num = marketingPlanService.updateMarketingPlanInEnterprise(marketingPlan);
        return ResultSet.getSuccess();
    }

    @ResponseBody
    @RequestMapping("/couponMarketingPlanInEnterprise")//设置优惠券链接
    public ResultSet couponMarketingPlanInEnterprise(@RequestParam("id") String id, @RequestParam(value="list",required=false) String list,@RequestParam("couponUrl") String couponUrl,@RequestParam("couponsSource") String couponsSource,@RequestParam("isDifferent") int isDifferent) {
       int res = marketingPlanService.couponMarketingPlanInEnterprise(id, list, couponUrl,couponsSource, isDifferent);
        if (res > 0) {
            return ResultSet.getSuccess();
        } else {
            return ResultSet.getFail();
        }

    }

    @RequestMapping("/examineMarketingPlan")//审核营销方案
    public ResultSet examineMarketingPlan(MarketingPlan marketingPlan) {
        int res = marketingPlanService.examineMarketingPlan(marketingPlan);
        if (res > 0) {
            return ResultSet.getSuccess();
        } else {
            return ResultSet.getFail();
        }
    }

    //接受异业推荐的营销方案
    @RequestMapping("/acceptMarketingPlanInEnterprise")
    public ResultSet acceptMarketingPlanInEnterprise(MarketingPlanRecommend marketingPlanRecommend) {
        int num = marketingPlanService.acceptMarketingPlanInEnterprise(marketingPlanRecommend);
        if (num > 0) {
            return ResultSet.getSuccess();
        } else {
            return ResultSet.getFail();
        }
    }

    //查看执行中营销方案
    @RequestMapping("/getExecutingMarketingPlanInEnterprise")
    public JqgridResponse<MarketingPlan> getExecutingMarketingPlanInEnterprise(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getExecutingMarketingPlanInEnterprise();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    //查看营销方案执行状态
    @RequestMapping("/getExecuteMarketingPlanPacking")
    public JqgridResponse<MarketingPlanPacking> getExecuteMarketingPlanPacking(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlanPacking> marketingPlanPackings = marketingPlanService.getExecuteMarketingPlanPacking();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanPackings);
    }

    //获得需要触达的营销方案，包括自己发起的和异业推荐的
    @RequestMapping("/getTouchPlanList")
    public JqgridResponse<VValueabledPlans> getTouchPlanList(JqgridFilter filter) {
        filter.refresh();
        List<VValueabledPlans> touchPlanList = marketingPlanService.getTouchPlanList();
        return JqgridResponseContext.getJqgridResponse(filter, touchPlanList);
    }


    //获得所有已经通过审核可以执行的营销方案，包括已经执行和没执行的,包括异业推荐，已经接受的营销方案
    @RequestMapping("/getExecutePlanList")
    public JqgridResponse<VValueabledPlans> getExecutePlanList(JqgridFilter filter) {
        filter.refresh();
        List<VValueabledPlans> touchPlanList = marketingPlanService.getExecutePlanList();
        return JqgridResponseContext.getJqgridResponse(filter, touchPlanList);
    }

    //查看待审核的营销方案
    @RequestMapping("/getCheckMarketingPlanInEnterprise")
    public JqgridResponse<MarketingPlan> getCheckMarketingPlanInEnterprise(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getCheckMarketingPlanInEnterprise();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    //查看可接受的营销方案
    @RequestMapping("/getCanAcceptMarketingPlanInEnterprise")
    public JqgridResponse<MarketingPlan> getCanAcceptMarketingPlanInEnterprise(JqgridFilter filter) {
        filter.refresh();
        List<MarketingPlan> marketingPlanList = marketingPlanService.getCanAcceptMarketingPlanInEnterprise();
        return JqgridResponseContext.getJqgridResponse(filter, marketingPlanList);
    }

    @RequestMapping("/marketingPlanLabelSettingPage")
    public ModelAndView marketingPlanLabelSettingPage(String id, Model model) {
        ModelAndView view = new ModelAndView("templates/marketingSchemeManage/marketingPlanLabelSetting");
        model.addAttribute("id", id);
        return view;
    }

    @RequestMapping("/getPersonsPackage")
    @ResponseBody
    public String getPersonsPackage(String marketId) {

        //以下调用网易接口
        String domainUrl = wechatOpenProperties.getForcastdomainUrl();//这里是网易的地址
        String merchantId = GetSysUser.getSysUser().getMerchantId().trim();
        String Url = domainUrl + "/api/wanglu/customerGroup/qty?tenantId=" + merchantId + "&marketId=" + marketId;
        //返回
        String res = HttpUtil.post(Url, null);
        JSONObject obj = JSONObject.parseObject(res);
        if (obj.containsKey("code")) {
            return obj.toString();
        } else if (obj.containsKey("errcode")) {
            return "[]";
        } else {
            return "[]";
        }
    }

}
