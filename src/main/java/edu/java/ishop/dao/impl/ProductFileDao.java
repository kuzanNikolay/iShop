package edu.java.ishop.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.java.ishop.acessor.FileDatasourceAccessor;
import edu.java.ishop.dao.ProductDao;
import edu.java.ishop.model.Product;
import edu.java.ishop.model.ProductCategory;
import edu.java.ishop.utils.ApplicationConfiguration;

public class ProductFileDao extends FileDatasourceAccessor implements ProductDao {

	public ProductFileDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getAll() {
		List<Product> result = new ArrayList<Product>();
		try(BufferedReader reader = getReader()){
			String line = null;
			long catId = 01;
			while((line = reader.readLine()) != null){
				String[] columns = line.split(",");
				
				Product p = new Product(Long.parseLong(columns[0]));
				p.setName(columns[1]);
				p.setPrice(new BigDecimal(columns[2]));
				p.setDescription(columns[3]);
				ProductCategory category = new ProductCategory(catId++);
				category.setName(columns[4]);
				p.setCategory(category);
				
				result.add(p);
			}
		} catch(IOException ex){
			throw new RuntimeException(ex);
		}
		
		return result;
	}

	@Override
	public Product getById(long Id) {
		throw new UnsupportedOperationException("getById");
	}

	@Override
	public void save(Product item) {
		try(BufferedWriter writer = getWriter()){
		
			writer.newLine();
			writer.write(item.getId()+","+item.getName()+","+item.getPrice()+","+item.getDescription()+
					","+item.getCategory().getName());
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(Product item) {
		throw new UnsupportedOperationException("delete");
	}

	@Override
	public Product getByCategory(ProductCategory category) {
		throw new UnsupportedOperationException("getByCategory");
	}

    //--------------------------- Services method ------------------------------//
    @Override
    public String getDatasourceName() {
        return  ApplicationConfiguration.getItem("file.products.location");
    }
    //-------------------------------------------------------------------------//
}
