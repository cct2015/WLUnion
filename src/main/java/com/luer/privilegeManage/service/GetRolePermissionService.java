package com.luer.privilegeManage.service;

import com.luer.privilegeManage.bean.PermissionTree;
import com.luer.privilegeManage.bean.SysRolePermission;

import java.util.List;

/**
 * Created by 87961 on 2019/1/3.
 */
public interface GetRolePermissionService {

    List<PermissionTree> getPermission();

    void gavePermission(List<PermissionTree> permissionTrees);

    List<SysRolePermission> getSysRolePermission();

    List<PermissionTree> getHavePermission(String roleId);
}
