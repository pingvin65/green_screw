package com.quince.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.quince.java.crepository.ContactRepository;
import com.quince.java.entity.ContactEntity;

@Service
public class ContacService {

	@Autowired
	ContactRepository contactRepository;

	public ContacService(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	public Page<ContactEntity> getAll(@PageableDefault Pageable pageable) {

		Page<ContactEntity> pagedResult = contactRepository.findAll(pageable);

		return pagedResult;

	}

}
