import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDevExam4_Select {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

			String sql = "SELECT * FROM products order by product_id";

			stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String price = rs.getString("price");

				System.out.println("product_id:" + id + ",product_name:" + name + ",price:" + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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