package xyz.marsj.spring.container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ContainerTest {
	@Autowired
	private ApplicationContext ctx;
	@Test
	public void testctx1(){
		SomeBean bean = ctx.getBean("somebean",SomeBean.class);
		bean.printf();
	}
	
	
@Test
public void testctx(){
	ApplicationContext ctx=new ClassPathXmlApplicationContext("xyz/marsj/container/ContainerTest-contest.xml");
	SomeBean bean = ctx.getBean("somebean",SomeBean.class);
	bean.printf();
}
}
