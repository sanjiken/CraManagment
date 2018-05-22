package it.agil.cramanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.agil.cramanagment.entity.Role;
import it.agil.cramanagment.service.RoleService;

@RestController(value = "role")
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("saveOrUpdate")
	public ResponseEntity<?> saveOrUpdate(@RequestBody final Role role) {
		final Role roleResponse = roleService.saveOrUpdate(role);
		return new ResponseEntity<>(roleResponse == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

	@GetMapping("findByID")
	public ResponseEntity<?> findByID(@RequestBody final Long id) {
		final Role roleResponse = roleService.findById(id);
		if (roleResponse != null) {
			return new ResponseEntity<>(roleResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("delete")
	public ResponseEntity<?> delete(@RequestBody final Long id) {
		final boolean deleteByIdResult = roleService.deleteById(id);
		return new ResponseEntity<>(deleteByIdResult ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}
