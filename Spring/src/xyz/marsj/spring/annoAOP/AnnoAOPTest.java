package xyz.marsj.spring.annoAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AnnoAOPTest {

	@Autowired
	private IEmployeeDao edao;
	@Autowired
	private IDepartmentDao ddao;
	@Test
	public void test(){
		
		ddao.query(new Department());
	}
}
