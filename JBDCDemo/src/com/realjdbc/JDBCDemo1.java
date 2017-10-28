package com.realjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo1 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=JDBCUtil.getmysqlcon();
		try {
			ps=con.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 3);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject("username")+"----"+rs.getObject("regtime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JDBCUtil.Close(rs,ps,con);
	}

}
