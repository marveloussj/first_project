package xyz.marsj.o2o.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.dto.LocalAuthExecution;
import xyz.marsj.o2o.entity.LocalAuth;
import xyz.marsj.o2o.entity.PersonInfo;

public class LocalAuthServiceTest extends BaseTest2 {
	@Autowired
	private ILocalAuthService localAuthService;

	@Test
	public void testBindLocalAuth(){
	PersonInfo personInfo=new PersonInfo();
	LocalAuth localAuth=new LocalAuth();
	personInfo.setUserId(13L);
	localAuth.setPersonInfo(personInfo);
	localAuth.setUserName("sj");
	localAuth.setPassword("333");
	LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
	System.out.println(lae.getStateInfo());
	}
	
	@Test
	public void testModifyLocalAuth(){
	LocalAuthExecution lae = localAuthService.modifyLocalAuth(13L, "sj", "333", "666");	
	System.out.println(lae.getStateInfo());
	LocalAuth localAuth = localAuthService.getLocalByUserNameAndPSW("sj", "666");
	System.out.println(localAuth.getLocalAuthId());
	
	}
	}
