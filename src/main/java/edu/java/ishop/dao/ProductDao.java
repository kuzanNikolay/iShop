package edu.java.ishop.dao;

import edu.java.ishop.model.Product;
import edu.java.ishop.model.ProductCategory;

public interface ProductDao extends ItemDao<Product> {
	Product getByCategory(ProductCategory category);
}
