package it.agil.cramanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.agil.cramanagment.entity.CraUser;
import it.agil.cramanagment.model.UserModelRequest;
import it.agil.cramanagment.service.CraUserService;

@RestController("craUser")
@RequestMapping("craUser")
public class CraUserController {

	@Autowired
	private CraUserService craUserService;

	@PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody final UserModelRequest user) {
		final CraUser craUser = craUserService.login(user.getEmailUser(), user.getPswUser());
		if (craUser != null) {
			return new ResponseEntity<>(craUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("saveOrUpdate")
	public ResponseEntity<?> addUser(@RequestBody final CraUser craUser) {
		final CraUser craUserResponse = craUserService.saveOrUpdate(craUser);
		return new ResponseEntity<>(craUserResponse == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

	@GetMapping("findByID")
	public ResponseEntity<?> findByID(@RequestBody final Long id) {
		final CraUser craUserResponse = craUserService.findById(id);
		if (craUserResponse != null) {
			return new ResponseEntity<>(craUserResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("delete")
	public ResponseEntity<?> delete(@RequestBody final Long id) {
		final boolean deleteByIdResult = craUserService.deleteById(id);
		return new ResponseEntity<>(deleteByIdResult ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}
