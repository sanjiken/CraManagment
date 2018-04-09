package it.agil.cramanagment.service;

import java.util.List;

import it.agil.cramanagment.entity.DayActivity;

public interface DayActivityService {

	DayActivity saveOrUpdate(DayActivity dayActivity);

	DayActivity findById(Long id);

	void delete(DayActivity dayActivity);

	List<DayActivity> getAllDayActivity();
}
