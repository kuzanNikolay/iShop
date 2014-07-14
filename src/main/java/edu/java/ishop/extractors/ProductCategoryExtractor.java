package edu.java.ishop.extractors;

import edu.java.ishop.model.ProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nikolay on 12.07.14.
 */
public class ProductCategoryExtractor extends Extractor<ProductCategory> {

    @Override
    public ProductCategory extractOne(ResultSet resultSet) throws SQLException {

        ProductCategory productCategory = new ProductCategory(resultSet.getLong(6));
        productCategory.setName(resultSet.getString(7));

        return productCategory;
    }
}
