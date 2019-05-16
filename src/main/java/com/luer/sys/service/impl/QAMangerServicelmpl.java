package com.luer.sys.service.impl;


import com.luer.sys.bean.*;
import com.luer.sys.dao.SysQaMapper;
import com.luer.sys.service.QAMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class QAMangerServicelmpl implements QAMangerService {

    @Autowired
    private SysQaMapper sysQaMapper;


    @Override
    public List<SysQa> qamangePlanInEnterprise(Integer source) {
        SysQaExample example=new SysQaExample();
        SysQaExample.Criteria criteria=example.createCriteria();
        if(source!=-1)
            criteria.andSourceEqualTo(source);
        return sysQaMapper.selectByExample(example);
    }

    @Override
    public int deleteMarketingPlanDotInEnterprise(String id) {
        return sysQaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateQAManage(SysQa sysQa) {
        return sysQaMapper.updateByPrimaryKeySelective(sysQa);
    }

    @Override
    public int addPlanQAManage(SysQa sysQa){

        return sysQaMapper.insert(sysQa);
    }

    @Override
    public List<SysQa>  selecttestall(){
        return sysQaMapper.selectByExample();
    }

    @Override
    public List<SysQa> QuestionAnser(){
        return sysQaMapper.QuestionAnser() ;
    }

    @Override
    public List<SysQa> SelectAnser(SysQa question){
        return sysQaMapper.selectAnser(question);
    }

    @Override
    public List<SysQa> ShowSelect(SysQa id){

        return sysQaMapper.ShowAll(id);
    }

    @Override
    public List<SysQa> mohu(SysQa question){
        return sysQaMapper.mohucha(question);
    }


    @Override
    public int insertbatch(List<SysQa> list){
            return sysQaMapper.Allinsert(list);
    }
}
