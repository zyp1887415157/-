package com.lanou.demo.controller;

import com.lanou.demo.bean.User;
import com.lanou.demo.service.UserRegister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RegisterController {

    @RequestMapping("/test")
    public String test(){
        return "register";
    }


    @RequestMapping("/register")
    public String register(@Validated(value = {UserRegister.class}) User user, BindingResult result, Model model) {
        if (result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            model.addAttribute("errors",errors);
            return "error";
        }else {
            return "login";
        }
    }
}
