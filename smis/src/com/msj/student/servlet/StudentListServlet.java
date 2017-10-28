package com.msj.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msj.student.dao.IStudentDAO;
import com.msj.student.dao.impl.StudentDAOImpl;
import com.msj.student.domain.Student;
@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = dao.list();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/Student/list.jsp").forward(req, resp);
		
	}

}
