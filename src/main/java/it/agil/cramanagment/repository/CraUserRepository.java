package it.agil.cramanagment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.agil.cramanagment.entity.CraUser;

public interface CraUserRepository extends PagingAndSortingRepository<CraUser, Long> {

	CraUser findByUsername(String username);
}
