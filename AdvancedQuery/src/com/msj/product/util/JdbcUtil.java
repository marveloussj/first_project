package com.msj.product.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static Properties p = new Properties();
	static {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
		try {
			//将资源文件中的数据加载到内存中
			p.load(in);
			//加载注册驱动
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取连接对象
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
	}

	// 释放资源 注意:后开的先关
	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
