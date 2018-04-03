package it.agil.cramanagment.service;

import it.agil.cramanagment.model.CraUser;

public interface CraUserService {
	void saveCraUser(CraUser craUser);

	CraUser login(final String username, final String pwd);

}
