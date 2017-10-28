package com.msj_01_hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class EncondFilter implements Filter{
 private String encoding ;
 @Override
	public void init(FilterConfig filterconfig) throws ServletException {
	 encoding = filterconfig.getInitParameter("encoding");
		
	}
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest)request;
		HttpServletResponse resp= (HttpServletResponse)response;
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
		
	}

	

}
