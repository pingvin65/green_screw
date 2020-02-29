package com.quince.java.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quince.java.repository.UserRepository2;

import com.quince.java.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository2 userRepository2;
	
	 public List<User> getAllUsers(Integer pageNo, Integer pageSize, String sortBy)
	    {
	        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
	 
	        Page<User> pagedResult = userRepository2.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<User>();
	        }
	    }
	public Page<User> getAllUser2(@PageableDefault Pageable pageable){
		
//		pageable = PageRequest.of(0, 3);
		
		Page<User> pagedResult = userRepository2.findAll(pageable);
		return pagedResult;
	}
	public Page<User> getAllByName(){
//		Sort sort = new Sort(new Sort.Order(Direction.ASC, "Name"));
//		Pageable pageable = new PageRequest(0, 5, sort);
		return null;
	}
	
	public Page<User>  getAll(@PageableDefault Pageable pageable){
		
		Page<User> pagedResult = userRepository2.findAll(pageable);

		return pagedResult;
		
	}
}
