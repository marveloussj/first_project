package com.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDemo1 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/testjdbc?user=root&password=19970617&useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
			System.out.println(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
