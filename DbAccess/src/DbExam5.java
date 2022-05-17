import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.products;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		products p = new products();
		DbUtil db = new DbUtil();
		Connection con = DbUtil.getConnection();
		ProductDao pd = new ProductDao(con);		
		List<products> array = pd.findAll();
	        for (products i : array) {
	            System.out.print( i.getproduct_id());
	            System.out.print( i.getproduct_name());
	            System.out.print( i.getprice());
	        }
	}
}
