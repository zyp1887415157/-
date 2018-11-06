package com.lanou.spring_shiro_test.Interceptor;

import com.lanou.spring_shiro_test.Utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authentication");
        try {
            String newToken = JwtUtil.autoRequire(token);
            response.setHeader("Authentication",newToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException("认证失败，请重新登录");
        }
    }
}
