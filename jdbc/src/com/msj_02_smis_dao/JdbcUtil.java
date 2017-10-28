package com.msj_02_smis_dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil {
	
	

	private static String url;
	private static String username;
	private static String password;
	static{
		try {
			Properties p= new Properties();
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			p.load(in);
			in.close();
			Class.forName(p.getProperty("driverClassName"));
			url=p.getProperty("url");
			username=p.getProperty("username");
			password=p.getProperty("password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getconnect(){
		try {
			
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
