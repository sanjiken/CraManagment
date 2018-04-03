package it.agil.cramanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.agil.cramanagment.model.CraUser;
import it.agil.cramanagment.service.CraUserService;

@RestController
public class CraUserController {
	
	@Autowired
	private CraUserService craUserService;

	@RequestMapping(value = "get")
	public CraUser getUser(@RequestParam String username, @RequestParam String pwd) {
		return craUserService.login(username, pwd);
	}

}
