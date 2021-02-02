package teamproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import teamproject.dto.CartDB;
import teamproject.service.CartDBService;

@Controller
public class CartDBController {
	private static Logger logger = 
			LoggerFactory.getLogger(CartDBController.class);
	
	@Resource
	private CartDBService cartService;
	
	@GetMapping("/cart")
	public String cartlist(Model model) {
		logger.info("CartDBController.cartlist() 실행");
		List<CartDB> cartlist = cartService.getCartlist();
		model.addAttribute("cartlist", cartlist);
		
		return "cart/cart";
	}
	
	@GetMapping("/deleteCart")
	public String deleteCart(int cartcode){
		cartService.deleteFromCart(cartcode);
		logger.info("Contoroller.deleteCart()");
		return "redirect:/cart";
	}
	
	@GetMapping("/cartBuy")
	public String cartBuy(List<CartDB> carts) {
		logger.info("Contoroller.cartBuy()");
		cartService.orderFromCarts(carts);
		
		return "redirect:/cart";
	}
}
