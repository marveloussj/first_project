package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static Properties pro=null;
	static {
		try {
			pro=new Properties();
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  public static Connection getmysqlcon(){
	  try {
		Class.forName(pro.getProperty("mysqldriver"));
		return DriverManager.getConnection(pro.getProperty("mysqlurl"),pro.getProperty("mysqluser"),pro.getProperty("mysqlpwd"));
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	  
  }
  public static void Close(ResultSet rs,Statement ps,Connection con){
	  
		  try {
			 if(rs!=null){
			rs.close();}
		} catch (SQLException e) {
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
				e.printStackTrace();
			}
	
	  
  }

public static void Close(Statement ps,Connection con){

	
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
			e.printStackTrace();
		}


}

public static void Close(Connection con){
	  try {
			 if(con!=null){
			con.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
