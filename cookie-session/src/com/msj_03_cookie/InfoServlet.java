package com.msj_03_cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie/info")
public class InfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");

	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	Cookie[] cs=req.getCookies();
for (Cookie cookie : cs) {
	if("username".equals(cookie.getName())){
		username=cookie.getValue();
	}
}
		out.println("欢迎:"+username);
		out.println("<br/>");
		out.println("<h1>咋回事啊</h1>");
		
	
}
}
