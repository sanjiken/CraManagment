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

import it.agil.cramanagment.entity.Client;
import it.agil.cramanagment.service.ClientService;

@RestController(value = "client")
@RequestMapping("client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("saveOrUpdate")
	public ResponseEntity<?> saveOrUpdate(@RequestBody final Client client) {
		final Client clientResponse = clientService.saveOrUpdate(client);
		return new ResponseEntity<>(clientResponse == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

	@GetMapping("delete")
	public ResponseEntity<?> delete(@RequestBody final Long id) {
		final boolean deleteByIdResult = clientService.deleteById(id);
		return new ResponseEntity<>(deleteByIdResult ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@GetMapping("findByID")
	public ResponseEntity<?> findByID(@RequestBody final Long id) {
		final Client clientResponse = clientService.findById(id);
		if (clientResponse != null) {
			return new ResponseEntity<>(clientResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("findAllSorted")
	public ResponseEntity<?> findAllSorted(@RequestParam final String property, @RequestParam final String direction) {
		final Order order = new Order(Direction.fromString(direction), property);
		final Iterable<Client> clients = clientService.findAllSorted(Sort.by(order));
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@GetMapping("findAll")
	public ResponseEntity<?> findAll() {
		final Iterable<Client> clients = clientService.findAll();
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@GetMapping("findByPage")
	public ResponseEntity<?> findByPage(@RequestParam final int page, @RequestParam final int size) {
		final Iterable<Client> clients = clientService.findAllByPage(page, size);
		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

}
