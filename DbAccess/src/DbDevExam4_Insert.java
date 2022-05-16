import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Insert {
    public static void main(String[] args) {
    	String param = "ボールペン";
    	int param2 = 200;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

                System.out.println("登録しました");
            // SQL query string
            String sql = "insert into products (product_name,price) values(?,?)";

            // create statement
            stmt = con.prepareStatement(sql);
            stmt.setString(1, param);
            stmt.setInt(2, param2);



           

            stmt.executeUpdate();




            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}