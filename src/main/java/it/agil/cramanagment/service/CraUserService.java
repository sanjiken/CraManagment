package it.agil.cramanagment.service;

import it.agil.cramanagment.entity.CraUser;

public interface CraUserService {

	CraUser saveOrUpdate(CraUser craUser);

	CraUser login(String username, String pwd);

	void delete(CraUser craUser);

	CraUser findById(Long id);

}
