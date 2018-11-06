package com.lanou.springbootredis.service;

import com.lanou.springbootredis.entity.RoleInfo;
import com.lanou.springbootredis.mapper.RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper mapper;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Cacheable(value = "roleService")
    @Override
    public List<RoleInfo> findAll() {
        System.out.println("RoleInfoServiceImpl.findAll");
        return mapper.findAll();
    }

    @Cacheable(value = "roleService", key = "#roleId")
    @Override
    public RoleInfo findOne(Long roleId) {
        System.out.println("RoleInfoServiceImpl.findOne");
        return mapper.findById(roleId).get();
    }


    // 插入数据的时候 可以同时插入到缓存里面  使用CachePut注解
    @CachePut(value = "roleService", key = "#roleInfo.roleId")
    @Override
    public RoleInfo addOne(RoleInfo roleInfo) {
        System.out.println("RoleInfoServiceImpl.addOne");
        RoleInfo info = mapper.save(roleInfo);
        return info;
    }


    // 添加这个注解  可以将缓存全部删除
    @CacheEvict(value = "roleService", allEntries = true)
    @Override
    public boolean deleteOne(Long roleId) {
        System.out.println("RoleInfoServiceImpl.deleteOne");
        mapper.deleteById(roleId);
        return true;
    }

    public boolean thumb(Long roleId) {
        ZSetOperations<Object, Object> opsForZSet = this.redisTemplate.opsForZSet();
        // 根据roleId 获取对应的对象
        RoleInfo one = findOne(roleId);
        opsForZSet.incrementScore("thumb:roleId",one,1);
        return true;
    }

    public Set<?> thumbList(){
        ZSetOperations<Object, Object> opsForZSet = this.redisTemplate.opsForZSet();
        Set<Object> set = opsForZSet.reverseRange("thumb:roleId", 0, 2);
        Set<ZSetOperations.TypedTuple<Object>> scores
                = opsForZSet.reverseRangeWithScores("thumb:roleId",0,2);
        return scores;
    }
}
