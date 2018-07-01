package xyz.marsj.o2o.controller.shopAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/shopadmin",method=RequestMethod.GET)
public class ShopAdminController {
	@RequestMapping("/shopoperation")
	public String shopOperation(){
		return "shop/shopoperation";
	}
	@RequestMapping("/shoplist")
	public String shopList(){
		return "shop/shoplist";
	}
	@RequestMapping("/shopmanage")
	public String shopManage(){
		return "shop/shopmanage";
	}
	@RequestMapping("/productcategorymanage")
	public String productCategoryManage(){
		return "shop/productcategorymanage";
	}
	@RequestMapping("/productoperation")
	public String productOperation(){
		return "shop/productoperation";
	}
	@RequestMapping("/productmanage")
	public String productManage(){
		return "shop/productmanage";
	}

}
