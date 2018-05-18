package it.agil.cramanagment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.agil.cramanagment.entity.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
