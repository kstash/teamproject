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
	
	@GetMapping("/reviewcheck")
	public String reviewcheck(Model model, String ordercode, long productcode) {
		logger.info("실행");
		ReviewDB reviewOne = reviewdbService.getReviewByO(ordercode);
		model.addAttribute("review",reviewOne);
		model.addAttribute("ordercode", ordercode);
		model.addAttribute("productcode", productcode);
		return "mypage/reviewcheck";
	}
	@GetMapping("/reviewlist")
	public String reviewlist() {
		logger.info("reviewlist 실행");
		return "mypage/reviewlist";
	}
	@GetMapping("/reviewwrite")
	public String reviewWrite(String ordercode, long productcode, Model model) {
		model.addAttribute("ordercode", ordercode);
		model.addAttribute("productcode", productcode);
		return "mypage/reviewwrite";
	}
	@PostMapping("/reviewwrite")
	public String reviewWriteForm(HttpSession session, ReviewDB review) {
		String userId = (String)session.getAttribute("sessionUserid");
		review.setUserId(userId);
		review.setReviewIsimage(0);
		reviewdbService.saveReview(review);
		return "redirect:/mypage/reviewlist";
	}
}
