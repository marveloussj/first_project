package xyz.marsj.hibernate;

import java.util.List;

import org.junit.Test;

public class StudentDaoTest {
private IStudentDAO dao;
public StudentDaoTest() {
	dao=new StudentDAOImpl();		
}

@Test
public void testSave(){
	Student stu=new Student();
	stu.setName("sj");
	stu.setAge(18);
	dao.save(stu);
}
@Test
public void testget(){
	Student student = dao.get(2L);
	System.out.println(student);
}
@Test
public void testDelete(){
	dao.delete(3L);
}
@Test
public void testUpdate(){
	Student stu = dao.get(2L);
	stu.setName("sjwd");
	dao.update(stu);
}
@Test
public void testQuery(){
	List<Student> query = dao.query();
	System.out.println(query);
}
}
