package com.luer.privilegeManage.service.Impl;

import com.luer.comm.utils.EmailSendUtil;
import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.UuidUtils;
import com.luer.privilegeManage.bean.*;
import com.luer.privilegeManage.dao.*;
import com.luer.privilegeManage.service.SysUserService;
import com.luer.comm.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by cloud on 2018/12/12.
 */

@Service
@Transactional
public class UserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;


    @Override
    public List<SysUser> getList() {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        return sysUserMapper.selectByExample(sysUserExample);
    }

    @Override
    public void addUser(SysUser sysUser) {
        sysUser.setId(UuidUtils.getUUID());
        /* sysUser.setAddUser();*/
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    //删除
    @Override
    public void deleteUser(SysUser sysUser) {
        if (sysUser.getId() != null && sysUser.getId() != "") {
            SysUserExample sysUserExample = new SysUserExample();
            SysUserExample.Criteria criteria = sysUserExample.createCriteria();
            criteria.andIdEqualTo(sysUser.getId());
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            /* SysUser user = sysUserMapper.getSysUserByUsername(sysUser.getName());*/
            SysUserRole user_role = sysUserRoleMapper.getRoleIdByUserId(sysUsers.get(0).getId());
            //删除user和role的关联
            sysUserRoleMapper.deleteByPrimaryKey(user_role.getId());
            //删除用户
            sysUserMapper.deleteByPrimaryKey(sysUser.getId());
        }


    }

    /**
     * 添加用户，角色信息
     *
     * @param sysUser
     * @param roleName 角色id
     * @return
     */
    @Override
    @Transactional
    public int addSysUser(SysUser sysUser, String roleName) {

        sysUser.setAddUser(GetSysUser.getSysUser().getUsername());
        sysUser.setAddTime(new Date());
        sysUser.setStatus(0);
        int insert;
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        if (user.getUserType().equals("0")) {
            //系统超级管理员用户添加同级普通用户
            //添加用户信息
            sysUser.setId(UuidUtils.getUUID());
            sysUser.setUserType("1");

        } else if (user.getUserType().equals("2")) {
            //系统代理商超级管理员添加同级用户
            //添加用户信息
            sysUser.setId(UuidUtils.getUUID());
            sysUser.setMerchantId(user.getMerchantId());
            sysUser.setUserType("3");

            //添加角色信息

        } else {
            //企业用户
            //企业超级管理员添加同级用户
            sysUser.setId(UuidUtils.getUUID());
            sysUser.setMerchantId(user.getMerchantId());
            sysUser.setUserType("5");

        }
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUser.setMerchantId(user.getMerchantId());
        sysUser.setAddTime(new Date());
        insert = sysUserMapper.insert(sysUser);
        if (insert == 1) {
            if (insert == 1) {
                //添加角色用户信息
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setId(UuidUtils.getUUID());
                sysUserRole.setRoleId(roleName);
                sysUserRole.setUserId(sysUser.getId());
                insert = sysUserRoleMapper.insert(sysUserRole);
            }

        }

        return insert;
    }

    //获取用户信息
    @Override
    public List<SysUser> getSysUser() {
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        List<SysUser> userOrdinaryManagerment = null;
        //获得系统超级管理员创建的普通用户
        if (user.getUserType().equals("0")) {
            userOrdinaryManagerment = sysUserMapper.getUserOrdinaryManagerment("1", null);
        } else if (user.getUserType().equals("2")) {
            //获得代理商管理员创建的普通用户
            userOrdinaryManagerment = sysUserMapper.getUserOrdinaryManagerment("3", user.getMerchantId());
        } else if (user.getUserType().equals("4")) {
            //获得企业管理员创建的普通用户
            userOrdinaryManagerment = sysUserMapper.getUserOrdinaryManagerment("5", user.getMerchantId());
        }
        return userOrdinaryManagerment;
    }


    //同级账号管理
    @Override
    public List<SysUser> getSysUsers() {
        //从容器中取出用户信息
       /* UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());*/
        //从容器中取出用户信息
        SysUsers user = GetSysUser.getSysUser();
        List<SysUser> users = null;
        //获得系统超级管理员创建的普通用户
        if (user.getUserType().equals("0")) {
            users = sysUserMapper.getSysUsers("1", user.getMerchantId());
        } else if (user.getUserType().equals("2")) {
            //获得代理商管理员创建的普通用户
            users = sysUserMapper.getSysUsers("3", user.getMerchantId());
        } else if (user.getUserType().equals("4")) {
            //获得企业管理员创建的普通用户
            users = sysUserMapper.getSysUsers("5", user.getMerchantId());
        }
        return users;
    }


    //获取下级管理员
    @Override
    public List<SysUser> getUsersManagerment() {
        List<SysUser> usersManagerment = sysUserMapper.getUsersManagerment();
        return usersManagerment;
    }


    //修改用户密码
    @Override
    public int updatePassword(String id, String password) {

        SysUser sysUser = new SysUser();
        sysUser.setPassword(passwordEncoder.encode(password));
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIdEqualTo(id);

        return sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
    }

    @Override
    public List<SysUser> verificateUser(SysUser sysUser) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andNameEqualTo(sysUser.getName());

        return sysUserMapper.selectByExample(sysUserExample);
    }

    @Override
    public List<SysUser> getAgentUsersManagerment() {
        List<SysUser> usersManagerment = sysUserMapper.getAgentUsersManagerment();
        return usersManagerment;
    }

    @Override
    public void updateSysUserPassword(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andNameEqualTo(sysUser.getName());
        sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
    }
