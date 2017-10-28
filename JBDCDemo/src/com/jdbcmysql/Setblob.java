package com.jdbcmysql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Setblob {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/testjdbc?user=root&password=19970617&useSSL=false";
		Connection con = null;
		PreparedStatement ps = null;
		File file = new File("d:/picture/i.jpg");
		File file1 = new File("d:/sjsj.jpg");
		InputStream is=null;
		OutputStream os=null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			// 使用setblob 把图片存入mysql中
	
			 /* ps=con.prepareStatement("insert into t_user (username,img) values (?,?)" );
			  ps.setObject(1, "沈");
			  ps.setBlob(2, new FileInputStream(file)); 
			  ps.execute();*/
			
			// 读取mysql中的图片
			ps = con.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 2012);
			rs = ps.executeQuery();
			 os=new FileOutputStream(file1);
			while (rs.next()) {
				//System.out.println(rs.getNString("img"));
			//os.write(rs.getInt("img"));
				Blob b=rs.getBlob("img");
				is=b.getBinaryStream();
				os= new FileOutputStream(file1);
				int i=0;
				while((i=is.read())!=-1){
					os.write(i);
				}
				
				
			}
			System.out.println("成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
