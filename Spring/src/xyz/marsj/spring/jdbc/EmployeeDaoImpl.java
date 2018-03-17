package xyz.marsj.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class EmployeeDaoImpl extends JdbcDaoSupport implements IEmployeeDao {

	@Override
	public void save(Employee e) {
		this.getJdbcTemplate().update("INSERT INTO employee(name) VALUES(?)",e.getName());

	}

	@Override
	public Employee get(Long id) {
		Employee e=this.getJdbcTemplate().query("SELECT * FROM employee WHERE id=?",new ResultSetExtractor<Employee>(){

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					Employee e=new Employee();
					e.setName(rs.getString("name"));
					e.setId(rs.getLong("id"));
					return e;
				}
				return null;
			}
			
		},id);
			return e;
	}

	@Override
	public List<Employee> list() {
		List<Employee> es=this.getJdbcTemplate().query("SELECT * FROM employee",new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e=new Employee();
				e.setName(rs.getString("name"));
				e.setId(rs.getLong("id"));
				return e;
			}
			
		});
		return es;
	}

}
