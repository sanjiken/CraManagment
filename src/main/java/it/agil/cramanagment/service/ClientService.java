package it.agil.cramanagment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.agil.cramanagment.entity.Client;

public interface ClientService {

	Client saveOrUpdate(Client client);

	void delete(Client client);

	Client findById(Long id);

	Page<Client> findAllByPage(int page, int size);

	Iterable<Client> findAllSorted(Sort sort);

}
