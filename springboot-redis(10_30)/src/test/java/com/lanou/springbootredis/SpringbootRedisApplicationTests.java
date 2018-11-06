package com.lanou.springbootredis;

import com.lanou.springbootredis.entity.RoleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Resource(name = "redisTemplate")
    private ValueOperations<Object,Object> valOps;

    @Test
    public void contextLoads() {

        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setName("孙悟空");
        roleInfo.setRoleId(1000L);
        valOps.set(roleInfo,"男");
        valOps.set("hello","world");
        System.out.println(valOps.get(roleInfo));
    }

}
