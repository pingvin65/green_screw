package com.quince.java.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.quince.java.entity.User;

public interface UserRepository2 extends PagingAndSortingRepository<User, Integer>{

//	Page<User> findByName(String name, Pageable pageable);
//	Pageable pageable = PageRequest.of(0, 10);
//	Page<User> findAll();
//	@RestResource(path = "name")
//	public Page<User> findByName(@Param("name") String name, Pageable p);

}
