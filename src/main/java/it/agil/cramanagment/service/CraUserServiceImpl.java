package it.agil.cramanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.model.CraUser;
import it.agil.cramanagment.repository.CraUserRepository;

@Service
public class CraUserServiceImpl implements CraUserService {

	@Autowired
	private CraUserRepository craUserRepository;

	@Override
	public void saveCraUser(CraUser craUser) {
		craUserRepository.save(craUser);
	}

	@Override
	public CraUser login(String username, String pwd) {
		
		// TODO Auto-generated method stub
		return craUserRepository.findByUsernameAndPwd(username, pwd);
	}

}
