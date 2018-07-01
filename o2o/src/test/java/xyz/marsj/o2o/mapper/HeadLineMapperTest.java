package xyz.marsj.o2o.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.marsj.o2o.BaseTest2;
import xyz.marsj.o2o.entity.HeadLine;

public class HeadLineMapperTest extends BaseTest2 {
	@Autowired
	private HeadLineMapper headLineMapper;
	@Test
	public void testQueryHeadLineList(){
		List<HeadLine> list=headLineMapper.queryHeadLineList(new HeadLine());
		assertEquals(4, list.size());
	}
}
