package com.lanou.demo.controller;

import com.lanou.demo.bean.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @RequestMapping(value = "/person/{name}",method = RequestMethod.GET)
    public Person findOne(@PathVariable String name){
        Person person = new Person();
        person.setName(name);
        person.setAge(22);
        return person;
    }
}
