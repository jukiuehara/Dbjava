package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.products;

public class ProductDao{
	private static final String SQL_ALL = "select product_id,product_name,price from products order by id";
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }
    public List<products> findAll(){
    	   List<products> list = new ArrayList<products>();
    
    try(PreparedStatement stmt = connection.prepareStatement(SQL_ALL)){
    	ResultSet rs = stmt.executeQuery();
    	
    	while(rs.next()) {
    		products p = new products(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("price"));
    		list.add(p);}
    	} catch(SQLException e) {
    		throw new RuntimeException(e);
    	}
    	return list;
    }
    }