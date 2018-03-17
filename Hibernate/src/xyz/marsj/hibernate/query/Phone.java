package xyz.marsj.hibernate.query;

public class Phone {
	private Long id;
	private PhoneType types;
	private String number;
	private Employee employee;//FK:EMPLOYEE_ID
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PhoneType getTypes() {
		return types;
	}
	public void setTypes(PhoneType types) {
		this.types = types;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
