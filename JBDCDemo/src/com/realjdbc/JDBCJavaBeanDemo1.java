package com.realjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 用javabean对象读取employee数据
 * @author sj
 *
 */
public class JDBCJavaBeanDemo1 {
	
	
	
	
	public static void main(String[] args) {
		//test01();
		test02();
	}

	private static void test02() {
		Connection con = JDBCUtil.getmysqlcon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp =null;
		List<Employee> list =new ArrayList<Employee>();
		try {
			
			ps =con.prepareStatement("select ename,salary,birthday from employee where id>?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				//System.out.println(rs.getObject("ename"));
				emp= new Employee(rs.getString(1),rs.getString(2),rs.getDate(3));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.Close(rs, ps, con);
		}
		for (Employee e : list) {
			System.out.println(e.getEname()+"---"+e.getSalary()+"---"+e.getBirthday());
		}
		
	}

	private static void test01() {
		Connection con = JDBCUtil.getmysqlcon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp =null;
		try {
			
			ps =con.prepareStatement("select ename,salary,birthday from employee where id=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				//System.out.println(rs.getObject("ename"));
				emp= new Employee(rs.getString(1),rs.getString(2),rs.getDate(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.Close(rs, ps, con);
		}
		System.out.println(emp.getEname()+"---"+emp.getSalary()+"---"+emp.getBirthday());
	}

}
