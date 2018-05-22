package it.agil.cramanagment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.agil.cramanagment.entity.CraUser;

public interface CraUserService {

	CraUser saveOrUpdate(CraUser craUser);

	CraUser login(String username, String pwd);

	boolean deleteById(Long id);

	CraUser findById(Long id);

	Page<CraUser> findAllByPage(int page, int size);

	Iterable<CraUser> findAllSorted(Sort sort);

	Iterable<CraUser> findAll();

}
