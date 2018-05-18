package it.agil.cramanagment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.agil.cramanagment.entity.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

}
