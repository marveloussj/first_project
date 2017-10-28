package com.msj_04_calservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		float result=0;
		String first = req.getParameter("first");
		String second = req.getParameter("second");
		String holder = req.getParameter("holder");
		if(StringUtil.has(first)&&StringUtil.has(second)){
			if("+".equals(holder)){
				result=Float.parseFloat(first)+Float.parseFloat(second);	
				}
			if("-".equals(holder)){
				result=Float.parseFloat(first)-Float.parseFloat(second);	
				}
			if("*".equals(holder)){
				result=Float.parseFloat(first)*Float.parseFloat(second);	
				}
			if("/".equals(holder)){
				result=Float.parseFloat(first)/Float.parseFloat(second);	
				}
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<form action='/day/calcu' method='post'>");
		out.println("<input name='first' type='number' value='"+(first==null?"":first)+"'>");
		out.println("<select name='holder' >");
		out.println("<option>+</option>");
		out.println("<option>-</option>");
		out.println("<option>*</option>");
		out.println("<option>/</option>");
		out.println("</select>");
		out.println("<input name='second' type='number' value='"+(second==null?"":second)+"'>");
		out.println("<input type='submit' value='='>");
		out.println("<input name='third' readonly value='"+result+"'>");
		out.println("</form>");
	}

}
