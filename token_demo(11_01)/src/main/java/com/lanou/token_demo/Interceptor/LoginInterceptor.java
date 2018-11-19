package com.lanou.token_demo.Interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lanou.token_demo.entity.User;
import com.lanou.token_demo.shiro.JwtToken;
import com.lanou.token_demo.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String taken = request.getHeader("Authentication");

        try {
//            String newToken = JwtUtils.autoRequire(taken);
            JwtToken jwtToken = new JwtToken(taken);
            SecurityUtils.getSubject().login(jwtToken);
            String newToken = (String) SecurityUtils.getSubject().getPrincipal();

            response.addHeader("Authentication",newToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException("认证失败，请重新登录");
        }
    }
}
