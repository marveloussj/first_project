package com.msj_02_param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/param/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	if("admin".equals(username)&&"1234".equals(password)){
		
		out.println("欢迎:"+username);
		out.println("<br/>");
		out.println("<a href='/param/list?username="+username+"'>收件箱(8)</a>");
	}
}
}
