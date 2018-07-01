package xyz.marsj.o2o.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.entity.Area;

public class AreaMapperTest extends BaseTest2 {
	@Autowired
	private AreaMapper areaMapper;
	@Test
	public void testAreaQuery(){
		List<Area> queryArea = areaMapper.queryArea();
		assertEquals(4, queryArea.size());
	}
}
