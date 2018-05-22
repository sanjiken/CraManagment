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

import it.agil.cramanagment.entity.Cra;
import it.agil.cramanagment.service.CraService;

@RestController(value = "cra")
@RequestMapping("cra")
public class CraController {

	@Autowired
	private CraService craService;

	@PostMapping("saveOrUpdate")
	public ResponseEntity<?> saveOrUpdate(@RequestBody final Cra cra) {
		final Cra craResponse = craService.saveOrUpdate(cra);
		return new ResponseEntity<>(craResponse == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

	@GetMapping("delete")
	public ResponseEntity<?> delete(@RequestBody final Long id) {
		final boolean deleteByIdResult = craService.deleteById(id);
		return new ResponseEntity<>(deleteByIdResult ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@GetMapping("findByID")
	public ResponseEntity<?> findByID(@RequestBody final Long id) {
		final Cra craResponse = craService.findById(id);
		if (craResponse != null) {
			return new ResponseEntity<>(craResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("findAllSorted")
	public ResponseEntity<?> findAllSorted(@RequestParam final String property, @RequestParam final String direction) {
		final Order order = new Order(Direction.fromString(direction), property);
		final Iterable<Cra> craList = craService.findAllSorted(Sort.by(order));
		return new ResponseEntity<>(craList, HttpStatus.OK);
	}

	@GetMapping("findAll")
	public ResponseEntity<?> findAll() {
		final Iterable<Cra> craList = craService.findAll();
		return new ResponseEntity<>(craList, HttpStatus.OK);
	}

	@GetMapping("findByPage")
	public ResponseEntity<?> findByPage(@RequestParam final int page, @RequestParam final int size) {
		final Iterable<Cra> craList = craService.findAllByPage(page, size);
		return new ResponseEntity<>(craList, HttpStatus.OK);
	}
}
