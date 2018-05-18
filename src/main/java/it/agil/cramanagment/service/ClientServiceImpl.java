package it.agil.cramanagment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.Client;
import it.agil.cramanagment.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveOrUpdate(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public Client findById(Long id) {
		Optional<Client> optionalClient = clientRepository.findById(id);
		return optionalClient.isPresent() ? optionalClient.get() : null;
	}

	@Override
	public Page<Client> findAllByPage(int page, int size) {
		return clientRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<Client> findAllSorted(Sort sort) {
		// TODO Auto-generated method stub
		return clientRepository.findAll(sort);
	}

}
