package it.agil.cramanagment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.agil.cramanagment.entity.Cra;

public interface CraService {
	
	Cra saveOrUpdate(Cra cra);

	void delete(Cra cra);

	Cra findById(Long id);

	Page<Cra> findAllByPage(int page, int size);

	Iterable<Cra> findAllSorted(Sort sort);
}
