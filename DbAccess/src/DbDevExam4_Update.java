import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDevExam4_Update {
    public static void main(String[] args) {
    	int param = 60;
    	int param2 = 101;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

                System.out.println("更新しました");
            // SQL query string
            String sql = "update products set price = ? where product_id = ?";

            // create statement
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, param);
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