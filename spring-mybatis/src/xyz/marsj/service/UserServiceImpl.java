package xyz.marsj.service;

import xyz.marsj.domain.User;
import xyz.marsj.mapper.UserMapper;

public class UserServiceImpl implements IUserService {
private UserMapper userMapper;

public void setUserMapper(UserMapper userMapper) {
	this.userMapper = userMapper;
}

@Override
public void add(User u) {
	
	userMapper.add(u);
	
}


}
