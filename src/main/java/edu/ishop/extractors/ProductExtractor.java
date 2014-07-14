package edu.ishop.extractors;

import edu.ishop.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nikolay on 12.07.14.
 */
public class ProductExtractor extends Extractor<Product> {

    @Override
    public Product extractOne(ResultSet resultSet) throws SQLException {

        Product product = new Product();
        product.setId(resultSet.getLong(1));
        product.setName(resultSet.getString(2));
        product.setPrice(resultSet.getBigDecimal(3));
        product.setDescription(resultSet.getString(4));

        return product;
    }
}
