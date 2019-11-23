package pe.edu.upc.autoplanet.service;

import java.util.Collection;

import pe.edu.upc.autoplanet.model.Client;

public interface ClientService {
	
	public abstract int createClient(Client client);
	public abstract int updateClient(Long id, Client client);
	public abstract int deleteClient(Long id);
	public abstract Collection<Client> getClients();

}