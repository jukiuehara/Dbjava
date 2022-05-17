package entity;

public class products {
	private Integer product_id;
	private String product_name;
	private Integer price;

	public products() {

	}

	public products(Integer product_id, String product_name, Integer price) {

		this.product_name = product_name;
		this.price = price;
		this.product_id = product_id;
	}

	public void setproduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setprice(Integer price) {
		this.price = price;
	}

	public Integer getproduct_id() {
		return this.product_id;
	}

	public String getproduct_name() {
		return this.product_name;
	}

	public Integer getprice() {
		return this.price;
	}

}