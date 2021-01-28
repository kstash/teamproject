package teamproject.dto;

public class ReviewDB {
	private int reviewPoint;
	private String reviewImagePath;
	private String reviewContents;
	private int reviewLikes;
	private String userId;
	private String orderCode;
	private long productCode;
	private int reviewIsimage;
	
	public int getReviewIsimage() {
		return reviewIsimage;
	}
	public void setReviewIsimage(int reviewIsimage) {
		this.reviewIsimage = reviewIsimage;
	}
	public int getReviewPoint() {
		return reviewPoint;
	}
	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}
	public String getReviewImagePath() {
		return reviewImagePath;
	}
	public void setReviewImagePath(String reviewImagePath) {
		this.reviewImagePath = reviewImagePath;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public int getReviewLikes() {
		return reviewLikes;
	}
	public void setReviewLikes(int reviewLikes) {
		this.reviewLikes = reviewLikes;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public long getProductCode() {
		return productCode;
	}
	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}
	
	
	
}
