package xyz.marsj.o2o.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.entity.LocalAuth;
import xyz.marsj.o2o.entity.PersonInfo;

public class LocalAuthMapperTest extends BaseTest2 {
	@Autowired
	private LocalAuthMapper localAuthMapper;
	@Test
	public void testInsertLocalAuth() throws Exception{
		LocalAuth localAuth=new LocalAuth();
		PersonInfo personInfo=new PersonInfo();
		personInfo.setUserId(12L);
		localAuth.setCreateTime(new Date());
		localAuth.setLastEditTime(new Date());
		localAuth.setPassword("123");
		localAuth.setUserName("marsj");
		localAuth.setPersonInfo(personInfo);
		int effectedNum = localAuthMapper.insertLocalAuth(localAuth);
		System.out.println(effectedNum);
		
	}
	@Test
	public void testQueryLocalByUserNameAndPSW(){
		LocalAuth localAuth = localAuthMapper.queryLocalByUserNameAndPSW("marsj", "123");
		Long id = localAuth.getLocalAuthId();
		System.out.println(id);
	
	}
	
	
	@Test
	public void testQueryLocalByUseId(){
		LocalAuth localAuth = localAuthMapper.queryLocalByUserId(12L);
		String password = localAuth.getPassword();
		System.out.println(password);
	
	}
	@Test
	public void testUpdateLocalAuth(){
		int effectedNum = localAuthMapper.updateLocalAuth(12, "marsj", "123", "456", new Date());
		System.out.println(effectedNum);
	
	}
	
	
	
	
}
