package com.bean;

public class ProductBean {
	// naming convention optional -> no error
	// when we use framework -> compulsory
	// convention over of the configuration
	// pan -> pna vado -> chokadi
	private Integer productId; // productid productid bean-> private can get setter private constru
	private String name;
	private float price;
	private Integer qty;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
