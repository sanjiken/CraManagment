package it.agil.cramanagment.repository;

import org.springframework.data.repository.CrudRepository;

import it.agil.cramanagment.entity.CraUser;

public interface CraUserRepository extends CrudRepository<CraUser, Long> {

	CraUser findByUsername(String username);
}
