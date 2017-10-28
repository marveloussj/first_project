package com.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentDemo {
	
	public static void main(String[] args) {
		Set<String> set1=new HashSet<>();
		set1.add("´ó¸ç");
		set1.add("Éò");
		set1.add("Éò´ó¸ç");
		Set<String> set2=new HashSet<>();
		set2.add("sj");
		set2.add("s");
		set2.add("sdg");
		Map<String,Set<String>> map=new HashMap<>();
		map.put("1°à", set1);
		map.put("2°à", set2);
		System.out.println(map);
		
		
		
		
		
		
	}
	

}
