package com.lanou.demo.mapper;

import com.lanou.demo.entity.Person;

import java.util.List;

public interface PersonMapper {

    List<Person> findAll();

    Person findByid(Person person);

    int addOne(Person person);

    int updateOne(Person person);
}
