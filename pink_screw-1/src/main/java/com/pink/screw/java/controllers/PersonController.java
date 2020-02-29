package com.pink.screw.java.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pink.screw.java.entities.Person;
import com.pink.screw.java.repositories.PersonRepository;
import com.pink.screw.java.services.PersonService;


@RestController
@RequestMapping("/persons2")
public class PersonController {
	@Autowired
    PersonService service;
 
	@Autowired
	private PersonRepository repository;
	
    @GetMapping
    public ResponseEntity<List<Person>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) 
    {
        List<Person> list = service.getAllEmployees(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<Person>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    @GetMapping("/li")
    public ResponseEntity<Page<Person>> getAllEmployees2(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy) 
    {
        Page<Person> list = service.getAllEmployees2(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<Page<Person>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public Page<Person> getAllNotes(
			@PageableDefault(size = 20, page = 0, sort = { "firstName" }, direction = Direction.ASC) Pageable pageable) {
		return service.getAll(pageable);
	}
	@PostMapping("/add2")
	ResponseEntity<String> addProduct(@Valid @RequestBody Person person){

		try {
			repository.save(person);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");	
		}
			
							
		return ResponseEntity.ok("Saved");		
	}

}