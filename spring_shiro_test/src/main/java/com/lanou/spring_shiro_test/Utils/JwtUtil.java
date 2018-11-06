package com.lanou.spring_shiro_test.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {


    public static String newToken(Long userId, long expiredSeconds) {
        String token = JWT.create()
                .withClaim("userId", userId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10000))
                .sign(Algorithm.HMAC256(Constans.SECRET_KEY));
        return token;
    }

    public static String newToken(Long userId) {
        return newToken(userId, Constans.DEFAULT_EXPIRED_SECONDS);
    }

    public static boolean checkToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constans.SECRET_KEY)).build();

        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String refreshToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        Long userId = jwt.getClaim("userId").asLong();
        return newToken(userId);
    }

    public static String autoRequire(String token) {
        boolean b = checkToken(token);
        if (b) {
            DecodedJWT jwt = JWT.decode(token);
            long current = System.currentTimeMillis();
            Long start = jwt.getClaim("iat").asLong();
            Long end = jwt.getClaim("exp").asLong();
            if ((current - start) * 1.0 / (end - start) > 0.8) {
                return refreshToken(token);
            }
            return token;
        }
        throw new JWTVerificationException("Token不合法");
    }
}
