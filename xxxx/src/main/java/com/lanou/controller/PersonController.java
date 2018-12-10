package com.lanou.controller;

import com.lanou.mapper.PersonMapper;
import com.lanou.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class PersonController {

    @Resource
    public PersonService personService;

    @RequestMapping(name = "/delete")
    public int deleteOne(Integer id){
        return personService.deleteOne(id);
    }
}
