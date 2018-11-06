package com.lanou.token_demo.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobaExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof NullPointerException) {
            ModelAndView mv = new ModelAndView();
            mv.setView(new MappingJackson2JsonView());
            mv.addObject("status", false);
            mv.addObject("code", 408);
            mv.addObject("message", ex.getMessage());
            return mv;
        }
        return null;
    }
}


