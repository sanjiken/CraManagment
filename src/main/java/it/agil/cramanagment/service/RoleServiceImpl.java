package it.agil.cramanagment.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.Role;
import it.agil.cramanagment.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role saveOrUpdate(final Role role) {
		return roleRepository.save(role);
	}

	@Override
	public boolean deleteById(final Long id) {
		try {
			roleRepository.deleteById(id);
			return true;
		} catch (final DataIntegrityViolationException e) {
			LOG.error("can't delete craUser with id={}", id);
		}
		return false;
	}

	@Override
	public Role findById(final Long id) {
		final Optional<Role> optionalRole = roleRepository.findById(id);
		return optionalRole.isPresent() ? optionalRole.get() : null;
	}

	@Override
	public Page<Role> findAllByPage(final int page, final int size) {
		return roleRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<Role> findAllSorted(final Sort sort) {
		return roleRepository.findAll(sort);
	}

}
