package com.msj.cascace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cascace")
public class CascaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String cmd=req.getParameter("cmd");
		if("province".equals(cmd)){
			getProvinces(req,resp);
		}else{
			getCitys(req,resp);
		}
		}
	
	
	protected void getProvinces(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		List<Province> allProvince = Province.getAllProvince();
		StringBuilder html=new StringBuilder();
		//<option value="1">四川</option>
		for (Province province : allProvince) {
			html.append("<option value='").append(province.getId()).append("'>").append(province.getName()).append("</option>");
		}
		out.println(html);
	}
	protected void getCitys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String provinceId = req.getParameter("provinceId");
		List<City> cityByProvinceId = City.getCityByProvinceId(Long.valueOf(provinceId));
		StringBuilder html=new StringBuilder();
		for (City city : cityByProvinceId) {
			html.append("<option value='").append(city.getId()).append("'>").append(city.getName()).append("</option>");
		}
		out.println(html);
	}

}
