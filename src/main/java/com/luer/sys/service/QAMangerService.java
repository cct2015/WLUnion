package com.luer.sys.service;

import com.luer.sys.bean.SysQa;

import java.util.List;

public interface QAMangerService {
    List<SysQa> qamangePlanInEnterprise(Integer source);
    int deleteMarketingPlanDotInEnterprise(String id);
    int updateQAManage(SysQa sysQa);
   int addPlanQAManage(SysQa sysQa);
    List<SysQa>  selecttestall();
    List<SysQa> QuestionAnser();
    List<SysQa> SelectAnser(SysQa question);
   List<SysQa> ShowSelect(SysQa id);

   List<SysQa> mohu(SysQa question);
   int insertbatch(List<SysQa> list);
}
