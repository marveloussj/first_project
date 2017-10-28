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
import com.msj.student.util.StringUtil;
@WebServlet("/student")
public class StudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	@Override
	public void init() throws ServletException {
		dao=new StudentDAOImpl();
	}
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	String cmd = req.getParameter("cmd");
	if("delete".equals(cmd)){
		delete(req, resp);
	}else if("edit".equals(cmd)){
		edit(req, resp);
	}else if("saveOrUpdate".equals(cmd)){
		saveOrUpdate(req, resp);
	}else{
		list(req, resp);
	}

}
protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	dao.delete(Long.valueOf(id));
	resp.sendRedirect(req.getContextPath()+"/student");
}
protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Student> list = dao.list();
	req.setAttribute("list", list);
	req.getRequestDispatcher("/WEB-INF/views/Student/list.jsp").forward(req, resp);
}
protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
	resp.sendRedirect(req.getContextPath()+"/student");
}
protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	if(StringUtil.haslength(id)){	
		Student stu = dao.get(Long.valueOf(id));
		req.setAttribute("stu", stu);
	}
	req.getRequestDispatcher("/WEB-INF/views/Student/edit.jsp").forward(req, resp);


}
}
