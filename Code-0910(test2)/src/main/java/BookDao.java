



import java.sql.Connection;
import java.sql.DriverManager;


public class BookDao {

    String url = "jdbc:mysql://localhost:3306/MyBookStore";
    String user = "root";
    String password = "123456";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
