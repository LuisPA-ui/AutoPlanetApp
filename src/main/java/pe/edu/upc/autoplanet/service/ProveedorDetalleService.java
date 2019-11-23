package pe.edu.upc.autoplanet.service;

import java.util.Collection;


import pe.edu.upc.autoplanet.model.ProveedorDetalle;

public interface ProveedorDetalleService {
	public abstract int createProveedorDetalle(ProveedorDetalle proveedorDetalle);
	public abstract int updateProveedorDetalle(Long id, ProveedorDetalle proveedorDetalle);
	public abstract int deleteProveedorDetalle(Long id);
	public abstract Collection<ProveedorDetalle> getProveedorDetalles();

}
