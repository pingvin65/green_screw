package com.pink.screw.java.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pink.screw.java.entities.Person;
import com.pink.screw.java.repositories.PersonRepository;

@RepositoryRestController
@RequestMapping("/api/v1")
public class PersonController {
	
	private final PersonRepository repository;
	
    @Autowired
    public PersonController(PersonRepository repo) { 
        repository = repo;
     
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public @ResponseBody ResponseEntity<?> getProducers() {
    	   List<Person> producers = new ArrayList<Person>();
    	   repository.findAll().forEach(producers::add);
    	   
    	Resources<String> resources = new Resources<String>(producers);
    	
    	 return ResponseEntity.ok(resources);
    	
    }

}
