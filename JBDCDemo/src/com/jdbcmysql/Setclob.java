package com.jdbcmysql;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试setclob
 * @author sj
 *
 */
public class Setclob {
public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/testjdbc?user=root&password=19970617&useSSL=false";
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	byte[] read="强无敌".getBytes();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url);
		//通过jdbc setclob输入文档信息
	/*	ps=con.prepareStatement("insert into t_user (username,info) values (?,?)");
		ps.setObject(1, "sj");
		//ps.setClob(2, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(read))));
		ps.setClob(2, new FileReader(new File("C:/Users/Administrator/Desktop/新建文本文档.xml")));
		ps.executeUpdate();*/
		//通过jdbc 读取文档信息
		ps=con.prepareStatement("select * from t_user where id=?");
		ps.setObject(1, 2010);
		rs=ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getObject("info"));
		}
		
		System.out.println("成功");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
			try {
				if(ps!=null){
				ps.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(con!=null){
				con.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
}
