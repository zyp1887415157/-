package com.lanou.springbootredis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;

// 相当于spring中的.xml文件  项目一启动就会加载这里面的配置
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        // 创建Redis模板
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        // 给key序列化  转成string类型   redis中key都是string类型
        template.setKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // 定制Jackson
        ObjectMapper mapper = new ObjectMapper();
        // 接收时间类型的数据时   转成这种格式 放入到redis中
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        // 关于jackson的更多配置，自己查
        // 比如对象的null属性是否序列化
        // 比如是否转成跟完美的Jackson格式
        valueSerializer.setObjectMapper(mapper);
        // 给value设置序列化成json格式
        template.setValueSerializer(valueSerializer);
        template.setKeySerializer(valueSerializer);
        // 在属性 配置之后 也会加载 application.yml 中 Jackson的配置
        template.afterPropertiesSet();
        // 返回 配置好的  template 对象
        return template;
    }
}
