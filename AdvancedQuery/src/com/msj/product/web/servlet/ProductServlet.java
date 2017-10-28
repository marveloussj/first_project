package com.msj.product.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msj.product.dao.IProductDAO;
import com.msj.product.dao.impl.ProductDAOImpl;
import com.msj.product.domain.Product;
import com.msj.product.util.StringUtils;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//关联DAO对象
	private IProductDAO dao;

	public void init() throws ServletException {
		dao = new ProductDAOImpl();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置处理请求参数的编码方式
		req.setCharacterEncoding("UTF-8");
		//获取请求的类型,并根据不同的类型调用不同的方法
		String cmd = req.getParameter("cmd");
		if ("edit".equals(cmd)) {
			edit(req, resp);
		} else if ("saveOrUpdate".equals(cmd)) {
			saveOrUpdate(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else {
			list(req, resp);
		}
	}

	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取所有的商品信息
		List<Product> list = dao.list();
		//将获取到的商品信息存放在请求作用域中
		req.setAttribute("list", list);
		//请求转发到list页面
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前台传递过来的需要删除的商品id
		String id = req.getParameter("id");
		//根据id删除对应的商品
		dao.delete(Long.valueOf(id));
		//URL重定向到/product,执行list方法,最后回到list.jsp页面
		resp.sendRedirect("/product");
	}

	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求参数,将其封装到一个Product对象中
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		Product p = new Product(null, productName, Long.valueOf(dir_id), Double.valueOf(salePrice), supplier, brand,
				Double.valueOf(cutoff), Double.valueOf(costPrice));
		//id如果有值证明用户此时执行的是修改操作,反之则是保存
		if (StringUtils.hasLength(id)) {
			p.setId(Long.valueOf(id));
			dao.update(p);
		} else {
			dao.save(p);
		}
		resp.sendRedirect("/product");
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		//根据id是否有值判断是添加跳转还是修改跳转
		if (StringUtils.hasLength(id)) {
			Product product = dao.get(Long.valueOf(id));
			req.setAttribute("pro", product);
		}
		//请求转发到edit.jsp
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
	}

}
