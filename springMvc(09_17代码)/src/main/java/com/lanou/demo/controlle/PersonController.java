package com.lanou.demo.controlle;

import com.lanou.demo.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController 注解标记的Controller
 * 里面的所有请求都自动加上了ResponseBody注解
 * Restful 它是一种url的设计规则
 * /add_user  ->  /user  put请求
 * /delete_user  ->user  delete请求
 * /update_user  ->user   post请求
 * /find_user    ->      get请求
 * <p>
 * /book?id=1    ->   /book/1  查询一本书
 */
@RestController
public class PersonController {

    /*
    查询所有用户
     */
//    @RequestMapping(value = "/person", method = RequestMethod.GET)
//    //required  必填
//    public List<Person> findAll(@RequestParam(value = "page", required = true, defaultValue = "1") int page,
//                                @RequestParam(defaultValue = "20") int count) {
//        return null;
//    }
//
//    @RequestMapping(value = "/person", method = RequestMethod.DELETE)
//    public Person delete() {
//        return null;
//    }

    @RequestMapping(value = "/person/{id}/{name}", method = RequestMethod.GET)
    public Person findOne(@PathVariable int id,@PathVariable String name) {
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAge(20);
        return p;
    }
}
