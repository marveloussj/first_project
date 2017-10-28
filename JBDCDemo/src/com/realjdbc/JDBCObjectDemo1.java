package com.realjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 使用Object[]来封装一下代码
 * 使用List<Object[]>来封装一下代码
 * @author sj
 *
 */
public class JDBCObjectDemo1 {
public static void main(String[] args) {
	Connection con=JDBCUtil.getmysqlcon();
	PreparedStatement ps= null;
	ResultSet rs=null;
	Object [] obj=new Object[3];
	List<Object[]> list=new ArrayList<Object[]>();
	try {
		ps=con.prepareStatement("select * from t_user where id >?");
		ps.setObject(1, 1);
		rs=ps.executeQuery();
		while(rs.next()){
			Object [] objs=new Object[3];
			//System.out.println(rs.getObject(2));
			objs [0]= rs.getObject("username");
			objs [1]= rs.getObject("pwd");
			objs [2]= rs.getObject("regtime");
			list.add(objs);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtil.Close(rs, ps, con);
	}
/*	for (int i = 0; i < obj.length; i++) {
		System.out.println(obj[i]);
	}*/
	for (Object[] objs : list) {
		System.out.println(objs[0]+"----"+objs[1]+"----"+objs[2]);
	}
}
}
