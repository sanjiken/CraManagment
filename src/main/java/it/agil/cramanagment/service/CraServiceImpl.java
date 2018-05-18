package it.agil.cramanagment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.agil.cramanagment.entity.Cra;
import it.agil.cramanagment.repository.CraRepository;

@Service
public class CraServiceImpl implements CraService {

	@Autowired
	private CraRepository craRepository;

	@Override
	public Cra saveOrUpdate(Cra cra) {
		return craRepository.save(cra);
	}

	@Override
	public void delete(Cra cra) {
		craRepository.delete(cra);
	}

	@Override
	public Cra findById(Long id) {
		Optional<Cra> optionalCra = craRepository.findById(id);
		// TODO Auto-generated method stub
		return optionalCra.isPresent() ? optionalCra.get() : null;
	}

	@Override
	public Page<Cra> findAllByPage(int page, int size) {
		// TODO Auto-generated method stub
		return craRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Iterable<Cra> findAllSorted(Sort sort) {
		// TODO Auto-generated method stub
		return craRepository.findAll(sort);
	}

}
