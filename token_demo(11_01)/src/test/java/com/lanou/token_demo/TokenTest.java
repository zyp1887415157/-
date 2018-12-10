package com.lanou.token_demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lanou.token_demo.utils.JwtUtils;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenTest {


    // 创建一个秘钥  秘钥是唯一的
    public static final String SECRET_KEY = "qqqwwweeerrrrttt";

    @Test
    public void createToken() {
        // 创建一个token
        String token = JWT.create()
                // 在负载中添加自定义的数据
                .withClaim("userId", 1001)
                .withClaim("userName", "zyp")
                // 设置该token生成时间
                // 可以稍微记录一下上次的登录时间
                .withIssuedAt(new Date())
                // 设置该token的过期时间
                // 10秒钟后该token过期
                .withExpiresAt(new Date(System.currentTimeMillis() + 300000))
                // 最后一个使用（加密算法）  会生成一个token对象
                .sign(Algorithm.HMAC256(SECRET_KEY));

        System.out.println(token);


    }


    @Test
    public void require() {

        // 返回一个 验证器
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .build();

        // 校验前端发送过来的token是否合法
        // 如果合法会返回一个解码后的jwt对象
        // 如果不合法  会抛出xxx异常
        try {
            //  已过期
            String taoken1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6Inp5cCIsImV4cCI6MTU0MTA3MzMyMywidXNlcklkIjoxMDAxLCJpYXQiOjE1NDEwNzMwMjN9.5UJ0tmGv9pcQiJrMpQ-Inp4mNaZRJJEiIJqPeV7gYRY\n";
            //  不合法
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6Inp5cCIsImV4cCI6MTU0MTA0Mjc5MiwidXNlcklkIjoxMDAxLCJpYXQiOjE1NDEwNDI3ODJ9.dFZfpSLy6tK_u-zEK86meWHqHjveev7_LEKHgu_njHk\n";
            DecodedJWT verify = verifier.verify(taoken1);
            System.out.println(verify.getHeader());
            System.out.println(verify.getPayload());
        } catch (TokenExpiredException e) {
            System.out.println("Token已过期");
        } catch (SignatureVerificationException e) {
            System.out.println("Token不合法");
        } catch (Exception e) {
            System.out.println("认证失败");
        }
    }


    @Test
    public void json() throws InterruptedException {
        String token = JwtUtils.newToken(1001, 10);
        System.out.println(token);
        Thread.sleep(7000);
        String newToken = JwtUtils.autoRequire(token);
        System.out.println(newToken);
    }

    @Test
    public void test3() {

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());

    }

    @Test
    public void test4() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test5() {
        int array[] = {2, 5, 7, 3, 6, 3};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[i] > array[i + 1]) {
                    int c = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = c;
                }
            }
        }
        System.out.println();
        for (int i : array) {
            System.out.println(i);
        }
    }

    @Test
    public void test6() {
        System.out.println(Integer.valueOf(1)==Integer.valueOf(1));
    }

}
