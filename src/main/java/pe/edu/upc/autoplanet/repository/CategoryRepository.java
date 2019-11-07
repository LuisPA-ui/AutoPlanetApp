package pe.edu.upc.autoplanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.autoplanet.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	// Número de categorías con nombre especificado
	@Query("select count(c.name) from Category c where c.name = :name")
	public int countByName(@Param("name") String categoryName);
	public List<Category> findAllByOrderByNameDesc();

}
