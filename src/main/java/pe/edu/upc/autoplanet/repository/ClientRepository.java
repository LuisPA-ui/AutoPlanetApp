package pe.edu.upc.autoplanet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.autoplanet.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	// Número de clientes con nombre especificado
	@Query("select count(c.name) from Client c where c.name = :name")
	public int countByName(@Param("name") String clientName);
	public List<Client> findAllByOrderByNameDesc();

}
