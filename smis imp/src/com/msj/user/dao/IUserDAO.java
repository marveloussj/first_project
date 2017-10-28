package com.msj.user.dao;

import com.msj.user.domain.User;

public interface IUserDAO {

	 User checkLogin(String username,String password);
}
