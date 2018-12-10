package com.lanou.service;

import com.lanou.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    public PersonMapper personMapper;

    @Override
    public int deleteOne(Integer id) {
        return personMapper.deleteOne(id);
    }

    @Override
    public int delete(List<Integer> ids) {
        return personMapper.delete(ids);
    }
}
