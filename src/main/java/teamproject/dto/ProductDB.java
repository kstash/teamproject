package teamproject.dto;

public class ProductDB {
	private int productCode;
	private String productName;
	private String productDesc;
	private int productPrice;
	private String productImagePath;
	private String lowcategoryEng;
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
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
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public String getLowcategoryEng() {
		return lowcategoryEng;
	}
	public void setLowcategoryEng(String lowcategoryEng) {
		this.lowcategoryEng = lowcategoryEng;
	}
	
	
}
