package teamproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminsController {
/* 해당 AdminsController는 관리자용 페이지에서 사용될 수 있는 것들을 
 * 종합적으로 컨트롤 하는 곳 입니다.
 * 1. 카테고리(상위, 하위) 설정.
 * 2. 특정 (최소)하위 카테고리에 종속된 product 정보를 추가, 수정, 제거
 * 3.  
 */
	private static final Logger logger = LoggerFactory.getLogger(AdminsController.class);
	
	@RequestMapping("/adminspage")
	public String adminspage() {
		//관리자 권한 체크 필수
		
		//관리자용 페이지 불러오기
		
		return "admins/adminspage";
	}
}
