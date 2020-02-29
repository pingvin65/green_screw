package com.pink.screw.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pink.screw.java.entities.Person;
import com.pink.screw.java.repositories.PersonRepository2;

@RepositoryRestController
@RequestMapping("/scanners")
public class PersonController2 {
	private final PersonRepository2 repository;

	@Autowired
	public PersonController2(PersonRepository2 rep) {
		repository = rep;
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value = "/search/listProducers")
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getProducers() {
		List<Person> producers = (List<Person>) repository.findAll();
//		Page<Person> producers2 = (Page<Person>) repository.findAll();

//		System.out.println(producers2);

		for (int i = 0; i < producers.size(); i++) {
			System.out.println(producers.get(i).getId());

		}
		producers.size();

		//
		// do some intermediate processing, logging, etc. with the producers
		//

		Resources resources = new Resources(producers);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonController2.class).getProducers())
				.withSelfRel();
		
		resources.add(link);

	
//		WebMvcLinkBuilder link2 =  WebMvcLinkBuilder.linkTo(PersonController2.class);

//		resources.add(linkTo(methodOn(PersonController2.class).getProducers()).withSelfRel());

		// add other links as needed

		return ResponseEntity.ok(resources);
	}

}