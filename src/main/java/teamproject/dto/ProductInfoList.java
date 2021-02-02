package teamproject.dto;

import java.util.List;

public class ProductInfoList {
	private ProductDB productdb;
	private ProdimageDB prodimgdb;
	private List<StockDB> stockdb;
	
	public ProductDB getProductdb() {
		return productdb;
	}
	public void setProductdb(ProductDB productdb) {
		this.productdb = productdb;
	}
	public ProdimageDB getProdimgdb() {
		return prodimgdb;
	}
	public void setProdimgdb(ProdimageDB prodimgdb) {
		this.prodimgdb = prodimgdb;
	}
	public List<StockDB> getStockdb() {
		return stockdb;
	}
	public void setStockdb(List<StockDB> stockdb) {
		this.stockdb = stockdb;
	}
	
}
