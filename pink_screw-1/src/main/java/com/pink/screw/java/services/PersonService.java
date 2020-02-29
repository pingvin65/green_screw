package com.pink.screw.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.pink.screw.java.entities.Person;
import com.pink.screw.java.repositories.PersonRepository;


@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Person> pagedResult = repository.findAll(paging);
		System.out.println(pagedResult.hasContent());
		if (pagedResult.hasContent()) {
			System.out.println(pagedResult.hasContent());
			return pagedResult.getContent();
		} else {
			System.out.println(new ArrayList<Person>());
			return new ArrayList<Person>();
		}
	}
	
	public Page<Person> getAllEmployees2(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

//		Page<Person> pagedResult = repository.findAll(paging);
		return repository.findAll(paging);
	}

	public Page<Person> getAll(@PageableDefault Pageable pageable) {

		Page<Person> pagedResult = repository.findAll(pageable);

		return pagedResult;

	}

}