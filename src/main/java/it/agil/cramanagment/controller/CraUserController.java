package it.agil.cramanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.agil.cramanagment.entity.CraUser;
import it.agil.cramanagment.service.CraUserService;

@RestController(value = "craUserManagment")
public class CraUserController {

	@Autowired
	private CraUserService craUserService;

	@GetMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestParam final String username, @RequestParam final String pwd) {
		final CraUser craUser = craUserService.login(username, pwd);
		if (craUser != null) {
			return new ResponseEntity<CraUser>(craUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping(value = "saveOrUpdate")
	public ResponseEntity<?> addUser(@RequestBody final CraUser craUser) {
		final CraUser craUserResponse = craUserService.saveOrUpdate(craUser);
		return new ResponseEntity<>(craUserResponse == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

}
