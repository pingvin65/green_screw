package com.quince.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quince.java.crepository.ContactRepository;
import com.quince.java.entity.ContactEntity;
import com.quince.java.service.ContacService;

@RestController
public class ContactController {

	@Autowired
	ContacService contacService;

	// Get All Notes
	@GetMapping("/contacts2")
	public Page<ContactEntity> getAllNotes(
			@PageableDefault(size = 2, page = 0, sort = { "firstName" }, direction = Direction.ASC) Pageable pageable) {
		return contacService.getAll(pageable);
	}

}
