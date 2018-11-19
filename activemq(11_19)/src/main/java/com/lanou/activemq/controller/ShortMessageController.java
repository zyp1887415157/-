package com.lanou.activemq.controller;

import com.lanou.activemq.service.ShortMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class ShortMessageController {

    @Resource
    private ShortMessageService shortMessageService;

    // 调用service中的方法  发送消息
    @RequestMapping("/send")
    public String test(){
        shortMessageService.sendVerifyCode();
        return "成功";
    }

}
