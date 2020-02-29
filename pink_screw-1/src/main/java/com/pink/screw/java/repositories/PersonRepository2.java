package com.pink.screw.java.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pink.screw.java.entities.Person;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people") 
//@Repository
public interface PersonRepository2 extends CrudRepository<Person, Long> {

	List<Person> findByLastName(@Param("frstName") String frstName);

	Page<Person> findAll(Pageable pageable);
}
