package com.lanou.token_demo.config;

import com.lanou.token_demo.shiro.JwtRealm;
import com.lanou.token_demo.shiro.SimpleRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class ShiroConfig {

    @Resource
    private SimpleRealm simpleRealm;

    @Resource
    private JwtRealm jwtRealm;

    // 使用Bean注解  就可以调用这个方法
    @Bean
    public SecurityManager securityManager() {

        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
        List<Realm> realms = Arrays.asList(simpleRealm, jwtRealm);
        securityManager.setRealms(realms);
        securityManager.setSessionManager(new DefaultSessionManager());
        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }
}
