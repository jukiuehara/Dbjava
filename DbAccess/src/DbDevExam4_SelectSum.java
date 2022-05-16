import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDevExam4_SelectSum {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

			String sql = "SELECT Sum(price) as sum FROM products";

			stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int sum = rs.getInt("sum");

				System.out.println("合計金額:" + sum);
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
