import dao.ProductDao;
import entity.products;
import util.DbUtil;

public class DbDevExam5_Update {
	public static void main(String[] args) {
		ProductDao pd = new ProductDao(DbUtil.getConnection());
		products a = pd.fintdByProductId(101);
		System.out.println("【更新前】");
        System.out.print( "product_id:" + a.getproduct_id());
        System.out.print(",product_name" + a.getproduct_name());
        System.out.println(",price" + a.getprice());
        products p = new products(101,"シャープペンシル",70);
        pd.update(p);
        products b = pd.fintdByProductId(101);
        System.out.println("【更新後】");
        System.out.print( "product_id:" + b.getproduct_id());
        System.out.print(",product_name" + b.getproduct_name());
        System.out.print(",price" + b.getprice());
        
	}
}