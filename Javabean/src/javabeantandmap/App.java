package javabeantandmap;

import java.util.Map;

public class App {
	public static void main(String[] args) throws Exception {
		Person p =new Person(1, "sj", "Φξτί", "java");
		Map<String, Object> map = BeanUtil.bean2map(p);
		System.out.println(map);
		
		Person person = BeanUtil.map2bean(map, Person.class);
		System.out.println(person);
	}

}
