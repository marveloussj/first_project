package jdbc;

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
			ps=con.prepareStatement("insert into students (id,name) values(?,?,?)");
			ps.setObject(1, 2);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject("id")+"----"+rs.getObject("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JDBCUtil.Close(rs,ps,con);
	}

}