package com.luer.privilegeManage.dao;

import com.luer.privilegeManage.bean.SysPermissionResource;
import com.luer.privilegeManage.bean.SysPermissionResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@MapperScan
@Component
public interface SysPermissionResourceMapper {
    int countByExample(SysPermissionResourceExample example);

    int deleteByExample(SysPermissionResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysPermissionResource record);

    int insertSelective(SysPermissionResource record);

    List<SysPermissionResource> selectByExample(SysPermissionResourceExample example);

    SysPermissionResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysPermissionResource record, @Param("example") SysPermissionResourceExample example);

    int updateByExample(@Param("record") SysPermissionResource record, @Param("example") SysPermissionResourceExample example);

    int updateByPrimaryKeySelective(SysPermissionResource record);

    int updateByPrimaryKey(SysPermissionResource record);
}