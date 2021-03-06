package it.agil.cramanagment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.agil.cramanagment.entity.Role;

public interface RoleService {

	Role saveOrUpdate(Role role);

	boolean deleteById(Long id);

	Role findById(Long id);

	Page<Role> findAllByPage(int page, int size);

	Iterable<Role> findAllSorted(Sort sort);

	Iterable<Role> findAll();
}
