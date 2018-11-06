package com.lanou.springbootredis.controller;

import com.lanou.springbootredis.entity.RoleInfo;
import com.lanou.springbootredis.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleInfoService service;

    @RequestMapping("/findAll")
    public List<RoleInfo> findAll() {
        return service.findAll();
    }

    @RequestMapping("/findOne/{roleId}")
    public RoleInfo findOne(@PathVariable Long roleId) {
        return service.findOne(roleId);
    }

    @RequestMapping("/addOne")
    public Boolean addOne(RoleInfo roleInfo) {
         service.addOne(roleInfo);
         return true;
    }


    @RequestMapping("/deleteOne/{roleId}")
    public boolean deleteOne(@PathVariable Long roleId) {
         return service.deleteOne(roleId);
    }

    // 点赞
    @RequestMapping("/like/{roleId}")
    public boolean like(@PathVariable Long roleId){
        boolean thumb = service.thumb(roleId);
        return thumb;
    }

    // 查询排名
    @RequestMapping("/thumbList")
    public Set<?> thumbList(){
        Set<?> objects = service.thumbList();
        return objects;
    }

}
