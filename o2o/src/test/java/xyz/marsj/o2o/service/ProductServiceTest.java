package xyz.marsj.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.dto.ImgHolder;
import xyz.marsj.o2o.dto.ProductExecution;
import xyz.marsj.o2o.entity.Product;
import xyz.marsj.o2o.entity.ProductCategory;
import xyz.marsj.o2o.entity.Shop;
import xyz.marsj.o2o.enums.ProductStateEnum;

public class ProductServiceTest extends BaseTest2 {
	@Autowired
	private IProductService productService;
	@Test
	public void testInsertProduct() throws FileNotFoundException{
		Shop shop=new Shop();
		shop.setShopId(15L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(54L);
		
		Product product=new Product();
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品");
		product.setCreateTime(new Date());
		product.setPriority(10);
		product.setProductDesc("test");
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		List<ImgHolder> thumbnailList=new ArrayList<ImgHolder>();
		//商品缩略图
		File file = new File("E:/picture/s.jpg");
		InputStream is=new FileInputStream(file);
		ImgHolder thumbnail=new ImgHolder(is, file.getName());
		//商品详情图
		File file1 = new File("E:/picture/readimagexs.jpg");
		InputStream is1=new FileInputStream(file1);
		ImgHolder thumbnail1=new ImgHolder(is1, file1.getName());
		
		File file2= new File("E:/picture/sjzm.jpg");
		InputStream is2=new FileInputStream(file2);
		ImgHolder thumbnail2=new ImgHolder(is2, file2.getName());
		
		thumbnailList.add(thumbnail1);
		thumbnailList.add(thumbnail2);
		
		ProductExecution productExecution = productService.addProduct(product, thumbnail, thumbnailList);
		assertEquals(ProductStateEnum.SUCCESS.getState(),productExecution.getState());
		
		
		
	}
	
	
	
	@Test
	public void testUpdateProduct() throws FileNotFoundException{
		Shop shop=new Shop();
		shop.setShopId(15L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(15L);
		
		Product product=new Product();
		product.setProductId(30L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("正式商品");
		product.setCreateTime(new Date());
		product.setPriority(50);
		product.setNormalPrice("10");
		product.setPromotionPrice("1");
		product.setProductDesc("official goods");
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		List<ImgHolder> thumbnailList=new ArrayList<ImgHolder>();
		//商品缩略图
		File file = new File("E:/picture/sjzm.jpg");
		InputStream is=new FileInputStream(file);
		ImgHolder thumbnail=new ImgHolder(is, file.getName());
		//商品详情图
		File file1 = new File("E:/picture/readimagexs.jpg");
		InputStream is1=new FileInputStream(file1);
		ImgHolder thumbnail1=new ImgHolder(is1, file1.getName());
		
		File file2= new File("E:/picture/s.jpg");
		InputStream is2=new FileInputStream(file2);
		ImgHolder thumbnail2=new ImgHolder(is2, file2.getName());
		
		thumbnailList.add(thumbnail1);
		thumbnailList.add(thumbnail2);
		
		ProductExecution productExecution = productService.modifyProduct(product, thumbnail, thumbnailList);
		assertEquals(ProductStateEnum.SUCCESS.getState(),productExecution.getState());
		
	}
	
	
	
	
	
}
