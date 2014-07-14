package edu.java.ishop.services;

import edu.java.ishop.dao.impl.ProductDatabaseDao;
import edu.java.ishop.dao.impl.ProductFileDao;
import edu.java.ishop.utils.ApplicationConfiguration;

public class ProductServiceFactory {

	private ProductServiceFactory() {
	}

	public static ProductService getServiceInstance(){
		ProductService instance = null;
		switch (ApplicationConfiguration.getItem("datasourceType")) {
		case "database":
			instance = new ProductService();
			instance.setDao(new ProductDatabaseDao());
			return instance;
        case "file":
            instance = new ProductService();
            instance.setDao(new ProductFileDao());
            return instance;
        default:
			instance = new ProductService();
			instance.setDao(new ProductFileDao());
			return instance;
		}
	}
	
	
	
	
	
	
	
	

}
