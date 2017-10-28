package com.msj_04_session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");
	//String password = req.getParameter("password");
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	//设置session
	HttpSession session = req.getSession();
	session.setAttribute("username", username);
	//url重写
	
	out.println("欢迎:"+username);
	out.println("<br/>");
	out.println("<a href='"+resp.encodeURL("/session/list")+"'>收件箱(8)</a>");
	
}
}
