package teamproject.dto;

import org.springframework.web.multipart.MultipartFile;

public class ReviewData {
	//field
	private int reviewScore;
	private String reviewWriter;
	private String reviewText;
	private MultipartFile reviewImage;
	
	//getter setter
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public MultipartFile getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(MultipartFile reviewImage) {
		this.reviewImage = reviewImage;
	}
	
	//Data
	
}
