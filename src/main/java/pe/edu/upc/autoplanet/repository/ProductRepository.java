package pe.edu.upc.autoplanet.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.autoplanet.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// Número de productos con nombre especificado
	@Query("select count(p.name) from Product p where p.name = :name")
	public int countByName(@Param("name") String productName);
	public Collection<Product> findAllByOrderByNameDesc();

}
