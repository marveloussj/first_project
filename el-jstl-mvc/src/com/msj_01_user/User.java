package com.msj_01_user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
private String name="fcc";
private Integer age=611;
private String[] fav={"a","b","c"};
private List<String> list =Arrays.asList(fav);
private Map<String,String> map=new HashMap<String,String>()
{
	{
	 this.put("sj", "wd");
	 this.put("www.sj", "hhh");

	}
};
@Override
public String toString() {
	return "User [name=" + name + ", age=" + age + ", fav=" + Arrays.toString(fav) + ", list=" + list + ", map=" + map
			+ "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String[] getFav() {
	return fav;
}
public void setFav(String[] fav) {
	this.fav = fav;
}
public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}
public Map<String, String> getMap() {
	return map;
}
public void setMap(Map<String, String> map) {
	this.map = map;
}



}
