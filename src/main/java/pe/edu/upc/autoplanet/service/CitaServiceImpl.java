package pe.edu.upc.autoplanet.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.autoplanet.model.Category;
import pe.edu.upc.autoplanet.model.Cita;
import pe.edu.upc.autoplanet.model.Product;
import pe.edu.upc.autoplanet.repository.CategoryRepository;
import pe.edu.upc.autoplanet.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaRepository citaRepository;
	
	@Override
	@Transactional
	public int createCita(Cita cita) {
		// TODO Auto-generated method stub
		int result = citaRepository.countByName(cita.getName());
		if(result == 0) {
			citaRepository.save(cita);
		}
		return result;
	}

	@Override	
	public int updateCita(Long id, Cita cita) {
		
		int result = 0;
		Optional<Cita> originalCita = citaRepository.findById(id);
		if(originalCita.isPresent()) {
			Cita updatedCita = originalCita.get();
			updatedCita.setName(cita.getName());
			
			updatedCita.setCreateAt(cita.getCreateAt());
			updatedCita.setClient(cita.getClient());
			updatedCita.setProduct(cita.getProduct());
			updatedCita.setFechaIngreso(cita.getFechaIngreso());
			updatedCita.setFechaSalida(cita.getFechaSalida());
			citaRepository.save(updatedCita);
		}
		return result;
		
	}

	@Override
	public int deleteCita(Long id) {
		
		Optional<Cita> cita = citaRepository.findById(id);
		if(!cita.isPresent()) {return -1; }
		citaRepository.delete(cita.get());
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cita> getCitas() {
		// TODO Auto-generated method stub
		return citaRepository.findAllByOrderByNameDesc();
	}
	

}
