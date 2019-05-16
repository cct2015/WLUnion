package com.luer.privilegeManage.service.Impl;


import com.luer.privilegeManage.bean.SysPermissionResource;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.bean.SysUsers;
import com.luer.privilegeManage.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 通过用户名查询用户信息
 * 储存用户所有角色
 */

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        //登陆验证时，通过username获取用户的所有权限信息，
        SysUser sysUser = sysUserMapper.getSysUserByUsername(username);
        if(sysUser!=null){
            List<SysPermissionResource> permissionList = sysUserMapper.getPermissionByUsername(username);
            //authorities ：存放所有用户权限
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            if(permissionList.size() >0){
                for (SysPermissionResource perm : permissionList) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(perm.getPermtag());
                    authorities.add(authority);
                }
            }else{
                GrantedAuthority authority = new SimpleGrantedAuthority("/index");
                authorities.add(authority);
            }

            // 把所有权限赋值给 user
            sysUser.setAuthorities(authorities);
            return  new SysUsers(sysUser,authorities);
            /*return new User(sysUser.getName(),sysUser.getPassword(),authorities);*/
        }else{
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
}
