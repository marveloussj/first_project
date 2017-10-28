package com.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ²âÊÔPreparedStatement
 * @author sj
 *
 */
public class MysqlDemo2 {
public static void main(String[] args) {
	String url= "jdbc:mysql://localhost:3306/testjdbc?user=root&password=19970617&useSSL=false";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
	try {
		con=DriverManager.getConnection(url);
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println(con);
		String sql="select * from t_user where id>?";
		ps =con.prepareStatement(sql);
		ps.setObject(1, 3);
		rs= ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getObject(1)+"----"+rs.getObject(2)+"----"+rs.getObject(3)+"----"+rs.getObject(4));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//¼ÇµÃ¹Ø±Õ,resultset--->preparement--->connection
	finally{
		
			try {
				if(rs!=null){
				rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(ps!=null){
				ps.close();}
			} catch (SQLException e) {
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
