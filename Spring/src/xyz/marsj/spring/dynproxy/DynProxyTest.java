package xyz.marsj.spring.dynproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DynProxyTest {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private TranscationManager manager;
	@Test
	public void testproxy(){
		IEmployeeService o = (IEmployeeService)Proxy.newProxyInstance(service.getClass().getClassLoader(), 
				new Class[]{IEmployeeService.class},new TranscationInvocationHandler(service, manager));
		o.save(new Employee());
	}
}
