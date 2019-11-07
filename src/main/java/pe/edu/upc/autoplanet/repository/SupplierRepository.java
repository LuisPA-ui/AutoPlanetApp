package pe.edu.upc.autoplanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.autoplanet.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	
	// Número de vendedores con nombre especificado
	@Query("select count(c.name) from Supplier c where c.name = :name")
	public int countByName(@Param("name") String supplierName);
	public List<Supplier> findAllByOrderByNameDesc();

}