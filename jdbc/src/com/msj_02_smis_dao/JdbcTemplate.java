package com.msj_02_smis_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
	private JdbcTemplate(){}
	public static void updata(String sql,Object...param){
		try (Connection con = JdbcUtil.getconnect(); 
			PreparedStatement ps = con.prepareStatement(sql);) {
		for (int i = 0; i < param.length; i++) {
			ps.setObject(i+1, param[i]);
			
		}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static <T> T query(String sql,IStudentHandler<T> she,Object...param){
		
		try  {Connection con = JdbcUtil.getconnect();
				PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			ResultSet rs = ps.executeQuery();
			
		return 	she.handle(rs);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
}
/*while (rs.next()) {
				Student stu = new Student(rs.getLong("id"), rs.getString("name"), rs.getString("age"));
				list.add(stu);}*/