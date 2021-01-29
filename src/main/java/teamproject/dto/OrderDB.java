package teamproject.dto;

import java.util.Date;

public class OrderDB {
	private String orderStatus;
	private String orderCode;
	private String orderColor;
	private String orderSize;
	private int orderCount;
	private String orderFreeshipping;
	private Date orderDate;
	private String userId;
	private long productCode;
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderColor() {
		return orderColor;
	}
	public void setOrderColor(String orderColor) {
		this.orderColor = orderColor;
	}
	public String getOrderSize() {
		return orderSize;
	}
	public void setOrderSize(String orderSize) {
		this.orderSize = orderSize;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getOrderFreeshipping() {
		return orderFreeshipping;
	}
	public void setOrderFreeshipping(String orderFreeshipping) {
		this.orderFreeshipping = orderFreeshipping;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
	
	
}
