package xyz.marsj.o2o.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;
import xyz.marsj.o2o.BaseTest;
import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.entity.Area;
import xyz.marsj.o2o.entity.ShopCategory;

public class shopCategoryMapperTest extends BaseTest2 {
	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	@Test
	public void testQueryShopCategory(){
//		ShopCategory testCategory=new ShopCategory();
//		//ShopCategory parentCategory=new ShopCategory();
//		testCategory.setParentId(10L);
//	
//		List<ShopCategory> list = shopCategoryMapper.queryShopCategory(testCategory);
//		assertEquals(2, list.size());
		List<ShopCategory> list = shopCategoryMapper.queryShopCategory(null);
		assertEquals(6, list.size());
		
	} 
}
