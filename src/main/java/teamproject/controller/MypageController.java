package teamproject.controller;

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

import teamproject.dto.OrderDB;
import teamproject.dto.ReviewDB;
import teamproject.service.OrderDBService;
import teamproject.service.ReviewDBService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Resource
	private OrderDBService orderdbService;
	
	@Resource
	private ReviewDBService reviewdbService;

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
	public String reviewWriteForm(HttpSession session, ReviewDB review) {
		String userId = (String)session.getAttribute("sessionUserid");
		review.setUserId(userId);
		review.setReviewIsimage(0);
		reviewdbService.saveReview(review);
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
	public String reviewreadForm(HttpSession session, ReviewDB review) {
		logger.info("실행");
		String userId = (String)session.getAttribute("sessionUserid");
		review.setUserId(userId);
		reviewdbService.updateReview(review);
		return "redirect:/mypage/reviewlist";
	}
	@RequestMapping("/reviewdelete")
	public String reviewDelete(String ordercode) {
		reviewdbService.deleteReviewByO(ordercode);
		return "redirect:/mypage/reviewlist";
	}
}
