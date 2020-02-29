package com.pink.screw.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pink.screw.java.entities.Person;

/* @RepositoryRestResource(collectionResourceRel = "people", path = "people") */
//@Repository
//@NoRepositoryBean
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

//  List<Person> findByLastName(@Param("name") String name);

	Page<Person> findAll(Pageable pageable);

}