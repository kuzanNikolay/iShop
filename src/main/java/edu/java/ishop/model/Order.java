package edu.java.ishop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order extends Model {

	private static final long serialVersionUID = -2425354848556400942L;
	private List<Product> products = new ArrayList<>();
	private Calendar creationDate;

	public Order(long id) {
		super(id);
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

}
