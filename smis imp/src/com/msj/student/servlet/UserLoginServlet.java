package com.msj.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msj.student.util.StringUtil;
import com.msj.user.dao.IUserDAO;
import com.msj.user.dao.impl.UserDaoimpl;
import com.msj.user.domain.User;
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new UserDaoimpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String safecode = req.getParameter("safecode");
		String code = (String) req.getSession().getAttribute("code");
		if(StringUtil.haslength(safecode)&&StringUtil.haslength(code)){
			if(!safecode.equals(code)){
				req.setAttribute("errormsg", "亲,验证码有误哦");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
				
			}
		}else{
			req.setAttribute("errormsg", "亲,验证码过时了哦");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
			}
			
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User u = dao.checkLogin(username, password);
		if(u==null){
			req.setAttribute("errormsg", "亲,用户名或密码错误");
			req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req, resp);
			return;
		}else{
			req.getSession().setAttribute("USER_IN_SESSION", u);
			resp.sendRedirect("/student");
		}
	}
}
