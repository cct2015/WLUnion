package com.luer.privilegeManage.service;

import com.luer.privilegeManage.bean.SysUser;

import java.util.List;

/**
 * Created by cloud on 2018/12/12.
 */
public interface SysUserService {

    List<SysUser> getList();

    void addUser(SysUser sysUser);

    void updateUser(SysUser sysUser);

    void deleteUser(SysUser sysUser);

    //添加用户
    int addSysUser(SysUser sysUser,String roleName);

    //获得用户信息
    List<SysUser> getSysUser();

    //同级账号管理
    List<SysUser> getSysUsers();


    //获得用户信息
    List<String> getAuth();

    //添加权限
    void addAuths(String auths,String userId);

    //获取下级管理员
    List<SysUser> getUsersManagerment();

    //修改用户密码
    int updatePassword(String id,String password);

    List<SysUser> verificateUser(SysUser sysUser);

    List<SysUser> getAgentUsersManagerment();

    void updateSysUserPassword(SysUser sysUser);

    List<SysUser> checkOldPassword(String name, String password);

    String sendEmail(String userName);

    void updateSysUserEmail(SysUser sysUser);

    SysUser getSysUserByName(String name);
}
