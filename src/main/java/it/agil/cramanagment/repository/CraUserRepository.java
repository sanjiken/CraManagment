package it.agil.cramanagment.repository;

import org.springframework.data.repository.CrudRepository;

import it.agil.cramanagment.model.CraUser;

public interface CraUserRepository extends CrudRepository<CraUser, Long> {
	CraUser findByUsernameAndPwd(String username, String pwd);
}
