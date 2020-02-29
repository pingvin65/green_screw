package com.quince.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quince.java.entity.User;
import com.quince.java.service.UserService;

@RestController
//@RepositoryRestController
@RequestMapping("/v1")
public class UserController2 {
	
	private final UserService service;
	
	
	
	public UserController2(UserService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value="/users/u")
	public ResponseEntity<MappingJacksonValue> getUser(@PageableDefault Pageable pageable){
		MappingJacksonValue wrapper = new MappingJacksonValue(service.getAllUser2(pageable));
		return ResponseEntity.ok(wrapper);
	}


	@RequestMapping(value="/users")
    public Page<User> showUsers(@PageableDefault Pageable pageable) {
    	return service.getAllUser2(pageable);
    }
}
