package com.msj_01_smis_util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msj_01_smis_domain.Student;

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
	
	public static List<Student> query(String sql,Object...param){
		List<Student> list = new ArrayList<Student>();
		try (Connection con = JdbcUtil.getconnect();
				PreparedStatement ps = con.prepareStatement(sql);
				) {
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student(rs.getLong("id"), rs.getString("name"), rs.getString("age"));
				list.add(stu);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
