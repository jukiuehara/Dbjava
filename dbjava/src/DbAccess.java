import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAccess {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // confirm
            System.out.println(" --- before connection --- ");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:axiz", "postgres", "axiz");

            // confirm
            System.out.println(" --- after connection --- ");

            // SQL query string
            String sql = "SELECT * FROM users";

            // create statement
            stmt = con.prepareStatement(sql);

            // execute
            ResultSet rs = stmt.executeQuery();

            // output
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String mail = rs.getString("mail");

                System.out.println(id);
                System.out.println(name);
                System.out.println(mail);
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