package edu.ishop;

import java.util.List;

import org.junit.Test;

import edu.ishop.dao.ProductDao;
import edu.ishop.dao.impl.ProductFileDao;
import edu.ishop.model.Product;
import edu.ishop.services.ProductService;
import static junit.framework.Assert.*;
public class ProductFileTest {

	public ProductFileTest() {

	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetallProducts(){
		ProductService productService = new ProductService();
		ProductDao dao = new ProductFileDao();
		productService.setDao(dao);
		final List<Product> products = productService.getAll();
		assertNotNull(products);
		assertTrue(products.size() != 1); 
		assertNotNull(products.get(0));
		assertEquals(products.get(0).getName(),"\"Audi A6\"");
		}
}
