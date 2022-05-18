package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.products;

public class ProductDao {
	private static final String SQL_ALL = "select product_id,product_name,price from products order by product_id";
	private static final String SQL_INSERT = "insert into products (product_name,price) VALUES (?, ?)";
	private static final String SQL_SELECT_ID = "select product_id,product_name,price from products where product_id = ?";
	private static final String SQL_UPDATE_ALL = "update products set product_name = ?,price = ? where product_id = ?";
	private static final String SQL_DELETE = "delete from products where product_name = ?";
	private Connection connection;

	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	public List<products> findAll() {
		List<products> list = new ArrayList<products>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				products p = new products(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public void register(products product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {

			stmt.setString(1, product.getproduct_name());
			stmt.setInt(2, product.getprice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public products fintdByProductId(Integer userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new products(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public void update(products product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_ALL)) {
			stmt.setString(1, product.getproduct_name());
			stmt.setInt(2, product.getprice());
			stmt.setInt(3, product.getproduct_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String name) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
			stmt.setString(1, name);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
