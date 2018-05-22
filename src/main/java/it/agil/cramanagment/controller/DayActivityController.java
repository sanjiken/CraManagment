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

import it.agil.cramanagment.entity.DayActivity;
import it.agil.cramanagment.service.DayActivityService;

@RestController(value = "dayActivity")
@RequestMapping("dayActivity")
public class DayActivityController {

	@Autowired
	private DayActivityService dayActivityService;

	@PostMapping("saveOrUpdate")
	public ResponseEntity<?> saveOrUpdate(@RequestBody final DayActivity dayActivity) {
		final DayActivity dayActivityResponse = dayActivityService.saveOrUpdate(dayActivity);
		return new ResponseEntity<>(dayActivityResponse == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

	@GetMapping("findByID")
	public ResponseEntity<?> findByID(@RequestBody final Long id) {
		final DayActivity dayActivityResponse = dayActivityService.findById(id);
		if (dayActivityResponse != null) {
			return new ResponseEntity<>(dayActivityResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("delete")
	public ResponseEntity<?> delete(@RequestBody final Long id) {
		final boolean deleteByIdResult = dayActivityService.deleteById(id);
		return new ResponseEntity<>(deleteByIdResult ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@GetMapping("findAllSorted")
	public ResponseEntity<?> findAllSorted(@RequestParam final String property, @RequestParam final String direction) {
		final Order order = new Order(Direction.fromString(direction), property);
		final Iterable<DayActivity> dayActivityList = dayActivityService.findAllSorted(Sort.by(order));
		return new ResponseEntity<>(dayActivityList, HttpStatus.OK);
	}

	@GetMapping("findAll")
	public ResponseEntity<?> findAll() {
		final Iterable<DayActivity> dayActivityList = dayActivityService.findAll();
		return new ResponseEntity<>(dayActivityList, HttpStatus.OK);
	}

	@GetMapping("findByPage")
	public ResponseEntity<?> findByPage(@RequestParam final int page, @RequestParam final int size) {
		final Iterable<DayActivity> dayActivityList = dayActivityService.findAllByPage(page, size);
		return new ResponseEntity<>(dayActivityList, HttpStatus.OK);
	}
}
