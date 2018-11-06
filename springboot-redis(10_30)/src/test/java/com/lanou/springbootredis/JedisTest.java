package com.lanou.springbootredis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    @Test
    public void test() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.close();

        // 构造方法不填参数的时候
        // 默认的url就是127.0.0.1:6379
        JedisPool pool = new JedisPool();
        Jedis j1 = pool.getResource();
        String s = j1.mset("a", "1", "b", "2","c","3");
        System.out.println(s);
        System.out.println(j1.mget("a","b","c"));
        j1.close();


    }
}
