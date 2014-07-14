/**
 * 
 */
package edu.java.ishop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.java.ishop.acessor.DatabaseDatasourceAccessor;
import edu.java.ishop.dao.ProductDao;
import edu.java.ishop.model.Product;
import edu.java.ishop.model.ProductCategory;
import edu.java.ishop.utils.ApplicationConfiguration;
import org.apache.log4j.Logger;

public class ProductDatabaseDao extends DatabaseDatasourceAccessor implements
		ProductDao {

    private static Logger logger = Logger.getLogger(ProductDatabaseDao.class.getName());


	public ProductDatabaseDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getAll() {

        if (logger.isDebugEnabled()){
            logger.debug("Begin of getAll() operation in ProductDatabaseDao");
        }

		List<Product> result = new ArrayList<>();
		try (Connection conn = openAccessWithDatasource();
				PreparedStatement pstmt = conn
						.prepareStatement("select p.id, p.name, p.price, p.description, p.categoryid, pc.id, pc.name from product p, productcategory pc where p.categoryid = pc.id");
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getLong(1));
                p.setName(rs.getString(2));
				p.setPrice(rs.getBigDecimal(3));
				p.setDescription(rs.getString(4));

				ProductCategory productCategory = new ProductCategory(
						rs.getLong(6));
				productCategory.setName(rs.getString(7));
				p.setCategory(productCategory);

				result.add(p);
                if (logger.isDebugEnabled()){
                    logger.debug("Getting Product with id = " + p.getId() + " and name = " + p.getName() + " from resultSet");
                }

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        if (logger.isDebugEnabled()){
            logger.debug("End of getAll() operation in ProductDatabaseDao");
        }


		return result;
	}

	@Override
	public Product getById(long Id) {
        try (Connection conn = openAccessWithDatasource();
             PreparedStatement pstm = conn.prepareStatement("select p.id, p.name, p.price, p.description, " +
                     "p.categoryid, pc.id, pc.name from product p, productcategory pc where p.categoryid = pc.id and p.id = ?");
        ){
            pstm.setLong(1,Id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                Product p = new Product();
                p.setId(rs.getLong(1));
                p.setName(rs.getString(2));
                p.setPrice(rs.getBigDecimal(3));
                p.setDescription(rs.getString(4));

                ProductCategory productCategory = new ProductCategory(rs.getLong(6));
                productCategory.setName(rs.getString(7));
                p.setCategory(productCategory);
                return p;
            } else {
                //TODO: change this to checked exception
                throw new RuntimeException("Product with id = " + Id + " not found");
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

	@Override
	public void save(Product item) {
		try (Connection conn = openAccessWithDatasource();
				PreparedStatement pstmt = conn
						.prepareStatement("insert into product (name,price, description, categoryid) values(?,?,?,?)");) {
			pstmt.setString(1, item.getName());
			pstmt.setBigDecimal(2, item.getPrice());
			pstmt.setString(3, item.getDescription());
			pstmt.setLong(4, item.getCategory().getId());

			pstmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Product item) {
		try (Connection conn = openAccessWithDatasource();
				PreparedStatement pstmt = conn
						.prepareStatement("delete from product where id = ?");) {
			pstmt.setLong(1, item.getId());
			pstmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Product getByCategory(ProductCategory category) {
	    try(Connection connection = openAccessWithDatasource();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select p.id, p.name, p.price, p.description, p.categoryid, pc.id, pc.name " +
                    "from product p, productcategory pc where p.categoryid = pc.id and pc.id = ?");
        ){
            preparedStatement.setLong(1, category.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getBigDecimal(3));
                product.setDescription(resultSet.getString(4));

                ProductCategory productCategory = new ProductCategory(resultSet.getLong(6));
                productCategory.setName(resultSet.getString(7));

                product.setCategory(productCategory);

                return product;
            } else {
                throw new RuntimeException("Product with category " + category.getName() + " not found");
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
	}



    //------------------ Services methods ---------------------------//

	@Override
	public String getPassword() {
		return ApplicationConfiguration.getItem("database.user.password");
	}

	@Override
	public String getUsername() {
		return ApplicationConfiguration.getItem("database.user.name");
	}

	@Override
	public String getConnectionUrl() {
		return ApplicationConfiguration.getItem("database.connection.url");
	}

	@Override
	public String getHost() {
		return ApplicationConfiguration.getItem("database.host");
	}

	@Override
	public String getDatabaseName() {
		return ApplicationConfiguration.getItem("database.name");
	}

	@Override
	public int getMaxConnections() {
		return Integer.parseInt(ApplicationConfiguration
				.getItem("database.max.connections"));
	}

	@Override
	public int getPort() {
		return Integer.parseInt(ApplicationConfiguration
				.getItem("database.port"));
	}
    //-------------------------------------------------------------------//
}
