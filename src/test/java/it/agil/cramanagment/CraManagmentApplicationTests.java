package it.agil.cramanagment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.agil.cramanagment.Entity.CraUser;
import it.agil.cramanagment.Entity.Role;
import it.agil.cramanagment.service.CraUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CraManagmentApplicationTests {
	
	@Autowired
	private CraUserService craUserService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void saveCraUser() {
		final CraUser craUser = new CraUser("agilItUsername", "agilItPwd", "admin@agilt-it.io", Role.D);
		craUserService.saveCraUser(craUser);
	}

}
