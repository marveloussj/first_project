package xyz.marsj.jpa;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
private IStudentDAO dao;
public StudentDaoTest() {
	dao=new StudentDAOImpl();		
}

@Before
public void testSave(){
	Student stu=new Student();
	stu.setName("sj");
	stu.setAge(18);
	dao.save(stu);
}
@Test
public void testget(){
	Student student = dao.get(1L);
	System.out.println(student);
}
@Test
public void testDelete(){
	dao.delete(1L);
}
@Test
public void testUpdate(){
	Student stu = dao.get(1L);
	stu.setName("sjwd");
	dao.update(stu);
}
@Test
public void testQuery(){
	List<Student> query = dao.query();
	System.out.println(query);
}
}
