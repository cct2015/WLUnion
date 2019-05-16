package com.luer.JD.dao;

import com.luer.JD.bean.JdOrder;
import com.luer.JD.bean.JdOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface JdOrderMapper {
    int countByExample(JdOrderExample example);

    int deleteByExample(JdOrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(JdOrder record);

    int insertSelective(JdOrder record);

    List<JdOrder> selectByExample(JdOrderExample example);

    JdOrder selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") JdOrder record, @Param("example") JdOrderExample example);

    int updateByExample(@Param("record") JdOrder record, @Param("example") JdOrderExample example);

    int updateByPrimaryKeySelective(JdOrder record);

    int updateByPrimaryKey(JdOrder record);

    List<JdOrder> selectOrder(@Param("merchantId")String merchantId, @Param("beginTime")Long beginTime, @Param("endTime")Long endTime, @Param("orderId")Long orderId);

     int orderListInsert(List<JdOrder> jdOrderList);


    List<JdOrder> selectAgentOrder(String merchantId);

    List<JdOrder> getAgentOrder(@Param("merchantId")String merchantId, @Param("parentId")String parentId, @Param("beginTime")Long beginTime, @Param("endTime")Long endTime, @Param("orderId")long orderId);

}