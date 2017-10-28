package com.msj.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msj.student.dao.IStudentDAO;
import com.msj.student.dao.impl.StudentDAOImpl;
@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	dao.delete(Long.valueOf(id));
	resp.sendRedirect(req.getContextPath()+"/student/list");
}
}
