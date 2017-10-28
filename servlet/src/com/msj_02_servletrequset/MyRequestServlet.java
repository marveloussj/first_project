package com.msj_02_servletrequset;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRequestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println(req.getContextPath());
	System.out.println(req.getHeader("User-Agent"));
	System.out.println(req.getMethod());
	System.out.println(req.getRequestURL());
	System.out.println("----------------------------");
	System.out.println(req.getParameter("username"));
	System.out.println(req.getParameter("password"));
}

}
