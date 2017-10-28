package com.msj.student.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msj.student.dao.IStudentDAO;
import com.msj.student.domain.Student;
import com.msj.student.handler.IResultSetHandler;
import com.msj.student.handler.impl.BeanHandler;
import com.msj.student.handler.impl.BeanListHandler;
import com.msj.student.query.StudentQueryObject;
import com.msj.student.util.JdbcTemplate;
import com.msj.student.util.StringUtil;

@SuppressWarnings("all")
public class StudentDAOImpl implements IStudentDAO {

	public void save(Student stu) {
		String sql = "INSERT student(name,age) VALUES(?,?)";
		Object[] params = { stu.getName(), stu.getAge() };
		JdbcTemplate.update(sql, params);
	}

	public void delete(Long id) {
		String sql = "DELETE FROM student WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	public void update(Student stu) {
		String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
		Object[] params = { stu.getName(), stu.getAge(), stu.getId() };
		JdbcTemplate.update(sql, params);
	}

	public Student get(Long id) {
		String sql = "SELECT * FROM student WHERE id = ?";
		return JdbcTemplate.query(sql, new BeanHandler<>(Student.class), id);
	}

	public List<Student> list() {
		String sql = "SELECT * FROM student";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Student.class));
	}

	private class StudentHandler 
			implements IResultSetHandler<List<Student>> {
		public List<Student> handle(ResultSet rs) {
			try (
					ResultSet r = rs;
			) {
				List<Student> list = new ArrayList<>();
				while (r.next()) {

					Long id = r.getLong("id");
					String name = r.getString("name");
					Integer age = r.getInt("age");
					// 把查询的结果封装成对象
					Student stu = new Student(id, name, age);
					list.add(stu);
				}
				return list;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public List<Student> query(StudentQueryObject qo) {
		String query = qo.getQuery();
		String sql="select * from student ";
		sql=sql+query;
	return JdbcTemplate.query(sql.toString(), new BeanListHandler<>(Student.class), qo.getParams().toArray());
		
	}
}
