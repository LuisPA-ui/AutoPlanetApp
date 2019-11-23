package pe.edu.upc.autoplanet.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.autoplanet.model.Cita;


@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{

	
	@Query("select count(p.name) from Cita p where p.name = :name")
	public int countByName(@Param("name") String citaName);
	public Collection<Cita> findAllByOrderByNameDesc();

}
