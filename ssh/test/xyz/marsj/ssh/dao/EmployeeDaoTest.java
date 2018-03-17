  package xyz.marsj.ssh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.service.IEmployeeService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeDaoTest {
	
	@Autowired
	private IEmployeeService service;
	
	@Test
	public void testSave(){
		Employee e=new Employee();
		e.setName("sj");
		e.setPassword("123");
		service.save(e);
	}
}
