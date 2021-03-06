package com.green.screw.java.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.screw.java.entities.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
	
	Page<ProductsEntity> findAll(Pageable pageable);
	
	Page<ProductsEntity> findByLikedSuppliers_NameStartingWithIgnoreCase(String name, Pageable pageable);
	
	Page<ProductsEntity> findByName(String name, Pageable pageable);
}
