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
import xyz.marsj.o2o.entity.WechatAuth;

public class WechatAuthMapperTest extends BaseTest2{
	@Autowired
	private WechatAuthMapper wechatAuthMapper;
	@Test
	public void insertWechatAuthTest(){
		PersonInfo personInfo=new PersonInfo();
		personInfo.setUserId(12L);
		personInfo.setEnableStatus(1);
		WechatAuth wechatAuth=new WechatAuth();
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId("zzz");
		wechatAuth.setCreateTime(new Date());
		int effectNum = wechatAuthMapper.insertWechatAuth(wechatAuth);
		assertEquals(1, effectNum);
	}
	
	
	@Test
	public void queryWechatAuthByIdTest(){
		WechatAuth wechatAuth = wechatAuthMapper.queryWechatAuthById("zzz");
		System.out.println(wechatAuth.getWechatAuthId());
	}
	
}
