package edu.ishop.model;

import java.math.BigDecimal;

public class Product extends Model {
	private static final long serialVersionUID = 1315655495740751915L;
	private BigDecimal price;
	private String description;
	private ProductCategory category;
	
	public Product(long id) {
		super(id);		
	}
	public Product(){ //we need it for serialization
		super(); 
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	

}
