import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbExam4 {
    public static void main(String[] args) {
    	String param = "地球儀";
    	int param2 = 101;
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");


            // SQL query string
            String sql = "SELECT * FROM products WHERE product_name = ?" + " OR product_id = ? order by product_id";

            // create statement
            stmt = con.prepareStatement(sql);
            stmt.setString(1, param);
            stmt.setInt(2, param2);



            // execute
            ResultSet rs = stmt.executeQuery();

            // output
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                String price = rs.getString("price");

                System.out.println("product_id:"+id+",product_name:"+name+",price:"+price);
            }
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