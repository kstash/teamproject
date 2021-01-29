package teamproject.dto;

public class CartDB {
	private String cartcode;
	private String cartcolor;
	private String cartsize;
	private int cartcount;
	private String userid;
	private long productcode;
	
	private String productname;
	private int productprice;
	
	public String getCartcode() {
		return cartcode;
	}
	public void setCartcode(String cartcode) {
		this.cartcode = cartcode;
	}
	public String getCartcolor() {
		return cartcolor;
	}
	public void setCartcolor(String cartcolor) {
		this.cartcolor = cartcolor;
	}
	public String getCartsize() {
		return cartsize;
	}
	public void setCartsize(String cartsize) {
		this.cartsize = cartsize;
	}
	public int getCartcount() {
		return cartcount;
	}
	public void setCartcount(int cartcount) {
		this.cartcount = cartcount;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public long getProductcode() {
		return productcode;
	}
	public void setProductcode(long productcode) {
		this.productcode = productcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
}
