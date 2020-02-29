package com.pink.screw.java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pink.screw.java.entities.Person;
import com.pink.screw.java.repositories.PersonRepository;

@RestController
/*@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")*/
public class PControlle {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/list")
	public Page<Person> getAll(
			@PageableDefault(size = 20, page = 0, sort = { "firstName" },
			direction = Direction.ASC) Pageable pageable){
		return personRepository.findAll(pageable);
		
	}

}
