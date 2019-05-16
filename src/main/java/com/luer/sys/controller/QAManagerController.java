package com.luer.sys.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.comm.utils.GetSysUser;
import com.luer.sys.bean.SysQa;
import com.luer.sys.service.QAMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/qamanagePlan")
public class QAManagerController {
    @Autowired
    private QAMangerService qaMangerService;
    @RequestMapping(value = "/qamanagePlanInEnterprise")
    @ResponseBody
    public JqgridResponse<SysQa> getqamangePlanInEnterprise(JqgridFilter filter, Integer source) {
        filter.refresh();
        List<SysQa> sysQaList = qaMangerService.qamangePlanInEnterprise(source);
        return JqgridResponseContext.getJqgridResponse(filter, sysQaList);
    }

    @RequestMapping(value = "/selecttest")
    public  String selecttest(){
        return "templates/myTest/selecttest";
    }

    @RequestMapping(value = "/selecttestall")
    @ResponseBody
    public  String selecttestall(Model model){

    List<SysQa> sysQaList = qaMangerService.selecttestall();
        model.addAttribute("list",sysQaList);
        return "templates/myTest/selecttest";
}

    @RequestMapping(value = "/deleteMarketingPlanDotInEnterprise")//
    @ResponseBody
    public ResultSet deleteMarketingPlanDotInEnterprise(String id){
        int num=qaMangerService.deleteMarketingPlanDotInEnterprise(id);
        return ResultSet.getSuccess();
    }
    @RequestMapping(value = "/UpdateQAInfo")
    public String QAInfopost(){
        return "templates/sys/UpdateQAInfo";
    }

    @RequestMapping(value = "/updateQAManage",method = RequestMethod.POST)
    @ResponseBody
    public ResultSet updateQAManage(SysQa sysQa){
        System.out.println(sysQa.getId());
        int num=qaMangerService.updateQAManage(sysQa);

        return ResultSet.getSuccess();//对应刚才的修改按钮
    }

    @RequestMapping(value = "/addQAManage")
    public String addQAManage(){
        return "templates/sys/addQAManage";
    }


    @RequestMapping(value = "/addPlanQAManage")
    @ResponseBody
    public ResultSet addPlanQAManage(SysQa sysQa){
        sysQa.setAddDate(new Date());
        sysQa.setAddUser(GetSysUser.getSysUser().getUsername());
        sysQa.setSource(0);
        int num=qaMangerService.addPlanQAManage(sysQa);

        return ResultSet.getSuccess();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


    @RequestMapping(value = "QuestionList")
    public String QuestionList(){
        return "templates/sys/questionList";
    }

    @RequestMapping(value = "/QuestionPlan")
    @ResponseBody
    public List<SysQa> QuestionPlan(){
        List<SysQa> questionlist=qaMangerService.QuestionAnser();
        return questionlist;
    }
@RequestMapping(value = "/SelectQuestion",method = RequestMethod.POST)
    @ResponseBody
    public List<SysQa> SelectQuestion(SysQa question){
    System.out.println(question);
        List<SysQa> selectQuestion=qaMangerService.SelectAnser(question);
        return selectQuestion;
}
    @RequestMapping(value = "/look")
    public String Look(){
        return "/templates/sys/UpdateQAInfo";
    }

    @RequestMapping(value = "/allShow")
    @ResponseBody
    public  List<SysQa> allShow(SysQa id){
        List<SysQa> selectShow= qaMangerService.ShowSelect(id);
        return selectShow;
    }

    @RequestMapping(value = "/QuestionPlanmo")
    @ResponseBody
    public List<SysQa> cha(SysQa question){
        List<SysQa> chalist=qaMangerService.mohu(question);
        return chalist;
    }

}









