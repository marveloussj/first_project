package com.msj.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msj.student.dao.IStudentDAO;
import com.msj.student.dao.impl.StudentDAOImpl;
import com.msj.student.domain.Student;
import com.msj.student.util.StringUtil;
@WebServlet("/student/edit")
public class StudenteditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(StringUtil.haslength(id)){	
			Student stu = dao.get(Long.valueOf(id));
			req.setAttribute("stu", stu);
		}
		req.getRequestDispatcher("/WEB-INF/views/Student/edit.jsp").forward(req, resp);
	}

}
