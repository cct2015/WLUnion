package com.luer.privilegeManage.service.serviceImpl;

import com.luer.comm.UuidUtils;
import com.luer.privilegeManage.bean.SysRole;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.bean.SysUserExample;
import com.luer.privilegeManage.bean.SysUserRole;
import com.luer.privilegeManage.dao.SysRoleMapper;
import com.luer.privilegeManage.dao.SysUserMapper;
import com.luer.privilegeManage.dao.SysUserRoleMapper;
import com.luer.privilegeManage.service.SysUserService;
import com.luer.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<SysUser> getList() {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        return sysUserMapper.selectByExample(sysUserExample);
    }

    @Override
    public void addUser(SysUser sysUser) {
        sysUser.setId(UUIDUtils.getUUID());
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void deleteUser(SysUser sysUser) {
        sysUserMapper.deleteByPrimaryKey(sysUser.getId());
    }

    /**
     * 添加用户，角色信息
     * @param sysUser
     * @param roleName
     * @return
     */
    @Transactional
    @Override
    public int addSysUser(SysUser sysUser, String roleName) {

        int insert;
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        SysRole sysRole =  sysRole = new SysRole();
        if(user.getUserType().equals("0")){
            //系统超级管理员用户添加同级普通用户
            //添加用户信息
            sysUser.setId(UuidUtils.getUUID());
            sysUser.setAddTime(new Date());
            sysUser.setStatus(0);
            sysUser.setMerchantId(user.getMerchantId());
            sysUser.setUserType("0");

            //添加角色信息
            sysRole.setRoleType(0);//系统用户

        }else if(user.getUserType().equals("1")){
            //系统代理商超级管理员添加同级用户
            //添加用户信息
            sysUser.setId(UuidUtils.getUUID());
            sysUser.setAddTime(new Date());
            sysUser.setStatus(0);
            sysUser.setMerchantId(user.getMerchantId());
            sysUser.setUserType("1");

            //添加角色信息
            sysRole.setRoleType(1);//代理商用户

        }else {
            //企业用户
            //系统代理商超级管理员添加同级用户
            sysUser.setId(UuidUtils.getUUID());
            sysUser.setAddTime(new Date());
            sysUser.setStatus(0);
            sysUser.setMerchantId(user.getMerchantId());
            sysUser.setUserType("2");
            //添加角色信息
            sysRole.setRoleType(2);//代理商用户


        }

       insert = sysUserMapper.insert(sysUser);
        if(insert==1){
            //添加角色信息
            sysRole.setId(UuidUtils.getUUID());
            sysRole.setMerchantId(user.getMerchantId());
            sysRole.setCreateUser(user.getName());

          insert =   sysRoleMapper.insert(sysRole);
            if(insert ==1){
                //添加角色用户信息
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setId(UuidUtils.getUUID());
                sysUserRole.setRoleId(sysRole.getId());
                sysUserRole.setUserId(sysUser.getId());
                insert = sysUserRoleMapper.insert(sysUserRole);
            }

        }

        return insert;
    }

    //
}
