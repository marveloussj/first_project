package com.jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * jdbc≈˙¥¶¿Ìbatch
 * @author sj
 *
 */
public class MySqlbatchDemo1 {
	public static void main(String[] args) {
		Statement st=null;
		Connection con= null;
		String url="jdbc:mysql://localhost:3306/testjdbc?user=root&password=19970617&useSSL=false";
		try {
			 con=DriverManager.getConnection(url);
			Class.forName("com.mysql.jdbc.Driver");
			st=con.createStatement();
			con.setAutoCommit(false);
			
			for (int i = 0; i <2000 ; i++) {
				st.addBatch("insert into t_user (id,username,pwd,regtime) values ("+i+"+4,'shen"+i+"',666,now())");
			}
			st.executeBatch();			
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(st!=null){
					st.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(con!=null){
					st.close();}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
	}

}
