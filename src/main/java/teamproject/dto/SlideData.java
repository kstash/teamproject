package teamproject.dto;

import org.springframework.web.multipart.MultipartFile;

public class SlideData {
	//Field
	private String title;
	private String color;
	private String desc;
	private MultipartFile slideImage;
	
	//Getters&Setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getSlide() {
		return slideImage;
	}
	public void setSlide(MultipartFile slideImage) {
		this.slideImage = slideImage;
	}
	
	
}
