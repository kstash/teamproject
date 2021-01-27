package teamproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.ReviewData;

@Controller
@RequestMapping("/item")
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	//item_detail 실행
	@RequestMapping("/")
	public String detailItem() {
		return "/item_detail/index";
	}
	//review 실행
	@RequestMapping("/review")
	public String review(Model model, int star5, int star4, int star3, int star2, int star1) {
		int stars =star5+star4+star3+star2+star1;
		double fivescore = Math.round(50*(star5+star4)/stars)/10.0;
		model.addAttribute("fivescore", fivescore);
		model.addAttribute("stars", stars);
		model.addAttribute("star5", star5);
		model.addAttribute("star4", star4);
		model.addAttribute("star3", star3);
		model.addAttribute("star2", star2);
		model.addAttribute("star1", star1);
		
		List<ReviewData> casList = new ArrayList<>();
		for(int i=0 ; i<stars; i++) {
			ReviewData cas = new ReviewData();
			cas.setReviewScore(5);
			cas.setReviewWriter("user"+i);
			cas.setReviewText("리뷰 내용 "+i+"번째");
			casList.add(cas);
		}
		model.addAttribute("casList", casList);
		
		
		return "/item_detail/review";
	}
	@RequestMapping("/review/cas")
	public String review_case(Model model) {

		
		return "/item_detail/review/cas";
	}
	
}
