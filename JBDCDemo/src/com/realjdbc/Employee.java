package com.realjdbc;

import java.sql.Date;

public class Employee {
	private Integer id;
	private String ename;
	private String salary;
	private Date birthday;
	private Integer depitd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getDepitd() {
		return depitd;
	}
	public void setDepitd(Integer depitd) {
		this.depitd = depitd;
	}
	public Employee() {
	}
	public Employee(String ename, String salary, Date birthday) {
		super();
		this.ename = ename;
		this.salary = salary;
		this.birthday = birthday;
	}
	
}
