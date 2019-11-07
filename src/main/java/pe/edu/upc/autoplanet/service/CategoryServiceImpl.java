package pe.edu.upc.autoplanet.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.autoplanet.model.Category;
import pe.edu.upc.autoplanet.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public int createCategory(Category category) {
		// TODO Auto-generated method stub
		int result = categoryRepository.countByName(category.getName());
		if(result == 0) {
			categoryRepository.save(category);
		}
		return result;
	}

	@Override
	@Transactional
	public int updateCategory(Long id, Category category) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Category> originalCategory = categoryRepository.findById(id);
		
		result = originalCategory.isPresent() ? 0 : -1;
		Category updatedCategory = originalCategory.get();
		updatedCategory.setName(category.getName());
		categoryRepository.save(updatedCategory);
		return result;
		
	}

	@Override
	@Transactional
	public int deleteCategory(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Category> category = categoryRepository.findById(id);
		category.ifPresent(c -> categoryRepository.delete(c));
		result = category.isPresent() ? 0 : -1;
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAllByOrderByNameDesc();
	}
	

}
