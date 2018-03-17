package four;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Map {

	public static void main(String[] args) {
		HashMap map1=new LinkedHashMap();
		map1.put("中国","china");
		map1.put("美国","amrican");
		map1.put("日本","Japan");
		
		
		
		Set<String>set=map1.keySet();
		for(String k:set)
		{
			String value=(String) map1.get(k);
			System.err.println("<"+k+","+value+">");
		}
		
		
		map1.remove("美国");

		Iterator<String> it=map1.keySet().iterator();
		while(it.hasNext())
		{
			String k=it.next();
			String value=(String) map1.get(k);
			System.err.println("<"+k+","+value+">");
		}
		
	
	}

}
