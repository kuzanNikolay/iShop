package edu.ishop;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import edu.ishop.dao.ProductDao;
import edu.ishop.model.Product;
import edu.ishop.services.ProductService;

public class CollaborationTest {

	public CollaborationTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void testProductServiceGetAll(){
		Mockery mockery = new Mockery();
		ProductService productService = new ProductService();
		
		final ProductDao dao= mockery.mock(ProductDao.class);
		productService.setDao(dao);
		
		final List<Product> products = new ArrayList<>();
		mockery.checking(new Expectations(){{
			oneOf(dao).getAll();will(returnValue(products));			
		}});
		
		
		productService.getAll();
		mockery.assertIsSatisfied();
	}
	
}
