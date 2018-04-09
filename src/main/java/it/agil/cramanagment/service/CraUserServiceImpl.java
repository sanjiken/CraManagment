package it.agil.cramanagment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.agil.cramanagment.entity.CraUser;
import it.agil.cramanagment.repository.CraUserRepository;

@Service
public class CraUserServiceImpl implements CraUserService {

	@Autowired
	private CraUserRepository craUserRepository;

	private final static Logger LOGGER = LoggerFactory.getLogger(CraUserServiceImpl.class);

	@Override
	public boolean saveOrUpdate(final CraUser craUser) {
		if (craUser == null) {
			LOGGER.error("craUser param can't be null ");
			return false;
		}
		try {
			craUserRepository.save(craUser);
			return true;
		} catch (final DataAccessException e) {
			LOGGER.warn(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public CraUser login(final String username, final String pwd) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(pwd)) {
			LOGGER.error("username and pwd params can't be empty");
			return null;
		}
		try {
			return craUserRepository.findByUsername(username);
		} catch (final DataAccessException e) {
			LOGGER.warn("can't login for username {} and pwd {}", username, pwd);
		}
		return null;
	}

	@Override
	public boolean delete(final CraUser craUser) {
		if (craUser == null) {
			LOGGER.error("craUser param can't be null");
			return false;

		}
		try {
			craUserRepository.delete(craUser);
			return true;
		} catch (final DataAccessException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public CraUser findById(final Long id) {
		final Optional<CraUser> optionalCraUsre = craUserRepository.findById(id);
		if (optionalCraUsre.isPresent()) {
			return optionalCraUsre.get();
		}
		return null;
	}

	@Override
	public List<CraUser> finAll() {
		final Iterable<CraUser> craUserIterator = craUserRepository.findAll();
		final List<CraUser> craUsers = StreamSupport.stream(craUserIterator.spliterator(), false)
				.collect(Collectors.toList());
		return craUsers;
	}

}
