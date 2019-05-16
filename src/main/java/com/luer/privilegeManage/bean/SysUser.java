package com.luer.privilegeManage.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SysUser implements Serializable {
    private String id;

    private String name;

    private String password;

    private String headPortrait;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date activateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date recentlyLanded;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date effictiveTime;

    private String nickname;

    private String email;

    private Integer age;

    private String userType;

    private String merchantId;

    private String remark;

    private String industryName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date addTime;

    private String addUser;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastUpdate;

    private String lastUpdater;

    private Integer status;

    private String roleName;

    // 用户拥有的所有权限
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


}