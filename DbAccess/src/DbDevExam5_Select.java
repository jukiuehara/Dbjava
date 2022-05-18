import dao.ProductDao;
import entity.products;
import util.DbUtil;

public class DbDevExam5_Select {
	public static void main(String[] args) {
		ProductDao pd = new ProductDao(DbUtil.getConnection());
		products a = pd.fintdByProductId(102);
        System.out.print( "product_id:" + a.getproduct_id());
        System.out.print(",product_name" + a.getproduct_name());
        System.out.print(",price" + a.getprice());
	}
}