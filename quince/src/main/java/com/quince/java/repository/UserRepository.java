package com.quince.java.repository;


import org.springframework.data.repository.CrudRepository;

import com.quince.java.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
