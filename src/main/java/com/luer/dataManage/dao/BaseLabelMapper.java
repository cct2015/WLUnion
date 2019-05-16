package com.luer.dataManage.dao;

import com.luer.comm.bean.TreeViewItem;
import com.luer.dataManage.bean.BaseLabel;
import com.luer.dataManage.bean.BaseLabelExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface BaseLabelMapper {
    int countByExample(BaseLabelExample example);

    int deleteByExample(BaseLabelExample example);

    int deleteByPrimaryKey(String id);

    int insert(BaseLabel record);

    int insertSelective(BaseLabel record);

    List<BaseLabel> selectByExample(BaseLabelExample example);

    BaseLabel selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BaseLabel record, @Param("example") BaseLabelExample example);

    int updateByExample(@Param("record") BaseLabel record, @Param("example") BaseLabelExample example);

    int updateByPrimaryKeySelective(BaseLabel record);

    int updateByPrimaryKey(BaseLabel record);

    List<BaseLabel> selectAll();

    void deleteAll();

    void insertBaseLabelList(@Param("list") List<BaseLabel> list);

    //获得所有的一级标签，最多50个
    List<BaseLabel> getOneStepLabelExclude();

    //获取一级标签的子标签
    List<BaseLabel> getLabelChildren(String parentKey);

    List<TreeViewItem> get163LabelCity();

    /*
     * 通过来源获取标签*/
    List<BaseLabel> selectBySource(Integer source);

    //通过来源获取一级标签
    List<BaseLabel> selectBySourceAndStep(Integer source);

    //禁止或者启动 网易或者自定义标签
    void prohibitAllBySource(@Param("source") Integer source, @Param("isValid") Integer isValid);

    //通过标签名查询标签
    List<BaseLabel> selectByText(@Param("selectValue") String selectValue, @Param("source") Integer source);

    //通过parentkey查询子标签
    BaseLabel selectByTextHead(@Param("selectValue") String selectValue, @Param("source") Integer source);
}