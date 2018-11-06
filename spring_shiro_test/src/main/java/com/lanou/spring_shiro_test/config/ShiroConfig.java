package com.lanou.spring_shiro_test.config;

import com.lanou.spring_shiro_test.shiro.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class ShiroConfig {

    @Resource
    private ShiroRealm shiroRealm;

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setSessionManager(new DefaultSessionManager());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }
}
