package com.lanou.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class Upload {

    @RequestMapping("/test3.action")
    public String test3(){
        return "upload";
    }

    @RequestMapping("/upload.action")
    public String upload(@RequestParam("bookImage") CommonsMultipartFile file,
                         HttpServletRequest request) throws Exception {
        //获取表单中设置的name
        String name = file.getName();
        System.out.println("key"+name);
        //获取文件原本的名字
        String filename = file.getOriginalFilename();
        System.out.println("文件名为"+filename);
        //获取文件类型
        String contentType = file.getContentType();
        System.out.println("文件类型为"+contentType);
        long size = file.getSize();
        System.out.println("获取文件大小"+size);
        ServletContext servletContext = request.getServletContext();
        //获取真实路径  如果不存在就创建一个文件夹
        String images = servletContext.getRealPath("images");
        File file1 = new File(images);
        file1.mkdirs();
        File image = new File(file1,filename);
        FileUtils.copyInputStreamToFile(file.getInputStream(),image);
        return "success";
    }

}
