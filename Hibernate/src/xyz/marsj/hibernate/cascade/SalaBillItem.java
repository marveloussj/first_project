package xyz.marsj.hibernate.cascade;

public class SalaBillItem {
private Long id;
private String product;
private SalaBill bill;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public SalaBill getBill() {
	return bill;
}
public void setBill(SalaBill bill) {
	this.bill = bill;
}
@Override
public String toString() {
	return "SalaBillItem [id=" + id + ", product=" + product + "]";
}

}
