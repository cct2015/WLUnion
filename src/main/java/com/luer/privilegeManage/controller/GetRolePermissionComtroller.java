package com.luer.privilegeManage.controller;

import com.luer.comm.bean.ResultSet;
import com.luer.privilegeManage.bean.PermissionTree;
import com.luer.privilegeManage.bean.SysRolePermission;
import com.luer.privilegeManage.service.GetRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 87961 on 2019/1/3.
 */
@Controller
public class GetRolePermissionComtroller {
    @Autowired
    private GetRolePermissionService getRolePermissionService;


    @PostMapping("/getPermission")
    @ResponseBody
    public List<PermissionTree> getPermission() {

        List<PermissionTree> permissionTrees = getRolePermissionService.getPermission();


        return permissionTrees;
    }
    @PostMapping("/getHavePermission")
    @ResponseBody
    public List<PermissionTree> getHavePermission(String roleId) {

        List<PermissionTree> permissionTrees = getRolePermissionService.getHavePermission(roleId);


        return permissionTrees;
    }

    @PostMapping("/getSysRolePermission")
    @ResponseBody
    public List<SysRolePermission> getSysRolePermission() {

        List<SysRolePermission> sysRolePermissions = getRolePermissionService.getSysRolePermission();


        return sysRolePermissions;
    }

    @PostMapping("/gavePermission")
    @ResponseBody
    public ResultSet gavePermission(@RequestBody List<PermissionTree> permissionTrees) {

        getRolePermissionService.gavePermission(permissionTrees);

        return ResultSet.getSuccess();
    }
}