/*修改密码验证旧密码是否正确*/
    @Override
    public List<SysUser> checkOldPassword(String name, String password) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andNameEqualTo(name);
        /*criteria.andPasswordEqualTo(passwordEncoder.encode(password));*/
        List<SysUser> sysUserList=sysUserMapper.selectByExample(sysUserExample);
        List<SysUser> sysUsers=new ArrayList<SysUser>();
        for (SysUser sysUser:sysUserList){
            if(passwordEncoder.matches(password,sysUser.getPassword())){
                sysUsers.add(sysUser);
            }
        }
        return sysUsers;
    }

    @Override
    public String sendEmail(String userName) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andNameEqualTo(userName);
        List<SysUser> sysUserList=sysUserMapper.selectByExample(sysUserExample);
        String code = null;
        if(sysUserList.size()>0){
            code= EmailSendUtil.sendEmail(sysUserList.get(0).getEmail());
        }else {
            code="NoMsg";
        }
        return code;
    }

    @Override
    public void updateSysUserEmail(SysUser sysUser) {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andNameEqualTo(sysUser.getName());
        sysUserMapper.updateByExampleSelective(sysUser, sysUserExample);
    }

    @Override
    public SysUser getSysUserByName(String name) {
        return sysUserMapper.getSysUserByUsername(name);
    }


    @Override
    public List<String> getAuth() {
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        SysUserRole roleIdByUserId = sysUserRoleMapper.getRoleIdByUserId(user.getId());
        List<String> list = sysRolePermissionMapper.selectAuthByRole(roleIdByUserId.getRoleId());
        return list;
    }

    //添加权限
    @Override
    public void addAuths(String auths, String userId) {
        List<String> authlist = Arrays.asList(auths.split(","));//权限

        //获得添加用户
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);

        if (userId != null || userId != "") {
            SysUserRole roleIdByUserId = sysUserRoleMapper.getRoleIdByUserId(userId);
            //去角色权限表查询该用户是否赋予权限
            SysRolePermissionExample sysRolePermissionExample = new SysRolePermissionExample();
            SysRolePermissionExample.Criteria criteria = sysRolePermissionExample.createCriteria();
            criteria.andRoleIdEqualTo(roleIdByUserId.getRoleId());

            List<SysRolePermission> sysRolePermissions = sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
            if (sysRolePermissions.size() > 0) {
                //已授权
            } else {
                //授予权限
                for (int i = 0; i < authlist.size(); i++) {
                    SysRolePermission sysRolePermission = new SysRolePermission();
                    sysRolePermission.setId(UuidUtils.getUUID());
                    sysRolePermission.setRoleId(roleIdByUserId.getRoleId());
                    sysRolePermission.setPermissionId(authlist.get(i));
                    sysRolePermissionMapper.insert(sysRolePermission);
                }
            }
        }


    }

}
