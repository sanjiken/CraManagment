package it.agil.cramanagment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.agil.cramanagment.entity.DayActivity;

public interface DayActivityService {
	DayActivity saveOrUpdate(DayActivity dayActivity);

	void delete(DayActivity dayActivity);

	DayActivity findById(Long id);

	Page<DayActivity> findAllByPage(int page, int size);

	Iterable<DayActivity> findAllSorted(Sort sort);
}
