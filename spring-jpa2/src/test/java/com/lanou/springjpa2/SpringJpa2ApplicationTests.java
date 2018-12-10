package com.lanou.springjpa2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpa2ApplicationTests {

    @Test
    public void contextLoads() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.stream().distinct();
        list.forEach(System.out::println);
    }

}
