package com.lanou.load_balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LoadBalanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalanceApplication.class, args);

    }

    @GetMapping("/test")
    public String test() {
        System.out.println("xxxxx");
        return "我欲成仙";
    }
}
