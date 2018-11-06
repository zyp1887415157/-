package com.lanou.springjpa2;

import com.lanou.springjpa2.entity.ModuleEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringJpa2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpa2Application.class, args);
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setModuleId(2l);
        moduleEntity.setModuleName("xx");
        System.out.println(moduleEntity);
    }

    @RequestMapping("test")
    public String test(){
        return "success";
    }
}
