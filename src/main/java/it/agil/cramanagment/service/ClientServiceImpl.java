package it.agil.cramanagment.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.Client;
import it.agil.cramanagment.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveOrUpdate(final Client client) {
		return clientRepository.save(client);
	}

	@Override
	public boolean deleteById(final Long id) {
		try {
			clientRepository.deleteById(id);
			return true;
		} catch (final DataIntegrityViolationException e) {
			LOG.error("can't delete client with id={}", id);
		}
		return false;

	}

	@Override
	public Client findById(final Long id) {
		final Optional<Client> optionalClient = clientRepository.findById(id);
		return optionalClient.isPresent() ? optionalClient.get() : null;
	}

	@Override
	public Page<Client> findAllByPage(final int page, final int size) {
		return clientRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<Client> findAllSorted(final Sort sort) {
		return clientRepository.findAll(sort);
	}

	@Override
	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

}
