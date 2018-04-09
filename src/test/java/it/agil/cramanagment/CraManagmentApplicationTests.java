package it.agil.cramanagment;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.agil.cramanagment.entity.CraUser;
import it.agil.cramanagment.entity.Role;
import it.agil.cramanagment.service.CraUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CraManagmentApplicationTests {

	@Autowired
	private CraUserService craUserService;

	@Before
	public void initData() {
		final String username = "agilItUsername";
		final String pwd = "agilItPwd";
		CraUser craUser = craUserService.login(username, pwd);
		if (craUser == null) {
			craUser = new CraUser(username, pwd, "agilItUsername@agilit.io", Role.D);
		}
		Assert.assertTrue(craUserService.saveOrUpdate(craUser));
	}

	@Test
	public void login() {
		final CraUser craUser = craUserService.login("agilItUsername", "agilItPwd");
		Assert.assertNotNull(craUser);
	}

	@Test
	public void findByid() {
		final String username = "agilItUsername";
		final String pwd = "agilItPwd";
		final CraUser craUser = craUserService.login(username, pwd);
		Assert.assertNotNull(craUserService.findById(craUser.getId()));
	}

	@Test
	public void findAll() {
		final List<CraUser> craUserList = craUserService.finAll();
		Assert.assertNotNull(craUserList);
		Assert.assertTrue(craUserList.size() > 0);
	}

	@After
	public void deleteData() {
		final String username = "agilItUsername";
		final String pwd = "agilItPwd";
		final CraUser craUser = craUserService.login(username, pwd);
		Assert.assertNotNull(craUser);
		Assert.assertTrue(craUserService.delete(craUser));
	}

}
