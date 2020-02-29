package com.quince.java.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quince.java.crepository.ContactRepository;

@Controller
@RequestMapping("/contacts3")
public class ContactController2 {

	ContactRepository contactRepository;

	public ContactController2(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@RequestMapping
	String showContacts(Model model, Pageable pageable) {

		model.addAttribute("contacts3", contactRepository.findAll(pageable));
		return "contacts3";
	}

}
