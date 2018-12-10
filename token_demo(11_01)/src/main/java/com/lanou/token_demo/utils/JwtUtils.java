package com.lanou.token_demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtils {

    /**
     * @param userId         用户id
     * @param expiredSeconds 过期时长
     * @return token
     */
    // 两个参数 用户id，过期时长
    public static String newToken(Integer userId, long expiredSeconds) {
        return JWT.create()
                .withClaim("userId", userId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiredSeconds * 1000))
                .sign(Algorithm.HMAC256(Constants.SECRET_KEY));
    }

    /**
     * 默认过期时间 30分钟
     *
     * @param userId
     * @return
     */

    public static String newToken(Integer userId) {
        return newToken(userId, Constants.DEFAULT_EXPIRED_SECONDS);
    }

    /**
     * 校验是否合法
     *
     * @param token 需要校验的token
     * @return 是否合法
     */
    public static boolean checkToker(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constants.SECRET_KEY))
                .build();

        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 刷新token
     *
     * @param token 原token
     * @return 新token
     */
    public static String refreshToken(String token) {
        // 解码
        DecodedJWT jwt = JWT.decode(token);
        Integer userId = jwt.getClaim("userId").asInt();
        // 返回新的token
        return newToken(userId);


    }

    public static String autoRequire(String taken) {
        boolean check = checkToker(taken);
        if (check) {
            DecodedJWT jwt = JWT.decode(taken);
            // 计算时间是否超过80%
            // 获取当前时间
            long current = System.currentTimeMillis() / 1000;
            // 获取开始时间
            Long start = jwt.getClaim("iat").asLong();
            Long end = jwt.getClaim("exp").asLong();
            // 存活时间 / 总时间  是否大于80%
            if ((current - start) * 1.0 / (end - start) > 0.8) {
                // 返回新的token
                return refreshToken(taken);
            } else {
                // 返回原来的token
                return taken;
            }
        } else {
            throw new JWTVerificationException("token不合法");
        }
    }

    public static Integer getUserId(String jwtToken) {
        //  返回用户id
        return JWT.decode(jwtToken).getClaim("userId").asInt();
    }
}
