package com.quince.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import static org.springframework.hateoas.LinkRelation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quince.java.entity.User;
import com.quince.java.service.UserService;

@RestController
//@RepositoryRestController
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RequestMapping("/users2")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<User> list = service.getAllUsers(pageNo, pageSize, sortBy);
		for (User u : list) {
			System.out.println(u.getId());
			@SuppressWarnings("deprecation")
			Link link = WebMvcLinkBuilder.linkTo(UserController.class).slash(u.getId()).withSelfRel();

			// Add link to singular resource

		}

		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/all")
	public Page<User> showUsers(@PageableDefault Pageable pageable) {
		// pageable = PageRequest.of(0, 2, Sort.by("name").descending());
		Page<User> users = service.getAll(pageable);
		for (User u : users) {
//			u.add(linkTo(methodOn(UserController.class).showUsers(pageable).get());
//			Link link = linkTo(methodOn(CustomerController.class));
//			u.add(linkTo(UserController.class).slash(u.getId().toString()));
			//linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();
		}
		
		return service.getAll(pageable);
	}



}
