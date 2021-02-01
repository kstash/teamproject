package teamproject.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teamproject.dto.ReviewDB;
import teamproject.dto.RevimageDB;
import teamproject.service.ReviewDBService;
import teamproject.service.RevimageDBService;

@Controller
@RequestMapping("/item")
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Resource
	private DataSource dataSource;
	
	@Resource
	private ReviewDBService reviewdbService;
	
	@Resource
	private RevimageDBService revimagedbService;
	
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
		
		//review가 없을때
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
		}
		
		//review가 있을때
		else {
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
			
			int imgCount = 0;
			String[] orderCodeList = new String[8];
			for(ReviewDB review : reviewList) {
				if(review.getReviewIsimage() > 0) {
					orderCodeList[imgCount] = review.getOrderCode();
					imgCount++;
				}
				if(imgCount >= 7) {
					break;
				}
			}
			model.addAttribute("orderCodeList", orderCodeList);
			
		}
		
		return "/item_detail/review";
	}
	
	
	//review image 불러오기
	@GetMapping("/battach")
	public void battach(String ordercode,  HttpServletResponse response) throws Exception {
		RevimageDB revimageOne = revimagedbService.getRevimageByO(ordercode);
		
		String imagePath = revimageOne.getRevimagePath();
		String oName = revimageOne.getRevimageOname();

		String filePath = "C:/git/teamproject/WebContent/resources/img/review/users"+imagePath+oName;
		
		response.setContentType(revimageOne.getRevimageType());

		oName = new String(oName.getBytes("UTF-8"), "ISO-8859-1");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + oName + ".jpg\"  ");
		
		OutputStream os = response.getOutputStream();
		
		InputStream is = new FileInputStream(filePath);
		byte[] data = new byte[1024];

		FileCopyUtils.copy(is, os);
		is.close();

		os.flush();
		os.close();
	}
	
	@RequestMapping("/reviewall")
	public String reviewAll(Model model) {
		logger.info("reviewall");
		List<ReviewDB> reviewList = reviewdbService.getReviewAll();
		model.addAttribute("reviewList",reviewList);
		return "review/reviewall";
	}
}
