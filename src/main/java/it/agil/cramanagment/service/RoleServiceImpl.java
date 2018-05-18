package it.agil.cramanagment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.Role;
import it.agil.cramanagment.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role saveOrUpdate(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}

	@Override
	public Role findById(Long id) {
		Optional<Role> optionalRole = roleRepository.findById(id);
		return optionalRole.isPresent() ? optionalRole.get() : null;
	}

	@Override
	public Page<Role> findAllByPage(int page, int size) {
		return roleRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<Role> findAllSorted(Sort sort) {
		return roleRepository.findAll(sort);
	}

}
