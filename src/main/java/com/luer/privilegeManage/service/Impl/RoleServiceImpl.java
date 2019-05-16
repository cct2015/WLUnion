package com.luer.privilegeManage.service.Impl;

import com.luer.comm.utils.GetSysUser;
import com.luer.comm.utils.UuidUtils;
import com.luer.privilegeManage.bean.SysRole;
import com.luer.privilegeManage.bean.SysRoleExample;
import com.luer.privilegeManage.bean.SysRolePermission;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.dao.SysRoleMapper;
import com.luer.privilegeManage.dao.SysRolePermissionMapper;
import com.luer.privilegeManage.dao.SysUserMapper;
import com.luer.privilegeManage.dao.SysUserRoleMapper;
import com.luer.privilegeManage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Override
    public List<SysRole> listRole() {
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria =sysRoleExample.createCriteria();
        if(!StringUtils.isEmpty(user.getMerchantId())){
            criteria.andMerchantIdEqualTo(user.getMerchantId());
        }
        criteria.andRolenameNotEqualTo("ROLE_ADMIN");
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        return sysRoles;
    }

    @Override
    public void delete(String id) {
        sysRolePermissionMapper.deleteByRoleId(id);//将该角色原有权限删除
        sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(SysRole sysRole) {
        //从容器中取出用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //通过用户名获取用户（判断用户类型）
        SysUser user = sysUserMapper.getSysUserByUsername(userDetails.getUsername());
        if(sysRole.getCreateUser()==null||sysRole.getCreateUser()==""){
            sysRole.setCreateUser(GetSysUser.getSysUser().getUsername());
        }
        sysRole.setMerchantId(user.getMerchantId());//为角色设置商户id
        sysRole.setId(UuidUtils.getUUID());
        sysRole.setRoleType(1);
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public void updateAuth(String auth,String roleId) {
        List<String> authList = Arrays.asList(auth.split(","));//解析为权限

        sysRolePermissionMapper.deleteByRoleId(roleId);//将该角色原有权限删除

        //授予权限
        for(int i=0;i<authList.size();i++){
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setId(UuidUtils.getUUID());
            sysRolePermission.setRoleId(roleId);
            sysRolePermission.setPermissionId(authList.get(i));
            sysRolePermissionMapper.insert(sysRolePermission);
        }
    }


}
