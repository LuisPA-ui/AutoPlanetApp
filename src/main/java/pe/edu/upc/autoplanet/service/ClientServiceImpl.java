package pe.edu.upc.autoplanet.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.autoplanet.model.Client;
import pe.edu.upc.autoplanet.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	@Transactional
	public int createClient(Client client) {
		// TODO Auto-generated method stub
		int result = clientRepository.countByName(client.getName());
		if(result == 0) {
			clientRepository.save(client);
		}
		return result;
	}

	@Override
	@Transactional
	public int updateClient(Long id, Client client) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Client> originalClient = clientRepository.findById(id);
		
		result = originalClient.isPresent() ? 0 : -1;
		Client updatedClient = originalClient.get();
		updatedClient.setName(client.getName());
		updatedClient.setAddress(client.getAddress());
		updatedClient.setDni(client.getDni());
		updatedClient.setPhone(client.getPhone());
		clientRepository.save(updatedClient);
		return result;
	}

	@Override
	@Transactional
	public int deleteClient(Long id) {
		// TODO Auto-generated method stub
		int result = 0;
		Optional<Client> client = clientRepository.findById(id);
		client.ifPresent(c -> clientRepository.delete(c));
		result = client.isPresent() ? 0 : -1;
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Client> getClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAllByOrderByNameDesc();
	}

}
