package teamproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import teamproject.dto.OrderDB;
import teamproject.dto.ReviewDB;
import teamproject.dto.RevimageDB;
import teamproject.service.OrderDBService;
import teamproject.service.ReviewDBService;
import teamproject.service.RevimageDBService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Resource
	private OrderDBService orderdbService;
	
	@Resource
	private ReviewDBService reviewdbService;
	
	@Resource
	private RevimageDBService revimagedbService;

	@GetMapping("/orderlist")
	public String orderlist(Model model, HttpSession session) {
		logger.info("orderlist 실행");
		String userId = (String)session.getAttribute("sessionUserid");
		List<OrderDB> orderlist = orderdbService.getOrderlistByUid(userId);
		model.addAttribute("orderlist", orderlist);

		return "mypage/orderlist";
	}
	
	//리스트가 작성되어있는지 찾아보는 메소드
	@GetMapping("/reviewcheck")
	public String reviewcheck(Model model, String ordercode, long productcode) {
		logger.info("실행");
		ReviewDB reviewOne = reviewdbService.getReviewByO(ordercode);
		model.addAttribute("review",reviewOne);
		model.addAttribute("ordercode", ordercode);
		model.addAttribute("productcode", productcode);
		return "mypage/reviewcheck";
	}
	//리뷰 작성

	@PostMapping("/reviewwrite")
	public String reviewWriteForm(HttpSession session, ReviewDB review, MultipartFile rphoto) throws IllegalStateException, IOException {
		String userId = (String)session.getAttribute("sessionUserid");
		review.setUserId(userId);
		//리뷰 이미치 있니 없ㅣ?
		if(rphoto.getContentType().equals("application/octet-stream")){
			review.setReviewIsimage(0);
			reviewdbService.saveReview(review);
		}else {
			//리뷰 먼저 저장
			review.setReviewIsimage(1);
			reviewdbService.saveReview(review);
			//이미지 db저장
			RevimageDB img = new RevimageDB();
			img.setOrderCode(review.getOrderCode());
			img.setRevimageOname(rphoto.getOriginalFilename());
			img.setRevimageType(rphoto.getContentType());
			img.setRevimagePath("/"+review.getOrderCode()+"/");
			//파일저장
			File saveFile = new File("C:/git/teamproject/WebContent/resources/img/review/users"+img.getRevimagePath()+img.getRevimageOname());
			rphoto.transferTo(saveFile);
			revimagedbService.addrevimage(img);
		}

		return "redirect:/mypage/reviewlist";
	}
	//리뷰리스트 page
	@GetMapping("/reviewlist")
	public String reviewlist(HttpSession session, Model model) {
		logger.info("실행");
		String userId = (String)session.getAttribute("sessionUserid");
		List<ReviewDB> reviewList = reviewdbService.getReviewlistByUid(userId);
		model.addAttribute("reviewList",reviewList);
		return "mypage/reviewlist";
	}
	
	@PostMapping("/reviewupdate")
	public String reviewreadForm(HttpSession session, ReviewDB review, MultipartFile rphoto) throws IllegalStateException, IOException {
		logger.info("실행");
		String userId = (String)session.getAttribute("sessionUserid");
		review.setUserId(userId);
		if(rphoto.getContentType().equals("application/octet-stream")){
			review.setReviewIsimage(0);
			reviewdbService.updateReview(review);
		}else {
			//리뷰 먼저 저장
			review.setReviewIsimage(1);
			reviewdbService.updateReview(review);
			//이미지 db저장
			RevimageDB img = new RevimageDB();
			img.setOrderCode(review.getOrderCode());
			img.setRevimageOname(rphoto.getOriginalFilename());
			img.setRevimageType(rphoto.getContentType());
			img.setRevimagePath("/"+review.getOrderCode()+"/");
			//파일저장
			File saveFile = new File("C:/git/teamproject/WebContent/resources/img/review/users"+img.getRevimagePath()+img.getRevimageOname());
			rphoto.transferTo(saveFile);
			revimagedbService.addrevimage(img);
		}
		
		
		
		return "redirect:/mypage/reviewlist";
	}
	@RequestMapping("/reviewdelete")
	public String reviewDelete(String ordercode) {
		RevimageDB img = revimagedbService.getRevimageByO(ordercode);
		if(img != null) {
			File targetFile = new File("C:/git/teamproject/WebContent/resources/img/review/users"+img.getRevimagePath());
			if(targetFile.exists()){ 
				//파일존재여부확인 
				if(targetFile.isDirectory()){ 
					//파일이 디렉토리인지 확인 
					File[] files = targetFile.listFiles(); 
					for( int i=0; i<files.length; i++){files[i].delete();}
				}
				targetFile.delete();
			}
		}
		revimagedbService.deleteRevimageByO(ordercode);
		reviewdbService.deleteReviewByO(ordercode);
		return "redirect:/mypage/reviewlist";
	}
}
