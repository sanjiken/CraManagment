package it.agil.cramanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.agil.cramanagment.Entity.CraUser;
import it.agil.cramanagment.service.CraUserService;

@RestController
public class CraUserController {
	
	@Autowired
	private CraUserService craUserService;

	@RequestMapping(value = "get")
	public CraUser getUser(@RequestParam String username, @RequestParam String pwd) {
		return craUserService.login(username, pwd);
	}
	
	//for test
	
	@RequestMapping(value = "api/testUrl", produces = MediaType.APPLICATION_JSON_VALUE)
	public String testUser() {
		return "helloo";
	}
}
