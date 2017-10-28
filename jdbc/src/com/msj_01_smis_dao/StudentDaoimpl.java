package com.msj_01_smis_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msj_01_smis_domain.Student;
import com.msj_01_smis_util.JdbcTemplate;
import com.msj_01_smis_util.JdbcUtil;

public class StudentDaoimpl implements IStudentDao {

	@Override
	public void save(Student stu) {	
		String sql = "INSERT  Student(name,age) value(?,?)";
		Object param[]={stu.getName(),stu.getAge()};
		JdbcTemplate.updata(sql, param);
	

	}

	@Override
	public void delete(Long id) {
		String sql = "delete from Student where id=?";
		JdbcTemplate.updata(sql, id);
	}

	@Override
	public void updata(Student stu) {
		String sql = "update  Student set name=?,age=? where id=?";
		Object param[]={stu.getName(),stu.getAge(),stu.getId()};
		JdbcTemplate.updata(sql, param);
	
		
	}

	@Override
	public Student get(Long id) {
		String sql = "select *from Student where id=?";
	 List<Student> list = JdbcTemplate.query(sql, id);
	 if(list.size()==1){
		 return list.get(0);
	 }else{
		 
		 return null;
	 }
	}

	@Override
	public List<Student> list() {
		String sql = "select *from Student";
		return JdbcTemplate.query(sql);
	}
}
