package com.msj_03_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");
	//String password = req.getParameter("password");
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	//cookie解码
	String uname = URLEncoder.encode(username, "utf-8");
	Cookie c=new Cookie("username", uname);
	resp.addCookie(c);
	out.println("欢迎:"+username);
	out.println("<br/>");
	out.println("<a href='/cookie/list'>收件箱(8)</a>");
	
}
}
