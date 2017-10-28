package com.msj_04_context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/context")
public class ServletContext extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String parameter = getInitParameter("encoding");	
	System.out.println(parameter);
		Object attribute = req.getServletContext().getInitParameter("encoding");
		System.out.println(attribute);
		
		
	}

}
