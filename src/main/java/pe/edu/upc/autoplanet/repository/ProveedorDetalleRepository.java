package pe.edu.upc.autoplanet.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.autoplanet.model.Product;
import pe.edu.upc.autoplanet.model.ProveedorDetalle;

@Repository
public interface ProveedorDetalleRepository extends JpaRepository<ProveedorDetalle, Long>{
	

	
	public int countByName(@Param("name") String productName);
	public Collection<ProveedorDetalle> findAllByOrderByNameDesc();

}
