package it.agil.cramanagment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.DayActivity;
import it.agil.cramanagment.repository.DayActivityRepository;

@Service
public class DayActivityServiceImpl implements DayActivityService {

	@Autowired
	private DayActivityRepository dayActivityRepository;

	@Override
	public DayActivity saveOrUpdate(DayActivity dayActivity) {
		return dayActivityRepository.save(dayActivity);
	}

	@Override
	public void delete(DayActivity dayActivity) {
		dayActivityRepository.delete(dayActivity);
	}

	@Override
	public DayActivity findById(Long id) {
		Optional<DayActivity> optionalDayActivity = dayActivityRepository.findById(id);
		return optionalDayActivity.isPresent() ? optionalDayActivity.get() : null;
	}

	@Override
	public Page<DayActivity> findAllByPage(int page, int size) {
		return dayActivityRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<DayActivity> findAllSorted(Sort sort) {
		return dayActivityRepository.findAll(sort);
	}

}
