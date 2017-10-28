package com.realjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 使用hashmap封装读取数据
 * 使用List<hashmap>封装
 * @author sj
 *
 */


public class JDBCMapDemo1 {
	public static void main(String[] args) {
		//text1();
		text2();
	}
	
	
	

	private static void text2() {

		Connection con=JDBCUtil.getmysqlcon();
		PreparedStatement ps= null;
		ResultSet rs=null;
		Map<Object, Object> map=null;
		List<Map<Object,Object>> list =new ArrayList<Map<Object,Object>>();
		try {
			ps=con.prepareStatement("select * from t_user where id>?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				map=new HashMap<Object, Object>();
				//System.out.println(rs.getObject("username"));
				map.put("username", rs.getObject("username"));
				map.put("pwd",rs.getObject("pwd"));
				map.put("regtime", rs.getObject("regtime"));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.Close(rs, ps, con);
		}
		for (Map<Object, Object> map1 : list) {
			for (Map.Entry<Object, Object> entry : map1.entrySet()) {  
			    System.out.print(entry.getKey()+"----"+entry.getValue());  
			}
			System.out.println();
		}
		
	
		
	}




	private static void text1() {
		Connection con=JDBCUtil.getmysqlcon();
		PreparedStatement ps= null;
		ResultSet rs=null;
		Map<Object, Object> map=new HashMap<Object, Object>();
		try {
			ps=con.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				//System.out.println(rs.getObject("username"));
				map.put("username", rs.getObject("username"));
				map.put("pwd",rs.getObject("pwd"));
				map.put("regtime", rs.getObject("regtime"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.Close(rs, ps, con);
		}
		
		for (Object str : map.keySet()) {
			System.out.print(map.get(str)+"\t");
			
		}
	}
	

}
