package com.luer.privilegeManage.service;

import com.luer.privilegeManage.bean.SysRole;

import java.util.List;

public interface RoleService {

    List<SysRole> listRole();

    void delete(String id);

    void add(SysRole sysRole);

    void update(SysRole sysRole);

    void updateAuth(String auth,String roleId);
}
