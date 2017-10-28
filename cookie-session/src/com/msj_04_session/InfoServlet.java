package com.msj_04_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/session/info")
public class InfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");

	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	//获取session
	HttpSession session = req.getSession();
	username = (String)session.getAttribute("username");
		out.println("欢迎:"+username);
		out.println("<br/>");
		out.println("<h1>咋回事啊</h1>");
		
	
}
}
