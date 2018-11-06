package com.lanou.demo.controller;

import com.lanou.demo.bean.Book;
import com.lanou.demo.exception.JsonException;
import com.lanou.demo.exception.JspException;
import com.lanou.demo.validate.BookAdd;
import com.lanou.demo.validate.BookUpdateValidator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    /*
    数据校验：
    1.需要人为的判断哪些属性需要校验
    2.这些属性各自需要怎么样的校验规则
    3.如果校验不通过需要提示什么信息
    4.这些信息如何发送给用户
     */
    @RequestMapping("/add")
    public String newBook(
            @Validated Book book,
            // 这个对象用来获取校验都通过的信息
            // 这个对象必须写在被校验实体类的后面
            // 这俩必须得挨着
            BindingResult result, Model model) {
        System.out.println("BookController.newBook");

        if (result.hasErrors()) {
            //判断是否存在校验不通过的属性
            //针对某个属性获取他的校验信息
            FieldError bookName = result.getFieldError("bookName");
            //针对某个属性获取他的所有校验信息
            List<FieldError> price = result.getFieldErrors("price");
            //获取所有属性的所有校验错误信息
            List<FieldError> errors = result.getFieldErrors();
            //如果出错了，把错误信息放到Model中
            model.addAttribute("errors", errors);
            for (FieldError error : errors) {
                String defaultMessage = error.getDefaultMessage();
                System.out.println(defaultMessage);
            }

            if (book.getId()>5) {
                throw new IllegalArgumentException("发生异常");
            }
            return "error";
        } else {
            return "success";
        }
    }

    @RequestMapping("/update")
    public String update(@Validated(value = {BookUpdateValidator.class, BookAdd.class}) Book book,
                         BindingResult result, Model model) {
        //更新书本的方法
        //该方法与新增书本的方法使用的是同一个实体对象
        //但是在不同的方法中校验规则是不同的
        return newBook(book, result, model);

    }

    @RequestMapping("/test")
    public String test(int id){
        if (id>5){
            throw new JsonException("ID出错",400);
        }
        return "success";
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("bookImage") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        // 获取前端设置的名字 name=imageName
        String name = file.getName();
        System.out.println("Key+"+name);
        // 获取文件原本的名字
        String filename = file.getOriginalFilename();
        System.out.println("文件名"+filename);
        //获取文件类型
        String type = file.getContentType();
        System.out.println("文件类型"+type);
        //获取文件大小
        long size = file.getSize();
        System.out.println("文件大小"+size);
        ServletContext app = request.getServletContext();
        //获取真实路径  如果不存在就创建文件夹
        String realPath = app.getRealPath("images");
        File fileDir = new File(realPath);
        fileDir.mkdirs();
        //  创建文件
        File image = new File(fileDir,filename);
        // 利用方法用流将图片写到文件中
        FileUtils.copyInputStreamToFile(file.getInputStream(),image);
        return "success";
    }
}
