package com.lanou3g;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/file-upload")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取真实路径
        String dirPath = getServletContext().getRealPath("files");
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //使用该类处理前端post过来的multipart/form-data数据
        ServletFileUpload up = new ServletFileUpload();
        //设置文件项(FileItem)工厂
        //这个Factory对象会在系统内部创建FileItem
        up.setFileItemFactory(new DiskFileItemFactory());
        //为文件项fileName设置编码
        up.setHeaderEncoding("utf-8");
        //单个文件的最大大小
        up.setFileSizeMax(1024 * 1024 * 2);
        //一次表单提交的最大值 一定要比上面的大
        up.setSizeMax(1024 * 1024 * 5);
        try {
            //解析请求
            List<FileItem> fileItems = up.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    //如果是表单属性(也就是说这个文件项不是文件)
                    continue;
                }

//                fileItem.getContentType();
                //返回这个文件项的ContentType
                //如果这个文件项是 formField,那么没有ContentType
                //返回该文件项上传的时候的  key
                //也就是html中input的name的属性的值
//                fileItem.getFieldName()
                //这个文件的文件名
                //fileItem.getName()
                //这个文件的文件大小
                //fileItem.getSize()

//               在dir文件夹下创建一个名为 fileItem.getName()的文件
//                File file = new File(dir, fileItem.getName());
                UUID uuid = UUID.randomUUID();
                String s = uuid.toString();
//                File file = new File(dir, s+".jpg");
                //获得图片绝对路径
//                file.getAbsolutePath()
                //将上传文件写入到本地文件中
//                fileItem.write(file);
                String name = fileItem.getName();
                String substring = name.substring(name.lastIndexOf(".") + 1);
                File file = new File(dir,s+"."+substring);
                fileItem.write(file);
            }
            out.println("文件上传成功😁");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
