package xyz.marsj.hibernate.query;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
	private Long id;
	private String name;
	private BigDecimal salay;
	private Date hireDate;//date
	private Department dept;//FK:DEPT_ID
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalay() {
		return salay;
	}
	public void setSalay(BigDecimal salay) {
		this.salay = salay;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
}
