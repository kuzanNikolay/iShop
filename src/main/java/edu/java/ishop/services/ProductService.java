package edu.java.ishop.services;

import java.util.List;

import edu.java.ishop.dao.ProductDao;
import edu.java.ishop.dao.impl.ProductFileDao;
import edu.java.ishop.model.Product;
import edu.java.ishop.model.ProductCategory;

public class ProductService {

	private ProductDao dao;
	
	public ProductService() {	
		dao = new ProductFileDao();
	}
	
	public List<Product> getAll(){ return dao.getAll(); }

	public void save(Product item){ dao.save(item); }

    public Product getById(long Id){ return dao.getById(Id); }

    public void delete(Product item){ dao.delete(item); }

    public Product getByCategory(ProductCategory category){ return dao.getByCategory(category); }

	public void setDao(ProductDao dao){
		this.dao = dao;
	}
}
