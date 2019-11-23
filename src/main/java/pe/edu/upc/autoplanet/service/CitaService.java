package pe.edu.upc.autoplanet.service;

import java.util.Collection;


import pe.edu.upc.autoplanet.model.Cita;

public interface CitaService {
	
	public abstract int createCita(Cita cita);
	public abstract int updateCita(Long id, Cita cita);
	public abstract int deleteCita(Long id);
	public abstract Collection<Cita> getCitas();

}
