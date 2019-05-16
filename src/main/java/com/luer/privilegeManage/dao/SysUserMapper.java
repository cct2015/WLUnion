package com.luer.privilegeManage.dao;

import com.luer.privilegeManage.bean.SysPermissionResource;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.bean.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan
public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //查找用户是否存在
    SysUser getSysUserByUsername(String username);

    //获取用户权限
    List<SysPermissionResource> getPermissionByUsername(String username);

    //获取管理员创建的普通用户
    List<SysUser> getUserOrdinaryManagerment(@Param("userType")String userType,@Param("merchantId")String merchantId);

    //获取下级管理员
    List<SysUser> getUsersManagerment();

    //同级账号管理
    List<SysUser> getSysUsers(@Param("userType")String userType,@Param("merchantId")String merchantId);

    //根据商户id删除用户
    void deleteMerchantIdUsers(@Param("merchantId")String merchantId);

    //根据商户id查询用户
    String getMerchantIdUsers(@Param("merchantId")String merchantId);

    List<SysUser> getAgentUsersManagerment();
}