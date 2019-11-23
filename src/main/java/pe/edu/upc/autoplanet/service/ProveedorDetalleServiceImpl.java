package pe.edu.upc.autoplanet.service;

import java.util.Collection;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.autoplanet.model.ProveedorDetalle;


import pe.edu.upc.autoplanet.repository.ProveedorDetalleRepository;

@Service
public class ProveedorDetalleServiceImpl implements ProveedorDetalleService{
	
	@Autowired
	private ProveedorDetalleRepository proveedordetalleRepository; 
	
	@Transactional
	@Override
	public int createProveedorDetalle(ProveedorDetalle entity) {
		
		int result = proveedordetalleRepository.countByName(entity.getName());
		if(result == 0) {
		
			proveedordetalleRepository.save(entity);
		}
		return result;
	}

	@Override
	public int updateProveedorDetalle(Long id, ProveedorDetalle proveedorDetalle) {
		int result = 0;
		Optional<ProveedorDetalle> originalProveedorDetalle= proveedordetalleRepository.findById(id);
		if(originalProveedorDetalle.isPresent()) {
			ProveedorDetalle updatedProvedorDetalle = originalProveedorDetalle.get();
			updatedProvedorDetalle.setName(proveedorDetalle.getName());
			updatedProvedorDetalle.setCalificacion(proveedorDetalle.getCalificacion());
			updatedProvedorDetalle.setClient(proveedorDetalle.getClient());
			updatedProvedorDetalle.setSupplier(proveedorDetalle.getSupplier());
			proveedordetalleRepository.save(updatedProvedorDetalle);
		}
		return result;
	}

	@Override
	public int deleteProveedorDetalle(Long id) {
		Optional<ProveedorDetalle> proveedorDetalle = proveedordetalleRepository.findById(id);
		if(!proveedorDetalle.isPresent()) {return -1; }
		proveedordetalleRepository.delete(proveedorDetalle.get());
		return 0;
	}

	@Override
	public Collection<ProveedorDetalle> getProveedorDetalles() {
		return proveedordetalleRepository.findAllByOrderByNameDesc();
	}

}
