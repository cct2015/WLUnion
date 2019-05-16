package com.luer.marketingSchemeManage.dao;

import com.luer.marketingSchemeManage.bean.VPlanRecommend;
import com.luer.marketingSchemeManage.bean.VPlanRecommendExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface VPlanRecommendMapper {
    List<VPlanRecommend> selectByExample(VPlanRecommendExample example);
}