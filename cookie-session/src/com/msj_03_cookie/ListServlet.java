package com.msj_03_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie/list")
public class ListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");

	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	Cookie[] c = req.getCookies();
	for (Cookie cookie : c) {
		
		if("username".equals(cookie.getName())){
			 username=cookie.getValue();
		}
		
	}
		out.println("欢迎:"+URLDecoder.decode(username,"utf-8"));
		out.println("<br/>");
		out.println("<a href='/cookie/info'>邮件一</a><br/>");
		out.println("<a href='/cookie/info'>邮件二</a>");
	
}
}
