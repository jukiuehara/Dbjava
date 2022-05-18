import java.util.List;

import dao.ProductDao;
import entity.products;
import util.DbUtil;

public class DbDevExam5_Delete {
	public static void main(String[] args) {
		ProductDao pd = new ProductDao(DbUtil.getConnection());
		pd.delete("ボールペン");
		List<products> list = pd.findAll();
		for (products i : list) {
			System.out.print("product_id:" + i.getproduct_id());
			System.out.print(",product_name" + i.getproduct_name());
			System.out.print(",price" + i.getprice());
			System.out.println("");
		}
	}
}