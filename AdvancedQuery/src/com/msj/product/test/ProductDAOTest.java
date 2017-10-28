package com.msj.product.test;

import java.util.List;

import org.junit.Test;

import com.msj.product.dao.IProductDAO;
import com.msj.product.dao.impl.ProductDAOImpl;
import com.msj.product.domain.Product;

public class ProductDAOTest {

	//1.成员变量私有化
	//2.关联商品dao对象(面向接口编程,方便后期替换dao的实现类)
	private IProductDAO dao = new ProductDAOImpl();

	@Test
	public void testSave() {
		//封装需要保存的商品信息对象
		//注意:构造器中的每个参数的类型和顺序
		Product pro = new Product(null, "雷蛇鼠标", 1L, 100d, "雷蛇", "雷蛇", 0.8d, 50d);
		//调用dao中的保存方法,将商品信息保存到数据库中
		dao.save(pro);
	}

	@Test
	public void testDelete() {
		//调用dao中的删除方法将编号21的商品删除
		dao.delete(21L);
	}

	@Test
	public void testUpdate() {
		//封装需要修改的商品信息
		Product pro = new Product(20L, "雷蛇鼠标2", 1L, 100d, "雷蛇2", "雷蛇2", 0.8d, 50d);
		//调用dao中的修改方法将编号为20的商品对应的信息修改掉
		dao.update(pro);
	}

	@Test
	public void testGet() {
		//获取商品编号为4的商品
		Product pro = dao.get(4L);
		//通过打印获取到的商品信息,观察结果是否正确
		System.out.println(pro);
	}

	@Test
	public void testList() {
		//获取所有的商品信息
		List<Product> list = dao.list();
		//循环打印,观察结果
		for (Product product : list) {
			System.out.println(product);
		}
	}

}
