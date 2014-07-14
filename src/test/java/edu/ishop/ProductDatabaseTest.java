package edu.ishop;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.ishop.dao.impl.ProductDatabaseDao;
import edu.ishop.model.Product;
import edu.ishop.model.ProductCategory;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDatabaseTest {

	public ProductDatabaseTest() {
		// TODO Auto-generated constructor stub
	}
/*
	@Test
	public void addProductTest() {
		ProductDatabaseDao dao = new ProductDatabaseDao();
		Product p = new Product();
		p.setName("Product1");
		p.setPrice(new BigDecimal("50.0"));

		ProductCategory pc = new ProductCategory(2l);
		p.setCategory(pc);
		dao.save(p);
	}

	@Test
	public void getAllProductTest() {
		ProductDatabaseDao dao = new ProductDatabaseDao();
		final List<Product> products = dao.getAll();
		assertNotNull(products);
		assertTrue(products.size() == 1);
		assertEquals("Cars", products.get(0).getCategory().getName());
		assertEquals(2, products.get(0).getCategory().getId());
	}

	@Test
	public void removeProductTest() {
		ProductDatabaseDao dao = new ProductDatabaseDao();
		List<Product> products = dao.getAll();
		for (Product p : products) {
			dao.delete(p);
		}

		products = dao.getAll();
		assertTrue(products.size() == 0);

	}
*/
}
