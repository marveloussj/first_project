package com.msj.user.text;

import org.junit.Test;

import com.msj.user.dao.IUserDAO;
import com.msj.user.dao.impl.UserDaoimpl;
import com.msj.user.domain.User;

public class UserDAOTest {
 private IUserDAO dao=new UserDaoimpl();
	@Test
	public void testCheckLogin() {
		User user = dao.checkLogin("admin", "123");
		System.out.println(user);
	}

}
