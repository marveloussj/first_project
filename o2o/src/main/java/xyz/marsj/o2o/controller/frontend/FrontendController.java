package xyz.marsj.o2o.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/frontend",method=RequestMethod.GET)
public class FrontendController {
	@RequestMapping("/index")
	public String index(){
		return "frontend/index";
	}
	@RequestMapping("/test")
	public String test(){
		return "frontend/test";
	}
	@RequestMapping("/shoplist")
	public String shopList(){
		return "frontend/shoplist";
	}
	@RequestMapping("/shopdetail")
	public String shopDetail(){
		return "frontend/shopdetail";
	}
}
