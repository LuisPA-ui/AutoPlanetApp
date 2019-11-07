package pe.edu.upc.autoplanet.service;

import java.util.Collection;

import pe.edu.upc.autoplanet.model.Category;

public interface CategoryService {
	
	public abstract int createCategory(Category category);
	public abstract int updateCategory(Long id, Category category);
	public abstract int deleteCategory(Long id);
	public abstract Collection<Category> getCategories();

}
