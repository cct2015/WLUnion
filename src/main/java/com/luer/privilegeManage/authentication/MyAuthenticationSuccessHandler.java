package com.luer.privilegeManage.authentication;

import com.luer.comm.constants.Constant;
import com.luer.comm.utils.WlAuthentication;
import com.luer.privilegeManage.bean.SysUser;
import com.luer.privilegeManage.dao.SysUserMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 自定义登录成功处理类
 */
@Component
@Log
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        if (isAjax) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal != null) {
                if (principal instanceof UserDetails) {
                    UserDetails userDetails = (UserDetails) principal;
                    String username = userDetails.getUsername();
                    //通过用户名查询当前用户对象
                    SysUser sysUser = sysUserMapper.getSysUserByUsername(username);
                    //根据登录用户生成cookie值
                    String value = WlAuthentication.getUserCookieValue(sysUser);
                    String cookieValue = URLEncoder.encode(value, "UTF-8");

                    //System.out.println("cookieValue================" + cookieValue);
                    Cookie cookie = new Cookie(Constant.COOKIEVALUE, cookieValue);
                    cookie.setDomain("wanglu163.com");
                    cookie.setSecure(false);
                    cookie.setPath("/");
                    cookie.setHttpOnly(true);
                    //cookie.setMaxAge(3600);


                    response.addCookie(cookie);
                    //创建session对象
                    HttpSession session = request.getSession();
                    session.setAttribute("usersId", sysUser.getId());
                    session.setAttribute("userType", sysUser.getUserType());//用户类型
                    session.setAttribute("merchantId", sysUser.getMerchantId());
                    session.setAttribute("userType", sysUser.getUserType());//用户类型

                    //跳转到用户主页
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json");
                    response.getWriter().println("{\"code\":200,\"msg\":\"登录成功！\"}");
                }
            }

        }
    }


}

