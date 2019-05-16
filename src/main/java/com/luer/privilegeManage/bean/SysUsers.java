package com.luer.privilegeManage.bean;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by cloud on 2018/12/20.
 */
@Data
public class SysUsers extends User {
    private String merchantId;
    private String userType;
    public SysUsers(){
        super(null,null,null);
    }
    public SysUsers(SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {

        super(sysUser.getName(), sysUser.getPassword(), authorities);
        this.setMerchantId(sysUser.getMerchantId());
        this.setUserType(sysUser.getUserType());
    }
}
