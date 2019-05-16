package com.luer.privilegeManage.controller;

import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.privilegeManage.bean.SysRole;
import com.luer.privilegeManage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
    * @author 张路明
    */
    @RequestMapping("/listRoles")
    @ResponseBody
    public JqgridResponse<SysRole> selectAll(JqgridFilter filter) {
        filter.refresh();
        List<SysRole> sysRoles = roleService.listRole();
        return JqgridResponseContext.getJqgridResponse(filter, sysRoles);
    }
    /**
     * 为新增的用户选择角色（不分页）
    * @author 张路明
    */
    @RequestMapping("/listRolesNotPage")
    @ResponseBody
    public List<SysRole> selectAll() {
        List<SysRole> sysRoles = roleService.listRole();
        return sysRoles;
    }
    /**
     * 删除角色
    * @author 张路明
    */
    @ResponseBody
    @RequestMapping("/deleteRole")
    public ResultSet delete(String id){
        roleService.delete(id);
        return  ResultSet.getSuccess();
    }
    /**
     * 新增角色
    * @author 张路明
    */
    @RequestMapping("addRole")
    @ResponseBody
    public ResultSet add(SysRole sysRole){
        roleService.add(sysRole);
        return ResultSet.getSuccess();
    }
    /**
     * 修改角色
    * @author 张路明
    */
    @ResponseBody
    @RequestMapping("update")
    public ResultSet update(SysRole sysRole){
        roleService.update(sysRole);
        return ResultSet.getSuccess();
    }
    /**
     * 修改角色权限
    * @author 张路明
    */
    @RequestMapping("updateRoleAuth")
    @ResponseBody
    public ResultSet updateAuth(String auth,String roleId){
        roleService.updateAuth(auth,roleId);
        return ResultSet.getSuccess();
    }
}
