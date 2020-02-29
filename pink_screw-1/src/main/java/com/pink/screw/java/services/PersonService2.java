package com.pink.screw.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.pink.screw.java.entities.Person;
import com.pink.screw.java.repositories.PersonRepository2;


@Service
public class PersonService2 {

	@Autowired
	private PersonRepository2 repository;


	
	public Iterable<Person> getAllPersons(Integer pageNo, Integer pageSize, String sortBy) {
//		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Iterable<Person> p = repository.findAll();
		return repository.findAll();
	}

	public Page<Person> getAll(@PageableDefault Pageable pageable) {

		Page<Person> pagedResult = repository.findAll(pageable);

		return pagedResult;

	}

}