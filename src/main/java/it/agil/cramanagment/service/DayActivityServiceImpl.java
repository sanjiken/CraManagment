package it.agil.cramanagment.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.DayActivity;
import it.agil.cramanagment.repository.DayActivityRepository;

@Service
public class DayActivityServiceImpl implements DayActivityService {

	private static final Logger LOG = LoggerFactory.getLogger(DayActivityServiceImpl.class);

	@Autowired
	private DayActivityRepository dayActivityRepository;

	@Override
	public DayActivity saveOrUpdate(final DayActivity dayActivity) {
		return dayActivityRepository.save(dayActivity);
	}

	@Override
	public boolean deleteById(final Long id) {
		try {
			dayActivityRepository.deleteById(id);
			return true;
		} catch (final DataIntegrityViolationException e) {
			LOG.error("can't delete craUser with id={}", id);
		}
		return false;

	}

	@Override
	public DayActivity findById(final Long id) {
		final Optional<DayActivity> optionalDayActivity = dayActivityRepository.findById(id);
		return optionalDayActivity.isPresent() ? optionalDayActivity.get() : null;
	}

	@Override
	public Page<DayActivity> findAllByPage(final int page, final int size) {
		return dayActivityRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<DayActivity> findAllSorted(final Sort sort) {
		return dayActivityRepository.findAll(sort);
	}

}
