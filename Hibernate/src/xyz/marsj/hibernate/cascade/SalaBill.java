package xyz.marsj.hibernate.cascade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SalaBill {

	private Long id;
	private String sn;
	private Date inputTime;
	private Set<SalaBillItem> sbi=new HashSet<SalaBillItem>();
	@Override
	public String toString() {
		return "SalaBill [id=" + id + ", sn=" + sn + ", inputTime=" + inputTime + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public Set<SalaBillItem> getSbi() {
		return sbi;
	}
	public void setSbi(Set<SalaBillItem> sbi) {
		this.sbi = sbi;
	}
}
