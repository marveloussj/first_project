package xyz.marsj.spring.jdbc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JdbcTest {
	@Autowired
	private IEmployeeDao dao;
	@Test
	public void testsave(){
		Employee e =new Employee();
		e.setName("sjj");
		dao.save(e);
	}
	@Test
	public void testget(){
		Employee e = dao.get(1L);
		System.out.println(e);
	}
	@Test
	public void testlist(){
		List<Employee> list = dao.list();
		System.out.println(list);
	}
}
