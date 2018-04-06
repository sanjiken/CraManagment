package it.agil.cramanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.agil.cramanagment.entity.CraUser;
import it.agil.cramanagment.repository.CraUserRepository;

@Service
public class CraUserServiceImpl implements CraUserService {

	@Autowired
	private CraUserRepository craUserRepository;

	@Override
	public CraUser saveOrUpdate(final CraUser craUser) {
		return craUserRepository.save(craUser);
	}

	@Override
	public CraUser login(final String username, final String pwd) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(pwd)) {
			return null;
		}
		final CraUser craUser = craUserRepository.findByUsername(username);
		return craUser != null && pwd.equals(craUser.getPwd()) ? craUser : null;
	}

	@Override
	public void delete(final CraUser craUser) {
		craUserRepository.delete(craUser);
	}

	@Override
	public CraUser findById(final Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
