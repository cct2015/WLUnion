package com.luer.privilegeManage.service.serviceImpl;


import com.luer.privilegeManage.bean.SysPermissionResource;
import com.luer.privilegeManage.bean.SysPermissionResourceExample;
import com.luer.privilegeManage.dao.SysPermissionResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 将所有资源和资源对应需要的角色存在map中
 * 用户请求资源的时候能够返回资源所对应的角色集合给
 * 决策器（MyAccessDecisionManager）
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private SysPermissionResourceMapper sysPermissionResourceMapper;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 加载权限表中所有权限
     */
    /*@PostConstruct*///  被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
    public void loadResourceDefine() {
        map = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        SysPermissionResourceExample sysPermissionResourceExample = new SysPermissionResourceExample();
        sysPermissionResourceExample.createCriteria();
        List<SysPermissionResource> sysPermissionResources = sysPermissionResourceMapper.selectByExample(sysPermissionResourceExample);
        for (SysPermissionResource permission : sysPermissionResources) {
            array = new ArrayList<ConfigAttribute>();
            cfg = new SecurityConfig(permission.getPermtag());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(permission.getPermtag(), array);
        }

    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) loadResourceDefine();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
