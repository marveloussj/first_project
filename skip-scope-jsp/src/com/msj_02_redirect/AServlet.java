package com.msj_02_redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect/a")
public class AServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter out = resp.getWriter();
	System.out.println("begain...a");
	resp.sendRedirect("/redirect/b");
	
	out.println("aaaaaaaaa");
	System.out.println("end...a");
}

}
