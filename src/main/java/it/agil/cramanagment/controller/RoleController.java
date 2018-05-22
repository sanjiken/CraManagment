package it.agil.cramanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("findAllSorted")
	public ResponseEntity<?> findAllSorted(@RequestParam final String property, @RequestParam final String direction) {
		final Order order = new Order(Direction.fromString(direction), property);
		final Iterable<Role> roleList = roleService.findAllSorted(Sort.by(order));
		return new ResponseEntity<>(roleList, HttpStatus.OK);
	}

	@GetMapping("findAll")
	public ResponseEntity<?> findAll() {
		final Iterable<Role> dayActivityList = roleService.findAll();
		return new ResponseEntity<>(dayActivityList, HttpStatus.OK);
	}

	@GetMapping("findByPage")
	public ResponseEntity<?> findByPage(@RequestParam final int page, @RequestParam final int size) {
		final Iterable<Role> roleList = roleService.findAllByPage(page, size);
		return new ResponseEntity<>(roleList, HttpStatus.OK);
	}
}
