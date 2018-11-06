package com.lanou3g;

import com.lanou3g.bean.HeaderImageBean;
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
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String realPath = getServletContext().getRealPath("images");
        FileUtils.forceMkdir(new File(realPath));
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload up = new ServletFileUpload(factory);
        up.setHeaderEncoding("utf-8");
        up.setFileSizeMax(2 * 1024 * 1024);
        up.setSizeMax(5 * 1024 * 1024);
        ComboPooledDataSource source = new ComboPooledDataSource();
        Connection conn = null;
        File image = null;
        String msg = null;
        try {
            conn = source.getConnection();
            List<FileItem> fileItems = up.parseRequest(request);
            Map<String, String> map = new HashMap<>();
            HeaderImageBean headerImageBean = new HeaderImageBean();
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    //如果是普通文件  获取 key /value  放入map集合
                    // 获取文件项的名字
                    String key = fileItem.getFieldName();
                    String value = fileItem.getString("utf-8");
                    map.put(key, value);
                } else {
                    if ("headerImg".equals(fileItem.getFieldName())) {
                        if (fileItem.getContentType().startsWith("image")) {
                            String name = fileItem.getName();
                            String substring = name.substring(name.lastIndexOf(".") + 1);
                            String type = "." + substring;
                            String imageType = fileItem.getContentType();
                            String uuid = UUID.randomUUID().toString();
                            image = new File(realPath, uuid + type);
                            fileItem.write(image);
                            String path = image.getAbsolutePath();
                            headerImageBean.setImageName(name);
                            headerImageBean.setImageType(imageType);
                            headerImageBean.setImagePath(path);
                        }
                    }
                }
            }
            //关闭事物的自动提交
            conn.setAutoCommit(false);
            String password1 = map.get("password1");
            if (password1 == null || !password1.equals(map.get("password2"))) {
                throw new IllegalAccessException("两次密码不相同");
            }
            String imgInsert = "insert into t_header_image (image_name,image_type,image_path) value (?,?,?)";
            Object[] imgValues = {headerImageBean.getImageName(), headerImageBean.getImageType(), headerImageBean.getImagePath()};
            QueryRunner runner = new QueryRunner();
            Long id = runner.insert(conn, imgInsert, new ScalarHandler<Long>(1), imgValues);
            String userInsert = "insert into t_user (image_id, username, password) value (?, ?, ?)";
            Object[] userValues = {id, map.get("username"), map.get("password1")};
            runner.update(conn, userInsert, userValues);
            DbUtils.commitAndCloseQuietly(conn);
            msg = "注册成功";
        } catch (Exception e) {
            e.printStackTrace();
            if (image != null) {
                image.delete();
            }
            DbUtils.rollbackAndCloseQuietly(conn);
            msg = "注册失败";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
