package com.quince.java.crepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.quince.java.entity.ContactEntity;


@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, Long> {
	
	  @RestResource(path = "fnames", rel = "fnames")
	  List<ContactEntity> findByFirstName(String fname);
	
}
