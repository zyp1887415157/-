package com.lanou.token_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TokenDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenDemoApplication.class, args);
    }

    /*
    token  令牌
    jwt  JsonWeb Token  是一种标准
    java-jwt  框架 是java实现的JWT标准的一个框架
    jjwt

    JWT标准：token是由三部分组成，每部分组成使用 . 分开
    第一部分： 头（heard）里面保存了该token加密方式
    第二部分： 负载（payload）里面保存了用户信息/token的信息（id、过期时间等等）
    第三部分： 校验信息

    第一部分和第二部分是json格式的数据使用Base64 编码后的信息
    注意：该部分的信息是明文，不能存数敏感数据

     */
}
