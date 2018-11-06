package com.lanou.demo.controller;

import com.lanou.demo.bean.User;
import com.lanou.demo.exception.JsonException;
import com.lanou.demo.service.UserLogin;
import com.lanou.demo.service.UserRegister;
import com.lanou.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {


    @Autowired
    private UserLogin userLogin = new UserServiceImpl();


    @RequestMapping("/test2")
    public String test() {
        return "login";
    }

    @RequestMapping("/result")
    public String result() {
        return "result";
    }


    @RequestMapping("/login")
    public String login(@Validated(value = {UserLogin.class}) User user, BindingResult result,
                        Model model, HttpServletRequest request) {
        boolean login = userLogin.login(user);
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            model.addAttribute("errors", errors);

            return "error";
        }
        if (login) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "success";
        } else {
            throw new JsonException("用户名/密码错误", 400);
        }
    }
}
