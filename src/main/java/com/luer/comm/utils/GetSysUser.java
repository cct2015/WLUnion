package com.luer.comm.utils;

import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.bean.SysUsers;
import com.luer.privilegeManage.dao.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by cloud on 2018/12/19.
 */
public class GetSysUser {
    @Autowired

    public static SysUsers getSysUser(){
        SysUsers user = (SysUsers)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
