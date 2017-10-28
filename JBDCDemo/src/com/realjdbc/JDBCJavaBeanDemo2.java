package com.realjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用javabean对象读取department数据
 * 
 * @author sj
 *
 */
public class JDBCJavaBeanDemo2 {
	public static void main(String[] args) {
		//test01();
		test02();

	}

	private static void test02() {
		Connection con =JDBCUtil.getmysqlcon();
		PreparedStatement ps =null;
		ResultSet rs=null;
		Department depart= null;
		List<Department> list =new ArrayList<Department>();
		try {
			ps=con.prepareStatement("select dname,address from department where id>?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				depart =new Department(rs.getString(1),rs.getString(2));
				list.add(depart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.Close(rs, ps, con);
		}
		//System.out.println(depart.getDname()+"----"+depart.getAddress());
		
		for (Department d : list) {
			System.out.println(d.getDname()+"----"+d.getAddress());
		}
	
		
	}

	private static void test01() {
		Connection con =JDBCUtil.getmysqlcon();
		PreparedStatement ps =null;
		ResultSet rs=null;
		Department depart= null;
		try {
			ps=con.prepareStatement("select dname,address from department where id=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				depart =new Department(rs.getString(1),rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.Close(rs, ps, con);
		}
		System.out.println(depart.getDname()+"----"+depart.getAddress());
		
		
	}
}
