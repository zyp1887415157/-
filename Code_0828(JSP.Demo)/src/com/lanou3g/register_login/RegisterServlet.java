package com.lanou3g.register_login;

import com.lanou3g.bean.HeaderImageBean;
import com.lanou3g.bean.UserBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register.action")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
        String dirPath = getServletContext().getRealPath("header-images");
        FileUtils.forceMkdir(new File(dirPath));
        //getParameter 只能取请求头中Content-Type的
        //值为:application/x-www-form-urlencoded 的请求的参数
        //或者是URL后面拼接的数据 说的直白点:name=XXX&password=yyy&age=18
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload up = new ServletFileUpload(factory);
        up.setHeaderEncoding("utf-8");
        up.setFileSizeMax(2 * 1024 * 1024);
        up.setSizeMax(5 * 1024 * 1024);
        ComboPooledDataSource source = new ComboPooledDataSource();
        Connection conn = null;
        File image = null;
        String msg= null;
        try {
            conn = source.getConnection();
            List<FileItem> fileItems = up.parseRequest(request);
            UserBean user = new UserBean();
            HeaderImageBean header = new HeaderImageBean();
            Map<String, String> map = new HashMap<>();
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    //如果是普通表单,先取出key
                    String key = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");
                    map.put(key, value);
//                    switch (key) {
//                        case "username":
//                            user.setUsername(value);
//                            break;
//                        case "password":
//                            user.setPassword(value);
//                            break;
//                    }
                } else {
                    //如果不是表单属性 说明 上传的是文件
                    if ("headerImage".equals(fileItem.getFieldName())) {
                        //接受用户上传的头像文件
                        if (fileItem.getContentType().startsWith("image")) {
                            // 图片名
                            String imageName = fileItem.getName();
                            String substring = imageName.substring(imageName.lastIndexOf(".") + 1);
                            String type = "." + substring;
                            // 图片类型
                            String imageType = fileItem.getContentType();
                            String uuid = UUID.randomUUID().toString();
                            // image 文件名
                            image = new File(dirPath, uuid + type);
                            fileItem.write(image);
                            //  文件绝对路径
                            String imagePath = image.getAbsolutePath();
                            header.setImageName(imageName);
                            header.setImageType(imageType);
                            header.setImagePath(imagePath);
                        }
                    }
                }
            }
            //把数据存储到数据库
            //关闭事物的自动提交
            conn.setAutoCommit(false);
            //对两次密输入进行校验
            String pwd = map.get("password");
            if (pwd == null || !pwd.equals(map.get("repeat"))) {
                throw new IllegalAccessException("两次密码不同");
            }
            String imgInsert = "insert into t_header_image (image_name,image_type,image_path) value (?,?,?)";
            Object[] imageValues = {header.getImageName(), header.getImageType(), header.getImagePath()};
            QueryRunner runner = new QueryRunner();
            //插入数据之后获取生成的id
            Long id = runner.insert(conn, imgInsert, new ScalarHandler<Long>(1), imageValues);
            String userInsert = "insert into t_user (image_id, username, password) value (?, ?, ?)";
            Object[] userValues = {id, map.get("username"), map.get("password")};
            runner.update(conn, userInsert, userValues);
            //提交事务
            DbUtils.commitAndCloseQuietly(conn);
//            out.println("注册成功");
            msg = "<a href = \"Login.html\">注册成功.点击跳转登录页面</a>";
        } catch (Exception e) {
            e.printStackTrace();
            //如果出现异常,把用户上传的文件删掉
            if (image != null) {
                image.delete();
            }
            //回滚事物
            try {
                DbUtils.rollbackAndCloseQuietly(conn);
//                out.println("注册失败");
                msg = "<a href = \"register.html\">注册失败.点击返回注册页面</a>";
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
