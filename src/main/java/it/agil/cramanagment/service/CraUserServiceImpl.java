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
import org.springframework.util.Assert;

import it.agil.cramanagment.entity.CraUser;
import it.agil.cramanagment.repository.CraUserRepository;

@Service
public class CraUserServiceImpl implements CraUserService {

	private static final Logger LOG = LoggerFactory.getLogger(CraUserServiceImpl.class);

	@Autowired
	private CraUserRepository craUserRepository;

	@Override
	public CraUser saveOrUpdate(final CraUser craUser) {
		return craUserRepository.save(craUser);
	}

	@Override
	public CraUser login(final String username, final String pwd) {
		Assert.hasText(username, "username can't be empty");
		Assert.hasText(pwd, "pwd can't be empty");
		final CraUser craUser = craUserRepository.findByUsername(username);
		return craUser != null && pwd.equals(craUser.getPwd()) ? craUser : null;
	}

	@Override
	public boolean deleteById(final Long id) {
		try {
			craUserRepository.deleteById(id);
			return true;
		} catch (final DataIntegrityViolationException e) {
			LOG.error("can't delete craUser with id={}", id);
		}
		return false;
	}

	@Override
	public CraUser findById(final Long id) {
		final Optional<CraUser> optioncraUser = craUserRepository.findById(id);
		return optioncraUser.isPresent() ? optioncraUser.get() : null;
	}

	@Override
	public Page<CraUser> findAllByPage(final int page, final int size) {
		return craUserRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<CraUser> findAllSorted(final Sort sort) {
		return craUserRepository.findAll(sort);
	}

}
