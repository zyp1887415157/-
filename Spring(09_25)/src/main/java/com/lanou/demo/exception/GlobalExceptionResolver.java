package com.lanou.demo.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//全局异常处理器
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    /*
       在Spring项目执行过程中，抛出了某个异常
       而这个异常没有try/catch，那么这个异常会传递到该方法中
       对异常做某个判断之后，可以返回特定的ModelAndView
       方法参数中的Exception对象，就是抛出的异常对象
     */

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        String message = ex.getMessage();

        if (ex instanceof  JspException){
            mv.setViewName("error");
            mv.addObject("error",message);
        }else if (ex instanceof JsonException){
            // 返回Json格式的错误信息
            JsonException je = (JsonException) ex;
            int code = je.getCode();
            mv.setView(new  MappingJackson2JsonView());
            mv.addObject("code",code);
            mv.addObject("status",false);
            mv.addObject("message",message);
        }else {
            mv.setViewName("error");
            mv.addObject("error","服务器出错了");
        }

        return mv;
    }
}
