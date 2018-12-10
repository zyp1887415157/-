package com.lanou.mapper;

import com.lanou.controller.PersonController;
import com.lanou.service.PersonService;
import com.lanou.service.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-service.xml", "classpath:mybatis-config.xml"})
public class PersonMapperTest {

    @Resource
    public PersonService personService;

    @Test
    public void test(){
        personService.deleteOne(1);
    }


    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(77);
        list.add(25);
        personService.delete(list);
    }
}