package com.msj.product.domain;

//商品对象
public class Product {

	private Long id;// 商品编号
	private String productName;// 商品名称
	private Long dir_id;// 商品分类编号
	private Double salePrice;// 商品零售价格
	private String supplier;// 商品供应商
	private String brand;// 商品品牌
	private Double cutoff;// 商品折扣
	private Double costPrice;// 商品成本价

	public Product() {
	}

	public Product(Long id, String productName, Long dir_id, Double salePrice, String supplier, String brand,
			Double cutoff, Double costPrice) {
		this.id = id;
		this.productName = productName;
		this.dir_id = dir_id;
		this.salePrice = salePrice;
		this.supplier = supplier;
		this.brand = brand;
		this.cutoff = cutoff;
		this.costPrice = costPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getDir_id() {
		return dir_id;
	}

	public void setDir_id(Long dir_id) {
		this.dir_id = dir_id;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getCutoff() {
		return cutoff;
	}

	public void setCutoff(Double cutoff) {
		this.cutoff = cutoff;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", dir_ir=" + dir_id + ", salePrice=" + salePrice
				+ ", supplier=" + supplier + ", brand=" + brand + ", cutoff=" + cutoff + ", costPrice=" + costPrice
				+ "]";
	}

}
