package com.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc事务的操作
 * @author sj
 *
 */
public class ShiwuDemo {
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/testjdbc?user=root&password=19970617&useSSL=false";
	Connection con=null;
	PreparedStatement pst1=null;
	PreparedStatement pst2=null;
	try {
		con= DriverManager.getConnection(url);
		Class.forName("com.mysql.jdbc.Driver");
		con.setAutoCommit(false);
		pst1=con.prepareStatement("insert into t_user (username,pwd) values (?,?)");
		pst1.setObject(1, "sj");
		pst1.setObject(2, 666);
		pst1.execute();
		System.out.println("sj成功");
		
		Thread.sleep(5000);
		
		pst2=con.prepareStatement("insert into t_user (username,pwd) values (?,?)");
		pst2.setObject(1, "沈杰");
		pst2.setObject(2, 6666);
		pst2.execute();
		System.out.println("沈杰成功");
		con.commit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {

			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}finally{
		if(pst1!=null&&pst2!=null){
			try {
				pst1.close();
				pst2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
}
