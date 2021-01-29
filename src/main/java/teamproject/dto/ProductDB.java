package teamproject.dto;

public class ProductDB {
	private long productCode;
	private String productName;
	private String productDesc;
	private int productPrice;
	private String lowcategoryEng;
	
	
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getLowcategoryEng() {
		return lowcategoryEng;
	}
	public void setLowcategoryEng(String lowcategoryEng) {
		this.lowcategoryEng = lowcategoryEng;
	}
	
	
}
