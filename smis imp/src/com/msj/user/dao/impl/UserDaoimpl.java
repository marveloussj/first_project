package com.msj.user.dao.impl;

import com.msj.student.handler.impl.BeanHandler;
import com.msj.student.util.JdbcTemplate;
import com.msj.user.dao.IUserDAO;
import com.msj.user.domain.User;

public class UserDaoimpl implements IUserDAO {

	@Override
	public User checkLogin(String username, String password) {
		String sql="SELECT * FROM user WHERE username=? AND password=?" ;
		User user = JdbcTemplate.query(sql, new BeanHandler<>(User.class), username,password);
		return user;
	}

}
