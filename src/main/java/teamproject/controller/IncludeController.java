package teamproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/include")
public class IncludeController {
	private static final Logger logger = LoggerFactory.getLogger(IncludeController.class);
	
	@RequestMapping("/footer")
	public String footer() {
		logger.info("실행");
		return "include/footer";
	}
}
