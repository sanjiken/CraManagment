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
import org.springframework.util.Assert;

import it.agil.cramanagment.entity.Cra;
import it.agil.cramanagment.repository.CraRepository;

@Service
public class CraServiceImpl implements CraService {

	private static final Logger LOG = LoggerFactory.getLogger(CraServiceImpl.class);

	@Autowired
	private CraRepository craRepository;

	@Override
	public Cra saveOrUpdate(final Cra cra) {
		return craRepository.save(cra);
	}

	@Override
	public boolean deleteById(final Long id) {
		boolean result = false;
		Assert.notNull(id, "id can't be null");
		try {
			craRepository.deleteById(id);
			result = true;
		} catch (final DataIntegrityViolationException e) {
			LOG.error("can't delete Cra with id = {}", id);

		}
		return result;
	}

	@Override
	public Cra findById(final Long id) {
		Assert.notNull(id, "id can't be null");
		final Optional<Cra> optionalCra = craRepository.findById(id);
		return optionalCra.isPresent() ? optionalCra.get() : null;
	}

	@Override
	public Page<Cra> findAllByPage(final int page, final int size) {
		Page<Cra> pageResponse = null;
		try {
			pageResponse = craRepository.findAll(PageRequest.of(page, size));
		} catch (final DataIntegrityViolationException e) {
			LOG.error("can't get {} pages with size = {}  ", page, size);
		}
		return pageResponse;
	}

	@Override
	public Iterable<Cra> findAllSorted(final Sort sort) {
		return craRepository.findAll(sort);
	}

	@Override
	public Iterable<Cra> findAll() {
		return craRepository.findAll();
	}

}
