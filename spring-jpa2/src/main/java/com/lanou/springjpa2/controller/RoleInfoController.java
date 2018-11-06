package com.lanou.springjpa2.controller;

import com.lanou.springjpa2.Repository.ModuleRepositry;
import com.lanou.springjpa2.Repository.RoleInfoRepository;
import com.lanou.springjpa2.Repository.temp.RoleEx;
import com.lanou.springjpa2.entity.ModuleEntity;
import com.lanou.springjpa2.entity.RoleEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleInfoController {

    @Resource
    private RoleInfoRepository roleInfoRepository;

    @Resource
    private ModuleRepositry moduleRepositry;



    @RequestMapping("/list")
    public List<RoleEntity> list() {
        return this.roleInfoRepository.findAll();
    }

    @RequestMapping("/moduleList")
    public List<ModuleEntity> test2() {
        return this.moduleRepositry.findAll();
    }

    @RequestMapping("/moduleCount")
    public List<RoleEx> test3() {
        return this.roleInfoRepository.roleGroup();
    }

    @RequestMapping("/autoList")
    public List<?> test4() {
        return this.roleInfoRepository.queryTest();
    }

}
