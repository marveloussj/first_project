package com.msj.product.dao;

import java.util.List;

import com.msj.product.domain.Product;

public interface IProductDAO {

	/**
	 * 保存商品
	 * @param pro 需要保存的商品对象
	 */
	void save(Product pro);

	/**
	 * 删除商品
	 * @param id 需要删除商品的编号
	 */
	void delete(Long id);

	/**
	 * 修改商品信息
	 * @param pro 需要修改的商品对象
	 */
	void update(Product pro);

	/**
	 * 根据指定的编号获取商品信息
	 * @param id 要获取的商品的编号
	 * @return 返回获取的商品对象,如果没有返回null
	 */
	Product get(Long id);

	/**
	 * 获取所有的商品信息
	 * @return 返回所有的商品信息集合,如果没有返回一个空集合
	 */
	List<Product> list();
}
