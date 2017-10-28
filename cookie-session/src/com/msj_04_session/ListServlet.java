package com.msj_04_session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/session/list")
public class ListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");

	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	Cookie[] c = req.getCookies();
	
		out.println("欢迎:"+username);
		out.println("<br/>");
		out.println("<a href='/session/info'>邮件一</a><br/>");
		out.println("<a href='/session/info'>邮件二</a>");
	
}
}
