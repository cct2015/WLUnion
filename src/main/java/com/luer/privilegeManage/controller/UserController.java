package com.luer.privilegeManage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luer.comm.bean.JqgridFilter;
import com.luer.comm.bean.JqgridResponse;
import com.luer.comm.bean.JqgridResponseContext;
import com.luer.comm.bean.ResultSet;
import com.luer.marketingSchemeManage.bean.MarketingPlan;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.service.SysUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cloud on 2018/12/12.
 */

@Controller
public class UserController {

    @Autowired
    private SysUserService sysUserService;


    @ResponseBody
    @RequestMapping("/getUser")
    public List<SysUser> getUser(){

        return  sysUserService.getList();
    }
    @ResponseBody
    @RequestMapping("/getname")
    public ResultSet getname(HttpServletRequest request){
        SecurityContextImpl securityContextImpl = (SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        String name = securityContextImpl.getAuthentication().getName();
        return   ResultSet.getSuccess(name);
    }
    @ResponseBody
    @RequestMapping("/getSysUserByName")
    public SysUser getSysUser(HttpServletRequest request){
        SecurityContextImpl securityContextImpl = (SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        String name = securityContextImpl.getAuthentication().getName();
        SysUser sysUser=sysUserService.getSysUserByName(name);
        return   sysUser;
    }
    /*发送验证码*/
    @ResponseBody
    @RequestMapping("/sendEmailMsg")
    public ResultSet sendEmail(String userName){
        String verificationCode=sysUserService.sendEmail(userName);
        return ResultSet.getSuccess(verificationCode);
    }
    @ResponseBody
    @RequestMapping("/addUser")
    public SysUser addUser(SysUser sysUser){
        sysUserService.addUser(sysUser);
        return  sysUser;
    }
    @ResponseBody
    @RequestMapping("/updateUser")
    public SysUser updateUser(SysUser sysUser){
        sysUserService.updateUser(sysUser);
        return  sysUser;
    }
    @ResponseBody
    @RequestMapping("/verificateUser")
    public List<SysUser> verificateUser(SysUser sysUser){
        List<SysUser> users=sysUserService.verificateUser(sysUser);
        return  users;
    }
    @ResponseBody
    @RequestMapping("/checkUserName")
    public String  checkUserName(SysUser sysUser){
        boolean result = true;
        List<SysUser> users=sysUserService.verificateUser(sysUser);
        if(users.size()>0){
            result = false;
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  resultString;
    }
    @ResponseBody
    @RequestMapping("/checkUserNameAndEmail")
    public String  checkUserNameAndEmail(String name){
        SysUser sysUser=new SysUser();
        sysUser.setName(name);
        boolean result = false;
        List<SysUser> users=sysUserService.verificateUser(sysUser);
        if(users.size()>0){
            if(users.get(0).getEmail()!=null){
                result = true;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  resultString;
    }
    @ResponseBody
    @RequestMapping("/deleteUser")
    public ResultSet deleteUser(SysUser sysUser){
        sysUserService.deleteUser(sysUser);
        return  ResultSet.getSuccess();
    }

    /**
     * 添加用户和角色信息getSysUser
     * @param sysUser
     * @return
     */
    @ResponseBody
    @RequestMapping("/addSysUser")
    public ResultSet addSysUser(SysUser sysUser, String roleName){
        sysUserService.addSysUser(sysUser,roleName);
        return  ResultSet.getSuccess();
    }
    @ResponseBody
    @RequestMapping("/updateSysUserPassword")
    public ResultSet updateSysUserPassword(SysUser sysUser){
        sysUserService.updateSysUserPassword(sysUser);
        return  ResultSet.getSuccess();
    }
    @ResponseBody
    @RequestMapping("/updateSysUserEmail")
    public ResultSet updateSysUserEmail(SysUser sysUser){
        sysUserService.updateSysUserEmail(sysUser);
        return  ResultSet.getSuccess();
    }

    /**
     * 获取不同用户信息()
     *
     */
    @ResponseBody
    @RequestMapping("/getSysUser")
    public JqgridResponse<SysUser> getSysUser(JqgridFilter filter){
        filter.refresh();
        List<SysUser> sysUser = sysUserService.getSysUser();
        return JqgridResponseContext.getJqgridResponse(filter,sysUser);
    }



    //同级账号管理
    @ResponseBody
    @RequestMapping("/getSysUsers")
    public JqgridResponse<SysUser> getSysUsers(JqgridFilter filter){
        filter.refresh();
        List<SysUser> sysUser = sysUserService.getSysUsers();
        return JqgridResponseContext.getJqgridResponse(filter,sysUser);
    }

    /**
     * 添加权限
     */
    @ResponseBody
    @RequestMapping("/addAuths")
    public ResultSet  addAuths(String auths,String userId) {
        sysUserService.addAuths(auths,userId);
        return ResultSet.getSuccess();
    }

    /**
     * 获取当前登陆用户的所有权限
    * @author 张路明
    */
    @ResponseBody
    @RequestMapping("/getAuth")
    public ResultSet getAuth(){
        List<String> auth = sysUserService.getAuth();
        return  ResultSet.getSuccess(auth);
    }

    /**
     * 获取企业超级管理员
     */
    @ResponseBody
    @RequestMapping("/getCompanyUsersManagerment")
    public JqgridResponse<SysUser> getUsersManagerment(JqgridFilter filter){
        filter.refresh();
        List<SysUser> usersManagerment = sysUserService.getUsersManagerment();
        return JqgridResponseContext.getJqgridResponse(filter,usersManagerment);
    }
    @ResponseBody
    @RequestMapping("/getAgentUsersManagerment")
    public JqgridResponse<SysUser> getAgentUsersManagerment(JqgridFilter filter){
        filter.refresh();
        List<SysUser> usersManagerment = sysUserService.getAgentUsersManagerment();
        return JqgridResponseContext.getJqgridResponse(filter,usersManagerment);
    }

    /**
     * 修改用户密码updatePassword
     */
    @ResponseBody
    @RequestMapping("/updatePassword")
    public ResultSet updatePassword(String id,String password){

        sysUserService.updatePassword(id,password);
        return ResultSet.getSuccess();
    }
    @ResponseBody
    @RequestMapping("/checkOldPassword")
    public String  checkOldPassword(String name, String password){
        List<SysUser> sysUsers=sysUserService.checkOldPassword(name,password);
        boolean result = false;
        if(sysUsers.size()>0){
            result = true;
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  resultString;
    }
}
