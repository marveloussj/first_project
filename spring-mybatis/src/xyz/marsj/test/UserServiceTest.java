package xyz.marsj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xyz.marsj.domain.User;
import xyz.marsj.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {
	@Autowired
	private UserServiceImpl userService;
	@Test
	public void testAdd(){
		User u=new User();
		u.setName("sj");
		u.setPassword("abc");
		userService.add(u);
	}
	
}
