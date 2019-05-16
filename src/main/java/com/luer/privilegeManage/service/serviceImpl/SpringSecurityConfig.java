package com.luer.privilegeManage.service.serviceImpl;

import com.luer.privilegeManage.authentication.MyAuthenticationFailHandler;
import com.luer.privilegeManage.authentication.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 *
 */
@Configuration
//@EnableWebSecurity: 禁用Boot的默认Security配置，配合@Configuration启用自定义配置
// （需要扩展WebSecurityConfigurerAdapter）
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true): 启用Security注解，
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Spring会自动寻找实现接口的类注入,会找到我们的 UserDetailsServiceImpl  类
    @Autowired
    private MyUserDetailService myuserDetailService;
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Autowired
    MyAuthenticationSuccessHandler mySuccessHandler;
    @Autowired
    MyAuthenticationFailHandler myFailHandler;

   /* @Autowired//注意这个方法是注入的*/
    public void globalAuthConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myuserDetailService);
    }


    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 设置拦截忽略文件夹，可以对静态资源放行
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        //自定义的认证方式
        //permitAll表示该请求任何人都可以访问，.anyRequest().authenticated(),表示其他的请求都必须要有权限认证
        http.authorizeRequests()
             /*   .anyRequest().authenticated()*/
                .and().formLogin().loginPage("/login")
                .successHandler(mySuccessHandler)
                .failureHandler(myFailHandler).permitAll()
                .and()
                .logout().permitAll()//注销行为任意访问
                .and()
                .userDetailsService(myuserDetailService)
                .csrf().disable(); // 关闭CSRF跨域
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }
}
