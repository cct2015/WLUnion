package com.luer.privilegeManage.dao;

import com.luer.privilegeManage.bean.SysRolePermission;
import com.luer.privilegeManage.bean.SysRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface SysRolePermissionMapper {
    int countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    List<String> selectAuthByRole(@Param("roleId") String roleId);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);

    int deleteByRoleId(@Param("role") String role);

    List<SysRolePermission> getPermission(@Param("roleId") String roleId);

    void addRolePermission(List<SysRolePermission> sysRolePermissions);

    List<SysRolePermission> getHavePermission(@Param("roleId") String roleId);
}