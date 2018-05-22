package it.agil.cramanagment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import it.agil.cramanagment.entity.Cra;

public interface CraService {

	Cra saveOrUpdate(Cra cra);

	boolean deleteById(Long id);

	Cra findById(Long id);

	Page<Cra> findAllByPage(int page, int size);

	Iterable<Cra> findAllSorted(Sort sort);

	Iterable<Cra> findAll();
}
