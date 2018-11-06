package com.lanou.spring_shiro_test;

import com.lanou.spring_shiro_test.shiro.ShiroToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringShiroTestApplicationTests {

    @Test
    public void contextLoads() {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new ShiroToken("gfc","gfc"));
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("money");
        roles.add("staff");
        boolean[] booleans = subject.hasRoles(roles);
        System.out.println(Arrays.toString(booleans));
    }

}
