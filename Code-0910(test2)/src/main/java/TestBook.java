import com.lanou.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBook {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from book";
        BookDao bookDao = new BookDao();
        Connection conn = bookDao.getConnection();
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(sql);
        while (set.next()){
            int bid = set.getInt("bid");
            String bname = set.getString("bname");
            double price = set.getDouble("price");
            String author = set.getString("author");
            String image = set.getString("image");
            Book book = new Book(bid,bname,price,author,image);
            System.out.println(book);
        }

    }
}
