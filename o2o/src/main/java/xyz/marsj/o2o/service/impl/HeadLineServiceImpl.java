package xyz.marsj.o2o.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.marsj.o2o.cache.JedisUtil;
import xyz.marsj.o2o.entity.HeadLine;
import xyz.marsj.o2o.exceptions.AreaOperationException;
import xyz.marsj.o2o.mapper.HeadLineMapper;
import xyz.marsj.o2o.service.IHeadLineService;
@Service
public class HeadLineServiceImpl implements IHeadLineService {
	@Autowired
	private HeadLineMapper headLineMapper;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	@Autowired
	private JedisUtil.Strings jedisStrings;

	@Override
	@Transactional
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
		String key=HLLISTKEY;
		List<HeadLine> headLineList =null;
		ObjectMapper mapper=new ObjectMapper();
		if(headLineCondition!=null&&headLineCondition.getEnableStatus()!=null){
			key=key+"_"+headLineCondition.getEnableStatus();
		}
		//redis不存在arealist信息
		if(!jedisKeys.exists(key)){
			headLineList = headLineMapper.queryHeadLineList(headLineCondition);
			String jsonString = null;
			try {
				jsonString = mapper.writeValueAsString(headLineList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new AreaOperationException(e.getMessage());
			}
			jedisStrings.set(key,jsonString);
		}else{
			//redis存在arealistx信息
			//直接取
			String jsonString = jedisStrings.get(key);
			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, HeadLine.class);
			try {
				headLineList = mapper.readValue(jsonString, javaType);
			} catch (Exception e) {
				e.printStackTrace();
				throw new AreaOperationException(e.getMessage());
			}
			
		}
		return headLineList;
	}



}
