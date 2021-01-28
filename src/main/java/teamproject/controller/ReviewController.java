package teamproject.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.ReviewDB;
import teamproject.service.ReviewDBService;

@Controller
@RequestMapping("/item")
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Resource
	private DataSource dataSource;
	
	@Resource
	private ReviewDBService reviewdbService;
	
	//item_detail 실행
	@RequestMapping("/")
	public String detailItem() {
		return "/item_detail/index";
	}
	//review 실행
	@GetMapping("/review")
	public String review(Model model, long productcode) {
		//review 전체 가져오기
		List<ReviewDB> reviewList = reviewdbService.getReviewListByPd(productcode);
		
		if(reviewList.isEmpty()) {
			model.addAttribute("stars", 0);
			model.addAttribute("star5", 0);
			model.addAttribute("starelse5", 1);
			model.addAttribute("star4", 0);
			model.addAttribute("starelse4", 1);
			model.addAttribute("star3", 0);
			model.addAttribute("starelse3", 1);
			model.addAttribute("star2", 0);
			model.addAttribute("starelse2", 1);
			model.addAttribute("star1", 0);
			model.addAttribute("starelse1", 1);
			model.addAttribute("fivescore", 0.0);
		}else {
			model.addAttribute("reviewList", reviewList);
	
			int stars = reviewList.size();
			//stars 리뷰의 개수
			model.addAttribute("stars", stars);
			
			//star5 star4 star3 star2 star1
			int[] star = {0,0,0,0,0};
			for(ReviewDB review : reviewList) {
				switch (review.getReviewPoint()) {
				case 5: star[4]++;
					break;
				case 4: star[3]++;
					break;
				case 3: star[2]++;
					break;
				case 2: star[1]++;
					break;
				case 1: star[0]++;
					break;
				}
			}
			model.addAttribute("star5", star[4]);
			model.addAttribute("starelse5", (stars - star[4]));
			model.addAttribute("star4", star[3]);
			model.addAttribute("starelse4", (stars - star[3]));
			model.addAttribute("star3", star[2]);
			model.addAttribute("starelse3", (stars - star[2]));
			model.addAttribute("star2", star[1]);
			model.addAttribute("starelse2", (stars - star[1]));
			model.addAttribute("star1", star[0]);
			model.addAttribute("starelse1", (stars - star[0]));
			
			//fivescore (star4+star5)/star전체
			double fivescore = Math.round(50*(star[4]+star[3])/stars)/10.0;
			model.addAttribute("fivescore", fivescore);
		}
		
		return "/item_detail/review";
		
		
	}
}
