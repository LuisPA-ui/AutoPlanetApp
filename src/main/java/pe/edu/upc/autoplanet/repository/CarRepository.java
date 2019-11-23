package pe.edu.upc.autoplanet.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.autoplanet.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	
	// Número de auto con placa especificado
	@Query("select count(p.placa) from Car p where p.placa = :placa")
	public int countByPlaca(@Param("placa") String productPlaca);
	public Collection<Car> findAllByOrderByPlacaDesc();

}
