package teamproject.dto;

public class ProdimageDB {
	private String prodImagetype;
	private String prodImageoname;
	private String prodImagepath;
	private long productCode;
	
	public String getProdImagetype() {
		return prodImagetype;
	}
	public void setProdImagetype(String prodImagetype) {
		this.prodImagetype = prodImagetype;
	}
	public String getProdImageoname() {
		return prodImageoname;
	}
	public void setProdImageoname(String prodImageoname) {
		this.prodImageoname = prodImageoname;
	}
	public String getProdImagepath() {
		return prodImagepath;
	}
	public void setProdImagepath(String prodImagepath) {
		this.prodImagepath = prodImagepath;
	}
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
}
