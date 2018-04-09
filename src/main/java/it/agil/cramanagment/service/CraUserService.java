package it.agil.cramanagment.service;

import java.util.List;

import it.agil.cramanagment.entity.CraUser;

public interface CraUserService {

	boolean saveOrUpdate(CraUser craUser);

	CraUser login(String username, String pwd);

	boolean delete(CraUser craUser);

	CraUser findById(Long id);

	List<CraUser> finAll();

}
