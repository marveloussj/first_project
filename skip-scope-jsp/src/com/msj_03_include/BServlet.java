package com.msj_03_include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/include/b")
public class BServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("begain...b");
	PrintWriter out = resp.getWriter();
	out.println("bbbbbbbbb");
	System.out.println("end...b");
}

}
