package it.agil.cramanagment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.agil.cramanagment.entity.Cra;

public interface CraRepository extends PagingAndSortingRepository<Cra, Long> {

}
