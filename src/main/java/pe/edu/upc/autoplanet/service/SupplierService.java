package pe.edu.upc.autoplanet.service;

import java.util.Collection;

import pe.edu.upc.autoplanet.model.Supplier;

public interface SupplierService {
	
	public abstract int createSupplier(Supplier supplier);
	public abstract int updateSupplier(Long id, Supplier supplier);
	public abstract int deleteSupplier(Long id);
	public abstract Collection<Supplier> getSuppliers();

}