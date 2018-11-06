package com.lanou.token_demo;

import com.lanou.token_demo.shiro.SimpleUsernameToken;
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
public class TokenDemoApplicationTests {


    @Test
    public void contextLoads() {

        Subject subject = SecurityUtils.getSubject();
        subject.login(new SimpleUsernameToken("ldh", "ldh"));
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("money");
        roles.add("staff");
        String[] pers = {"admin:create", "admin:update", "money:create", "money:delete"};
        boolean[] permitted = subject.isPermitted(pers);
        boolean[] booleans = subject.hasRoles(roles);
        System.out.println(Arrays.toString(booleans));
        System.out.println(Arrays.toString(permitted));

    }

}
