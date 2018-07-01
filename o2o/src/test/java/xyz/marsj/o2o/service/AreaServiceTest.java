package xyz.marsj.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.entity.Area;

public class AreaServiceTest extends BaseTest2 {
	@Autowired
	private IAreaService areaService;
	@Autowired 
	private ICacheService cacheSerivce;
	@Test
	public void testGetAreaList(){
		List<Area> areaList = areaService.getAreaList();
		assertEquals("东苑", areaList.get(0).getAreaName());
		cacheSerivce.removeFromCache(areaService.AREALISTKEY);
		areaList=areaService.getAreaList();
	}
}
