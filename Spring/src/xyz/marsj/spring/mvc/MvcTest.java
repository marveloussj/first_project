package xyz.marsj.spring.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MvcTest {
	@Autowired
	private ApplicationContext cxt;
	@Test
	public void test(){
		EmployeeAction action = cxt.getBean("employeeAction",EmployeeAction.class);
		action.save();
	}

}
