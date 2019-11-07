package pe.edu.upc.autoplanet.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.autoplanet.model.Supplier;
import pe.edu.upc.autoplanet.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	@Transactional
	public int createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		int result = supplierRepository.countByName(supplier.getName());
		if(result == 0) {
			supplierRepository.save(supplier);
		}
		return result;
	}

	@Override
	@Transactional
	public int updateSupplier(Long id, Supplier supplier) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Supplier> originalSupplier = supplierRepository.findById(id);
		
		result = originalSupplier.isPresent() ? 0 : -1;
		Supplier updatedSupplier = originalSupplier.get();
		updatedSupplier.setName(supplier.getName());
		supplierRepository.save(updatedSupplier);
		return result;
		
	}

	@Override
	@Transactional
	public int deleteSupplier(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Supplier> supplier = supplierRepository.findById(id);
		supplier.ifPresent(c -> supplierRepository.delete(c));
		result = supplier.isPresent() ? 0 : -1;
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAllByOrderByNameDesc();
	}

}