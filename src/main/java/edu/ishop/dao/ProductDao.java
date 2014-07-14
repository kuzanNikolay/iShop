package edu.ishop.dao;

import edu.ishop.model.Product;
import edu.ishop.model.ProductCategory;

public interface ProductDao extends ItemDao<Product> {
	Product getByCategory(ProductCategory category);
}
