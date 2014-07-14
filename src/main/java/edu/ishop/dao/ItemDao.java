package edu.ishop.dao;

import java.util.List;
import edu.ishop.model.Model;


public interface ItemDao<T extends Model> {
	public List<T> getAll();
	public T getById(long Id);
	public void save(T item);
	public void delete(T item);
}
