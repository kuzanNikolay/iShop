package edu.java.ishop.extractors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 12.07.14.
 */
public abstract class Extractor<T> {
    /**
     * Extract fields only from appropriate table.
     * Doesn't extract data from 'connected' tables.
     */
    public abstract T extractOne(ResultSet resultSet) throws SQLException;

    /**
     * Extract fields only from appropriate table.
     * Doesn't extract data from 'connected' tables.
     */
    public List<T> extractAll(ResultSet resultSet) throws SQLException{
        List<T> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(extractOne(resultSet));
        }

        return result;
    }


}
