package com.luer.dataManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.dataManage.bean.MerchantDefineData;
import com.luer.dataManage.bean.MerchantInformation;
import com.luer.dataManage.service.MerchantInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 87961 on 2019/3/15.
 */
@Controller
@RequestMapping("/merchantInformation")
public class MerchantInformationController {
    @Autowired
    private MerchantInformationService merchantInformationService;

    @ResponseBody
    @RequestMapping("/getMerchantInformation")
    private MerchantInformation getMerchantInformation(){

        return merchantInformationService.getMerchantInformation();
    }
    @ResponseBody
    @RequestMapping("/getMerchantDefineInformation")
    public MerchantDefineData getMerchantDefineInformation(String url){

        return merchantInformationService.getMerchantDefineInformation(url);
    }
    @ResponseBody
    @RequestMapping("/getMerchantDefineDataList")
    public JqgridResponse<MerchantDefineData> getMerchantDefineDataList(JqgridFilter filter){
        filter.refresh();
        List<MerchantDefineData> list=merchantInformationService.getMerchantDefineDataList();
        return JqgridResponseContext.getJqgridResponse(filter,list);
    }
    @ResponseBody
    @RequestMapping("/addMerchantDefineData")
    public ResultSet addMerchantDefineData(MerchantDefineData merchantDefineData){
        merchantInformationService.addMerchantDefineData(merchantDefineData);
        return ResultSet.getSuccess();
    }
    @ResponseBody
    @RequestMapping("/updateMerchantDefineData")
    public ResultSet updateMerchantDefineData(MerchantDefineData merchantDefineData){
        merchantInformationService.updateMerchantDefineData(merchantDefineData);
        return ResultSet.getSuccess();
    }
    @ResponseBody
    @RequestMapping("/deleteById")
    public ResultSet deleteById(String id){
        merchantInformationService.deleteById(id);
        return ResultSet.getSuccess();
    }

}
