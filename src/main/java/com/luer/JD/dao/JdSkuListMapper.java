package com.luer.JD.dao;

import com.luer.JD.bean.JdSkuList;
import com.luer.JD.bean.JdSkuListExample;
import com.luer.JD.bean.JdSkuListKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface JdSkuListMapper {
    int countByExample(JdSkuListExample example);

    int deleteByExample(JdSkuListExample example);

    int deleteByPrimaryKey(JdSkuListKey key);

    int insert(JdSkuList record);

    int insertSelective(JdSkuList record);

    List<JdSkuList> selectByExample(JdSkuListExample example);

    JdSkuList selectByPrimaryKey(JdSkuListKey key);

    int updateByExampleSelective(@Param("record") JdSkuList record, @Param("example") JdSkuListExample example);

    int updateByExample(@Param("record") JdSkuList record, @Param("example") JdSkuListExample example);

    int updateByPrimaryKeySelective(JdSkuList record);

    int updateByPrimaryKey(JdSkuList record);

    List<JdSkuList> selectOrderSkuListByID(long orderId);

    int   skulistInsert(List<JdSkuList> list);
}