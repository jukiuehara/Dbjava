import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.products;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		products p = new products();
		Connection con = DbUtil.getConnection();
		ProductDao pd = new ProductDao(con);		
		
		p.setproduct_name("ボールペン");
		p.setprice(200);
		pd.register(p);
		
		List<products> array = pd.findAll();
	        for (products i : array) {
	            System.out.print( "product_id:" + i.getproduct_id());
	            System.out.print(",product_name" + i.getproduct_name());
	            System.out.print(",price" + i.getprice());
	            System.out.println("");
	        }
	}
}
