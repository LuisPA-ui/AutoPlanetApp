package pe.edu.upc.autoplanet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.autoplanet.model.Users;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
}