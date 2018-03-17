package xyz.marsj.spring.jdbc;

import java.util.List;

public interface IEmployeeDao {
 void save(Employee e);
 Employee get(Long id);
 List<Employee> list();
}
