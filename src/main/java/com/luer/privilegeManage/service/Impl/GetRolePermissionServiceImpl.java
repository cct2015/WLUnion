package com.luer.privilegeManage.service.Impl;

import com.luer.comm.utils.UuidUtils;
import com.luer.privilegeManage.bean.*;
import com.luer.privilegeManage.dao.SysRolePermissionMapper;
import com.luer.privilegeManage.dao.SysUserMapper;
import com.luer.privilegeManage.dao.SysUserRoleMapper;
import com.luer.privilegeManage.service.GetRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 87961 on 2019/1/3.
 */
@Service
@Transactional
public class GetRolePermissionServiceImpl implements GetRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<PermissionTree> getPermission() {
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        SysUserRoleExample example =new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<SysUserRole> sysUserRoles= sysUserRoleMapper.selectByExample(example);
        List<SysRolePermission> sysRolePermissions=sysRolePermissionMapper.getPermission(sysUserRoles.get(0).getRoleId());
        List<PermissionTree> permissionTreeList =changePermissionTestList(sysRolePermissions);
        return permissionTreeList;
    }

    @Override
    public void gavePermission(List<PermissionTree> permissionTrees) {
        List<SysRolePermission> sysRolePermissions=new ArrayList<SysRolePermission>();


        System.out.println("-----------"+permissionTrees.size());
            for (PermissionTree permissionTree :permissionTrees){
                SysRolePermission sysRolePermission=new SysRolePermission();
                sysRolePermission.setId(permissionTree.getId());
                sysRolePermission.setParentId(permissionTree.getPId());
                sysRolePermission.setPermissionName(permissionTree.getName());
                sysRolePermission.setPermissionLevel(permissionTree.getPermissionLevel());
                sysRolePermission.setPermissionOrder(permissionTree.getPermissionOrder());
                sysRolePermission.setRoleId(permissionTree.getRoleId());
                sysRolePermission.setPermissionId(permissionTree.getPermissionId());
                sysRolePermissions.add(sysRolePermission);

            }
            for(int i=0;i<sysRolePermissions.size();i++){
                if(sysRolePermissions.get(i).getParentId()==null){
                    String id=sysRolePermissions.get(i).getId();
                    sysRolePermissions.get(i).setId(UuidUtils.getUUID());
                    String s=sysRolePermissions.get(i).getId();

                    for(int j=0;j<sysRolePermissions.size();j++){
                        if(sysRolePermissions.get(j).getParentId()!=null) {

                            if (sysRolePermissions.get(j).getParentId().equals(id)) {
                                String secondId = sysRolePermissions.get(j).getId();
                                sysRolePermissions.get(j).setId(UuidUtils.getUUID());
                                sysRolePermissions.get(j).setParentId(sysRolePermissions.get(i).getId());
                                for (int k = 0; k < sysRolePermissions.size(); k++) {
                                    if(sysRolePermissions.get(k).getParentId()!=null) {
                                        if (sysRolePermissions.get(k).getParentId().equals(secondId)) {
                                            sysRolePermissions.get(k).setId(UuidUtils.getUUID());
                                            sysRolePermissions.get(k).setParentId(sysRolePermissions.get(j).getId());
                                        }
                                    }
                                }

                            }
                        }
                    }


                }
            }
            sysRolePermissionMapper.deleteByRoleId(sysRolePermissions.get(0).getRoleId());
            sysRolePermissionMapper.addRolePermission(sysRolePermissions);


    }

    @Override
    public List<SysRolePermission> getSysRolePermission() {
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        SysUserRoleExample example =new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<SysUserRole> sysUserRoles= sysUserRoleMapper.selectByExample(example);
        SysRolePermissionExample sysRolePermissionExample=new SysRolePermissionExample();
        SysRolePermissionExample.Criteria criteria1=sysRolePermissionExample.createCriteria();
        criteria1.andRoleIdEqualTo(sysUserRoles.get(0).getRoleId());
        List<SysRolePermission> sysRolePermissions=sysRolePermissionMapper.getPermission(sysUserRoles.get(0).getRoleId());
        return sysRolePermissions;
    }

    @Override
    public List<PermissionTree> getHavePermission(String roleId) {
        //获取角色原有权限
        List<SysRolePermission> sysRolePermissions=sysRolePermissionMapper.getHavePermission(roleId);
        List<PermissionTree> permissionTreeList =changePermissionTestList(sysRolePermissions);
        //获取超级管理员权限
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        SysUserRoleExample example =new SysUserRoleExample();
        SysUserRoleExample.Criteria criteria=example.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        List<SysUserRole> sysUserRoles= sysUserRoleMapper.selectByExample(example);
        List<SysRolePermission> sysRoles=sysRolePermissionMapper.getPermission(sysUserRoles.get(0).getRoleId());
        List<PermissionTree> permissions =changePermissionTestList(sysRoles);
        //通过相同的permission_id获取数据id值
        for(int i=0;i<permissionTreeList.size();i++){
                for (int j=0;j<permissions.size();j++){
                       if(permissionTreeList.get(i).getPermissionId().equals(permissions.get(j).getPermissionId())){
                           permissionTreeList.get(i).setId(permissions.get(j).getId());
                       }
                }
        }
        return permissionTreeList;
    }

    public List<PermissionTree> changePermissionTestList(List<SysRolePermission> sysRolePermissionList) {
        List<PermissionTree> PermissionTreeList = new ArrayList<PermissionTree>();
        String str;
        for (SysRolePermission sysRolePermission : sysRolePermissionList) {
            PermissionTree  permissionTree= new PermissionTree();
            permissionTree.setId(sysRolePermission.getId());
            permissionTree.setName(sysRolePermission.getPermissionName());
            permissionTree.setRoleId(sysRolePermission.getRoleId());
            permissionTree.setPermissionLevel(sysRolePermission.getPermissionLevel());
            permissionTree.setPermissionOrder(sysRolePermission.getPermissionOrder());
            permissionTree.setPermissionId(sysRolePermission.getPermissionId());

            if (!(sysRolePermission.getParentId() == null || sysRolePermission.getParentId().equals(""))) {
                permissionTree.setPId(sysRolePermission.getParentId());
            }
            PermissionTreeList.add(permissionTree);
        }
        return PermissionTreeList;
    }
}
