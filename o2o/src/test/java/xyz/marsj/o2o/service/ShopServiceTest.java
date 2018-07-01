package xyz.marsj.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.dto.ImgHolder;
import xyz.marsj.o2o.dto.ShopExecution;
import xyz.marsj.o2o.entity.Area;
import xyz.marsj.o2o.entity.PersonInfo;
import xyz.marsj.o2o.entity.Shop;
import xyz.marsj.o2o.entity.ShopCategory;
import xyz.marsj.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest2 {
	@Autowired
	private IShopService shopService;
	@Test
	public void testQueryShopList(){
		Shop shopCondition=new Shop();
		ShopCategory shopCategory =new ShopCategory();
		shopCategory.setShopCategoryId(22L);
		shopCondition.setShopCategory(shopCategory);
		ShopExecution se = shopService.queryShopList(shopCondition, 1, 1);
		System.out.println("new查询条数"+se.getShopList().size());
		System.out.println("总条数"+se.getCount());
		
	}
	@Test
	public void testModifyShop() throws Exception{
		Shop shop = new Shop();
		shop.setShopId(22L);
		shop.setShopName("娱乐大厦");
		File imgfile =new File("E:/picture/readimagexs.jpg");
		InputStream shopImgInputStream=new FileInputStream(imgfile);
		ImgHolder imgHolder=new ImgHolder(shopImgInputStream,"picturereadimagexs.jpg");
		ShopExecution modifyShop = shopService.modifyShop(shop, imgHolder);
		System.out.println("新的图片地址为"+modifyShop.getShop().getShopImg());
	}
	
	@Test
	public void testAddShop() throws Exception{
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		owner.setUserId(8L);
		area.setAreaId(3L);
		shopCategory.setShopCategoryId(11L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("test");
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		File shopImg=new File("E:/picture/market.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImgHolder imgHolder=new ImgHolder(is,shopImg.getName());
		ShopExecution addShop = shopService.addShop(shop, imgHolder);
		assertEquals(ShopStateEnum.CHECK.getState(),addShop.getState());
	}
}
