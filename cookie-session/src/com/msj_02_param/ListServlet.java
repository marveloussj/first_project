package com.msj_02_param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/param/list")
public class ListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");

	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();

		out.println("欢迎:"+username);
		out.println("<br/>");
		out.println("<a href='/param/info?username="+username+"'>邮件一</a><br/>");
		out.println("<a href='/param/info?username="+username+"'>邮件二</a>");
	
}
}
