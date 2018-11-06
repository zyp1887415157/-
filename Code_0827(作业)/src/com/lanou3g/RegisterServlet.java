package com.lanou3g;

import com.jspsmart.upload.SmartUpload;
import com.lanou3g.Test.Image;
import com.lanou3g.Test.UnderlineProcessor;
import com.lanou3g.Test.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");
        ComboPooledDataSource source = new ComboPooledDataSource();
        PrintWriter out = response.getWriter();


        try {
            String username = request.getParameter("username");
//            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 =request.getParameter("password2");
            System.out.println(username + password1 + password2);
            if (password1.equals(password2)) {
                Connection conn = source.getConnection();
                QueryRunner runner = new QueryRunner();
                String sql1 = "select username from t_user";
                List<User> query = runner.query(conn, sql1, new BeanListHandler<>(User.class, new UnderlineProcessor()));
                String dirpath = getServletContext().getRealPath("files");
                File dir = new File(dirpath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                ServletFileUpload up = new ServletFileUpload();
                up.setFileItemFactory(new DiskFileItemFactory());
                up.setHeaderEncoding("utf-8");
                up.setFileSizeMax(2 * 1024 * 1024);
                up.setSizeMax(5 * 1024 * 1024);
                List<FileItem> fileItems = up.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        continue;
                    }
                    String name = fileItem.getName();
                    String substring = name.substring(name.lastIndexOf(".") + 1);
                    String type = "." + substring;
                    UUID uuid = UUID.randomUUID();
                    String s = uuid.toString();
                    File file = new File(dir, s + type);
                    String absolutePath = file.getAbsolutePath();
                    fileItem.write(file);
                    String sql = "insert into t_header_image(image_name,image_type,image_path) values (?,?,?)";
                    Object[] o = {name, type, absolutePath};
                    runner.insert(conn, sql, new BeanListHandler<>(Image.class, new UnderlineProcessor()), o);

                }

                int i;
                hhh:
                for (i = 0; i < query.size(); i++) {
                    for (User user : query) {
                        if (username.equals(user.getUsername())) {
                            break hhh;
                        }
                    }
                }
                if (i < query.size()) {
                    out.println("<a href =\"Register.html\" ><h1>用户名已存在</h1></a>");
                } else if (i == query.size()) {
                    String sql = "insert into t_user (username,password) values(?,?)";
                    Object[] o = {username, password1};
                    runner.insert(conn, sql, new BeanListHandler<>(User.class, new UnderlineProcessor()), o);
                    response.setHeader("refresh", "5;url=index.jsp");
                    response.getWriter().println("<a  href=\"Login.html\">5秒之后自动跳转到登录页面</a>");
                    out.println("<h1>注册成功</h1>");
                }
            } else {
                out.println("<h1>注册失败</h1>");
                response.setHeader("refresh", "5;url=Register.html");
                response.getWriter().println("<a  href=\"Register.html\">5秒之后自动跳转到登录页面</a>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        System.out.println(username);
        System.out.println(password1);
        System.out.println(password2);
    }
}
