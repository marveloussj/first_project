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
@WebServlet("/student/save")
public class StudentSaveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	String name = req.getParameter("name");
	String age = req.getParameter("age");
	String id = req.getParameter("id");
	Student stu=new Student(null,name,Integer.valueOf(age));
	if(StringUtil.haslength(id)){
		stu.setId(Long.valueOf(id));
		dao.update(stu);
	}else{
		
		dao.save(stu);
		
	}
	resp.sendRedirect(req.getContextPath()+"/student/list");
}
}
