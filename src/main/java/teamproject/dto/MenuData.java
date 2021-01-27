package teamproject.dto;

public class MenuData {
	//field
	private String linkpart;
	private String korean;
	
	//datalist
	private static String[] top = { "knit" , "longsleeves" , "hoody" , "blouse" , "shirts" , "bustier" , "shortsleeves" , "nosleeves" , "vest"};
	private static String[] topk = { "니트" , "긴팔" , "후드,맨투맨" , "블라우스" , "셔츠" , "뷔스티에" , "반팔" , "나시" , "조끼"};
	private static String[] outer = { "coat", "padding" , "jacket" , "furjacket", "leatgerhacjet", "cardigan"  , "jumper" };
	private static String[] outerk = { "코트", "패딩" , "자켓" , "퍼자켓", "가죽자켓", "가디건"  , "점퍼" };
	private static String[] pants = { "leggings", "longpants" , "denim" , "training"  , "shortpants" , "jumpesuit" };
	private static String[] pantsk = { "레깅스", "롱팬츠" , "데님" , "트레이닝"  , "숏팬츠" , "점프슈트" };
	private static String[] skirt = { "long", "midi" , "mini"};
	private static String[] skirtk = { "롱", "미디" , "미니"};
	//upperdata
	private static String[]  upperarr = { "top", "outer" , "pants" , "skirt"};
	private static String[]  upperarrk = { "탑", "아우터" , "팬츠" , "스커트"};
	private static String[][]  upperlist = { top, outer , pants , skirt};
	private static String[][]  upperlistk = { topk, outerk , pantsk , skirtk};
	
	public MenuData() {
		
	}
	
	
	//Getter Setter
	public String getLinkpart() {
		return linkpart;
	}
	public void setLinkpart(String linkpart) {
		this.linkpart = linkpart;
	}
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	//upperList search method
	public static String[] upperList(String upper){
		for(int i=0 ; i<upperarr.length ; i++) {
			if(upper.equals(upperarr[i])) {
				return upperlist[i]; 
			}
		}
		return null;
	}
	//upperList search method korean
	public static String[] upperListk(String upper){
		for(int i=0 ; i<upperarr.length ; i++) {
			if(upper.equals(upperarr[i])) {
				return upperlistk[i]; 
			}
		}
		return null;
	}
	//upper search method korean
	public static String upperK(String upper){
		for(int i=0 ; i<upperarr.length ; i++) {
			if(upper.equals(upperarr[i])) {
				return upperarrk[i]; 
			}
		}
		return null;
	}
	
	//now search method korean
	public static String nowK(String upper, String now){
		for(int i=0 ; i<upperarr.length ; i++) {
			if(upper.equals(upperarr[i])) {
				for(int j=0; j<upperlist[i].length; j++) {
					if(now.equals(upperlist[i][j])) {
						return upperlistk[i][j];
						
					}
				}
			}
		}
		for(int i=0 ; i<upperarr.length ; i++) {
			if(upper.equals(upperarr[i])) {
				return upperarrk[i]; 
			}
		}
		return null;
	}
}
