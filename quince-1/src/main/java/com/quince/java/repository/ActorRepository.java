package com.quince.java.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.quince.java.entity.ActorEntity;

public interface ActorRepository extends PagingAndSortingRepository<ActorEntity, Long>{

}
