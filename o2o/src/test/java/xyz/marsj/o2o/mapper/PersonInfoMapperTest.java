package xyz.marsj.o2o.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.entity.PersonInfo;
import xyz.marsj.o2o.entity.Product;
import xyz.marsj.o2o.entity.ProductCategory;
import xyz.marsj.o2o.entity.Shop;

public class PersonInfoMapperTest extends BaseTest2{
	@Autowired
	private PersonInfoMapper personInfoMapper;
	@Test
	public void insertPersonInfoTest(){
		PersonInfo personInfo=new PersonInfo();
		personInfo.setName("沈杰");
		personInfo.setBirthday(new Date());
		personInfo.setGender("1");
		personInfo.setCreateTime(new Date());
		personInfo.setLastEditTime(new Date());
		personInfo.setEmail("446454384@163.com");
		personInfo.setPhone("177");
		personInfo.setEnableStatus(1);
		int effectNum = personInfoMapper.insertPersonInfo(personInfo);
		assertEquals(1, effectNum);
	}
	
	
	@Test
	public void queryPersonInfoByIdTest(){
		PersonInfo personInfo = personInfoMapper.queryPersonInfoById(12L);
		assertEquals("沈杰", personInfo.getName());
	}
	
}
