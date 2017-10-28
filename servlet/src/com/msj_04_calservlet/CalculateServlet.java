package com.msj_04_calservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		int result = 0;
		String first = req.getParameter("first");
		String second = req.getParameter("second");
		String holder = req.getParameter("holder");
		if (StringUtil.has(first) && StringUtil.has(second)) {

			if ("+".equals(holder)) {
				result = Integer.valueOf(first) + Integer.valueOf(second);
			} else if ("-".equals(holder)) {
				result = Integer.valueOf(first) - Integer.valueOf(second);
			} else if ("*".equals(holder)) {
				result = Integer.valueOf(first) * Integer.valueOf(second);
			} else if ("/".equals(holder)) {
				result = Integer.valueOf(first) / Integer.valueOf(second);
			}

		}

		PrintWriter out = resp.getWriter();
		out.println("<form action='/day/cal' method='post'>");
		out.println("<input name='first' type='number' value='" + (first == null ? "" : first) + "'>");
		out.println("<select name='holder'>");
		out.println("<option>+</option>");
		out.println("<option>-</option>");
		out.println("<option>*</option>");
		out.println("<option>/</option>");
		out.println("</select>");
		out.println("<input name='second' type='number' value='" + (second == null ? "" : second) + "'>");
		out.println("<input name='='  type='submit' value='='>");
		out.println("<input name='result' value='" + result + "'>");

		out.println("</form>");

	}

}
