package com.msj.product.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msj.product.dao.IProductDAO;
import com.msj.product.domain.Product;
import com.msj.product.template.JdbcTemplate;
import com.msj.product.util.JdbcUtil;

//商品CRUD的实现类
public class ProductDAOImpl implements IProductDAO {

	public void save(Product pro) {
		String sql = "INSERT INTO product VALUES(NULL,?,?,?,?,?,?,?)";
		JdbcTemplate.update(sql, pro.getProductName(), pro.getDir_id(), pro.getSalePrice(), pro.getSupplier(),
				pro.getBrand(), pro.getCutoff(), pro.getCostPrice());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id=?";
		JdbcTemplate.update(sql, id);
	}

	public void update(Product pro) {
		String sql = "UPDATE product SET productName=?,dir_id=?,salePrice=?,supplier=?,brand=?,cutoff=?,costPrice=? WHERE id=?";
		JdbcTemplate.update(sql, pro.getProductName(), pro.getDir_id(), pro.getSalePrice(), pro.getSupplier(),
				pro.getBrand(), pro.getCutoff(), pro.getCostPrice(), pro.getId());
	}

	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//2.琏 获取连接对象
			conn = JdbcUtil.getConnection();
			//3.欲 创建语句对象
			ps = conn.prepareStatement(sql);
			//为sql中的占位符设置值 JDBC中的索引从1开始,有多少占位符就需要设置多少个值
			ps.setLong(1, id);
			//4.执 执行sql语句  
			rs = ps.executeQuery();//注意:此方法没有参数
			//处理结果集,将查询出来的每行数据封装到一个Product对象中
			if (rs.next()) {
				String productName = rs.getString("productName");
				Long dir_id = rs.getLong("dir_id");
				Double salePrice = rs.getDouble("salePrice");
				String supplier = rs.getString("supplier");
				String brand = rs.getString("brand");
				Double cutoff = rs.getDouble("cutoff");
				Double costPrice = rs.getDouble("costPrice");
				Product p = new Product(id, productName, dir_id, salePrice, supplier, brand, cutoff, costPrice);
				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.事 释放资源 注意:后开的先关
			JdbcUtil.close(conn, ps, rs);
		}
		return null;
	}

	public List<Product> list() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product";
		List<Product> list = new ArrayList<>();
		try {
			//2.琏 获取连接对象
			conn = JdbcUtil.getConnection();
			//3.欲 创建语句对象
			ps = conn.prepareStatement(sql);
			//4.执 执行sql语句  
			rs = ps.executeQuery();//注意:此方法没有参数
			//处理结果集,将查询出来的每行数据封装到一个Product对象中
			while (rs.next()) {
				Long id = rs.getLong("id");
				String productName = rs.getString("productName");
				Long dir_id = rs.getLong("dir_id");
				Double salePrice = rs.getDouble("salePrice");
				String supplier = rs.getString("supplier");
				String brand = rs.getString("brand");
				Double cutoff = rs.getDouble("cutoff");
				Double costPrice = rs.getDouble("costPrice");
				Product p = new Product(id, productName, dir_id, salePrice, supplier, brand, cutoff, costPrice);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.事 释放资源 注意:后开的先关
			JdbcUtil.close(conn, ps, rs);
		}
		return list;
	}

}
