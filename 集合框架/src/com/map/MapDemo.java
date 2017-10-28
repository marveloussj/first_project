package com.map;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
	public static void main(String[] args) {
		String str="sfjdskfsfgdlafdlgs";
		char[] ch=str.toCharArray();
		Map<Character,Integer> map=new TreeMap<>();
		for (char c : ch) {
			if(map.containsKey(c)){
				Integer old= map.get(c);
				map.put(c,old+1);
				
			}else{
				map.put(c, 1);
			}
			}System.out.println(map);
	}
	
	
	
	

}
