package com.green.screw.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.screw.java.entities.SuppliersEntity;

public interface SupplierRepository extends JpaRepository<SuppliersEntity, Long> {
	
	Page<SuppliersEntity> findAll(Pageable pageable);
	
}
